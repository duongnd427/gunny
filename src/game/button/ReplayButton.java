package game.button;

import base.GameObject;
import input.MouseInput;
import renderer.ImageRenderer;
import scene.GamePlayScene;
import scene.SceneManager;
import utils.Utils;

import javax.sound.sampled.Clip;

public class ReplayButton extends GameObject {
    private Clip clip;
    public ReplayButton() {
        this.position.set(500, 350);
        this.renderer = new ImageRenderer("resources/images/replay.png", 120, 120);
    }

    @Override
    public void run() {
        super.run();
        if (MouseInput.instance.isClicked
                && MouseInput.instance.position.x > (position.x - 120 / 2)
                && MouseInput.instance.position.x < (position.x + 120 / 2)
                && MouseInput.instance.position.y > (position.y - 120 / 2)
                && MouseInput.instance.position.y < (position.y + 120 / 2)
                ) {
            this.clip = Utils.loadAudio("resources/audio/button.wav");
            this.clip.start();
            SceneManager.instance.changeScene(new GamePlayScene());
        }
    }
}
