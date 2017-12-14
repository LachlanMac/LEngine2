package com.lmac.lengine.ui;



import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.TextField;

import com.lmac.lengine.utils.Log;

public class InputField extends LComponent{
	GameContainer input;
	TextField entryField;
	LFont font;
	TrueTypeFont menuFont;
	
	
	public InputField(int xLoc, int yLoc, int width, int height, GameContainer gc, LFont font) {
		super(xLoc, yLoc, height, width);
		this.input = gc;
		this.font = font;
		menuFont = font.getFont();
		entryField = new TextField(input, menuFont, xLoc, yLoc, width, height);
		
		setBackground(Color.darkGray, null);
		setTextColor(Color.cyan);
		drawBounds = false;
		
	}

	public void action() {
		Log.print("CLICK");
		entryField.setFocus(true);
	}
	
	public void render(Graphics g) {
	

		if (drawBounds)
			g.draw(bounds);
		g.setColor(Color.white);
		entryField.render(input, g);
	}
	
	public void setBackground(Color backgroundColor, Color borderColor) {
		
		entryField.setBackgroundColor(backgroundColor);
		entryField.setBorderColor(borderColor);
		
	}

	public void setTextColor(Color textColor) {
		
		entryField.setTextColor(textColor);
		
	}

	@Override
	public void update(GameContainer gc, Rectangle cursor) {
		if (this.getBounds().intersects(cursor)) {
			if (gc.getInput().isMousePressed(0)) {
				action();
			}
		}
		
	}
	
	public String getText() {
		return entryField.getText();
	}
	
	public void resize() {
		
	}
	
}	
