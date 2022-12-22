package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.TankStarGame;
import jdk.incubator.vector.VectorOperators;
import org.w3c.dom.Text;

public class SavedGamesScreen implements Screen {
    public static final int SAVED_GAMES_WIDTH=569;
    public static final int SAVED_GAMES_HEIGHT=50;
    public static final int GAME_BUTTON_WIDTH=800;
    public static final int GAME_BUTTON_HEIGHT=100;

    TankStarGame game;
    Texture savedGames;
    Texture Game1Active;
    Texture Game1Inactive;
    Texture Game2Active;
    Texture Game2Inactive;
    Texture Game3Active;
    Texture Game3Inactive;
    Texture img;
    Texture BackButton;
    public SavedGamesScreen(TankStarGame game){
        this.game=game;
        Game1Active=new Texture("savedgames/Game1Active.png");
        Game1Inactive=new Texture("savedgames/Game1Inactive.png");
        Game2Active= new Texture("savedgames/Game2Active.png");
        Game2Inactive= new Texture("savedgames/Game2Inactive.png");
        Game3Active= new Texture("savedgames/Game3Active.png");
        Game3Inactive= new Texture("savedgames/Game3Inactive.png");
        savedGames=new Texture("savedgames/saved games.png");
        BackButton=new Texture("BackButton.png");
    }

    @Override
    public void show() {
        img =new Texture("choosetank/Background.png");
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(img,0,0,TankStarGame.GAME_WIDTH,TankStarGame.GAME_HEIGHT);
        game.batch.draw(BackButton,30,600,130,110);
        if(Gdx.input.getX()<30+130 && Gdx.input.getX()>30 && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<600+110 && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>600){
            if(Gdx.input.isTouched()){
                game.setScreen(new MainMenuScreen(game));
            }
        }
        int x_savedgames= (int) (((TankStarGame.GAME_WIDTH)/2)-((SAVED_GAMES_WIDTH)/2));
        game.batch.draw(savedGames,x_savedgames,600F,SAVED_GAMES_WIDTH,SAVED_GAMES_HEIGHT);

        if(Gdx.input.getX()<x_savedgames-50+GAME_BUTTON_WIDTH && Gdx.input.getX()>x_savedgames-50 && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<400F+GAME_BUTTON_HEIGHT && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>400F){
            game.batch.draw(Game1Active,x_savedgames-50,400F,GAME_BUTTON_WIDTH,GAME_BUTTON_HEIGHT);
        }
        else{
            game.batch.draw(Game1Inactive,x_savedgames-50,400F,GAME_BUTTON_WIDTH,GAME_BUTTON_HEIGHT);
        }


        if(Gdx.input.getX()<x_savedgames-50+GAME_BUTTON_WIDTH && Gdx.input.getX()>x_savedgames-50 && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<250F+GAME_BUTTON_HEIGHT && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>250F){
            game.batch.draw(Game2Active,x_savedgames-50,250F,GAME_BUTTON_WIDTH,GAME_BUTTON_HEIGHT);
        }
        else{
            game.batch.draw(Game2Inactive,x_savedgames-50,250F,GAME_BUTTON_WIDTH,GAME_BUTTON_HEIGHT);
        }

        if(Gdx.input.getX()<x_savedgames-50+GAME_BUTTON_WIDTH && Gdx.input.getX()>x_savedgames-50 && TankStarGame.GAME_HEIGHT-Gdx.input.getY()<100F+GAME_BUTTON_HEIGHT && TankStarGame.GAME_HEIGHT-Gdx.input.getY()>100F){
            game.batch.draw(Game3Active,x_savedgames-50,100F,GAME_BUTTON_WIDTH,GAME_BUTTON_HEIGHT);
        }
        else{
            game.batch.draw(Game3Inactive,x_savedgames-50,100F,GAME_BUTTON_WIDTH,GAME_BUTTON_HEIGHT);
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
