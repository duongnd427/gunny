package game.viewFinder;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class ViewFinder extends GameObject {

    public Vector2D velocity;


    public ViewFinder() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
    }
}
