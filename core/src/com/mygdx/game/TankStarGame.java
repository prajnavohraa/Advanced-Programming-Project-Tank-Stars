package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Screens.ExitPromptScreen;
import com.mygdx.game.Screens.MainGameScreen;
import com.mygdx.game.Screens.MainMenuScreen;
import com.mygdx.game.Screens.WinnerScreen;
import com.mygdx.game.others.MyContactListener;
import com.mygdx.game.others.Tank_player;
import sun.jvm.hotspot.oops.TypeArrayKlass;

public class TankStarGame extends Game {
	public World world;
	private Tank_player tank1;
	private Tank_player tank2;
	private Body player1;
	private Body player2;
	public Tank_player winner;
	public Tank_player current_player;
	public Box2DDebugRenderer boxrenderer;

	public static final int GAME_WIDTH=1351;
	public static final int GAME_HEIGHT=746;
	public SpriteBatch batch;
	private FitViewport fit;
	public Vector2 hinge;
	public Vector2 firing_position;
	public TiledMap map;
	public OrthogonalTiledMapRenderer renderer;
	public OrthographicCamera camera;
	public Array<Body> Remove= new Array<>();

	public boolean isGameOver;

	@Override
	public void create () {
		batch = new SpriteBatch();
		fit= new FitViewport(GAME_WIDTH,GAME_HEIGHT);
		world= new World(new Vector2(0,-9.8f*5), false);
		player1=player_create_circle(180/16f, 330/16f, 20/16f,"tank1");
		tank1= new Tank_player(this,player1);
		boxrenderer= new Box2DDebugRenderer();
		player2=player_create_circle(580/16f, 330/16f, 20/16f,"tank2");
		tank2= new Tank_player(this,player2);
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		world.dispose();
		boxrenderer.dispose();
		batch.dispose();
	}

	public void update(float delta){
		remove_bullets();

		world.step(1/60f,6,2);
		this.batch.setProjectionMatrix(this.camera.combined);
		update_input(delta);
		if(this.current_player.getHealth()<=0){
			if(this.current_player.getPlayer().equals(player1)){
				this.winner=this.tank2;
			}
			else{
				this.winner=this.tank1;
			}
			this.current_player=this.winner;
			this.isGameOver=true;
		}
		if(this.isGameOver){
			this.winner=this.current_player;
			this.setScreen(new WinnerScreen(this));
		}
	}

	public void update_input(float delta){
		int horizontal_force=0;
		int vertical_force=0;
		if(this.current_player.getFuel()>0){
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
				horizontal_force-=1;
				this.current_player.setFuel();
			}
			if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
				horizontal_force+=1;
				this.current_player.setFuel();
			}
			if (Gdx.input.isKeyJustPressed(Input.Keys.UP) || Gdx.input.isKeyJustPressed(Input.Keys.W)){
				vertical_force+=1;
				this.current_player.setFuel();
			}
			if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)){
				vertical_force-=1;
				this.current_player.setFuel();
			}
			if(this.current_player.equals(tank1)){
				tank1.getPlayer().setLinearVelocity(horizontal_force*20,-9.8f);
			}
			if(this.current_player.equals(tank2)){
				tank2.getPlayer().setLinearVelocity(horizontal_force*20,-9.8f);
			}
		}
//		else{
//			isGameOver=true;
//		}
	}
//	public Body player_create_box(float x, float y, float width, float height){
//		Body player_body;
//		BodyDef bdef= new BodyDef();
//		bdef.type= BodyDef.BodyType.DynamicBody;
//		bdef.position.set(x,y);
//		bdef.fixedRotation=true;
//		player_body=world.createBody(bdef);
//		PolygonShape shape= new PolygonShape();
//		shape.setAsBox(width,height);
//		player_body.createFixture(shape,1.0f);
//		shape.dispose();
//		return player_body;
//	}

	public Body player_create_circle(float x, float y, float radius, String name){
		Body platform_body;
		BodyDef bdef= new BodyDef();
		bdef.type= BodyDef.BodyType.DynamicBody;
		bdef.position.set(x,y);
		bdef.fixedRotation=true;
		platform_body=world.createBody(bdef);
		CircleShape shape= new CircleShape();
		shape.setRadius(radius);
		Fixture fixture=platform_body.createFixture(shape,1.0f);
		fixture.setUserData(name);
		shape.dispose();
		return platform_body;
	}

	public void remove_bullets() {
		for(Body body:Remove){
			world.destroyBody(body);
			Remove.removeValue(body,true);
		}
		Remove.clear();
	}

	public float between_angle(Tank_player current_player){
		this.current_player=current_player;
		hinge= new Vector2(this.current_player.getPlayer().getPosition().x,this.current_player.getPlayer().getPosition().y);
		firing_position= new Vector2(Gdx.input.getX()/16f,Gdx.input.getY()/16f);
		if(current_player.equals(tank1)){
			float angle= MathUtils.atan2(47-(firing_position.y+hinge.y),firing_position.x-hinge.x);
			angle%=2*MathUtils.PI;
			if(angle<0){
				angle=0;
			}
			else if(angle>MathUtils.PI/2f){
				angle=MathUtils.PI/2f;
			}
			return angle;
		}
		else{
			float angle= MathUtils.atan2(47-(firing_position.y+hinge.y),firing_position.x-hinge.x);
			angle%=2*MathUtils.PI;
			if(angle>MathUtils.PI){
				angle=MathUtils.PI;
			}
			else if(angle<MathUtils.PI/2f){
				angle=MathUtils.PI/2f;
			}
			return angle;
		}
	}

	public Tank_player getTank1() {
		return tank1;
	}

	public Tank_player getTank2() {
		return tank2;
	}

	public Body getPlayer1() {
		return player1;
	}

	public Body getPlayer2() {
		return player2;
	}
}