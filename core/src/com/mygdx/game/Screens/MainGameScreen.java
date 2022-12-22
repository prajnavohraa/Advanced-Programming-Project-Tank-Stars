package com.mygdx.game.Screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.TankStarGame;
import com.mygdx.game.others.CollisionListenerTank2;
import com.mygdx.game.others.MyContactListener;
import com.mygdx.game.others.Tank_player;
import com.mygdx.game.others.TiledObjects;
import jdk.incubator.vector.VectorOperators;
import jdk.tools.jmod.Main;
import org.w3c.dom.Text;

import java.awt.*;

public class MainGameScreen implements Screen {
    TankStarGame game;
    Texture Background;
    Texture AbramsTank;
    Texture FrostTank;
    Texture bullet;
    Texture PowerDisplay;
    Texture Fuel;
    Texture FireButton;
    Texture PauseButton;
    Texture AngleDisplay;
    Texture rectangle;
    Texture Terrain;
    Texture TrajectoryLines;
    Texture Player1;
    Texture Player2;
    Texture vs;
    Texture GamePausedBox;
    Texture MainMenuActive;
    Texture MainMenuInactive;
    Texture RestartActive;
    Texture RestartInactive;
    Texture ResumeActive;
    Texture ResumeInactive;
    Texture SaveActive;
    Texture SaveInactive;

    public MainGameScreen(TankStarGame game){
        this.game=game;
        //AbramsTank= new Texture("maingame/Abrams-removebg-preview.png");
//        AngleDisplay= new Texture("maingame/AngleDisplay.png");
//        FireButton= new Texture("maingame/FireButton.png");
        Fuel= new Texture("maingame/Rectangle 11.png");
//        PauseButton= new Texture("maingame/PauseButton.png");

//        PowerDisplay= new Texture("maingame/PowerDisplay.png");
        rectangle= new Texture("maingame/Rectangle 9.png");
//        TrajectoryLines= new Texture("maingame/TrajectoryLines.png");
//        vs= new Texture("maingame/Vs.png");
//        Terrain= new Texture("maingame/WhatsApp Image 2022-11-22 at 12.50 1.png");
//        Player1= new Texture("maingame/PLAYER 1 (1).png");
//        Player2= new Texture("maingame/PLAYER 2 (1).png");
//        GamePausedBox= new Texture("pausedgame/GamePausedBox.png");
//        MainMenuActive= new Texture("pausedgame/MainMenuActive.png");
//        MainMenuInactive= new Texture("pausedgame/MainMenuInactive.png");
//        RestartActive= new Texture("pausedgame/RestartActive.png");
//        RestartInactive= new Texture("pausedgame/RestartInactive.png");
//        ResumeActive= new Texture("pausedgame/ResumeActive.png");
//        ResumeInactive= new Texture("pausedgame/ResumeInactive.png");
//        SaveActive= new Texture("pausedgame/SaveActive.png");
//        SaveInactive= new Texture("pausedgame/SaveInactive.png");
        game.map= new TmxMapLoader().load("Map_Tank_Star2.tmx");
        game.renderer= new OrthogonalTiledMapRenderer(game.map,1/16f);
        game.camera= new OrthographicCamera();
        game.camera.setToOrtho(false,(1351/2f)/8f,(746/2f)/8f);
        AbramsTank= new Texture("maingame/Abrams-removebg-preview.png");
        FrostTank= new Texture("maingame/FrostTank.png");
        bullet= new Texture("maingame/bullet1-removebg-preview.png");
        Fuel= new Texture("maingame/Rectangle 11.png");
        game.current_player= game.getTank1();
        TiledObjects.parseTiledObjectLayer(game.world, game.map.getLayers().get(1).getObjects());

    }
    @Override
    public void show() {
        Background =new Texture("maingame/MainGameBackground.png");
        game.world.setContactListener(new MyContactListener(game));
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,0);
        game.batch.begin();
        game.batch.draw(Background,0,0,TankStarGame.GAME_WIDTH/16f,TankStarGame.GAME_HEIGHT/16f);
        game.batch.draw(AbramsTank,game.getPlayer1().getPosition().x-(75/2f)/16f, game.getPlayer1().getPosition().y-(75/2f)/16f,70/16f,70/16f);
        game.batch.draw(FrostTank,game.getPlayer2().getPosition().x-(75/2f)/16f, game.getPlayer2().getPosition().y-(75/2f)/16f,70/16f,70/16f);
        game.batch.draw(rectangle,0,700/16f,200/16f*game.getTank1().getHealth()/10,25/16f);
        game.batch.draw(rectangle,1350/16f,700/16f,200/16f*(-1)*game.getTank2().getHealth()/10,25/16f);
        game.batch.draw(Fuel,0,650/16f,200/16f*game.getTank1().getFuel()/1000,25/16f);
        //game.batch.setColor(Color.WHITE);
        game.batch.draw(Fuel,1350/16f,650/16f,200/16f*(-1)*game.getTank2().getFuel()/1000,25/16f);
//        game.batch.draw(Terrain,0,0,TankStarGame.GAME_WIDTH,(TankStarGame.GAME_HEIGHT)/2);
//        game.batch.draw(AbramsTank,70,325,175,175);
//        game.batch.draw(PinkyTank,1060,250,150,115);
//        game.batch.draw(TrajectoryLines,740,165,350,350);
//        game.batch.draw(PauseButton,30,650,60,60);
//        if(Gdx.input.getX()<90 && Gdx.input.getX()>30 && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<710 && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>650) {
//            if (Gdx.input.isTouched()) {
//                game.setScreen(new PauseGameScreen(game));
//            }
//        }

//        game.batch.draw(Player1,150,680,150,27);
//        game.batch.draw(vs,620,600,150,150);

//        game.batch.draw(Player2,1070,680,150,27);
//        game.batch.draw(PowerDisplay,900,110,200,100);
//        game.batch.draw(AngleDisplay,1070,110,200,100);
//        game.batch.draw(Fuel,940,60,250,50);

        game.batch.end();
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            create_bullets(game.between_angle(game.current_player));
            game.current_player=switch_player();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            game.setScreen(new PauseGameScreen(game));
        }
        game.renderer.setView(game.camera);
        game.camera.update();
        game.renderer.render();
        game.update(delta);
        game.boxrenderer.render(game.world, game.camera.combined);
    }

    @Override
    public void resize(int width, int height) {

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
        game.world.dispose();
        game.boxrenderer.dispose();
    }

    private void create_bullets(float angle){
        CircleShape circle= new CircleShape();
        circle.setRadius(0.5f);
        circle.setPosition(new Vector2(game.current_player.getPlayer().getPosition().x-(50/2f)/16f+80/16f,game.current_player.getPlayer().getPosition().y-(50/2f)/16f+60/16f));
        BodyDef bdef= new BodyDef();
        bdef.type= BodyDef.BodyType.DynamicBody;
        Body bullet= game.world.createBody(bdef);
        Fixture fixture=bullet.createFixture(circle,1);
        fixture.setUserData("bullet");
        circle.dispose();
        bullet.setLinearVelocity(30*MathUtils.cos(angle),40*MathUtils.sin(angle)-9.8f*Gdx.graphics.getDeltaTime());
//        if(game.current_player.equals(game.tank1)){
//            game.current_player=game.tank2;
//        }
//        if(game.current_player.equals(game.tank2)){
//            game.current_player=game.tank1;
//        }
    }

    public Tank_player switch_player(){
        if(game.current_player.equals(game.getTank1())){
            game.current_player=game.getTank2();
        }
        else{
            game.current_player=game.getTank1();
        }
        return game.current_player;
    }

}
