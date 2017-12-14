package com.lmac.lengine.ui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface UI {

	public abstract void update(GameContainer gc);
	public abstract void render(Graphics g);
	public abstract void init();
	
	
}
