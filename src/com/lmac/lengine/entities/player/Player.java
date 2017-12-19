package com.lmac.lengine.entities.player;

import java.util.Vector;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.animation.Animator;
import com.lmac.lengine.animation.Animator.Direction;
import com.lmac.lengine.assets.ModelLoader;
import com.lmac.lengine.assets.TextureLoader;
import com.lmac.lengine.config.PlayerLoader;
import com.lmac.lengine.entities.Entity;
import com.lmac.lengine.entities.EntityManager;
import com.lmac.lengine.net.MovePacket;
import com.lmac.lengine.net.ServerReceiver;
import com.lmac.lengine.net.ServerSender;
import com.lmac.lengine.utils.Log;

public class Player extends Entity {
	//
	int playerID;
	StateBasedGame game;
	ServerSender pOut;
	ServerReceiver pIn;
	GameContainer input;
	EntityManager em;
	int timeOut = 0;
	int speed = 3;
	int level = 0;
	Vector<Entity> eList;
	private Animator anim;
	private Animation currentAnim;

	public Player(float x, float y, StateBasedGame game, GameContainer input, EntityManager em, ServerSender pOut,
			ServerReceiver pIn, int playerID, int level) {
		super(x, y);
		this.em = em;
		this.game = game;
		this.input = input;
		loc = new Vector2f(x, y);
		this.pOut = pOut;
		this.pIn = pIn;
		this.playerID = playerID;
		this.level = level;
		this.anim = new Animator(ModelLoader.bearwarrior_1_set);
		this.eList = em.getEntityList();
		PlayerLoader.setDimensions(this);
		currentAnim = anim.getDownIdle();

		setBounds(false);
	}

	@Override
	public void update() {

		timeOut++;
		if (timeOut > 600) {
			em.removeEntity(this);
			game.enterState(0);
		}
		move();

	}

	@Override
	public void render(Graphics g) {

		g.drawAnimation(currentAnim, getX(), getY());
		g.setColor(Color.red);
		g.draw(bounds);

	}

	public void move() {

		Vector2f v = new Vector2f();
		int movX = 0;
		int movY = 0;

		if (input.getInput().isKeyDown(Input.KEY_W)) {
			movY--;
		}
		if (input.getInput().isKeyDown(Input.KEY_S)) {
			movY++;
		}

		if (input.getInput().isKeyDown(Input.KEY_D)) {
			movX++;
		}
		if (input.getInput().isKeyDown(Input.KEY_A)) {
			movX--;
		}

		if (movX == 0 && movY == 0) {
			currentAnim = anim.getIdleAnimation();
			return;
		}

		if (Math.abs(movX) == Math.abs(movY) && movY != 0) {
			int diagSpeed = (int) speed * 2 / 3;
			v = new Vector2f(movX * diagSpeed, movY * diagSpeed);

		} else {
			v = new Vector2f(movX * speed, movY * speed);
		}

		anim.setLastDirection(new Vector2f(movX, movY));

		currentAnim = anim.getMovementAnim();

		updateBounds(v.getX(), v.getY(), false);
		if (!checkIntersects()) {

			loc.set(loc.getX() + v.getX(), loc.getY() + v.getY());

			String moveP = "#05=" + playerID + "=" + loc.getX() + "=" + loc.getY();
			pOut.addPacket(new MovePacket(moveP.getBytes()));
		} else {

			updateBounds(-v.getX(), -v.getY(), false);

		}

	}

	public float getX() {
		return loc.getX();
	}

	public float getY() {
		return loc.getY();
	}

	public void resetTimeOut() {
		timeOut = 0;
	}

	public int getPlayerID() {
		return playerID;
	}

	public int getPlayerType() {
		return 1;
	}

	public boolean checkIntersects() {

		for (int i = 0; i < eList.size(); i++) {

			if (this.bounds.intersects(eList.get(i).getBounds())) {
				if (eList.get(i).isPlayer() || !eList.get(i).isCollidable())
					continue;

				return true;
			}

		}
		return false;
	}

	public boolean isPlayer() {
		return true;
	}
}
