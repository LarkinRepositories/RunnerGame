package com.mygdx.game.Heroes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameScreen;
import com.mygdx.game.GameScreen2;

public class Player {
    private GameScreen2 gameScreen;

    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;

    private float score;

    private final int WIDTH = 250;
    private final int HEIGHT = 400;

    private float time;

    public Vector2 getPosition() {
        return position;
    }

    public Player(GameScreen2 gameScreen) {
        this.gameScreen = gameScreen;
        this.texture = new Texture("player/Punk_run.png");
        this.position = new Vector2(10,0);
        this.velocity = new Vector2(240.0f, 0.0f);
        this.score = 0;
    }

    public void render(SpriteBatch batch) {

        int frame = (int) (time / 0.1f);
        frame = frame % 8;
        batch.draw(texture, gameScreen.getPlayerAnchor(), position.y,frame * 260,0,WIDTH,HEIGHT);
       // batch.draw(texture, gameScreen.getPlayerAnchor(),position.y, 100,0,WIDTH,HEIGHT);

    }

    public void update(float deltaTime) {
        if (position.y > gameScreen.getGroundHeight()) {
            velocity.y -= 700.0f * deltaTime;
        } else {
            position.y = gameScreen.getGroundHeight();
            velocity.y = 0.0f;
            time += velocity.x *deltaTime / 300f;
        }
        if (Gdx.input.justTouched()) {
            velocity.y = 420;
        }
        position.mulAdd(velocity, deltaTime);
        velocity.x += 5.0 * deltaTime;
        score += velocity.x * deltaTime / 5.0f;
    }

}
