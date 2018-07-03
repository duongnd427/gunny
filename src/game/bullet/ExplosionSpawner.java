package game.bullet;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.bullet.bulletLeft.BulletLeft;
import game.bullet.bulletRight.BulletRight;
import renderer.ImageRenderer;

import java.util.Random;

public class ExplosionSpawner extends GameObject {

    public static ExplosionSpawner instance = new ExplosionSpawner();

    private Random random;
    private ExplosionSpawner() {

    }

    public void explosion(GameObject gameObject) {
        for(double angle1 = 0.0; angle1 <= 360; angle1 += 23) {
            this.random = new Random();
            for (double angle = 0.0; angle <= 360.0; angle += random.nextInt(30)+30) {
                Explosion explosion = GameObjectManager.instance.recycle(Explosion.class);
                explosion.renderer = new ImageRenderer("resources/images/explore.png", 12, 12);
                explosion.position.set(gameObject.position);
                explosion.velocity.set((new Vector2D(this.random.nextInt(4)+1, 0)).rotate(angle));
                explosion.run();
            }
        }
    }

    public void explosionDiePlayer (GameObject gameObject){
        for (double angle = -180.0; angle <= 0.0; angle += 10.0) {
            if (Constant.turn == 1) {
                BulletLeft bulletLeft = GameObjectManager.instance.recycle(BulletLeft.class);
                bulletLeft.position.set(gameObject.position);
                bulletLeft.velocity.set(
                        (new Vector2D(50, 0)).rotate(angle));
                GameObjectManager.instance.add(bulletLeft);
            } else if (Constant.turn == 0) {
                BulletRight bulletRight = GameObjectManager.instance.recycle(BulletRight.class);
                bulletRight.position.set(gameObject.position);
                bulletRight.velocity.set(
                        (new Vector2D(50, 0)).rotate(angle));
                GameObjectManager.instance.add(bulletRight);
            }

        }


    }
}
