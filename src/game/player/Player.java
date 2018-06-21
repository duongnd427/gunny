package game.player;

import base.GameObject;
import base.Vector2D;
import game.viewFinder.ViewFinder;
import renderer.ImageRenderer;

public class Player extends GameObject{

    public Vector2D velocity;
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    public ViewFinder viewFinder;

    public Player(int x, int y, String path){
        this.position.set(x,y);
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer(path,100,80);
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
    }

    public Player() {
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.playerMove.run(this);
        this.playerShoot.run(this);

    }
}
