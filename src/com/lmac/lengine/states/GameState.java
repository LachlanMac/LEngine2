package com.lmac.lengine.states;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.config.Options;
import com.lmac.lengine.entities.EntityManager;
import com.lmac.lengine.entities.player.Player;
import com.lmac.lengine.map.Map;
import com.lmac.lengine.net.Connection;
import com.lmac.lengine.net.HeartBeatPacket;
import com.lmac.lengine.net.MovePacket;
import com.lmac.lengine.net.ServerReceiver;
import com.lmac.lengine.net.ServerSender;
import com.lmac.lengine.ui.GameUI;
import com.lmac.lengine.utils.Log;

//
public class GameState extends BasicGameState {

	Player p;
	int playerID;
	GameUI gui;
	Connection serverConn;
	ServerReceiver receiver;
	ServerSender sender;
	EntityManager em;
	Map map;

	public GameState(Connection conn) {
		this.serverConn = conn;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {

		Log.print("Init GAMESTATE");

	}

	@Override
	public void enter(GameContainer gc, StateBasedGame game) {
		Log.print("Entering Game State: 0");
		em = new EntityManager();
		gui = new GameUI(gc);

		receiver = new ServerReceiver(serverConn, game, em);

		sender = new ServerSender(serverConn, game);

		sender.start();
		receiver.start();

		p = new Player(200, 300, game, gc, em, sender, receiver, Options.playerID);

		em.addLocalPlayer(p);

		map = new Map(playerID, gc, p);
		
		map.buildMap("Elba.txt");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		map.render(g);
		em.render(g);
		g.resetTransform();
		gui.render(g);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		map.update();
		em.update();

		gui.update(gc);
		sender.addPacket(new HeartBeatPacket(p.getPlayerID()));
	}

	@Override
	public int getID() {
		return 1;
	}

}
