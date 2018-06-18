package game.viewFinder;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import renderer.ImageRenderer;

import java.awt.*;

public class ViewFinder extends GameObject {

    public Vector2D velocity;
    private ViewFinderMove viewFinderMove;

    public ViewFinder() {
        this.velocity = new Vector2D();
        this.viewFinderMove = new ViewFinderMove();
        this.renderer = new ImageRenderer("resources/images/circle.png",20,20);
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            this.position.add(10,10);
        }
        this.viewFinderMove.run();
        Vector2D rotate = this.velocity.rotate(viewFinderMove.angle);

        this.position.addUp(rotate);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }
}
