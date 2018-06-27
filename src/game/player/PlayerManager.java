package game.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import input.KeyboardInput;

public class PlayerManager extends GameObject {

    public static PlayerManager instance = new PlayerManager();

    private Vector2D velocity;
    private FrameCounter frameCounter;
    private int power = 0;
    private double angle = 0.0;

    private PlayerManager() {
        this.velocity = new Vector2D();
        this.frameCounter = new FrameCounter(5);
    }

    public void move(GameObject gameObject) {
        if (KeyboardInput.instance.leftPressed) {
            this.velocity.x -= 10;
        }
        if (KeyboardInput.instance.rightPressed) {
            this.velocity.x += 10;
        }
        if (KeyboardInput.instance.leftReleased) {
            this.velocity.x = 0;
        }
        if (KeyboardInput.instance.rightReleased) {
            this.velocity.x = 0;
        }
        gameObject.position.addUp(this.velocity);

        this.inScreen(gameObject);
    }

    private void inScreen(GameObject gameObject) {
        if (gameObject.position.x <= 20) gameObject.position.x = 20;
        if (gameObject.position.x >= 974) gameObject.position.x = 974;
    }

    public void shoot(GameObject gameObject) {
        if (KeyboardInput.instance.spacePressed) {
            if (this.frameCounter.run()) {
                this.power += 5;
                this.frameCounter.reset();
            }
        }
        if (KeyboardInput.instance.spaceReleased) {
            Bullet bulletPlayer = GameObjectManager.instance.recycle(Bullet.class);
            bulletPlayer.position.set(gameObject.position);
            bulletPlayer.velocity.set(10, -this.power);
            this.power = 0;
        }
    }
}

