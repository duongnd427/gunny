package platform;

import base.GameObject;
import game.bullet.bulletLeft.BulletLeft;
import game.bullet.bulletLeft.BulletExactlyLeft;
import game.bullet.bulletRight.BulletExactlyRight;
import game.bullet.bulletRight.BulletRight;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import renderer.ImageRenderer;

public class Platform extends GameObject implements PhysicBody {

    private BoxCollider boxCollider;

    public Platform() {
        this.renderer = new ImageRenderer("resources/images/platformBlock1.png", 32, 32);
        this.boxCollider = new BoxCollider(32, 32);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 16, this.position.y - 16);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof BulletLeft || gameObject instanceof BulletRight) {
            this.isAlive = false;
        }
        if (gameObject instanceof BulletExactlyLeft || gameObject instanceof BulletExactlyRight) {
            this.isAlive = false;
        }
    }
}
