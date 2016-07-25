package com.mygdx.blockbunny.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.blockbunny.Game;
import com.mygdx.blockbunny.handlers.GameStateManager;

/**
 * Created by MC on 7/20/16.
 */
public abstract class GameState {

	protected GameStateManager gsm;
	protected Game game;

	protected SpriteBatch sb;
	protected OrthographicCamera cam;
	protected OrthographicCamera hudCam;

	protected GameState(GameStateManager gsm) {
		this.gsm = gsm;
		game = gsm.game();
		sb = game.getSpriteBatch();
		cam = game.getCamera();
		hudCam = game.getHUDCamera();
	}

	public abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render();
	public abstract void dispose();
}
