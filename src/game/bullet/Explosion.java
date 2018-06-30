package game.bullet;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Explosion extends GameObject {

    private FrameCounter frameCounter;


    public Explosion() {
        this.frameCounter = new FrameCounter(3);
    }


    @Override
    public void run(){
        super.run();
        ImageRenderer imageRenderer = (ImageRenderer)this.renderer;
        this.position.addUp(this.velocity);
        if(frameCounter.run()) {
            if (imageRenderer != null) {
                imageRenderer.width -= 1;
                imageRenderer.height -= 1;
                if (imageRenderer.width == 0 || imageRenderer.height == 0) {
                    this.isAlive = false;
                }
            }
            frameCounter.reset();
        }



    }
}
