package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Heroes.Player;
import org.w3c.dom.Text;

public class GameScreen2 implements Screen {
    private RunnerGame runnerGame;
    private SpriteBatch batch;
    private Texture skyBackground;
    private Texture ruinsSecondLayer;
    private Texture ruinedCity;
    private Texture ground;
    private float worldX;
    private float groundHeight = 190.0f;
    private float playerAnchor = 0.0f;
    private Player player;

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

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for (int i = 0; i < 9; i++) {
            batch.draw(skyBackground, i*480-worldX%480,260);
            batch.draw(ruinsSecondLayer, i*480-worldX%480,110);
            batch.draw(ruinedCity, i*480-worldX%480,35);
            batch.draw(ground, i*200-worldX%200,0);
        }

//        for (int i = 0; i < 5; i++) {
//            batch.draw(skyBackground, i*480, 420);
//            batch.draw(ruinsSecondLayer, i*480 ,270);
//        }
//        batch.draw(ruinedCity, 0,200);
//        batch.draw(ruinedCity, 480,200);
//        batch.draw(ruinedCity, 480+480,200);
//        batch.draw(ground, 0, 180);
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
        skyBackground.dispose();
    }
    public void update(float dt) {
        player.update(dt);
        worldX += 300.0f * dt;
    }
}
