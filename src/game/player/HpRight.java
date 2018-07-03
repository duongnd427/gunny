package game.player;

import base.GameObject;
import base.GameObjectManager;
import game.player.playerRight.PlayerRight;
import renderer.HpRenderer;

import java.awt.*;

public class HpRight extends GameObject {
    public HpRight() {
        this.position.set(920,10);
        this.renderer = new HpRenderer(0, 15, Color.RED);
    }

    @Override
    public void run() {
        super.run();
        PlayerRight playerRight = GameObjectManager.instance.findPlayerRight("right");
        HpRenderer hpRenderer = (HpRenderer) this.renderer;
        hpRenderer.width = 15*playerRight.live;
    }
}
