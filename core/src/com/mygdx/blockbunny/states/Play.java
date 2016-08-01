package com.mygdx.blockbunny.states;

import static com.mygdx.blockbunny.handlers.B2DVars.PPM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Logger;
import com.mygdx.blockbunny.handlers.B2DVars;
import com.mygdx.blockbunny.handlers.GameStateManager;
import com.mygdx.blockbunny.handlers.MyContactListener;
import com.mygdx.blockbunny.handlers.Touch;

/**
 * Created by MC on 7/20/16.
 */
public class Play extends GameState {

	private World world;
	private Box2DDebugRenderer b2dr;

	private OrthographicCamera b2dCam;

	private Body playerBody;

	public static Logger logger = new Logger("Dev", Logger.INFO);

	public Play(GameStateManager gsm) {
		super(gsm);

		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		int centerX = width / 2;
		int centerY = height / 2;

		logger.info("Width: " + width + " (" + (width/PPM) + ") " + " Height: " + height + " (" + (height/PPM) + ")");
		logger.info("CenterX: " + centerX + " (" + (centerX/PPM) + ") " + " CenterY: " + centerY + " (" + (centerY/PPM) + ")");

		world = new World(new Vector2(0, -9.81f), true);
		world.setContactListener(new MyContactListener(this));

		b2dr = new Box2DDebugRenderer();

		b2dCam = new OrthographicCamera();
		b2dCam.setToOrtho(false, width / PPM, height / PPM);

		// create platform
		BodyDef bdef = new BodyDef();
		bdef.position.set( centerX / PPM , (centerY - 100) / PPM );
		bdef.type = BodyDef.BodyType.StaticBody;
		Body body = world.createBody(bdef);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox( 200 / PPM, 50 / PPM);

		FixtureDef fdef = new FixtureDef();
		fdef.shape = shape;
		fdef.filter.categoryBits = B2DVars.BIT_GROUND;
		fdef.filter.maskBits = B2DVars.BIT_PLAYER;
		body.createFixture(fdef).setUserData("ground");

		// create player
		bdef.position.set( centerX / PPM, (centerY + 200) / PPM);
		bdef.type = BodyDef.BodyType.DynamicBody;
		body = world.createBody(bdef);

		shape.setAsBox(50 / PPM, 50 / PPM);
		fdef.shape = shape;
		fdef.filter.categoryBits = B2DVars.BIT_PLAYER;
		fdef.filter.maskBits = B2DVars.BIT_GROUND;
		body.createFixture(fdef).setUserData("box");
	}

	@Override
	public void handleInput() {

		if(Touch.isPressed(Touch.TOUCH1)) {
			logger.info("Pressed 1");
		}

		if(Touch.isPressed(Touch.TOUCH2)) {
			logger.info("Pressed 2");
		}

	}

	@Override
	public void update(float dt) {

		handleInput();

		world.step(dt, 6, 2);

	}

	@Override
	public void render() {

		b2dr.render(world, b2dCam.combined);

	}

	@Override
	public void dispose() {

	}
}
