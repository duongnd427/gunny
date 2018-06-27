package game.viewFinder;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.PlayerRight;
import renderer.ImageRenderer;

public class ViewFinderRight extends GameObject {

    public ViewFinderMove viewFinderMove;

    public ViewFinderRight() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        viewFinderMove = new ViewFinderMove();
    }

    @Override
    public void run() {
        super.run();
        PlayerRight playerRight = GameObjectManager.instance.findPlayerRight(this.side);
        if (playerRight != null) {
            this.position.set(playerRight.position.add(this.velocity));
            this.velocity.set(playerRight.position.subtract(this.position));
        }
        viewFinderMove.run(this);
        this.position.addUp(velocity);
    }
}
