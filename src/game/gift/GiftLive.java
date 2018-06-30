package game.gift;

import base.GameObject;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import renderer.ImageRenderer;

public class GiftLive extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;

    public GiftLive() {
        this.renderer = new ImageRenderer("resources/images/Gift-icon.png", 30, 30);
        this.boxCollider = new BoxCollider(30, 30);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 15, this.position.y - 15);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
