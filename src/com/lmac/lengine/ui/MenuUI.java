package com.lmac.lengine.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.assets.UILoader;
import com.lmac.lengine.config.Options;
import com.lmac.lengine.net.LoginConnection;
import com.lmac.lengine.states.MenuState;
import com.lmac.lengine.utils.Log;

public class MenuUI implements UI {

	GameContainer input;
	TextField userField, passwordField;
	MenuButton login;
	InputField userName, password, charID;
	
	StateBasedGame game;
	public MenuUI(GameContainer gc, StateBasedGame game) {
		this.input = gc;
		userName = new InputField(400, 300, 200, 40, gc, UILoader.menuFont);
		password = new InputField(400, 360, 200, 40, gc, UILoader.menuFont);
		charID = new InputField(620, 300, 50, 40, gc, UILoader.menuFont);
		this.game = game;
		init();
		
	}

	public void init() {
		configureButtons();
	
	}

	@Override
	public void update(GameContainer gc) {
		Rectangle cursor = new Rectangle(gc.getInput().getMouseX(), gc.getInput().getMouseY(), 1, 1);
		login.update(gc, cursor);
		userName.update(gc, cursor);
		password.update(gc, cursor);
		charID.update(gc, cursor);
	}

	@Override
	public void render(Graphics g) {
		UILoader.background.draw(0, 0, Options.screenWidth, Options.screenHeight);
	
		g.setFont(UILoader.menuFont.getFont());
		login.render(g);
		g.drawString("Username", 250, 305);
		g.drawString("Password", 250, 365);
		
		userName.render(g);
		password.render(g);
		charID.render(g);
		
		

	}
	
	public void configureButtons() {
		login = new MenuButton(400, 450, 200, 50) {
			@Override
			public void action() {
				
				Log.print(userName.getText().trim());
				Log.print(password.getText().trim());
				String usr = userName.getText().trim();
				String pwd = password.getText().trim();
				String cID = charID.getText().trim();
				int char_ID = Integer.parseInt(cID);
				
				Options.playerID = char_ID;
				LoginConnection lc = new LoginConnection(MenuState.serverConn, game);
				lc.login(usr, pwd, char_ID);
			}

		};
		
		login.setText("Login");
		
	}

}
