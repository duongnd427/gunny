package game.player;

import base.GameObject;

import constant.Constant;

import game.viewFinder.ViewFinderSpawner;
import input.KeyboardInput;
import renderer.ImageRenderer;


public class PlayerLeft extends GameObject {


    public PlayerLeft() {
        this.position.set(50, 500);
        this.side = "left";
        this.renderer = new ImageRenderer("resources/images/player.png", 150, 100);

    }

    @Override
    public void run() {
        if (Constant.turn == 0) {
            ViewFinderSpawner.instance.createViewFinderLeft(this);
            PlayerManager.instance.shoot(this);
            PlayerManager.instance.move(this);
            if (KeyboardInput.instance.spaceReleased)
                Constant.turn = 1;
            KeyboardInput.instance.reset();
        }
    }


}
