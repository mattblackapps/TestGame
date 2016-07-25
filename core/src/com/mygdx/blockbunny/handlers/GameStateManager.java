package com.mygdx.blockbunny.handlers;

import com.mygdx.blockbunny.Game;
import com.mygdx.blockbunny.states.GameState;
import com.mygdx.blockbunny.states.Play;

import java.util.Stack;

/**
 * Created by MC on 7/20/16.
 */
public class GameStateManager {

	private Game game;

	private Stack<GameState> gameStates;

	public static final int PLAY = 912837;

	public GameStateManager(Game game) {
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(PLAY);
	}

	public void update(float dt) {
		gameStates.peek().update(dt);
	}

	public void render() {
		gameStates.peek().render();
	}

	public Game game() { return game; }

	public void setState(int state) {
		popState();
		pushState(state);
	}

	public void pushState(int state) {
		gameStates.push(getState(state));
	}

	public void popState() {
		GameState g = gameStates.pop();
		g.dispose();
	}

	private GameState getState(int state) {
		if(state == PLAY) return new Play(this);
		return null;
	}

}
