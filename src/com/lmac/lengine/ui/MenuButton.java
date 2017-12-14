package com.lmac.lengine.ui;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class MenuButton extends LButton{

	
	String text = null;
	Color color = Color.white;
	
	public MenuButton(int xLoc, int yLoc, int height, int width) {
		super(xLoc, yLoc, height, width);
		
	}

	@Override
	public void update(GameContainer gc, Rectangle cursor) {
		if (this.getBounds().intersects(cursor)) {
			if (gc.getInput().isMousePressed(0)) {
				action();
			}
		}
		
	}
	@Override
	public void render(Graphics g){
		g.setColor(color);
		g.draw(bounds);
		if(text != null){
			g.drawString(text, xLoc + (width / 2) - (text.length() * 8), yLoc + (height / 2) - (16));
		}
		
	}
	
	public void setText(String str){
		text = str;
		
	}
	public void setColor(Color color){
		this.color = color;
	}
	
}
