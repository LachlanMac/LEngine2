package com.lmac.lengine.map;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.lmac.lengine.map.tiles.DirtTile;
import com.lmac.lengine.map.tiles.FloorTile;
import com.lmac.lengine.map.tiles.GrassTile;
import com.lmac.lengine.map.tiles.WaterTile;

public abstract class Tile {

	protected float hCost = 1f;
	protected float x, y, size;
	protected String tileName;
	protected boolean isSolid;
	public final static int TILE_SIZE = 64;
	protected int tile_ID;
	protected int type = 0;
	protected Image tileImage;

	public Tile(float x, float y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.size = TILE_SIZE;

	}

	public abstract void render(Graphics g);

	public void update() {

	}

	public boolean isSolid() {
		return false;
	}

	public Rectangle tileBounds() {

		return new Rectangle(x * size, y * size, size, size);

	}

	public String toString() {
		return this.tileName + "(" + this.x + ", " + this.y + ")";

	}

	public int getTileID() {

		return tile_ID;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;

	}

	public void setType(int type) {
		this.type = type;
	}

	public float getCost() {
		return hCost;
	}

	public static Tile getTileByID(int x, int y, int id) {
		if (id == 1) {
			return new GrassTile(x, y, id);
		}
		if (id == 0) {
			return new DirtTile(x, y, id);
		}
		if (id == 2) {
			return new WaterTile(x, y, id);
		} else {
			return new FloorTile(x, y, id);
		}

	}

}
