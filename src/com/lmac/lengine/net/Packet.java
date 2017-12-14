package com.lmac.lengine.net;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.lmac.lengine.config.Options;

public abstract class Packet {

	protected InetAddress destinationAddress;
	protected int destinationPort = Options.gameServerPort;
	protected int playerID;
	
	public Packet() {
		
	}

	public abstract DatagramPacket getPacket();

	
	
	public InetAddress getDestinationAddress() {

		try {
			return InetAddress.getByName(Options.serverAddress);
		} catch (UnknownHostException e) {

			e.printStackTrace();
			return null;
		}

	}

	public int getDestinationPort() {

		return destinationPort;

	}
}
