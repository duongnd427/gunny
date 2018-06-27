package game.player;

import base.GameObject;
import base.GameObjectManager;

public class PlayerSpawner extends GameObject {

    public PlayerSpawner() {
        PlayerLeft playerLeft = GameObjectManager.instance.recycle(PlayerLeft.class);
        GameObjectManager.instance.add(playerLeft);
        PlayerRight playerRight = GameObjectManager.instance.recycle(PlayerRight.class);
        GameObjectManager.instance.add(playerRight);
    }

}
