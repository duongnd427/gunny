package game.player;

import base.GameObject;
import constant.Constant;
import input.KeyboardInput;
import renderer.PowerRenderer;
import java.awt.*;


public class Power extends GameObject {


    public Power() {
        this.renderer = new PowerRenderer(0, 30, Color.ORANGE);
    }

    @Override
    public void run() {
        super.run();
        PowerRenderer powerRenderer = (PowerRenderer) this.renderer;
            powerRenderer.width = (int) (5 * Constant.pow);
    }
}

