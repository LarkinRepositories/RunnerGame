package com.mygdx.game.Obstacles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Spikes {
    private Texture texture;
    private Vector2 position;
    private Rectangle rectangle;

    private final int WIDTH = 80;
    private final int HEIGHT = 80;

    public Vector2 getPosition() {
        return position;
    }
    public Rectangle getRectangle() {
        return rectangle;
    }

    public Spikes(Vector2 position) {
        this.texture = new Texture("Obstacles/spikes_1.png");
        this.position = position;
        this.rectangle = new Rectangle(position.x, position.y, WIDTH, HEIGHT);
    }

    public void setPosition(float x, float y) {
        position.set(x,y);
        rectangle.setPosition(position);
    }

    public void render(SpriteBatch batch, float worldX) {
        batch.draw(texture, position.x - worldX, position.y);
    }


}
