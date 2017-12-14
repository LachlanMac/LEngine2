package com.lmac.lengine.net;

import java.net.DatagramPacket;



public class HeartBeatPacket extends Packet{
	private int playerID;
	final private String HEARTBEAT_PACKET_ID = "#99";
	public HeartBeatPacket(int playerID) {
		
		this.playerID = playerID;
	
	}



	
	
	
	
	@Override
	public DatagramPacket getPacket() {
		
		byte[] data = new String(HEARTBEAT_PACKET_ID + "=" + playerID + "=" + "heartbeat").getBytes();
		
		return new DatagramPacket(data, data.length, this.getDestinationAddress(), this.getDestinationPort());
		
		
	}

}
