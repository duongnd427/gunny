package game.gift;

import base.GameObject;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import renderer.ImageRenderer;

public class Gift extends GameObject implements PhysicBody {
        public BoxCollider boxCollider;
    public Gift() {
        this.renderer = new ImageRenderer("resources/images/Gift-icon.png", 20, 20);
        this.boxCollider = new BoxCollider(20,20);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 15,this.position.y -15);
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

