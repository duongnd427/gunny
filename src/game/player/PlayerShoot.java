package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import game.bullet.Bullet;
import input.KeyboardInput;

public class PlayerShoot {
    public FrameCounter frameCounter = new FrameCounter(10);
    public PlayerShoot() {
    }

    public void run(Player1 player1) {
        if (KeyboardInput.instance.spacePressed) {
            if (this.frameCounter.run()) {
                Bullet bulletPlayer = new Bullet();
                bulletPlayer.position.set(player1.position);
               // Vector2D rotate = player.player1Move.velocity.add
                     //   (new Vector2D(2, 0).rotate(player.player1Move.angle));
                bulletPlayer.velocity.set(3,-3);
                GameObjectManager.instance.add(bulletPlayer);
                this.frameCounter.reset();
            }
        }
    }
}
