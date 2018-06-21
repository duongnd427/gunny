package game.bullet;

import base.GameObject;
import base.Vector2D;
import game.gift.Gift;
import game.physic.BoxCollider;
import game.physic.PhysicBody;
import game.physic.RunHitObject;
import renderer.ImageRenderer;

public class Bullet extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public Bullet() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/bullet.png",40,30);
        this.boxCollider = new BoxCollider(40,30);
        this.runHitObject = new RunHitObject(
                Gift.class
        );
    }

    @Override
    public void run(){
        super.run();
        this.boxCollider.position.set(this.position.x -10,this.position.y-7);
        this.velocity.addUp(0,1f);
        this.position.addUp(this.velocity);
        this.runHitObject.run(this);
        this.dieBullet();
    }

    public void dieBullet() {
        if (this.position.y > 600)
            this.isAlive = false;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof Gift) {
            this.isAlive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
