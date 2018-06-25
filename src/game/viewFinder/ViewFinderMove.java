package game.viewFinder;

import base.GameObject;
import base.Vector2D;
import input.KeyboardInput;

public class ViewFinderMove {
    public double angle = 0.0;
    public Vector2D velocity;

    public ViewFinderMove() {
        this.velocity = new Vector2D(0,-60);
    }

    public void run(GameObject gameObject) {

        if (KeyboardInput.instance.upPressed) {
            this.angle -= 1.0;
        }
        if (KeyboardInput.instance.downPressed) {
            this.angle += 1.0;
        }
        if (KeyboardInput.instance.upReleased) {
            this.angle = 0;
        }
        if (KeyboardInput.instance.downReleased) {
            this.angle = 0;
        }
        Vector2D rotate = velocity.rotate(angle);
        this.velocity.set(rotate);
        gameObject.position.addUp(this.velocity);
    }

}
