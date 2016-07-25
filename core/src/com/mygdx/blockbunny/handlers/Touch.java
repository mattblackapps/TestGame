package com.mygdx.blockbunny.handlers;

/**
 * Created by MC on 7/24/16.
 */
public class Touch {

	public static boolean[] touches;
	public static boolean[] ptouches;

	public static final int NUM_TOUCHES = 2;
	public static final int TOUCH1 = 0;
	public static final int TOUCH2 = 1;

	static {
		touches = new boolean[NUM_TOUCHES];
		ptouches = new boolean[NUM_TOUCHES];
	}

	public static void update() {
		for(int i = 0; i < NUM_TOUCHES; i++) {
			ptouches[i] = touches[i];
		}
	}

	public static void setTouch(int i, boolean b) { touches[i] = b; }

	public static boolean isDown(int i) {
		return touches[i];
	}

	public static boolean isPressed(int i) {
		return touches[i] && !ptouches[i];
	}
}
