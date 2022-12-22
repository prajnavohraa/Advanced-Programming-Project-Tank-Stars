package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.TankStarGame;

public class PauseGameScreen implements Screen {
    public static final int BUTTON_WIDTH=377;
    public static final int BUTTON_HEIGHT=77;

    TankStarGame game;
    Texture Background;
    Texture AbramsTank;
    Texture PinkyTank;
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




    public PauseGameScreen(TankStarGame game){
        this.game=game;
//        AbramsTank= new Texture("maingame/Abrams-removebg-preview.png");
//        AngleDisplay= new Texture("maingame/AngleDisplay.png");
//        FireButton= new Texture("maingame/FireButton.png");
//        Fuel= new Texture("maingame/Fuel.png");
//        PauseButton= new Texture("maingame/PauseButton.png");
//        PinkyTank= new Texture("maingame/PinkyTank.png");
//        PowerDisplay= new Texture("maingame/PowerDisplay.png");
//        rectangle= new Texture("maingame/Rectangle 9.png");
//        TrajectoryLines= new Texture("maingame/TrajectoryLines.png");
//        vs= new Texture("maingame/Vs.png");
//        Terrain= new Texture("maingame/WhatsApp Image 2022-11-22 at 12.50 1.png");
//        Player1= new Texture("maingame/PLAYER 1 (1).png");
//        Player2= new Texture("maingame/PLAYER 2 (1).png");
        GamePausedBox= new Texture("pausedgame/GamePausedBox.png");
        MainMenuActive= new Texture("pausedgame/MainMenuActive.png");
        MainMenuInactive= new Texture("pausedgame/MainMenuInactive.png");
        RestartActive= new Texture("pausedgame/RestartActive.png");
        RestartInactive= new Texture("pausedgame/RestartInactive.png");
        ResumeActive= new Texture("pausedgame/ResumeActive.png");
        ResumeInactive= new Texture("pausedgame/ResumeInactive.png");
        SaveActive= new Texture("pausedgame/SaveActive.png");
        SaveInactive= new Texture("pausedgame/SaveInactive.png");
    }

    @Override
    public void show() {
        Background =new Texture("maingame/MainGameBackground.png");
        GamePausedBox= new Texture("pausedgame/GamePausedBox.png");
        MainMenuActive= new Texture("pausedgame/MainMenuActive.png");
        MainMenuInactive= new Texture("pausedgame/MainMenuInactive.png");
        RestartActive= new Texture("pausedgame/RestartActive.png");
        RestartInactive= new Texture("pausedgame/RestartInactive.png");
        ResumeActive= new Texture("pausedgame/ResumeActive.png");
        ResumeInactive= new Texture("pausedgame/ResumeInactive.png");
        SaveActive= new Texture("pausedgame/SaveActive.png");
        SaveInactive= new Texture("pausedgame/SaveInactive.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,0);
        game.batch.begin();
        game.batch.draw(Background,0,0,TankStarGame.GAME_WIDTH/16f,TankStarGame.GAME_HEIGHT/16f);
        Background =new Texture("maingame/MainGameBackground.png");
//        GamePausedBox= new Texture("pausedgame/GamePausedBox.png");
//        MainMenuActive= new Texture("pausedgame/MainMenuActive.png");
//        MainMenuInactive= new Texture("pausedgame/MainMenuInactive.png");
//        RestartActive= new Texture("pausedgame/RestartActive.png");
//        RestartInactive= new Texture("pausedgame/RestartInactive.png");
//        ResumeActive= new Texture("pausedgame/ResumeActive.png");
//        ResumeInactive= new Texture("pausedgame/ResumeInactive.png");
//        SaveActive= new Texture("pausedgame/SaveActive.png");
//        SaveInactive= new Texture("pausedgame/SaveInactive.png");
//        game.batch.draw(Terrain,0,0,TankStarGame.GAME_WIDTH,(TankStarGame.GAME_HEIGHT)/2);
//        game.batch.draw(AbramsTank,70,325,175,175);
//        game.batch.draw(PinkyTank,1060,250,150,115);
//        game.batch.draw(TrajectoryLines,740,165,350,350);
//        game.batch.draw(PauseButton,30,650,60,60);
//        game.batch.draw(rectangle,150,620,400,40);
//        game.batch.draw(Player1,150,680,150,27);
//        game.batch.draw(vs,620,600,150,150);
//        game.batch.draw(rectangle,830,620,400,40);
//        game.batch.draw(Player2,1070,680,150,27);
//        game.batch.draw(PowerDisplay,900,110,200,100);
//        game.batch.draw(AngleDisplay,1070,110,200,100);
//        game.batch.draw(Fuel,940,60,250,50);
        game.batch.draw(GamePausedBox,420/16f, 120/16f,580/16f,550/16f);

        if(Gdx.input.getX()/16f<500/16f+BUTTON_WIDTH/16f && Gdx.input.getX()/16f>500/16f && TankStarGame.GAME_HEIGHT/16f-Gdx.input.getY()/16f<470/16f+BUTTON_HEIGHT/16f && TankStarGame.GAME_HEIGHT/16f-Gdx.input.getY()/16f>470/16f){
            game.batch.draw(ResumeActive,500/16f, 470/16f,BUTTON_WIDTH/16f,BUTTON_HEIGHT/16f);
            if(Gdx.input.isTouched()){
                game.setScreen(new MainGameScreen(game));
            }
        }
        else{
            game.batch.draw(ResumeInactive,500/16f, 470/16f,BUTTON_WIDTH/16f,BUTTON_HEIGHT/16f);
        }

        if(Gdx.input.getX()/16f<500/16f+BUTTON_WIDTH/16f && Gdx.input.getX()/16f>500/16f && TankStarGame.GAME_HEIGHT/16f-Gdx.input.getY()/16f<370/16f+BUTTON_HEIGHT/16f && TankStarGame.GAME_HEIGHT/16f-Gdx.input.getY()/16f>370/16f){
            game.batch.draw(RestartActive,500/16f, 370/16f,BUTTON_WIDTH/16f,BUTTON_HEIGHT/16f);
            if(Gdx.input.isTouched()){
                TankStarGame new_game= new TankStarGame();
                game.setScreen(new MainGameScreen(new_game));
            }
        }
        else{
            game.batch.draw(RestartInactive,500/16f, 370/16f,BUTTON_WIDTH/16f,BUTTON_HEIGHT/16f);
        }

        if(Gdx.input.getX()/16f<(500+BUTTON_WIDTH)/16f && Gdx.input.getX()/16f>500/16f && TankStarGame.GAME_HEIGHT/16f-Gdx.input.getY()/16f<(270+BUTTON_HEIGHT)/16f && TankStarGame.GAME_HEIGHT/16f-Gdx.input.getY()/16f>270/16f){
            game.batch.draw(SaveActive,500/16f, 270/16f,BUTTON_WIDTH/16f,BUTTON_HEIGHT/16f);
        }
        else{
            game.batch.draw(SaveInactive,500/16f, 270/16f,BUTTON_WIDTH/16f,BUTTON_HEIGHT/16f);
        }

        if(Gdx.input.getX()/16f<(500+BUTTON_WIDTH)/16f && Gdx.input.getX()/16f>500/16f && TankStarGame.GAME_HEIGHT/16f-Gdx.input.getY()/16f<(170+BUTTON_HEIGHT)/16f && TankStarGame.GAME_HEIGHT/16f-Gdx.input.getY()/16f>170/16f){
            game.batch.draw(MainMenuActive,500/16f, 170/16f,BUTTON_WIDTH/16f,BUTTON_HEIGHT/16f);
            if(Gdx.input.isTouched()){
                game.setScreen(new MainMenuScreen(game));
            }
        }
        else{
            game.batch.draw(MainMenuInactive,500/16f, 170/16f,BUTTON_WIDTH/16f,BUTTON_HEIGHT/16f);
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
