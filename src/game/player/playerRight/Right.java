package game.player.playerRight;

import base.GameObject;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;

public class Right extends GameObject {
    public Right(){
        this.position.set(250, 200);
        this.side = "Right";
        this.renderer = new AnimationRenderer(20,150, 130,
                "resources/images/player21.png",
                "resources/images/player22.png"
        );
    }
}
