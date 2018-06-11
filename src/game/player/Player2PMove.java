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
        player2P.position.addUp(this.velocity);
    }

}
