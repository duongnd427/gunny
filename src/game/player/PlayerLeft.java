package game.player;

import base.GameObject;

import base.GameObjectManager;
import constant.Constant;

import game.viewFinder.ViewFinderLeft;
import input.KeyboardInput;
import renderer.ImageRenderer;


public class PlayerLeft extends GameObject {

    private ViewFinderLeft viewFinderLeft;


    public PlayerLeft() {
        this.position.set(50, 500);
        this.side = "left";
        this.renderer = new ImageRenderer("resources/images/player.png", 150, 100);
        viewFinderLeft = new ViewFinderLeft();
        GameObjectManager.instance.add(viewFinderLeft);

    }

    @Override
    public void run() {
        if (Constant.turn == 0) {
            viewFinderLeft.run();
            PlayerManager.instance.shoot(this);
            PlayerManager.instance.move(this);
            if (KeyboardInput.instance.spaceReleased)
                Constant.turn = 1;
            KeyboardInput.instance.reset();
        }
    }


}
