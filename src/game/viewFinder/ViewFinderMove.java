package game.viewFinder;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.PlayerLeft;
import game.player.PlayerRight;
import input.KeyboardInput;

public class ViewFinderMove {
    public double angle = 0.0;
    public Vector2D velocity;

    public ViewFinderMove() {
        this.velocity = new Vector2D(0,-30);
    }

    public void run(GameObject gameObject) {
        if (KeyboardInput.instance.upPressed) {
            this.angle -= 1.0;
            System.out.println("upPreesed");
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
        Vector2D rotate = this.velocity.rotate(angle);
        System.out.println("out");
        this.velocity.set(rotate);
        gameObject.position.addUp(this.velocity);
    }

}
