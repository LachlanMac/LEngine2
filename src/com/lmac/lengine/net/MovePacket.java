package com.lmac.lengine.net;

import java.net.DatagramPacket;

public class MovePacket extends Packet{

	private byte[] moveData;
	
	public MovePacket(byte[] moveData){
		this.moveData = moveData;
		
	}
	
	
	
	
	@Override
	public DatagramPacket getPacket() {
		
		DatagramPacket p = new DatagramPacket(moveData,  moveData.length, this.getDestinationAddress(), this.getDestinationPort());
		
		return p;
		
	}

}
