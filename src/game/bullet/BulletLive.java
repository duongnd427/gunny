package game.bullet;

import base.GameObject;
import base.Vector2D;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.physic.RunHitObject;
import game.player.playerLeft.PlayerLeft;
import game.player.playerRight.PlayerRight;
import renderer.AnimationRenderer;
import utils.Utils;

import javax.sound.sampled.Clip;

public class BulletLive extends GameObject implements PhysicBody {


    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private Clip clip;

    public BulletLive() {
        this.velocity = new Vector2D();
        this.renderer = new AnimationRenderer(10, 40, 40,
                "resources/images/heart1.png",
                "resources/images/heart2.png"
        );
        this.boxCollider = new BoxCollider(30, 30);
        this.runHitObject = new RunHitObject(
                PlayerLeft.class,
                PlayerRight.class
        );
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 15, this.position.y - 15);
        this.position.addUp(this.velocity);
        this.runHitObject.run(this);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
        this.clip = Utils.loadAudio("resources/audio/bullet.wav");
        this.clip.start();
        ExplosionSpawner.instance.explosion(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
