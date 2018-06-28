package game.physic;

import base.Vector2D;

import java.awt.*;

public class BoxCollider {
    public Vector2D position;
    public int width;
    public int heigh;

    public BoxCollider(int width, int heigh) {
        this.width = width;
        this.heigh = heigh;
        this.position = new Vector2D();
    }

    public boolean checkBoxCollider(BoxCollider other) {
        Rectangle r1 = new Rectangle((int) this.position.x, (int) this.position.y, this.width, this.heigh);
        Rectangle r2 = new Rectangle((int) other.position.x, (int) other.position.y, other.width, other.heigh);
        return r1.intersects(r2);
    }
}
