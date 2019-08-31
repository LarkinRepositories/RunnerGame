package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Heroes.Player;
import com.mygdx.game.Obstacles.Spikes;
import org.w3c.dom.Text;

import java.util.Arrays;

public class GameScreen2 implements Screen {
    private RunnerGame runnerGame;
    private SpriteBatch batch;
    private Texture skyBackground;
    private Texture ruinsSecondLayer;
    private Texture ruinedCity;
    private Texture ground;
    private float worldX;
    private float groundHeight = -150.0f;
    private float playerAnchor = 20.0f;
    private Player player;
    private Spikes[] spikes;
    private Sound music;

    public float getGroundHeight() {
        return groundHeight;
    }
    public float getPlayerAnchor() {
        return playerAnchor;
    }

    public GameScreen2(RunnerGame runnerGame, SpriteBatch batch) {
        this.runnerGame = runnerGame;
        this.batch = batch;
    }

    @Override
    public void show() {
        skyBackground = new Texture("city-ruins/sky-firstLayer.png");
        ruinsSecondLayer = new Texture("city-ruins/ruins-secondLayer.png");
        ruinedCity = new Texture("city-ruins/ruinedCity.png");
        ground = new Texture("city-ruins/ground.png");
        player = new Player(this);
        spikes = new Spikes[MathUtils.random(50,150)];
        spikes[0] = new Spikes(new Vector2(500, groundHeight+160));
        for (int i = 1; i < spikes.length; i++) {
            spikes[i] = new Spikes(new Vector2(spikes[i-1].getPosition().x + MathUtils.random(300,900), groundHeight+160));
        }

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for (int i = 0; i < 9; i++) {
            batch.draw(skyBackground, i*480 - player.getPosition().x % 480,260);
            batch.draw(ruinsSecondLayer, i*480 - player.getPosition().x % 480,110);
            batch.draw(ruinedCity, i*480 - player.getPosition().x % 480,35);
            batch.draw(ground, i*200 - player.getPosition().x % 200,0);
        }
        player.render(batch);
        for (Spikes spike: spikes) {
            spike.render(batch, player.getPosition().x - playerAnchor);
        }
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
        skyBackground.dispose();
    }
    public void update(float dt) {
        player.update(dt);
        worldX += 300.0f * dt;
    }
}
