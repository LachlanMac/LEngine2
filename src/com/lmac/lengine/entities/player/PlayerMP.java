package com.lmac.lengine.entities.player;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.lmac.lengine.assets.TextureLoader;
import com.lmac.lengine.entities.Entity;
import com.lmac.lengine.utils.Log;

public class PlayerMP extends Entity {

	String playerName;
	private int playerID;
	Vector2f loc;

	public PlayerMP(float x, float y, int playerID, String playerName) {
		super(x, y);
		loc = new Vector2f(x, y);
		this.playerName = playerName;
	}

	public PlayerMP(int playerID) {
		super(0, 0);
		loc = new Vector2f(0, 0);
		this.playerID = playerID;
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.drawImage(TextureLoader.player, loc.getX(), loc.getY());
	}
	public int getPlayerID() {
		return playerID;
	}

	public void move(float newX, float newY) {

		loc.set(newX, newY);

	}
}
