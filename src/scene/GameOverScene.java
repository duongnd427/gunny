package scene;

import base.GameObjectManager;
import game.button.ReplayButton;
import game.text.TextOver;
import game.background.Background;

public class GameOverScene implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new TextOver());
        GameObjectManager.instance.add(new ReplayButton());
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
