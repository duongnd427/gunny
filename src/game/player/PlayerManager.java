package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import game.bullet.bulletLeft.BulletLeft;
import game.bullet.bulletRight.BulletRight;
import game.player.playerLeft.PlayerLeft;
import game.player.playerRight.PlayerRight;
import game.viewFinder.ViewFinderLeft;
import game.viewFinder.ViewFinderRight;
import input.KeyboardInput;

public class PlayerManager extends GameObject {

    public static PlayerManager instance = new PlayerManager();


    private Vector2D velocity;

    private PlayerManager() {
        this.velocity = new Vector2D();
    }

    public void move(GameObject gameObject) {
        if (Constant.countMove != 3) {
            if (KeyboardInput.instance.leftPressed) {
                this.velocity.x -= 10;
            }
            if (KeyboardInput.instance.rightPressed) {
                this.velocity.x += 10;
            }
            if (KeyboardInput.instance.leftReleased) {
                this.velocity.x = 0;Constant.countMove += 1;
            }
            if (KeyboardInput.instance.rightReleased) {
                this.velocity.x = 0;Constant.countMove += 1;
            }
            gameObject.position.addUp(this.velocity);
            this.inScreen(gameObject);
        }
    }

    private void inScreen(GameObject gameObject) {
        if (gameObject.position.x <= 10) gameObject.position.x = 10;
        if (gameObject.position.x >= 1000) gameObject.position.x = 1000;
    }

    public void shoot(GameObject gameObject) {
        if (KeyboardInput.instance.spacePressed) {
            Constant.pow += 1;
            if (Constant.pow == 121) {
                Constant.pow = 5;
            }
        }

        if (KeyboardInput.instance.spaceReleased) {
            if (Constant.turn == 0) {
                BulletLeft bulletLeft = GameObjectManager.instance.recycle(BulletLeft.class);
                ViewFinderLeft viewFinderLeft = GameObjectManager.instance.findViewFinderLeft("left");
                PlayerLeft playerLeft = GameObjectManager.instance.findPlayerLeft("left");
                bulletLeft.position.set(gameObject.position.add(viewFinderLeft.position.subtract(playerLeft.position)));
                bulletLeft.velocity.set((viewFinderLeft.position.subtract(playerLeft.position)).normalize().multiply((Constant.pow / 2)));

            } else if (Constant.turn == 1) {
                BulletRight bulletRight = GameObjectManager.instance.recycle(BulletRight.class);

                ViewFinderRight viewFinderRight = GameObjectManager.instance.findViewFinderRight("right");
                PlayerRight playerRight = GameObjectManager.instance.findPlayerRight("right");
                bulletRight.position.set(gameObject.position.add(viewFinderRight.position.subtract(playerRight.position)));
                bulletRight.velocity.set((viewFinderRight.position.subtract(playerRight.position)).normalize().multiply((Constant.pow / 2)));
            }
            Constant.pow = 0;
        }
    }
}

