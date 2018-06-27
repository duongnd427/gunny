package game.viewFinder;

import base.GameObject;
import base.GameObjectManager;

public class ViewFinderSpawner extends GameObject {

    public ViewFinderSpawner() {
        ViewFinderLeft viewFinderLeft = GameObjectManager.instance.recycle(ViewFinderLeft.class);
        ViewFinderRight viewFinderRight = GameObjectManager.instance.recycle(ViewFinderRight.class);
        GameObjectManager.instance.add(viewFinderLeft);
        GameObjectManager.instance.add(viewFinderRight);
    }
}
