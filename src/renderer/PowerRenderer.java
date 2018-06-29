package renderer;

import base.Vector2D;

import java.awt.*;

public class PowerRenderer implements Renderer {
    public int width;
    private int height;
    private Color color;

    public PowerRenderer(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(this.color);
        graphics.fillRect(200, 520, this.width, this.height);
        graphics.setColor(Color.lightGray);
        graphics.drawRect(200, 520, 600, 30);
    }
}
