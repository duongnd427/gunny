package game.player;

import base.GameObject;
import base.GameObjectManager;
import renderer.HpRenderer;


import java.awt.*;

public class HpLeft extends GameObject {
    public HpLeft() {
        this.position.set(10,10);
        this.renderer = new HpRenderer(75, 15, Color.RED);
    }

    @Override
    public void run() {
        super.run();
        PlayerLeft playerLeft = GameObjectManager.instance.findPlayerLeft("left");
        HpRenderer hpRenderer = (HpRenderer) this.renderer;
        hpRenderer.width = 15*playerLeft.live;
    }

}
