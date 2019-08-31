package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Heroes.Hero;
import com.mygdx.game.Heroes.Knight;
import com.mygdx.game.Heroes.Player;

public class GameScreen implements Screen {
    private RunnerGame runnerGame;
    private SpriteBatch batch;
    private Texture backGround;
    private Texture ground;
    private float worldX;
    private float groundHeight = 190.0f;
    private float playerAnchor = 200.0f;
    private Player player;

    public float getPlayerAnchor() {
        return playerAnchor;
    }

    public GameScreen(RunnerGame runnerGame, SpriteBatch batch) {
        this.runnerGame = runnerGame;
        this.batch = batch;
    }

    @Override
    public void show() {
        this.backGround = new Texture("background.jpg");
        this.ground = new Texture("ground.jpg");
        //player = new Player(this);

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(backGround, 0 , 0);
        for (int i = 0; i < 8; i++) {
            batch.draw(ground, i*200 - worldX % 200, 0);
        }
        player.render(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        runnerGame.getViewport().update(width, height, true);
        runnerGame.getViewport().apply();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        backGround.dispose();
        ground.dispose();
    }

    public void update(float dt) {
        player.update(dt);
        worldX += 200.0f * dt;
    }
}
