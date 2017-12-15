package com.lmac.lengine.entities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;



public abstract class Entity {
	
	protected Vector2f loc;
	protected float x, y;
	protected int width, height;
	
	public Entity(float x, float y) {

		this.x = x;
		this.y = y;
		this.loc = new Vector2f(x, y);

	}
	
	public abstract void update();
	
	
	public abstract void render(Graphics g);
	
	
	public Vector2f getCenter() {
		
		return new Vector2f(loc.getX() + (width / 2), loc.getY() + (height / 2));
		
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
}
