package com.lmac.lengine.entities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;



public abstract class Entity {
	
	
	private final int DEFAULT_HEIGHT = 64;
	private final int DEFAULT_WIDTH = 64;
	
	protected Vector2f loc;
	protected float x, y;
	protected int width, height;
	
	public Entity(float x, float y) {
		this.height = DEFAULT_HEIGHT;
		this.width = DEFAULT_WIDTH;
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
