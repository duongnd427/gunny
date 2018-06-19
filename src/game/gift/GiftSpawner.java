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
        this.frameCounter = new FrameCounter(100);
    }

    @Override
    public void run(){
        super.run();
        if (this.frameCounter.run()) {
            Gift gift = GameObjectManager.instance.recycle(Gift.class);
            gift.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            GameObjectManager.instance.add(gift);
            this.frameCounter.reset();
        }
    }
}
