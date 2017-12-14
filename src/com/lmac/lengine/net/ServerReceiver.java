package com.lmac.lengine.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.newdawn.slick.state.StateBasedGame;

import com.lmac.lengine.config.Options;
import com.lmac.lengine.entities.EntityManager;
import com.lmac.lengine.utils.Log;


public class ServerReceiver extends Thread {

	private int port;
	private DatagramSocket socket = null;
	private InetAddress address;
	private byte[] inData, outData;
	PacketReader pr;
	EntityManager em;
	private DatagramPacket inPacket;

	private boolean loginStatus = false;
	
	public ServerReceiver(Connection conn, StateBasedGame game, EntityManager em){
		this.socket = conn.getSocket();
		this.em = em;
		this.port = conn.getPort();
		this.address = conn.getAddress();
		pr = new PacketReader(em);
		
	}
	@Override
	public void run(){
		Log.print("Server Listener Started");
		while(true) {
			
			try {
				
				inData = new byte[512];
				inPacket = new DatagramPacket(inData, inData.length);
				
				socket.receive(inPacket);
				
				String received = new String(inPacket.getData());
				
				String packetID =  received.substring(0, 2);
				String packetData = received.substring(2);
				
			
				pr.readPacket(packetID, packetData);
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	public void sendTest(){
		
		String data = "92-this is a test packet";
		outData = new byte[256];
		outData = data.getBytes();
		DatagramPacket p = new DatagramPacket(outData, outData.length, address, port);
		
		try {
			
			Log.print("Sending Packet");
			socket.send(p);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
