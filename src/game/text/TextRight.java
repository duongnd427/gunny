package game.text;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class TextRight extends GameObject {
    public TextRight() {
        this.position.set(350, 250);
        this.renderer = new TextRenderer(
                "URF WIN",
                Color.blue,
                "resources/Kings Feast.otf",
                80
        );
    }
}
