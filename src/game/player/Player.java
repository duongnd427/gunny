package game.player;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Player extends GameObject{

    public Vector2D velocity;
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;

    public Player(int x, int y, String path){
        this.position.set(x,y);
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer(path,160,140);
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.playerMove.run(this);
        this.playerShoot.run(this);

    }
}
