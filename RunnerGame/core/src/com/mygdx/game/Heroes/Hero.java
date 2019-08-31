package com.mygdx.game.Heroes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;

public abstract class Hero {
    private GameScreen gameScreen;

    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;

    private float score;

    private final int WIDTH = 100;
    private final int HEIGHT = 100;

    public Vector2 getPosition() {
        return position;
    }

    public Hero(GameScreen gameScreen, Texture texture, Vector2 position, Vector2 velocity) {
        this.gameScreen = gameScreen;
        this.texture = texture;
        this.position = position;
        this.velocity = velocity;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, gameScreen.getPlayerAnchor(), position.y,0,0,WIDTH, HEIGHT);

    }

    abstract void update(float deltaTime);

}
