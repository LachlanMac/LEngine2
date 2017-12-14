package com.lmac.lengine.net;

import java.net.DatagramPacket;

import com.lmac.lengine.utils.Log;

public class ConnectPacket extends Packet {

	byte[] connectData;
	
	public ConnectPacket(byte[] connectData){
		this.connectData = connectData;
		
	}
	
	@Override
	public DatagramPacket getPacket() {
		
		DatagramPacket p = new DatagramPacket(connectData,  connectData.length, this.getDestinationAddress(), this.getDestinationPort());
		Log.print("Sending Connect Data to Server: " + connectData.toString());
		return p;
	}

}
