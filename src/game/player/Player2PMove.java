package game.player;

import base.Vector2D;
import input.KeyboardInput;

public class Player2PMove {

    public Vector2D velocity;

    public Player2PMove(){
        this.velocity = new Vector2D();
    }
    public void run(Player2P player2P){
        if (KeyboardInput.instance.leftPressed) {
            this.velocity.x -= 10;
        }
        if (KeyboardInput.instance.rightPressed) {
            this.velocity.x += 10;
        }
        if (KeyboardInput.instance.leftReleased) {
            this.velocity.x = 0;
        }
        if (KeyboardInput.instance.rightReleased) {
            this.velocity.x = 0;
        }
        player2P.position.addUp(this.velocity);

        this.inScreen(player2P);
    }

    public void inScreen(Player2P player2P) {
        if (player2P.position.x <= 15) player2P.position.x = 15;
        if (player2P.position.x >= 984) player2P.position.x = 984;
    }

}
