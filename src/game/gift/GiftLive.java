package game.gift;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.bullet.BulletLive;
import game.bullet.bulletLeft.BulletExactlyLeft;
import game.bullet.bulletRight.BulletExactlyRight;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.player.playerLeft.PlayerLeft;
import game.player.playerRight.PlayerRight;
import renderer.ImageRenderer;

public class GiftLive extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;

    public GiftLive() {
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
        BulletLive bulletLive = GameObjectManager.instance.recycle(BulletLive.class);

        if (Constant.turn == 1) {
            bulletLive.position.set(this.position);
            PlayerLeft playerLeft = GameObjectManager.instance.findPlayerLeft("left");
            bulletLive.velocity.set((playerLeft.position.subtract(this.position).normalize()));
        }
        if (Constant.turn == 0) {
            bulletLive.position.set(this.position);
            PlayerRight playerRight = GameObjectManager.instance.findPlayerRight("right");
            bulletLive.velocity.set((playerRight.position.subtract(this.position).normalize()));
        }
    }
}
