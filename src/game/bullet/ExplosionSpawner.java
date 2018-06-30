package game.bullet;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
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
}
