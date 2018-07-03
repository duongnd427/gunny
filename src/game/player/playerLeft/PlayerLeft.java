package game.player.playerLeft;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import game.bullet.BulletLive;
import game.bullet.ExplosionSpawner;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.physic.RunHitObject;
import game.player.NextScene;
import game.player.PlayerManager;
import game.viewFinder.ViewFinderLeft;
import input.KeyboardInput;
import platform.Platform;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import scene.PlayerRightWinScene;
import scene.SceneManager;

import java.awt.*;


public class PlayerLeft extends GameObject implements PhysicBody {

    private ViewFinderLeft viewFinderLeft;
    private FrameCounter delay = new FrameCounter(10);
    private FrameCounter timeDelay = new FrameCounter(100);
    private FrameCounter frameCounter = new FrameCounter(1800);
    public BoxCollider boxCollider;
    private boolean isAnimation = false;
    private float GRAVITY = 0.05f;
    private RunHitObject runHitObject;
    public int live = 6;



    public PlayerLeft() {
        this.position.set(100, 0);
        this.side = "left";
        this.renderer = new AnimationRenderer(10, 70, 50,
                "resources/images/player11.png",
                "resources/images/player12.png"
                );
        this.boxCollider = new BoxCollider(70, 50);
        viewFinderLeft = GameObjectManager.instance.recycle(ViewFinderLeft.class);
        this.runHitObject = new RunHitObject(
                Platform.class
        );
    }

    @Override
    public void run() {
        super.run();
        if (isAnimation) {
            if (timeDelay.run()) {
                timeDelay.reset();
                isAnimation = false;
            }
        }
        this.velocity.y += GRAVITY;
        moveVertica();
        this.position.addUp(velocity);
        this.runHitObject.run(this);

        if (Constant.turn == 0) {
            if (this.position.y > 600){
                Constant.turn = 1;
                ExplosionSpawner.instance.explosionDiePlayer(this);
                GameObjectManager.instance.recycle(NextScene.class);
            }
                viewFinderLeft.isAlive = true;
                viewFinderLeft.run();
                this.boxCollider.position.set(this.position.x - 35, this.position.y - 25);
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

    private void moveVertica() {

        BoxCollider nextBoxCollider = boxCollider.shift(0,velocity.y);

        Platform platform = GameObjectManager.instance.checkCollision(nextBoxCollider, Platform.class);
        if(platform != null){
            velocity.y = 0;
        }
    }

    @Override
    public void render(Graphics graphics) {
        if (isAnimation) {
            if (delay.run()){
                delay.reset();
                return;
            }
        }
        super.render(graphics);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof BulletLive) {
            if (this.live == 5) {
                this.live += 1;
            }
            if (this.live == 4) {
                this.live += 2;
            }
            if (this.live < 4) {
                this.live += 3;
            }
        }
        this.live -= 1;
        if (this.live < 5) this.isAnimation = true;
        if (this.live == 0) {
            this.isAlive = false;
            ExplosionSpawner.instance.explosionDiePlayer(this);
            GameObjectManager.instance.recycle(NextScene.class);
        }
    }

}
