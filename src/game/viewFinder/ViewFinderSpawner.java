package game.viewFinder;

import base.GameObject;
import base.GameObjectManager;

public class ViewFinderSpawner extends GameObject {

    public static ViewFinderSpawner instance = new ViewFinderSpawner();
    private ViewFinderMove viewFinderMove;


    private ViewFinderSpawner() {
        this.viewFinderMove = new ViewFinderMove();
    }

    public void createViewFinderLeft(GameObject gameObject) {

        gameObject = GameObjectManager.instance.findCharacter("left");
        if (gameObject != null) {
            ViewFinder viewFinder = GameObjectManager.instance.recycle(ViewFinder.class);
            viewFinder.side = "left";
            viewFinder.position.set(gameObject.position.add(viewFinder.velocity));
            viewFinder.velocity.set(gameObject.position.add(viewFinder.position));
            viewFinderMove.run(viewFinder);
        }
        gameObject = null;
    }

    public void createViewFinderRight(GameObject gameObject) {

        gameObject = GameObjectManager.instance.findCharacter("right");
        if (gameObject != null) {
            ViewFinder viewFinder = GameObjectManager.instance.recycle(ViewFinder.class);
            viewFinder.side = "right";
            viewFinder.position.set(gameObject.position.add(viewFinder.velocity));
            viewFinder.velocity.set(gameObject.position.add(viewFinder.position));
            viewFinderMove.run(viewFinder);
        }
        gameObject = null;


    }
}