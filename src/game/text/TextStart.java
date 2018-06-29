package game.text;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class TextStart extends GameObject {
    public TextStart() {
        this.position.set(280, 250);
        this.renderer = new TextRenderer(
                "START",
                Color.cyan,
                "resources/Kings Feast.otf",
                150
        );
    }

}
