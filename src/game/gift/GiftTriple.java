package game.gift;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.bullet.bulletLeft.BulletLeft;
import game.bullet.bulletRight.BulletRight;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import renderer.ImageRenderer;

public class GiftTriple extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    private Vector2D velocity;

    public GiftTriple() {
        this.renderer = new ImageRenderer("resources/images/Gift-icon.png", 30, 30);
        this.boxCollider = new BoxCollider(30, 30);
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 15, this.position.y - 15);
    }


    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
        for (double alpha = -135.0; alpha <= 0.0; alpha += 40) {
            if (Constant.turn == 1) {
                BulletLeft bulletLeft = GameObjectManager.instance.recycle(BulletLeft.class);
                bulletLeft.position.set(this.position);

                Vector2D rotate = velocity.add
                        (new Vector2D(10, 0)).rotate(alpha);
                bulletLeft.velocity.set(rotate);

                GameObjectManager.instance.add(bulletLeft);
            } else if (Constant.turn == 0) {
                BulletRight bulletRight = GameObjectManager.instance.recycle(BulletRight.class);
                bulletRight.position.set(this.position);

                Vector2D rotate = velocity.add
                        (new Vector2D(10, 0)).rotate(alpha);
                bulletRight.velocity.set(rotate);

                GameObjectManager.instance.add(bulletRight);
            }

        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

}
