package input;

import base.Vector2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    public static MouseInput instance = new MouseInput();

    public Vector2D position = new Vector2D();
    public boolean isClicked;
    public boolean isReleased;
    private MouseInput() {
    }

    public void reset() {
        isReleased = false;
        isClicked = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.isClicked = true;
        this.position.set(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.isReleased = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
