package game.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.viewFinder.ViewFinderRight;
import input.KeyboardInput;
import renderer.ImageRenderer;

public class PlayerRight extends GameObject implements PhysicBody {

    private FrameCounter frameCounter = new FrameCounter(1800);
    public BoxCollider boxCollider;
    private ViewFinderRight viewFinderRight;

    public PlayerRight() {
        this.side = "right";
        this.position.set(900, 50);
        this.renderer = new ImageRenderer("resources/images/player2.png", 60, 50);
        viewFinderRight = GameObjectManager.instance.recycle(ViewFinderRight.class);
        this.boxCollider = new BoxCollider(60, 50);
        viewFinderRight.isAlive = false;
    }

    @Override
    public void run() {
        viewFinderRight.isAlive = false;
        if (this.position.y <= 450) {
            this.position.y += 5;

        }

        if (Constant.turn == 1) {
            viewFinderRight.isAlive = true;
            viewFinderRight.run();
            this.boxCollider.position.set(this.position.x - 30 , this.position.y - 25);
            PlayerManager.instance.shoot(this);
            PlayerManager.instance.move(this);
            if (KeyboardInput.instance.spaceReleased || frameCounter.run()){
                Constant.turn = 0;
                viewFinderRight.isAlive = false;
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
