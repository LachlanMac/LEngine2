package com.lmac.lengine.net;

import com.lmac.lengine.config.Options;
import com.lmac.lengine.entities.EntityManager;
import com.lmac.lengine.entities.player.PlayerMP;
import com.lmac.lengine.utils.Log;

public class PacketReader {

	EntityManager em;
////
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
			
		case "02":
			parseDisconnectPacket(packetData);
			break;
			
		case "88":
			parseHeartBeatPacket(packetData);
			break;
			
		case "44":
			parseMPPlayerMovementPacket(packetData);
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
		
		int playerID = Integer.parseInt(data[1].trim());
		em.getLocalPlayer().resetTimeOut();
		if (playerID == Options.playerID) {
			return;
		} else {
			em.updateMPConnections(playerID);

		}

	}

	public void parseMPPlayerMovementPacket(String packetData) {
		String[] data = packetData.split("=");
		int playerID = Integer.parseInt(data[1].trim());

		if (playerID == Options.playerID) {
			return;
		}

		float xCoord = Float.parseFloat(data[2].trim());
		float yCoord = Float.parseFloat(data[3].trim());

		em.getPlayerMPByID(playerID).move(xCoord, yCoord);

	}


	public void parseMovePacket(String packetData) {
		String[] data = packetData.split("=");

		int playerID = Integer.parseInt(data[1].trim());

		if (playerID == Options.playerID) {
			return;
		}

		float xCoord = Float.parseFloat(data[2].trim());
		float yCoord = Float.parseFloat(data[3].trim());

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
