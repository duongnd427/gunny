package game.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import game.gift.GiftTriple;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.viewFinder.ViewFinderRight;
import input.KeyboardInput;
import renderer.ImageRenderer;
import scene.GameOverScene;
import scene.SceneManager;

public class PlayerRight extends GameObject implements PhysicBody {

    private FrameCounter frameCounter = new FrameCounter(1800);
    public BoxCollider boxCollider;
    private ViewFinderRight viewFinderRight;
    public int live = 5;

    public PlayerRight() {
        this.side = "right";
        this.position.set(900, 450);
        this.renderer = new ImageRenderer("resources/images/player2.png", 40, 40);
        viewFinderRight = GameObjectManager.instance.recycle(ViewFinderRight.class);
        this.boxCollider = new BoxCollider(40, 40);
        viewFinderRight.isAlive = false;
    }

    @Override
    public void run() {
        viewFinderRight.isAlive = false;

        if (Constant.turn == 1) {
                viewFinderRight.isAlive = true;
                viewFinderRight.run();
                this.boxCollider.position.set(this.position.x - 20, this.position.y - 20);
                PlayerManager.instance.shoot(this);
                PlayerManager.instance.move(this);
                if (KeyboardInput.instance.spaceReleased || frameCounter.run()) {
                    Constant.turn = 0;
                    viewFinderRight.isAlive = false;
                    frameCounter.reset();
                    Constant.countMove = 0;
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
        if (gameObject instanceof GiftTriple) {
            this.live += 2;
        } else {
            this.live -= 1;
        }
        if (this.live == 0) {
            this.isAlive = false;
            SceneManager.instance.changeScene(new GameOverScene());
        }
    }
}
