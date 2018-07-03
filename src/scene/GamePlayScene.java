package scene;

import base.GameObjectManager;
import constant.Constant;
import game.background.Background;
import game.gift.GiftSpawner;
import game.player.*;
import game.player.playerLeft.HpLeft;
import game.player.playerLeft.PlayerLeft;
import game.player.playerRight.HpRight;
import game.player.playerRight.PlayerRight;
import maps.Map;
import utils.Utils;

import javax.sound.sampled.Clip;

public class GamePlayScene implements Scene {
    private Clip clip;
    @Override
    public void init() {
        this.setupCharacter();
        Constant.turn = 0;
        this.clip = Utils.loadAudio("resources/audio/play.wav");
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
        this.addPlatforms();
    }

    private void addPlatforms(){
        Map map = Map.load("resources/gunny_map_lvl.json");
        map.generate();
    }


}
