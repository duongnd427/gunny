package game.viewFinder;

import base.GameObject;
import base.Vector2D;
import input.KeyboardInput;

public class ViewFinderMove {

    public static ViewFinderMove instance = new ViewFinderMove();
    private Vector2D velocity;
    private double angle = 0.0;

    private ViewFinderMove() {
        this.velocity = new Vector2D(0, -70);
    }


    public void move(GameObject gameObject) {
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

        this.velocity.set(this.velocity.rotate(angle));
        gameObject.position.addUp(this.velocity);
    }

}
