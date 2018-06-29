package scene;

import base.GameObjectManager;
import game.text.TextStart;
import game.button.StartButton;
import game.background.Background;

public class GameStartScene implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.recycle(TextStart.class);
        GameObjectManager.instance.add(new StartButton());
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
