package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import game.bullet.Bullet;
import input.KeyboardInput;

public class PlayerShoot {

    private int power;
    private FrameCounter frameCounter = new FrameCounter(10);
    public PlayerShoot() {
    }

    public void run(Player player) {
        if (KeyboardInput.instance.spacePressed) {
            if(this.frameCounter.run()){
                this.power += 6 ;
                this.frameCounter.reset();
        }
        }
        if (KeyboardInput.instance.spaceReleased){
            Bullet bulletPlayer = new Bullet();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(10,-this.power);
            GameObjectManager.instance.add(bulletPlayer);
            this.power = 0;
        }
    }
}
