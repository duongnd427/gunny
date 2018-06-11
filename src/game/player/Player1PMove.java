package game.player;

import base.Vector2D;
import input.KeyboardInput;

public class Player1PMove {

    public Vector2D velocity;

    public Player1PMove(){
        this.velocity = new Vector2D();
    }
    public void run(Player1P player1P){
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
        player1P.position.addUp(this.velocity);

        this.inScreen(player1P);
    }

    public void inScreen(Player1P player1P) {
        if (player1P.position.x <= 20) player1P.position.x = 20;
        if (player1P.position.x >= 974) player1P.position.x = 974;
    }
}
