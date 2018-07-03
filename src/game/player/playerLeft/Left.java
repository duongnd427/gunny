package game.player.playerLeft;

import base.GameObject;
import renderer.ImageRenderer;

public class Left extends GameObject {
    public Left(){
        this.position.set(820, 200);
        this.side = "left";
        this.renderer = new ImageRenderer("resources/images/player.png", 150, 150);
    }
}
