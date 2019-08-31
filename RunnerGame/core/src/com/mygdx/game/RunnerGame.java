package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class RunnerGame extends Game {
	private SpriteBatch batch;
	private GameScreen2 gameScreen;
	private Viewport viewport;

	public Viewport getViewport() {
		return viewport;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		//gameScreen = new GameScreen(this, batch);
		gameScreen = new GameScreen2(this,batch);
		viewport = new FitViewport(1920, 1080);
		setScreen(gameScreen);
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		getScreen().render(dt);
	}

	@Override
	public void dispose () {
		batch.dispose();
		getScreen().dispose();
	}
}
