package game.player;

import base.Vector2D;
import input.KeyboardInput;

public class PlayerMove {

    public Vector2D velocity;

    public PlayerMove(){
        this.velocity = new Vector2D();
    }
    public void run(Player player){
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
        player.position.addUp(this.velocity);

        this.inScreen(player);
    }

    public void inScreen(Player player) {
        if (player.position.x <= 15) player.position.x = 15;
        if (player.position.x >= 984) player.position.x = 984;
    }

}
