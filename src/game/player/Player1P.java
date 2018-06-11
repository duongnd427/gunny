package game.player;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Player1P extends GameObject{

    public Vector2D velocity;
    public Player1PMove player1PMove;

    public Player1P(){
        this.position.set(50,500);
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/player.png",150,100);
        this.player1PMove = new Player1PMove();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.player1PMove.run(this);
    }
}
