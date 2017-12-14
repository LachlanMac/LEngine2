package com.lmac.lengine.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class LEngineLauncher {

	
	public static void main(String[] args){
		
		AppGameContainer game;
		try {
			game = new AppGameContainer(new Lengine("GAME prealpha v0.001.15"));
			game.setDisplayMode(1280, 800, false);
			game.setTargetFrameRate(60);
			game.setMaximumLogicUpdateInterval(60);
			game.setVSync(true);
			game.setUpdateOnlyWhenVisible(false);
			game.setAlwaysRender(true);
			// start game
			game.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
