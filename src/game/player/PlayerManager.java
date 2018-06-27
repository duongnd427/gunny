package game.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import game.viewFinder.ViewFinderLeft;
import input.KeyboardInput;

public class PlayerManager extends GameObject {

    public static PlayerManager instance = new PlayerManager();

    private Vector2D velocity;
    private FrameCounter frameCounter;
    private float power = 0;

    private PlayerManager() {
        this.velocity = new Vector2D();
//        this.frameCounter = new FrameCounter(5);
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
                this.power += 1;
        }

        if (KeyboardInput.instance.spaceReleased) {
            Bullet bulletPlayer = GameObjectManager.instance.recycle(Bullet.class);
            ViewFinderLeft viewFinderLeft = GameObjectManager.instance.findViewFinderLeft("left");
            PlayerLeft playerLeft = GameObjectManager.instance.findPlayerLeft("left");
            bulletPlayer.position.set(gameObject.position.add(viewFinderLeft.position.subtract(playerLeft.position)));
            bulletPlayer.velocity.set((viewFinderLeft.position.subtract(playerLeft.position)).multiply((power/20)));
            this.power = 0;
        }
    }
}

