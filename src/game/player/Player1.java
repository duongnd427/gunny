package game.player;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Player1 extends GameObject{

    public Vector2D velocity;
    public Player1Move player1Move;
    public PlayerShoot playerShoot;

    public Player1(){
        this.position.set(50,500);
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/player.png",150,100);
        this.player1Move = new Player1Move();
        this.playerShoot = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.player1Move.run(this);
        this.playerShoot.run(this);
    }
}
