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
        this.renderer = new ImageRenderer("resources/images/bullet.png",50,26);
        this.boxCollider = new BoxCollider(25,25);
        this.runHitObject = new RunHitObject(
                Gift.class
        );
    }

    private void dieBullet() {
        if (this.position.x < 0 || this.position.x > 1024 || this.position.y >600)
            this.isAlive = false;
    }

    @Override
    public void run(){
        super.run();
        this.velocity.addUp(0,1);
        this.boxCollider.position.set(this.position.x -25,this.position.y-13);
        this.position.addUp(this.velocity);
        this.dieBullet();
        this.runHitObject.run(this);
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
