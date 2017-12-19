package com.lmac.lengine.net;

import com.lmac.lengine.config.Options;
import com.lmac.lengine.entities.Creature;
import com.lmac.lengine.entities.EntityManager;
import com.lmac.lengine.entities.player.PlayerMP;
import com.lmac.lengine.utils.Log;

public class PacketReader {
	///

	EntityManager em;

	public PacketReader(EntityManager em) {

		this.em = em;

	}

	public void readPacket(String packetData) {


		String data = new String(packetData);
		String packetCode = data.substring(0, 3);

		switch (packetCode) {
		case "#05":
			parseMovePacket(packetData);
			break;
			
		case "#06":
			parseCreatureMovePacket(packetData);
			break;

		case "02":
			parseDisconnectPacket(packetData);
			break;

		case "88":
			parseHeartBeatPacket(packetData);
			break;

		case "44":
			parseMPPlayerMovementPacket(packetData);
			break;
		case "#65":
			parseSpawnerCreatureListPacket(packetData);
			break;
		case "#70":
			parseMPConnection(packetData);
			break;

		case "01":
			Log.print("WE SHOULD NOT BE HERE");
			break;

		default:
			Log.print("Invalid Packet ID");
			break;

		}
	}

	public void parseMPConnection(String packetData) {

		String[] data = packetData.split("=");
		int packetID = Integer.parseInt(data[1].trim());

		// TODO handle more than one other player connecting
		int playerID = Integer.parseInt(data[2].trim());

		em.getLocalPlayer().resetTimeOut();
		if (playerID == Options.playerID) {
			return;
		} else {
			em.updateMPConnections(playerID);

		}

	}
	
	public void parseCreatureMovePacket(String packetData) {
		Log.print(packetData);
		String[] data = packetData.split("=");
		int packetID = Integer.parseInt(data[1].trim());
		int creatureID = Integer.parseInt(data[2].trim());
		float xCoord = Float.parseFloat(data[3].trim());
		float yCoord = Float.parseFloat(data[4].trim());
		String dir = data[5].trim();
		
		Creature c = (Creature) em.getCreatureByID(creatureID);
		
		if(c != null) {
			
			c.move(xCoord, yCoord, dir);
		}else {
			Log.print("CREATURE IS NULL :( ");
		}
		
	}
	
	public void parseSpawnerCreatureListPacket(String packetData) {

		String[] data = packetData.split("=");

		int creatures = data.length - 1;
//
		// iterate through creature list (for spawner)
		for (int i = 2; i < data.length; i++) {
		
			String[] creatureInfo = data[i].split("x");

			int id = Integer.parseInt(creatureInfo[0].trim());
			int type = Integer.parseInt(creatureInfo[1].trim());

			float x = Float.parseFloat(creatureInfo[2].trim());
			float y = Float.parseFloat(creatureInfo[3].trim());
			int level = Integer.parseInt(creatureInfo[4].trim());
			
			// If the creature doesn't exist
			if (em.getCreatureByID(id) == null) {

				Creature c = new Creature(id, type, x, y, level);
				
				em.addEntity(c);
			}

		}

	}

	public void parseMPPlayerMovementPacket(String packetData) {
		String[] data = packetData.split("=");

		int packetID = Integer.parseInt(data[1].trim());
		int playerID = Integer.parseInt(data[2].trim());

		if (playerID == Options.playerID) {
			return;
		}

		float xCoord = Float.parseFloat(data[3].trim());
		float yCoord = Float.parseFloat(data[4].trim());

		em.getPlayerMPByID(playerID).move(xCoord, yCoord);

	}

	public void parseMovePacket(String packetData) {
		String[] data = packetData.split("=");

		int packetID = Integer.parseInt(data[1].trim());
		int playerID = Integer.parseInt(data[2].trim());

		if (playerID == Options.playerID) {
			return;
		}

		float xCoord = Float.parseFloat(data[3].trim());
		float yCoord = Float.parseFloat(data[4].trim());

		PlayerMP p = em.getPlayerMPByID(playerID);

		if (p == null) {

			em.removeMPPlayer(p);
			return;
		}

		p.move(xCoord, yCoord);

	}

	public void parseHeartBeatPacket(String packetData) {

	}

	public void parseDisconnectPacket(String packetData) {

	}

}
