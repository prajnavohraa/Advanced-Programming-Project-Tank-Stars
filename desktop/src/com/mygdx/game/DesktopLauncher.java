package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.TankStarGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("TankStars");
		config.setResizable(false);
		config.setWindowedMode(TankStarGame.GAME_WIDTH,TankStarGame.GAME_HEIGHT);
		config.setResizable(false);
		new Lwjgl3Application(new TankStarGame(), config);
	}
}
