import base.GameObjectManager;
import game.background.Background;
import game.gift.GiftSpawner;
import game.player.PlayerLeft;
import game.player.PlayerRight;
import game.player.PlayerSpawner;
import game.viewFinder.ViewFinderLeft;
import game.viewFinder.ViewFinderRight;
import game.viewFinder.ViewFinderSpawner;
import input.KeyboardInput;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;


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
//        GameObjectManager.instance.add(new PlayerLeft());
//        GameObjectManager.instance.add(new PlayerRight());
        GameObjectManager.instance.add(new PlayerSpawner());
//        GameObjectManager.instance.add(new ViewFinderLeft());
//        GameObjectManager.instance.add(new ViewFinderRight());
        GameObjectManager.instance.add(new ViewFinderSpawner());
    }


    @Override

    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
        KeyboardInput.instance.reset();
    }

}