package scene;

import base.GameObjectManager;
import game.button.ReplayButton;
import game.player.playerLeft.Left;
import game.text.TextLeft;
import game.background.Background;
import utils.Utils;

import javax.sound.sampled.Clip;

public class PlayerLeftWinScene implements Scene {
    private Clip clip;
    @Override
    public void init() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new Left());
        GameObjectManager.instance.add(new TextLeft());
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
