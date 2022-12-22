package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.TankStarGame;

public class ExitPromptScreen implements Screen {
    private static final double DO_WIDTH=830;
    private static final double DO_HEIGHT=400;
    private static final double BUTTON_WIDTH=200;
    private static final double BUTTON_HEIGHT=100;
    private static final double OTHER_BUTTON_WIDTH=339;
    private static final double OTHER_BUTTON_HEIGHT=85;
    private static final double MAIN_MENU_WORD_HEIGHT=36;
    private static final double MAIN_MENU_WORD_WIDTH=364;

    TankStarGame game;
    Texture mainMenuText;
    Texture doYouWantToExit;
    Texture NoActive;
    Texture NoInactive;
    Texture YesActive;
    Texture YesInactive;
    Texture resumeGameButtonInactive;
    Texture newGameButtonInactive;
    Texture exitButtonInactive;
    Texture TankStarsLogo;
    Texture image;

    public ExitPromptScreen(TankStarGame game){
        this.game=game;
        TankStarsLogo=new Texture("mainmenu/TankStarsLogo.png");
        mainMenuText=new Texture("mainmenu/MAIN MENU.png");
        doYouWantToExit=new Texture("exitprompt/doYouWantToExit.png");
        NoActive=new Texture("exitprompt/NoActive.png");
        NoInactive=new Texture("exitprompt/NoInactive.png");
        YesActive=new Texture("exitprompt/YesActive.png");
        YesInactive=new Texture("exitprompt/YesInactive.png");
        newGameButtonInactive=new Texture("mainmenu/NewGameInactive.png");
        exitButtonInactive=new Texture("mainmenu/ExitInactive.png");
        resumeGameButtonInactive=new Texture("mainmenu/ResumeGameInactive.png");

    }

    @Override
    public void show() {
        image =new Texture("mainmenu/MainMenuBackground.png");
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        //SETTING THE BACKGROUND IMAGE
        game.batch.draw(image,0,0,TankStarGame.GAME_WIDTH,TankStarGame.GAME_HEIGHT);
        game.batch.draw(TankStarsLogo,50,250,666,375);
        int x_coordinate=(int) (((TankStarGame.GAME_WIDTH)*17/20)-((OTHER_BUTTON_WIDTH)*17/20));
        game.batch.draw(mainMenuText, (float) x_coordinate-20, 500F, (float) MAIN_MENU_WORD_WIDTH, (float) MAIN_MENU_WORD_HEIGHT);
        game.batch.draw(newGameButtonInactive, (float) x_coordinate, 360F, (float) OTHER_BUTTON_WIDTH, (float) OTHER_BUTTON_HEIGHT);
        game.batch.draw(resumeGameButtonInactive, (float) x_coordinate, 240F, (float) OTHER_BUTTON_WIDTH, (float) OTHER_BUTTON_HEIGHT);
        game.batch.draw(exitButtonInactive, (float) x_coordinate, 120F, (float) OTHER_BUTTON_WIDTH, (float) OTHER_BUTTON_HEIGHT);
        int x= (int) (((TankStarGame.GAME_WIDTH)/2)-((DO_WIDTH)/2));
        int y= (int) (((TankStarGame.GAME_HEIGHT)/2)-((DO_HEIGHT)/2));
        game.batch.draw(doYouWantToExit, (float) x, (float) y, (float) DO_WIDTH, (float) DO_HEIGHT);

        if(Gdx.input.getX()<400+BUTTON_WIDTH && Gdx.input.getX()>400 && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<260+BUTTON_HEIGHT && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>260){
            game.batch.draw(YesActive, 430, 260, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if (Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }
        else{
            game.batch.draw(YesInactive, 430, 260, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
        }

        if(Gdx.input.getX()<800+BUTTON_WIDTH && Gdx.input.getX()>800 && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<260+BUTTON_HEIGHT && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>260){
            game.batch.draw(NoActive, 720, 260, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if (Gdx.input.isTouched()){
                game.setScreen(new MainMenuScreen(game));
            }
        }
        else{
            game.batch.draw(NoInactive, 720, 260, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);

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
