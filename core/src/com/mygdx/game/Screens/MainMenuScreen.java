package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.TankStarGame;

public class MainMenuScreen implements Screen {
    private static final double BUTTON_WIDTH=339;
    private static final double BUTTON_HEIGHT=85;
    private static final double MAIN_MENU_WORD_HEIGHT=36;
    private static final double MAIN_MENU_WORD_WIDTH=364;


    TankStarGame game;
    Texture mainMenuText;
    Texture resumeGameButtonActive;
    Texture newGameButtonActive;
    Texture exitButtonActive;
    Texture resumeGameButtonInactive;
    Texture newGameButtonInactive;
    Texture exitButtonInactive;
    Texture TankStarsLogo;

    public MainMenuScreen (TankStarGame game){
        this.game=game;
        TankStarsLogo=new Texture("mainmenu/TankStarsLogo.png");
        mainMenuText=new Texture("mainmenu/MAIN MENU.png");
        newGameButtonActive=new Texture("mainmenu/NewGameActive.png");
        exitButtonActive=new Texture("mainmenu/ExitActive.png");
        resumeGameButtonActive=new Texture("mainmenu/ResumeGameActive.png");

        //inactive buttons
        newGameButtonInactive=new Texture("mainmenu/NewGameInactive.png");
        exitButtonInactive=new Texture("mainmenu/ExitInactive.png");
        resumeGameButtonInactive=new Texture("mainmenu/ResumeGameInactive.png");
    }
    Texture image;

    @Override
    public void show() {
        image =new Texture("mainmenu/MainMenuBackground.png");
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        //SETTING THE BACKGROUND IMAGE
        game.batch.draw(image,0,0,TankStarGame.GAME_WIDTH,TankStarGame.GAME_HEIGHT);
        int x= (int) (((TankStarGame.GAME_WIDTH)*17/20)-((BUTTON_WIDTH)*17/20));
        game.batch.draw(TankStarsLogo,50,250,666,375);
        game.batch.draw(mainMenuText, (float) x-20, 500F, (float) MAIN_MENU_WORD_WIDTH, (float) MAIN_MENU_WORD_HEIGHT);
        if(Gdx.input.getX()<x+BUTTON_WIDTH && Gdx.input.getX()>x && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<360F+BUTTON_HEIGHT && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>360F){
            game.batch.draw(newGameButtonActive, (float) x, 360F, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                game.setScreen(new ChooseTankScreenPlayer1(game));
            }
        }
        else{
            game.batch.draw(newGameButtonInactive, (float) x, 360F, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
        }
        if(Gdx.input.getX()<x+BUTTON_WIDTH && Gdx.input.getX()>x && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<120F+BUTTON_HEIGHT && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>120F){
            game.batch.draw(exitButtonActive, (float) x, 120F, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new ExitPromptScreen(game));
            }
        }
        else{
            game.batch.draw(exitButtonInactive, (float) x, 120F, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
        }
        if(Gdx.input.getX()<x+BUTTON_WIDTH && Gdx.input.getX()>x && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<240F+BUTTON_HEIGHT && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>240F){
            game.batch.draw(resumeGameButtonActive, (float) x, 240F, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                game.setScreen(new SavedGamesScreen(game));
            }
        }
        else{
            game.batch.draw(resumeGameButtonInactive, (float) x, 240F, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
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
