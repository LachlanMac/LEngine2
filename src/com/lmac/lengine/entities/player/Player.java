package com.lmac.lengine.entities.player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.assets.TextureLoader;
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
	Vector2f loc;
	int timeOut = 0;
	int speed = 3;
	public Player(float x, float y, StateBasedGame game, GameContainer input, EntityManager em, ServerSender pOut, ServerReceiver pIn, int playerID) {
		super(x, y);
		this.em = em;
		this.game = game;
		this.input = input;
		loc = new Vector2f(x, y);
		this.pOut = pOut;
		this.pIn = pIn;
		this.playerID = playerID;
	}

	@Override
	public void update() {
		
		timeOut++;
		if(timeOut > 600) {
			em.removeEntity(this);
			game.enterState(0);
		}
		move();
	
		
		
	}

	@Override
	public void render(Graphics g) {
	
		g.drawImage(TextureLoader.player, loc.getX(), loc.getY());
		
	}
	
	public void move(){
		
		Vector2f v = new Vector2f();
		int movX = 0;
		int movY = 0;
		
		if(input.getInput().isKeyDown(Input.KEY_W)){
			movY--;
		}
		if(input.getInput().isKeyDown(Input.KEY_S)){
			movY++;
		}

		if(input.getInput().isKeyDown(Input.KEY_D)){
			movX++;
		}
		if(input.getInput().isKeyDown(Input.KEY_A)){
			movX--;
		}
		
		if (movX == 0 && movY == 0){
			return;
		}
		
		
		
		if (Math.abs(movX) == Math.abs(movY) && movY != 0) {
			int diagSpeed = (int) speed * 2 / 3;
			v = new Vector2f(movX * diagSpeed, movY * diagSpeed);

		} else {
			v = new Vector2f(movX * speed, movY * speed);
		}
		
		loc.set(loc.getX() + v.getX(), loc.getY() + v.getY());
		
		String moveP = "#05=" + playerID + "=" + loc.getX() + "=" + loc.getY();
		pOut.addPacket(new MovePacket( moveP.getBytes()));
		
		
	}
	
	public void resetTimeOut() {
		Log.print("RESETING TIMEOUT");
		timeOut = 0;
	}
	
	public int getPlayerID(){
		return playerID;
	}

}
