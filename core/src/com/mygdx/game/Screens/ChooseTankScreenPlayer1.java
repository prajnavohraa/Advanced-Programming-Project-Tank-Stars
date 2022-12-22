package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.TankStarGame;

public class ChooseTankScreenPlayer1 implements Screen {
    public static final double CHOOSE_TANK_WIDTH=500;
    public static final double CHOOSE_TANK_HEIGHT=40;

    public static final double RECTANGLE_WIDTH=1200;
    public static final double RECTANGLE_HEIGHT=365;

    public static final double TANKS_WIDTH=400;
    public static final double TANKS_HEIGHT=300;

    public static final double START_WIDTH=370;
    public static final double START_HEIGHT=100;
    TankStarGame game;
    Texture img;
    Texture chooseTankText;
    Texture BlueRectangle;
    Texture AbramsActive;
    Texture AbramsInactive;
    Texture PinkyActive;
    Texture PinkyInactive;
    Texture ToxicActive;
    Texture ToxicInactive;
    Texture nextActive;
    Texture nextInactive;
    Texture BackButton;
    Texture Player1;

    public ChooseTankScreenPlayer1(TankStarGame game){
        this.game=game;
        chooseTankText=new Texture("choosetank/choose tank.png");
        BlueRectangle=new Texture("choosetank/BlueRectangle.png");
        AbramsActive= new Texture("choosetank/ABramsActive.png");
        AbramsInactive=new Texture("choosetank/AbramsInactive.png");
        PinkyActive= new Texture("choosetank/PinkyActive.png");
        PinkyInactive= new Texture("choosetank/PinkyInactive.png");
        ToxicActive=new Texture("choosetank/ToxicActive.png");
        ToxicInactive=new Texture("choosetank/ToxicInactive.png");
        nextActive=new Texture("choosetank/NextActive.png");
        nextInactive= new Texture("choosetank/NextInactive.png");
        BackButton=new Texture("BackButton.png");
        Player1=new Texture("choosetank/PLAYER 1 (1).png");

    }

    @Override
    public void show() {
        img =new Texture("choosetank/Background.png");
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(img,0,0,TankStarGame.GAME_WIDTH,TankStarGame.GAME_HEIGHT);
        int x_choosetank= (int) (((TankStarGame.GAME_WIDTH)/2)-((CHOOSE_TANK_WIDTH)/2));
        int x_rectangle= (int) (((TankStarGame.GAME_WIDTH)/2)-((RECTANGLE_WIDTH)/2));
        int x_pinky=(int) (((TankStarGame.GAME_WIDTH)/2)-((TANKS_WIDTH)/2));
        int x_start= (int) (((TankStarGame.GAME_WIDTH)/2)-((START_WIDTH)/2));
        game.batch.draw(BackButton,50,700,50,45);
        if(Gdx.input.getX()<50+130 && Gdx.input.getX()>50 && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<700+110 && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>700){
            if(Gdx.input.isTouched()){
                game.setScreen(new MainMenuScreen(game));
            }
        }
        game.batch.draw(chooseTankText, (float) x_choosetank,670F, (float) CHOOSE_TANK_WIDTH, (float) CHOOSE_TANK_HEIGHT);
        game.batch.draw(Player1, 500,600F, 300, 50);
        game.batch.draw(BlueRectangle, (float) x_rectangle, 200F, (float) RECTANGLE_WIDTH, (float) RECTANGLE_HEIGHT);
        if(Gdx.input.getX()<100F+TANKS_WIDTH && Gdx.input.getX()>100F && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<220F+TANKS_HEIGHT && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>220F){
            game.batch.draw(AbramsActive, 100F,220F, (float) TANKS_WIDTH-40, (float) TANKS_HEIGHT);
            if(Gdx.input.isTouched()){
                game.batch.draw(AbramsActive, 100F,220F, (float) TANKS_WIDTH-40, (float) TANKS_HEIGHT);
            }
        }
        else{
            game.batch.draw(AbramsInactive, 100F,220F, (float) TANKS_WIDTH-40, (float) TANKS_HEIGHT);
        }

        if(Gdx.input.getX()<x_pinky+45+TANKS_WIDTH && Gdx.input.getX()>x_pinky+45 && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<220F+TANKS_HEIGHT && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>220F){
            game.batch.draw(PinkyActive, (float) x_pinky+45,220F, (float) TANKS_WIDTH, (float) TANKS_HEIGHT);
            if(Gdx.input.isTouched()){
                game.batch.draw(PinkyActive, (float) x_pinky+45,220F, (float) TANKS_WIDTH, (float) TANKS_HEIGHT);
            }
        }
        else{
            game.batch.draw(PinkyInactive, x_pinky+45,220F, (float) TANKS_WIDTH, (float) TANKS_HEIGHT);
        }

        if(Gdx.input.getX()<950F+TANKS_WIDTH && Gdx.input.getX()>950F && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<220F+TANKS_HEIGHT && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>220F){
            game.batch.draw(ToxicActive,950F,220F, (float) TANKS_WIDTH, (float) TANKS_HEIGHT);
            if(Gdx.input.isTouched()){
                game.batch.draw(ToxicActive,950F,220F, (float) TANKS_WIDTH, (float) TANKS_HEIGHT);
            }
        }
        else{
            game.batch.draw(ToxicInactive,950F,220F, (float) TANKS_WIDTH, (float) TANKS_HEIGHT);
        }
        if(Gdx.input.getX()<x_start+START_WIDTH && Gdx.input.getX()>x_start && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<50F+TANKS_HEIGHT && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>50F){
            game.batch.draw(nextActive, (float) x_start,50F, (float) START_WIDTH, (float) START_HEIGHT);
            if(Gdx.input.isTouched()){
                game.setScreen(new ChooseTankScreenPlayer2(game));
            }
        }
        else{
            game.batch.draw(nextInactive, (float) x_start,50F, (float) START_WIDTH, (float) START_HEIGHT);
        }

        game.batch.end();
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

    }
}
