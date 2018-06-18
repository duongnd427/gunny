import base.GameObjectManager;
import game.background.Background;
import game.gift.GiftSpawner;
import game.player.Player;
import game.viewFinder.ViewFinder;
import input.KeyboardInput;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;
    private Player player1, player2;
    private int turn = 0;


    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.setupCharacter();
        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new GiftSpawner());
        GameObjectManager.instance.add(new ViewFinder());
        player1 = new Player(50, 500, "resources/images/player.png");
        player2 = new Player(850, 500, "resources/images/player2.png");
//        GameObjectManager.instance.add(new ViewFinderSpawner());
    }


    @Override

    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.player1.render(graphics);
        this.player2.render(graphics);
        this.repaint();
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
        if (turn == 0) {
            this.player1.run();
            if (KeyboardInput.instance.spaceReleased)
                turn = 1;
        } else {
            this.player2.run();
            if (KeyboardInput.instance.spaceReleased)
                turn = 0;
        }
        KeyboardInput.instance.reset();
    }

}