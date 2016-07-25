package com.mygdx.blockbunny.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

/**
 * Created by MC on 7/24/16.
 */
public class MyInputProcessor extends InputAdapter {

	public static final int V_WIDTH = Gdx.graphics.getWidth();
	public static final int V_HEIGHT = Gdx.graphics.getHeight();
	public static final int V_CENTER_X = V_WIDTH / 2;
	public static final int V_CENTER_Y = V_HEIGHT / 2;


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		if(screenX <= V_CENTER_X) {
			Touch.setTouch(Touch.TOUCH1, true);
		}

		if(screenX > V_CENTER_X) {
			Touch.setTouch(Touch.TOUCH2, true);
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(screenX <= V_CENTER_X) {
			Touch.setTouch(Touch.TOUCH1, false);
		}

		if(screenX > V_CENTER_X) {
			Touch.setTouch(Touch.TOUCH2, false);
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if(screenX <= V_CENTER_X) {
			Touch.setTouch(Touch.TOUCH2, false);
			Touch.setTouch(Touch.TOUCH1, true);
		}

		if(screenX > V_CENTER_X) {
			Touch.setTouch(Touch.TOUCH1, false);
			Touch.setTouch(Touch.TOUCH2, true);
		}
		return true;
	}
}
