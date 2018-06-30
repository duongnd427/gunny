package game.bullet;

import base.GameObject;
import base.Vector2D;
import game.gift.Gift;
import game.gift.GiftExactly;
import game.gift.GiftTriple;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.physic.RunHitObject;
import game.player.PlayerLeft;
import game.player.PlayerRight;
import renderer.ImageRenderer;

public class Bullet extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public Bullet() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/bullet.png", 30, 16);
        this.boxCollider = new BoxCollider(30, 16);
        this.runHitObject = new RunHitObject(
                Gift.class,
                GiftTriple.class,
                GiftExactly.class,
                PlayerLeft.class,
                PlayerRight.class
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
        this.boxCollider.position.set(this.position.x - 15, this.position.y - 8);
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
