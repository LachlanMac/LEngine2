package com.lmac.lengine.entities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public abstract class Entity {

	private final int DEFAULT_HEIGHT = 64;
	private final int DEFAULT_WIDTH = 64;

	protected Vector2f loc;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	protected int id;
	private boolean collidable = false;

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
		return new Vector2f(loc.getX() + ((DEFAULT_WIDTH - width) / 2), loc.getY() + ((DEFAULT_HEIGHT - height) / 2));
	}
	public Vector2f getFlippedCenter() {
		return new Vector2f(loc.getX() + ((DEFAULT_HEIGHT - height) / 2), loc.getY() + ((DEFAULT_WIDTH - width) / 2));
	}

	public float getX() {
		return this.loc.getX();
	}

	public float getY() {
		return this.loc.getY();
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setBounds(boolean flipped) {
		if(!flipped) {
			bounds = new Rectangle(getCenter().getX(), getCenter().getY(), width, height);
		}else {
			bounds = new Rectangle(getFlippedCenter().getX(), getFlippedCenter().getY(), height, width);
		}
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void updateBounds(float x, float y, boolean flipped) {
		if (!flipped) {
			bounds.setX(bounds.getX() + x);
			bounds.setY(bounds.getY() + y);
		}else {
			
			
		}
	}

	public boolean isPlayer() {
		return false;
	}

	public int getID() {
		return id;
	}
	public void setCollidable(boolean value) {
		collidable = value;
	}
	
	public boolean isCollidable() {
		return collidable;
	}
}
