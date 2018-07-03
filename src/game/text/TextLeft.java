package game.text;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class TextLeft extends GameObject {
    public TextLeft() {
        this.position.set(70, 250);
        this.renderer = new TextRenderer(
                "PLAYER lEFT WIN",
                Color.blue,
                "resources/Kings Feast.otf",
                80
        );
    }
}
