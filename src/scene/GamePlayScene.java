package scene;

import base.GameObjectManager;
import game.background.Background;
import game.gift.GiftSpawner;
import game.player.PlayerLeft;
import game.player.PlayerRight;
import game.player.Power;

public class GamePlayScene implements Scene {
    @Override
    public void init() {
        this.setupCharacter();
    }
    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
    private void setupCharacter() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new GiftSpawner());
        GameObjectManager.instance.add(new PlayerLeft());
        GameObjectManager.instance.add(new PlayerRight());
        GameObjectManager.instance.add(new Power());
    }

}
