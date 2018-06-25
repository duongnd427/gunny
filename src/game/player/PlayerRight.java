package game.player;

import base.GameObject;
import constant.Constant;
import game.viewFinder.ViewFinderSpawner;
import input.KeyboardInput;
import renderer.ImageRenderer;

public class PlayerRight extends GameObject {

    public PlayerRight() {
        this.side = "right";
        this.position.set(850, 500);
        this.renderer = new ImageRenderer("resources/images/player2.png", 150, 100);
    }

    @Override
    public void run() {
        if (Constant.turn == 1) {
            ViewFinderSpawner.instance.createViewFinderRight(this);
            PlayerManager.instance.shoot(this);
            PlayerManager.instance.move(this);
            if (KeyboardInput.instance.spaceReleased)
                Constant.turn = 0;
            KeyboardInput.instance.reset();
        }
    }

}
