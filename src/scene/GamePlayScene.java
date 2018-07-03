package scene;

import base.FrameCounter;
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
import java.util.Random;

public class GamePlayScene implements Scene {
    private Clip clip;
    private int autoMap = new Random().nextInt(4);
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
        if (autoMap == 0) {
            this.addPlatforms1();
        } else if (autoMap == 1) {
            this.addPlatforms2();
        } else if (autoMap == 2) {
            this.addPlatforms3();
        } else if (autoMap == 3) {
            this.addPlatforms4();
        }
    }

    private void addPlatforms1() {
        Map map = Map.load("resources/gunny_map_lvl1.json");
        map.generate();
    }

    private void addPlatforms2() {
        Map map = Map.load("resources/gunny_map_lvl2.json");
        map.generate();
    }

    private void addPlatforms3() {
        Map map = Map.load("resources/gunny_map_lvl3.json");
        map.generate();
    }

    private void addPlatforms4() {
        Map map = Map.load("resources/gunny_map_lvl4.json");
        map.generate();
    }

}
