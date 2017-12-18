package com.lmac.lengine.animation;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Vector2f;

import com.lmac.lengine.entities.Entity;

public class Animator {

	private Animation[] animationSet;
	private Animation down_anim, up_anim, left_anim, right_anim, down_anim_idle, up_anim_idle, left_anim_idle,
			right_anim_idle;

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	private Direction lastMoved = Direction.DOWN;

	public Animator(Entity e, Animation[] animationSet) {
		this.animationSet = animationSet;
		down_anim = animationSet[0];
		up_anim = animationSet[1];
		left_anim = animationSet[2];
		right_anim = animationSet[3];
		down_anim_idle = animationSet[4];
		up_anim_idle = animationSet[5];
		left_anim_idle = animationSet[6];
		right_anim_idle = animationSet[7];

	}

	public Direction getLastDirection() {

		return lastMoved;

	}

	public void setLastDirection(Vector2f dir) {

		dir.normalise();
		float x = dir.getX();
		float y = dir.getY();

		// Horizontal magnitude is higher
		if (Math.abs(x) >= Math.abs(y)) {
			if (x <= 0) {
				lastMoved = Direction.LEFT;
			}
			if (x >= 0) {
				lastMoved = Direction.RIGHT;
			}

		}
		// Vertical magnitude is higher
		else {
			if (y <= 0) {
				lastMoved = Direction.UP;
			}
			if (y >= 0) {
				lastMoved = Direction.DOWN;
			}
		}

	}

	public Animation getIdleAnimation() {
		if (lastMoved == Direction.DOWN) {
			return down_anim_idle;
		} else if (lastMoved == Direction.UP) {
			return up_anim_idle;
		} else if (lastMoved == Direction.RIGHT) {
			return right_anim_idle;
		} else {
			return left_anim_idle;
		}

	}
	
	
	public Animation getMovementAnim() {
		if (lastMoved == Direction.DOWN) {
			return down_anim;
		} else if (lastMoved == Direction.UP) {
			return up_anim;
		} else if (lastMoved == Direction.RIGHT) {
			return right_anim;
		} else {
			return left_anim;
		}

	}

	public Animation getDown() {
		return down_anim;
	}

	public Animation getDownIdle() {
		return down_anim_idle;
	}

	public Animation getUp() {
		return up_anim;
	}

	public Animation getUpIdle() {
		return up_anim_idle;
	}

	public Animation getRight() {
		return right_anim;
	}

	public Animation getRightIdle() {
		return right_anim_idle;
	}

	public Animation getLeft() {
		return left_anim;
	}

	public Animation getLeftIdle() {
		return left_anim_idle;
	}

}
