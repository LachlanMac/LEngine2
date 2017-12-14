package com.lmac.lengine.entities;

import java.util.Vector;

import org.newdawn.slick.Graphics;

import com.lmac.lengine.config.Options;
import com.lmac.lengine.entities.player.PlayerMP;
import com.lmac.lengine.utils.Log;

public class EntityManager {

	public Vector<Entity> entityList;
	public Vector<PlayerMP> playerList;

	public EntityManager() {

		entityList = new Vector<Entity>();
		playerList = new Vector<PlayerMP>();

	}

	public void updateMPConnections(int id) {

		PlayerMP p;
		int counter = 0;

		if (playerList.size() == 0) {

			addMPPlayer(new PlayerMP(id));
			return;

		}

		for (int i = 0; i < playerList.size(); i++) {

			int existingPID = playerList.get(i).getPlayerID();
			if (id == existingPID) {

			} else {
				counter++;

			}
			if (counter > 0) {
				Log.print("THIS CLIENT [ID=" + Options.playerID + "] is adding MPCLIENT [ID=" + id
						+ "] to the gameworld");
				addMPPlayer(new PlayerMP(id));

			}

		}

	}

	public void update() {

		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).update();
		}
		for (int k = 0; k < playerList.size(); k++) {
			playerList.get(k).update();
		}

	}

	public void render(Graphics g) {

		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).render(g);
		}
		for (int k = 0; k < playerList.size(); k++) {
			playerList.get(k).render(g);
		}
	}

	public void addMPPlayer(PlayerMP e) {

		int newPlayerID = e.getPlayerID();

		for (int i = 0; i < playerList.size(); i++) {

			if (newPlayerID == playerList.get(i).getPlayerID()) {

				return;

			}

		}
		Log.print("Added a MP Player to the Entity List");
		playerList.add(e);
	}

	public void removeMPPlayer(PlayerMP e) {
		playerList.remove(e);
	}

	public void removeEntity(Entity e) {

		entityList.remove(e);

	}

	public void addEntity(Entity e) {

		Log.print("Added new Player to Entity Manager  CLIENTID=" + Options.playerID + " Entity ID =");
		entityList.add(e);

	}

	public PlayerMP getPlayerMPByID(int id) {
		PlayerMP p = null;
		for (int k = 0; k < playerList.size(); k++) {
			if (playerList.get(k).getPlayerID() == id) {
				p = playerList.get(k);
			}

		}
		return p;
	}

}
