package game.player;

import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import game.viewFinder.ViewFinderRight;
import input.KeyboardInput;
import renderer.ImageRenderer;

public class PlayerRight extends GameObject {


    private ViewFinderRight viewFinderRight;

    public PlayerRight() {
        this.side = "right";
        this.position.set(850, 500);
        this.renderer = new ImageRenderer("resources/images/player2.png", 150, 100);
        viewFinderRight = new ViewFinderRight();
        GameObjectManager.instance.add(viewFinderRight);
    }

    @Override
    public void run() {
        if (Constant.turn == 1) {
            viewFinderRight.run();
            PlayerManager.instance.shoot(this);
            PlayerManager.instance.move(this);
            if (KeyboardInput.instance.spaceReleased)
                Constant.turn = 0;
            KeyboardInput.instance.reset();
        }
    }

}
