package game.gift;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.bullet.Bullet;
import game.bullet.BulletExactly;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.player.PlayerLeft;
import game.player.PlayerRight;
import renderer.ImageRenderer;

public class GiftExactly extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;

    public GiftExactly() {
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
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
        BulletExactly bulletExactly = GameObjectManager.instance.recycle(BulletExactly.class);
        bulletExactly.position.set(this.position);
        if (Constant.turn == 0) {
            PlayerLeft playerLeft = GameObjectManager.instance.findPlayerLeft("left");
            bulletExactly.velocity.set((playerLeft.position.subtract(this.position).normalize().multiply(10.0f)));
        }
        if (Constant.turn == 1) {
            PlayerRight playerRight = GameObjectManager.instance.findPlayerRight("right");
            bulletExactly.velocity.set((playerRight.position.subtract(this.position).normalize().multiply(10.0f)));
        }
    }

}
