package game.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import game.bullet.Bullet;
import game.bullet.BulletExactly;
import game.gift.GiftTriple;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.viewFinder.ViewFinderLeft;
import input.KeyboardInput;
import renderer.ImageRenderer;
import scene.GameOverScene;
import scene.SceneManager;


public class PlayerLeft extends GameObject implements PhysicBody {

    private ViewFinderLeft viewFinderLeft;
    private FrameCounter frameCounter = new FrameCounter(1800);
    public BoxCollider boxCollider;
    public int live = 5;



    public PlayerLeft() {
        this.position.set(100, 450);
        this.side = "left";
        this.renderer = new ImageRenderer("resources/images/player.png", 50, 36);
        this.boxCollider = new BoxCollider(50, 36);
        viewFinderLeft = GameObjectManager.instance.recycle(ViewFinderLeft.class);
    }

    @Override
    public void run() {

        if (Constant.turn == 0) {

                viewFinderLeft.isAlive = true;
                viewFinderLeft.run();
                this.boxCollider.position.set(this.position.x - 25, this.position.y - 18);
                PlayerManager.instance.shoot(this);
                PlayerManager.instance.move(this);
                if (KeyboardInput.instance.spaceReleased || frameCounter.run()) {
                    Constant.turn = 1;
                    viewFinderLeft.isAlive = false;
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
        }
        else {
            this.live -= 1;
        }
        if (this.live == 0) {
            this.isAlive = false;
            SceneManager.instance.changeScene(new GameOverScene());
        }
    }

}
