package game.viewFinder;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

import java.awt.*;

public class ViewFinder extends GameObject {

    public Vector2D velocity;
    private ViewFinderMove viewFinderMove;

    public ViewFinder(int x, int y) {
//        this.velocity = new Vector2D();
        this.viewFinderMove = new ViewFinderMove();
        this.position.set(x,y);
        this.renderer = new ImageRenderer("resources/images/circle.png",20,20);
//        System.out.println("xx");
    }

    @Override
    public void run() {
        super.run();
        this.viewFinderMove.run(this);
//        Vector2D rotate = this.velocity.rotate(viewFinderMove.angle);
//        this.position.addUp(rotate);
    }



}
