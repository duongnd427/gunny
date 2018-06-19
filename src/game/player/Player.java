package game.player;

import base.GameObject;
import base.Vector2D;
import game.viewFinder.ViewFinder;

public class Player extends GameObject {

    public Vector2D velocity;
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    public ViewFinder viewFinder;
    public PlayerSpawner playerSpawner;

    public Player() {

        this.playerSpawner = new PlayerSpawner();
        this.velocity = new Vector2D();
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.viewFinder = new ViewFinder();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);

    }
}
