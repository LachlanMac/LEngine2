package com.lmac.lengine.entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.lmac.lengine.animation.Animator;
import com.lmac.lengine.assets.ModelLoader;
import com.lmac.lengine.config.CreatureLoader;
import com.lmac.lengine.config.Options;

public class Creature extends Entity {

	int id, creatureType, level;

	private boolean hasMoved = false;
	private int moveCounter = 0;
	private Animator anim;
	private Animation currentAnim;

	public Creature(int id, int creatureType, float x, float y, int level) {
		super(x, y);
		this.creatureType = creatureType;
		this.id = id;
		this.level = level;
		this.loc = new Vector2f(x, y);
	
		anim = CreatureLoader.getAnimator(creatureType);
		CreatureLoader.setDimensions(this);
		currentAnim = anim.getDownIdle();
		setBounds(false);
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
		//g.draw(bounds);
	}

	public int getID() {
		return id;
	}
	
	public void move(float x, float y, String dir) {
		
		hasMoved = true;
		
		moveCounter = 0;
		
		loc.set(x, y);
		
		setBounds(anim.flip());
		
		anim.setLastDirectionByString(dir);
		
		currentAnim = anim.getMovementAnim();
		
		
		
		
	}
	
	public int getCreatureType() {
		return creatureType;
	}
	

}
