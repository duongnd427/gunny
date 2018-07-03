package game.gift;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class GiftSpawner extends GameObject {
    private FrameCounter frameCounter;
    private Random random;

    public GiftSpawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(1000);
    }

    @Override
    public void run() {
        super.run();
        int auto = random.nextInt(3);

        if (this.frameCounter.run()) {
            if (auto == 0) {
                Gift gift = GameObjectManager.instance.recycle(Gift.class);
                gift.position.set(this.random.nextInt(800) + 100, this.random.nextInt(300) + 50);
            } else if (auto == 1) {
                GiftExactly giftExactly = GameObjectManager.instance.recycle(GiftExactly.class);
                giftExactly.position.set(this.random.nextInt(800) + 100, this.random.nextInt(400) + 50);
            } else if (auto == 2) {
                GiftTriple giftTriple = GameObjectManager.instance.recycle(GiftTriple.class);
                giftTriple.position.set(this.random.nextInt(800) + 100, this.random.nextInt(400) + 50);
            }

            this.frameCounter.reset();
        }
    }

}
