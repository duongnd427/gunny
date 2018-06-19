package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import game.bullet.Bullet;
import input.KeyboardInput;

public class PlayerShoot {
    public FrameCounter frameCounter = new FrameCounter(10);
    public PlayerShoot() {
    }

    public void run(Player player) {
        if (KeyboardInput.instance.spacePressed) {
            if (this.frameCounter.run()) {
                Bullet bulletPlayer = new Bullet();
                bulletPlayer.position.set(player.position);
                bulletPlayer.velocity.set(3,-3);
                GameObjectManager.instance.add(bulletPlayer);
                this.frameCounter.reset();
            }
        }
    }
}
