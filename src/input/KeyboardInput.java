package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

    public  static KeyboardInput instance = new KeyboardInput();

    public boolean leftPressed;
    public boolean leftReleased;
    public boolean rightPressed;
    public boolean rightReleased;
    public boolean upPressed;
    public boolean upReleased;
    public boolean downPressed;
    public boolean downReleased;
    public boolean spacePressed;
    public boolean spaceReleased;
    public boolean wPressed;
    public boolean wReleased;
    public boolean aPressed;
    public boolean aReleased;
    public boolean sPressed;
    public boolean sReleased;
    public boolean dPressed;
    public boolean dReleased;



    private KeyboardInput(){

    }

    public  void reset() {
        this.leftReleased = false;
        this.leftPressed = false;
        this.rightReleased = false;
        this.upReleased = false;
        this.spaceReleased = false;
        this.rightPressed = false;
        this.upPressed = false;
        this.spacePressed = false;
        this.downPressed = false;
        this.downReleased = false;
        this.wPressed = false;
        this.wReleased = false;
        this.aPressed = false;
        this.aReleased = false;
        this.sPressed = false;
        this.sReleased = false;
        this.dPressed = false;
        this.dReleased = false;

    }

    @Override
    public void keyTyped(KeyEvent e){


    }
    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            this.leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.rightPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            this.upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            this.downPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            this.spacePressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A){
            this.aPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S){
            this.sPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            this.dPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W){
            this.wPressed = true;
        }

    }
    @Override
    public void keyReleased(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            this.leftReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.rightReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            this.upReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            this.downReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            this.spaceReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W){
            this.wReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A){
            this.aReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            this.dReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S){
            this.sReleased = true;
    }
}
}
