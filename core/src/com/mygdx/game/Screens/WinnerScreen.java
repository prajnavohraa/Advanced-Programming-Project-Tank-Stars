package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.TankStarGame;
import org.w3c.dom.Text;

public class WinnerScreen implements Screen {
    Texture img;
    TankStarGame game;
    Texture mainMenuInactive;
    Texture mainMenuActive;
    Texture QuitInactive;
    Texture QUitActive;
    Texture AbramsTank;
    Texture FrostTank;
    Texture victory;
    public WinnerScreen(TankStarGame game){
        this.game=game;
        mainMenuActive= new Texture("WinnerScreen/MainMenuActive.png");
        mainMenuInactive= new Texture("WinnerScreen/MainMenuInactive.png");
        QuitInactive= new Texture("Group 86.png");
        QUitActive=new Texture("Group 90.png");
        victory= new Texture("WinnerScreen/Victory.png");
        AbramsTank= new Texture("maingame/Abrams-removebg-preview.png");
        FrostTank= new Texture("maingame/FrostTank.png");
    }
    @Override
    public void show() {
        img= new Texture("choosetank/Background.png");

        mainMenuActive= new Texture("WinnerScreen/MainMenuActive.png");
        mainMenuInactive= new Texture("WinnerScreen/MainMenuInactive.png");
        QuitInactive= new Texture("Group 86.png");
        QUitActive=new Texture("Group 90.png");
        victory= new Texture("WinnerScreen/Victory.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,0);
        game.batch.begin();
        game.batch.draw(img,0,0,TankStarGame.GAME_WIDTH/16f,TankStarGame.GAME_HEIGHT/16f);
        if(game.winner.getPlayer().equals(game.getPlayer1())){
            game.batch.draw(AbramsTank,400/16f,130/16f, 550/16f, 550/16f);
        }
        else{
            game.batch.draw(FrostTank,400/16f,130/16f, 550/16f, 550/16f);
        }
        if(Gdx.input.getX()/16f<1090/16f && Gdx.input.getX()/16f>750/16f && TankStarGame.GAME_HEIGHT/16f-Gdx.input.getY()/16f<240/16f && TankStarGame.GAME_HEIGHT/16f-Gdx.input.getY()/16f>140/16f){
            game.batch.draw(mainMenuActive,750/16f,140/16f,340/16f,100/16f);
            if(Gdx.input.isTouched()){
                game.camera.setToOrtho(false,(1351),(746));
                game.batch.setProjectionMatrix(game.camera.combined);
                game.setScreen(new MainMenuScreen(game));
            }
        }
        else{
            game.batch.draw(mainMenuInactive,750/16f,140/16f,340/16f,100/16f);
        }

        if(Gdx.input.getX()/16f<620/16f && Gdx.input.getX()/16f>280/16f && TankStarGame.GAME_HEIGHT/16f-Gdx.input.getY()<240/16f && TankStarGame.GAME_HEIGHT/16f-Gdx.input.getY()/16f>140/16f){
            game.batch.draw(QUitActive,280/16f,140/16f,340/16f,100/16f);
            if(Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }
        else{
            game.batch.draw(QuitInactive,280/16f,140/16f,340/16f,100/16f);
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
