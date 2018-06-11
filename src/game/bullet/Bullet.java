package game.bullet;

import base.GameObject;
import base.Vector2D;
import game.gift.Gift;
import game.physic.Boxcollider;
import game.physic.PhysicBody;
import game.physic.RunHitObject;
import renderer.ImageRenderer;

public class Bullet extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public Boxcollider boxcollider;
    private RunHitObject runHitObject;

    public Bullet() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/bullet.png",50,26);
        this.boxcollider = new Boxcollider(25,25);
        this.runHitObject = new RunHitObject(
                Gift.class
        );
    }

    @Override
    public void run(){
        super.run();
        this.boxcollider.position.set(this.position.x -25,this.position.y-13);
        this.position.addUp(this.velocity);
        this.runHitObject.run(this);
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof Gift) {
            this.isAlive = false;
        }
    }

    @Override
    public Boxcollider getBoxCollider() {
        return this.boxcollider;
    }
}
