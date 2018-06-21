package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import game.bullet.Bullet;
import input.KeyboardInput;

public class PlayerShoot {

    public int power = 0;
    private FrameCounter frameCounter = new FrameCounter(10);
    public PlayerShoot() {
    }

    public void run(Player player) {
        if (KeyboardInput.instance.spacePressed) {
                this.power += 1;

            }
            if (KeyboardInput.instance.spaceReleased) {
                Bullet bulletPlayer = new Bullet();
                bulletPlayer.position.set(player.position);
                bulletPlayer.velocity.set(20, -this.power);
                GameObjectManager.instance.add(bulletPlayer);
                this.power = 0;
        }
    }
}
