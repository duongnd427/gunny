package game.player;

import base.GameObject;
import base.GameObjectManager;
import input.KeyboardInput;
import renderer.ImageRenderer;

import java.util.ArrayList;
import java.util.List;

public class PlayerSpawner extends GameObject {

    public List<Player> players;
    private int index = 0;


    public PlayerSpawner() {

        this.players = new ArrayList<>();
        Player player1 = GameObjectManager.instance.recycle(Player.class);
        Player player2 = GameObjectManager.instance.recycle(Player.class);
        players.add(player1);
        players.add(player2);player1.position.set(50, 500);
        player1.renderer = new ImageRenderer("resources/images/player.png", 160, 140);
        player1.position.set(850, 500);
        player1.renderer = new ImageRenderer("resources/images/player2.png", 160, 140);
    }

    @Override
    public void run() {
        super.run();
        if (index == 0) {
            players.get(index).run();
            if (KeyboardInput.instance.spaceReleased)
                index = 1;
        }
        if (index == 1) {
            players.get(index).run();
            if (KeyboardInput.instance.spaceReleased)
                index = 0;
        }
    }
}
