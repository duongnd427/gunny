package game.player.playerRight;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import game.bullet.ExplosionSpawner;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.physic.RunHitObject;
import game.player.NextScene;
import game.player.PlayerManager;
import game.viewFinder.ViewFinderRight;
import input.KeyboardInput;
import platform.Platform;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import scene.PlayerLeftWinScene;
import scene.SceneManager;

import java.awt.*;

public class PlayerRight extends GameObject implements PhysicBody {

    private FrameCounter delay = new FrameCounter(10);
    private FrameCounter timeDelay = new FrameCounter(100);
    private FrameCounter frameCounter = new FrameCounter(1800);
    private boolean isAnimation = false;
    public BoxCollider boxCollider;
    private ViewFinderRight viewFinderRight;
    private RunHitObject runHitObject;
    private float GRAVITY = 0.05f;
    public int live = 6;


    public PlayerRight() {
        this.side = "right";
        this.position.set(900, 0);
        this.renderer = new AnimationRenderer(10,80, 60,
                "resources/images/player21.png",
                "resources/images/player22.png"
        );
        viewFinderRight = GameObjectManager.instance.recycle(ViewFinderRight.class);
        this.boxCollider = new BoxCollider(50, 60);
        viewFinderRight.isAlive = false;
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
        viewFinderRight.isAlive = false;
        this.velocity.y += GRAVITY;
        moveVertica();
        this.runHitObject.run(this);
        this.position.addUp(velocity);

        this.boxCollider.position.set(this.position.x - 25, this.position.y - 30);
        if (Constant.turn == 1) {
                viewFinderRight.isAlive = true;
                viewFinderRight.run();
            if (this.position.y > 600){
                Constant.turn = 0;
                ExplosionSpawner.instance.explosionDiePlayer(this);
                SceneManager.instance.changeScene(new PlayerLeftWinScene());
            }
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
    public void render(Graphics graphics) {
        if (isAnimation) {
            if (delay.run()){
                delay.reset();
                return;
            }
        }
        super.render(graphics);
    }

    private void moveVertica() {

        BoxCollider nextBoxCollider = boxCollider.shift(0,velocity.y);

        Platform platform = GameObjectManager.instance.checkCollision(nextBoxCollider, Platform.class);
        if(platform != null){
            velocity.y = 0;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.live -= 1;
        if (this.live < 5) this.isAnimation = true;
        if (this.live == 0) {
            this.isAlive = false;
            ExplosionSpawner.instance.explosionDiePlayer(this);
            GameObjectManager.instance.recycle(NextScene.class);
        }
    }
}
