package game.player.playerRight;

import base.GameObject;
import renderer.ImageRenderer;

public class Right extends GameObject {
    public Right(){
        this.position.set(150, 200);
        this.side = "Right";
        this.renderer = new ImageRenderer("resources/images/player2.png", 150, 150);
    }
}
