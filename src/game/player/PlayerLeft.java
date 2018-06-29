package game.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.viewFinder.ViewFinderLeft;
import input.KeyboardInput;
import renderer.ImageRenderer;


public class PlayerLeft extends GameObject implements PhysicBody {

    private ViewFinderLeft viewFinderLeft;
    private FrameCounter frameCounter = new FrameCounter(1800);
    public BoxCollider boxCollider;



    public PlayerLeft() {
        this.position.set(50, 450);
        this.side = "left";
        this.renderer = new ImageRenderer("resources/images/player.png", 70, 50);
        this.boxCollider = new BoxCollider(70, 50);
        viewFinderLeft = GameObjectManager.instance.recycle(ViewFinderLeft.class);
    }

    @Override
    public void run() {
        if (Constant.turn == 0) {
            viewFinderLeft.isAlive = true;
            viewFinderLeft.run();
            this.boxCollider.position.set(this.position.x - 35, this.position.y - 25);
            PlayerManager.instance.shoot(this);
            PlayerManager.instance.move(this);
            if (KeyboardInput.instance.spaceReleased || frameCounter.run()) {
                Constant.turn = 1;
                viewFinderLeft.isAlive = false;
                frameCounter.reset();
            }
            KeyboardInput.instance.reset();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }

}
