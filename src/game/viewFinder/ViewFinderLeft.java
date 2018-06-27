package game.viewFinder;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.PlayerLeft;
import renderer.ImageRenderer;

public class ViewFinderLeft extends GameObject {

    public ViewFinderMove viewFinderMove;


    public ViewFinderLeft() {
        this.side = "left";
        this.velocity = new Vector2D(0,-30);
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        viewFinderMove = new ViewFinderMove();
    }

    @Override
    public void run() {
        super.run();
        PlayerLeft playerLeft = GameObjectManager.instance.findPlayerLeft(this.side);
        if (playerLeft != null) {
            this.position.set(playerLeft.position.add(this.velocity));
            this.velocity.set(playerLeft.position.subtract(this.position));
        }
        viewFinderMove.run(this);
        this.position.addUp(this.velocity);
    }
}
