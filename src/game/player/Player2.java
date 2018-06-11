package game.player;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Player2 extends GameObject {

    public Vector2D velocity;
    public Player2Move player2Move;

    public Player2(){
        this.position.set(950,500);
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/player2.png",150,150);
        this.player2Move = new Player2Move();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.player2Move.run(this);
    }
}
