package game.viewFinder;

import base.GameObjectManager;
import game.player.Player;
import input.KeyboardInput;

public class ViewFinderMove {

    public double angle = 0.0;

    public ViewFinderMove() {
    }

    public void run() {
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            if (KeyboardInput.instance.upPressed) {
                player.velocity.set(2,0);
                this.angle -= 15.0;
            }
            if (KeyboardInput.instance.downPressed) {
                player.velocity.set(2,0);
                this.angle += 15.0;
            }
            if (KeyboardInput.instance.upReleased) {
                player.velocity.set(0,0);
                this.angle = 0;
            }
            if (KeyboardInput.instance.downReleased) {
                player.velocity.set(0,0);
                this.angle = 0;
            }
        }

    }
}
