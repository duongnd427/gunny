package game.player;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Player2P extends GameObject {

    public Vector2D velocity;
    public Player2PMove player2PMove;

    public Player2P(){
        this.position.set(950,500);
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/player.png",40,40);
        this.player2PMove = new Player2PMove();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.player2PMove.run(this);
    }
}
