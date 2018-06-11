package game.player;

import base.Vector2D;
import input.KeyboardInput;

public class Player2Move {

    public Vector2D velocity;

    public Player2Move(){
        this.velocity = new Vector2D();
    }
    public void run(Player2 player2){
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
        player2.position.addUp(this.velocity);

        this.inScreen(player2);
    }

    public void inScreen(Player2 player2) {
        if (player2.position.x <= 15) player2.position.x = 15;
        if (player2.position.x >= 984) player2.position.x = 984;
    }

}
