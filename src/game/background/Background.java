package game.background;

import base.GameObject;
import renderer.BackgroundRenderer;

import java.awt.*;

public class Background extends GameObject {

    public Background() {
        this.renderer = (renderer.Renderer) new BackgroundRenderer("resources/images/background.png",1024, 600);
    }
}