package scene;

import base.GameObjectManager;
import game.background.Background;
import game.button.ReplayButton;
import game.player.playerRight.Right;
import game.text.TextRight;
import utils.Utils;

import javax.sound.sampled.Clip;

public class PlayerRightWinScene implements Scene {
    private Clip clip;
    @Override
    public void init() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new Right());
        GameObjectManager.instance.add(new TextRight());
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
