import base.GameObjectManager;
import game.background.Background;
import game.gift.GiftSpawner;
import game.player.Player1;
import game.player.Player2;
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
        GameObjectManager.instance.add(new Player1());
        GameObjectManager.instance.add(new Player2());
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