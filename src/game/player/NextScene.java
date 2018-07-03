package game.player;

import action.ActionAdapter;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import constant.Constant;
import scene.PlayerLeftWinScene;
import scene.PlayerRightWinScene;
import scene.Scene;
import scene.SceneManager;

public class NextScene extends GameObject {

    public NextScene() {
    }

    @Override
    public void run() {
        super.run();
        this.addAction(
                new SequenceAction(
                        new WaitAction(50),
                        new ActionAdapter() {
                            @Override
                            public boolean run(GameObject owner) {
                                if (Constant.turn == 1) {
                                    SceneManager.instance.changeScene(new PlayerRightWinScene());
                                } else if (Constant.turn == 0) {
                                    SceneManager.instance.changeScene(new PlayerLeftWinScene());
                                }
                                SceneManager.instance.changeScene(new PlayerRightWinScene());
                                return true;
                            }
                        }
                )
        );
    }
}
