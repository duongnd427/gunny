package game.gift;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.physic.Boxcollider;
import game.physic.PhysicBody;
import renderer.ImageRenderer;

public class Gift extends GameObject implements PhysicBody {
        public Boxcollider boxcollider;
    public Gift() {
        this.renderer = new ImageRenderer("resources/images/Gift-icon.png", 20, 20);
        this.boxcollider = new Boxcollider(20,20);
    }

    @Override
    public void run() {
        super.run();
        this.boxcollider.position.set(this.position.x - 15,this.position.y -15);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public Boxcollider getBoxCollider() {
        return this.boxcollider;
    }
}

