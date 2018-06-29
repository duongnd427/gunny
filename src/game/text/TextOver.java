package game.text;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class TextOver extends GameObject {
    public TextOver() {
        this.position.set(180, 250);
        this.renderer = new TextRenderer(
                "GAME OVER",
                Color.cyan,
                "resources/Kings Feast.otf",
                120
        );
    }
}
