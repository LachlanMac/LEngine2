package com.lmac.lengine.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import com.lmac.lengine.utils.Log;

public abstract class LComponent {
	private int xPad = 0, yPad = 0;
	private int xLoc, yLoc, height, width;
	protected Rectangle bounds;
	protected boolean drawBounds = true;

	public LComponent(int xLoc, int yLoc, int height, int width) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.height = height;
		this.width = width;
		setBounds();
	}

	public abstract void update(GameContainer gc, Rectangle cursor);

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		if (drawBounds)
			g.draw(bounds);
	}

	public void action() {
		Log.print("DEFAULT ACTION");
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setWidthPad(int pad) {
		xPad = pad;
		setBounds();
	}

	public void setHeightPad(int pad) {
		yPad = pad;
		setBounds();
	}

	public void setBounds() {
		bounds = new Rectangle(xLoc + xPad, yLoc + yPad, width - (xPad * 2), height - (yPad * 2));
	}

	public void drawBounds(boolean bool) {
		drawBounds = bool;
	}

}
