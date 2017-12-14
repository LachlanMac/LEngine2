package com.lmac.lengine.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class HeartBeat {

	Connection conn = null;
	DatagramSocket socket;
	int playerID;
	
	public HeartBeat(Connection conn, int playerID) {
		this.conn = conn;
		socket = conn.getSocket();
		this.playerID = playerID;
	}
	
	public void update() {
		
		
		
		DatagramPacket heartBeat = new HeartBeatPacket(playerID).getPacket();
		
		try {
			socket.send(heartBeat);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	
}
