package game.physic;

import base.GameObject;

public interface PhysicBody {

    Boxcollider getBoxCollider();

    void getHit(GameObject gameObject);
}
