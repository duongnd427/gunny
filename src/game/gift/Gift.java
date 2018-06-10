package game.gift;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import renderer.ImageRenderer;

public class Gift extends GameObject {

    public Gift() {
        this.renderer = new ImageRenderer("resources/images/Gift-icon.png", 15, 15);
    }

    @Override
    public void run() {
        super.run();
    }
}

