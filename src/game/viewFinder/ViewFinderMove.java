package game.viewFinder;

import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import input.KeyboardInput;

public class ViewFinderMove {

    public double angle = 0.0;
    private Vector2D velocity;

    public ViewFinderMove() {
        this.velocity = new Vector2D();
    }

    public void run(ViewFinder viewFinder) {

            if (KeyboardInput.instance.upPressed) {
                this.velocity.set(2,0);
                this.angle -= 15.0;
            }
            if (KeyboardInput.instance.downPressed) {
                this.velocity.set(2,0);
                this.angle += 15.0;
            }
            if (KeyboardInput.instance.upReleased) {
                this.velocity.set(0,0);
                this.angle = 0;
            }
            if (KeyboardInput.instance.downReleased) {
                this.velocity.set(0,0);
                this.angle = 0;
            }
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
            viewFinder.position.addUp(this.velocity);

    }
}
