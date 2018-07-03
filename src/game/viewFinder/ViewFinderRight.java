package game.viewFinder;

import base.GameObject;
import base.GameObjectManager;
import game.player.playerRight.PlayerRight;
import renderer.ImageRenderer;

public class ViewFinderRight extends GameObject {


    public ViewFinderRight() {
        this.side = "right";
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
    }

    @Override
    public void run() {
        super.run();
        PlayerRight playerRight = GameObjectManager.instance.findPlayerRight(this.side);
        if (playerRight != null) {
            this.position.set(playerRight.position.add(this.velocity));
            this.velocity.set(playerRight.position.subtract(this.position));
        }
        ViewFinderMove.instance.move(this);
        this.position.addUp(this.velocity);
    }
}
