package game.button;

import base.GameObject;
import input.MouseInput;
import renderer.ImageRenderer;
import scene.GamePlayScene;
import scene.SceneManager;

public class StartButton extends GameObject {
    public StartButton(){
        this.position.set(500,350);
        this.renderer = new ImageRenderer("resources/images/Play-Button.png",130,130);
    }
    @Override
    public void run() {
        super.run();
        if (MouseInput.instance.isClicked
                && MouseInput.instance.position.x > (position.x - 130 / 2)
                && MouseInput.instance.position.x < (position.x + 130 / 2)
                && MouseInput.instance.position.y > (position.y - 130 / 2)
                && MouseInput.instance.position.y < (position.y + 130 / 2)
                ) {
            SceneManager.instance.changeScene(new GamePlayScene());
        }
    }
}
