package game.player;

import base.Vector2D;
import input.KeyboardInput;

public class Player1Move {

    public Vector2D velocity;

    public Player1Move(){
        this.velocity = new Vector2D();
    }
    public void run(Player1 player1){
        if (KeyboardInput.instance.aPressed) {
            this.velocity.x -= 10;
        }
        if (KeyboardInput.instance.dPressed) {
            this.velocity.x += 10;
        }
        if (KeyboardInput.instance.aReleased) {
            this.velocity.x = 0;
        }
        if (KeyboardInput.instance.dReleased) {
            this.velocity.x = 0;
        }
        player1.position.addUp(this.velocity);

        this.inScreen(player1);
    }

    public void inScreen(Player1 player1) {
        if (player1.position.x <= 20) player1.position.x = 20;
        if (player1.position.x >= 974) player1.position.x = 974;
    }
}
