package game.bullet;

import base.GameObject;
import base.Vector2D;
import game.gift.Gift;
import game.gift.GiftExactly;
import game.gift.GiftLive;
import game.gift.GiftTriple;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.physic.RunHitObject;
import game.player.PlayerLeft;
import game.player.PlayerRight;
import renderer.ImageRenderer;

public class BulletExactly extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public BulletExactly() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/bullet.png", 50, 26);
        this.boxCollider = new BoxCollider(50, 26);
        this.runHitObject = new RunHitObject(
                Gift.class,
                GiftTriple.class,
                GiftExactly.class,
                PlayerLeft.class,
                PlayerRight.class,
                GiftLive.class
        );
    }

    private void dieBullet() {
        if (this.position.x < 0 || this.position.x > 1024 || this.position.y > 600)
            this.isAlive = false;
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 25, this.position.y - 13);
        this.position.addUp(this.velocity);
        this.dieBullet();
        this.runHitObject.run(this);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
        ExplosionSpawner.instance.explosion(this);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
