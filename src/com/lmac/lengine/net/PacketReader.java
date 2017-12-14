package com.lmac.lengine.net;

import com.lmac.lengine.config.Options;
import com.lmac.lengine.entities.EntityManager;
import com.lmac.lengine.entities.player.PlayerMP;
import com.lmac.lengine.utils.Log;

public class PacketReader {

	EntityManager em;

	public PacketReader(EntityManager em) {

		this.em = em;

	}

	public void readPacket(String packetID, String packetData) {

		switch (packetID) {
		case "05":
			parseMovePacket(packetData);
			break;
		case "02":
			parseDisconnectPacket(packetData);
			break;
		case "88":
			parseHeartBeatPacket(packetData);
			break;
		case "41":
			parseMPPlayerDisconnectPacket(packetData);
			break;
		case "44":
			parseMPPlayerMovementPacket(packetData);
			break;
		case "70":
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
		int playerID = Integer.parseInt(data[1]);

		if (playerID == Options.playerID) {
			return;
		} else {
			em.updateMPConnections(playerID);

		}

	}

	public void parseMPPlayerMovementPacket(String packetData) {
		String[] data = packetData.split("=");
		int playerID = Integer.parseInt(data[1]);

		if (playerID == Options.playerID) {
			return;
		}

		float xCoord = Float.parseFloat(data[2]);
		float yCoord = Float.parseFloat(data[3]);

		em.getPlayerMPByID(playerID).move(xCoord, yCoord);

	}

	public void parseMPPlayerConnectPacket(String packetData) {
		String[] data = packetData.split("=");
		int playerID = Integer.parseInt(data[1]);
		if (playerID == Options.playerID) {
			return;
		}

		String name = data[2];
		Log.print("Added : ID[" + playerID + "]   at " + name);

		em.addMPPlayer(new PlayerMP(0, 0, playerID, name));

	}

	public void parseMPPlayerDisconnectPacket(String packetData) {

		String[] data = packetData.split("=");
		int playerID = Integer.parseInt(data[1]);
		if (playerID == Options.playerID) {
			return;
		}
		em.removeMPPlayer(em.getPlayerMPByID(playerID));

	}

	public void parseMovePacket(String packetData) {

		String[] data = packetData.split("=");

		int playerID = Integer.parseInt(data[1]);

		if (playerID == Options.playerID) {
			return;
		}

		float xCoord = Float.parseFloat(data[2]);
		float yCoord = Float.parseFloat(data[3]);

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
