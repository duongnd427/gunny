package scene;

import base.GameObjectManager;
import game.background.Background;
import game.gift.GiftSpawner;
import game.player.*;
import utils.Utils;

import javax.sound.sampled.Clip;

public class GamePlayScene implements Scene {
    private Clip clip;
    @Override
    public void init() {
        this.setupCharacter();
        this.clip = Utils.loadAudio("resources/audio/gamePlay.wav");
        this.clip.start();
        this.clip.loop(-1);
    }
    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        this.clip.stop();
    }
    private void setupCharacter() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new GiftSpawner());
        GameObjectManager.instance.add(new PlayerLeft());
        GameObjectManager.instance.add(new PlayerRight());
        GameObjectManager.instance.add(new Power());
        GameObjectManager.instance.add(new HpLeft());
        GameObjectManager.instance.add(new HpRight());
    }

}
