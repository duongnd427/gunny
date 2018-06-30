package scene;

import base.GameObjectManager;
import game.button.ReplayButton;
import game.text.TextOver;
import game.background.Background;
import utils.Utils;

import javax.sound.sampled.Clip;

public class GameOverScene implements Scene {
    private Clip clip;
    @Override
    public void init() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new TextOver());
        GameObjectManager.instance.add(new ReplayButton());
        this.clip = Utils.loadAudio("resources/audio/gameOver.wav");
        this.clip.start();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        this.clip.stop();
    }
}
