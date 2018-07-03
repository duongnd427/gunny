package game.viewFinder;

import base.GameObject;
import base.GameObjectManager;
import game.player.playerLeft.PlayerLeft;
import renderer.ImageRenderer;

public class ViewFinderLeft extends GameObject {


    public ViewFinderLeft() {
        this.side = "left";
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
    }

    @Override
    public void run() {
        super.run();
        PlayerLeft playerLeft = GameObjectManager.instance.findPlayerLeft(this.side);
        {
            this.position.set(playerLeft.position.add(this.velocity));
            this.velocity.set(playerLeft.position.subtract(this.position));
        }
        ViewFinderMove.instance.move(this);
        this.position.addUp(this.velocity);
    }

}
