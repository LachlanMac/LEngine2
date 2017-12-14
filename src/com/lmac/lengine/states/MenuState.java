package com.lmac.lengine.states;


import java.net.InetAddress;
import java.net.UnknownHostException;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.assets.AssetManager;
import com.lmac.lengine.assets.UILoader;
import com.lmac.lengine.config.Options;
import com.lmac.lengine.main.Lengine;
import com.lmac.lengine.net.Connection;
import com.lmac.lengine.net.LoginConnection;
import com.lmac.lengine.skills.*;
import com.lmac.lengine.ui.*;
import com.lmac.lengine.utils.Log;


public class MenuState extends BasicGameState {
	

	AssetManager am;
	MenuUI ui;
	public static Connection loginConn, serverConn;
	public LoginConnection lc;
	
	
	public MenuState(Connection conn){
		serverConn = conn;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		am = new AssetManager();
		ui = new MenuUI(gc, game);
	
		am.init();
		ui.init();
		
	
		try {
			loginConn = new Connection(InetAddress.getByName(Options.serverAddress), Options.loginServerPort);
		
			Log.print("Creating Login Connection");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
	
		ui.render(g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		ui.update(gc);
	
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
