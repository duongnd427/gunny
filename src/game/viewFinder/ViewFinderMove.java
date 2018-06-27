package game.viewFinder;

import base.GameObject;
import base.Vector2D;
import input.KeyboardInput;

public class ViewFinderMove {

    public static ViewFinderMove instance = new ViewFinderMove();
    private Vector2D velocity;
    private double angle = 0.0;

    private ViewFinderMove() {
        this.velocity = new Vector2D(0,-50);
    }


    public void move(GameObject gameObject) {
        if (KeyboardInput.instance.upPressed) {
            this.angle -= 1.0;
            System.out.println("upPressed");
        }
        if (KeyboardInput.instance.downPressed) {
            this.angle += 1.0;
            System.out.println("downPressed");
        }
        if (KeyboardInput.instance.upReleased) {
            this.angle = 0;
            System.out.println("upRe");
        }
        if (KeyboardInput.instance.downReleased) {
            this.angle = 0;
        }

        this.velocity.set(this.velocity.rotate(angle));
        gameObject.position.addUp(this.velocity);
    }

}
