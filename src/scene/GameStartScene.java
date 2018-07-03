package scene;

import base.GameObjectManager;
import game.text.TextStart;
import game.button.StartButton;
import game.background.Background;
import utils.Utils;

import javax.sound.sampled.Clip;

public class GameStartScene implements Scene {

    private Clip clip;
    @Override
    public void init() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.recycle(TextStart.class);
        GameObjectManager.instance.add(new StartButton());
        this.clip = Utils.loadAudio("resources/audio/gamestart.wav");
        this.clip.start();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        this.clip.stop();
    }
}
