package game.player.playerLeft;

import base.GameObject;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;

public class Left extends GameObject {
    public Left(){
        this.position.set(820, 200);
        this.side = "left";
        this.renderer = new AnimationRenderer(10, 150, 140,
                "resources/images/player11.png",
                "resources/images/player12.png"
        );
    }
}
