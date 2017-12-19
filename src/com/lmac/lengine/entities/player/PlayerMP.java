package com.lmac.lengine.entities.player;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.lmac.lengine.animation.Animator;
import com.lmac.lengine.assets.ModelLoader;
import com.lmac.lengine.assets.TextureLoader;
import com.lmac.lengine.entities.Entity;
import com.lmac.lengine.utils.Log;

public class PlayerMP extends Entity {

	String playerName;
	private int playerID;

	private Animator anim;
	private Animation currentAnim;
	private boolean hasMoved = false;
	private int moveCounter = 0;

	public PlayerMP(float x, float y, int playerID, String playerName) {
		super(x, y);
		loc = new Vector2f(x, y);
		this.playerName = playerName;

	}

	public PlayerMP(int playerID) {
		super(0, 0);
		loc = new Vector2f(0, 0);
		this.playerID = playerID;
		this.anim = new Animator(ModelLoader.cat_1_set);
		currentAnim = anim.getDownIdle();
	}

	@Override
	public void update() {
		if (hasMoved) {
			moveCounter++;
			if (moveCounter > 5) {

				hasMoved = false;
				moveCounter = 0;
				currentAnim = anim.getIdleAnimation();
			}

		}

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.drawAnimation(currentAnim, getX(), getY());
	}

	public int getPlayerID() {
		return playerID;
	}

	public void move(float newX, float newY) {
		hasMoved = true;
		Vector2f oldLoc = new Vector2f(loc.getX(), loc.getY());
		Vector2f newLoc = new Vector2f(newX, newY);
		loc.set(newX, newY);
		Vector2f direction = newLoc.sub(oldLoc);

		anim.setLastDirection(new Vector2f(direction));
		currentAnim = anim.getMovementAnim();
	}
}
