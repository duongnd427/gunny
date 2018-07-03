package game.bullet.bulletRight;

import base.GameObject;
import base.Vector2D;
import game.bullet.ExplosionSpawner;
import game.gift.Gift;
import game.gift.GiftExactly;
import game.gift.GiftTriple;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.physic.RunHitObject;
import game.player.playerLeft.PlayerLeft;
import game.player.playerRight.PlayerRight;
import platform.Platform;
import renderer.AnimationRenderer;
import utils.Utils;

import javax.sound.sampled.Clip;

public class BulletRight extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private Clip clip;

    public BulletRight() {
        this.velocity = new Vector2D();
        this.renderer = new AnimationRenderer(2, 40, 40,
                "resources/images/bulletright1.png",
                "resources/images/bulletright2.png",
                "resources/images/bulletright3.png",
                "resources/images/bulletright4.png",
                "resources/images/bulletright5.png",
                "resources/images/bulletright6.png",
                "resources/images/bulletright7.png",
                "resources/images/bulletright8.png"
                );
        this.boxCollider = new BoxCollider(30, 30);
        this.runHitObject = new RunHitObject(
                Gift.class,
                GiftTriple.class,
                GiftExactly.class,
                PlayerLeft.class,
                PlayerRight.class,
                Platform.class
        );
    }

    private void dieBullet() {
        if (this.position.x < 0 || this.position.x > 1024 || this.position.y > 600)
            this.isAlive = false;
    }

    @Override
    public void run() {
        super.run();
        this.velocity.addUp(0, 1);
        this.boxCollider.position.set(this.position.x - 15, this.position.y - 15);
        this.position.addUp(this.velocity);
        this.dieBullet();
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
