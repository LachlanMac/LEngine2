package com.lmac.lengine.config;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Options {
	public static int screenWidth = 1280;
	public static int screenHeight = 800;
	public static int loginServerPort = 7999;
	public static int gameServerPort = 8000;
	public static String serverAddress = "localhost";
	public static int playerID = 0;
	public static String playerName = "default";

	//PACKET VARIABLES
	public static final int LOGIN_PACKET_SIZE = 128;
	public static final String HEART_BEAT = "heartbeat";
	
	
	public static PlayerData playerData = new PlayerData();
	
	public static InetAddress getInetAddress(){
		InetAddress address = null;
		try {
			address = InetAddress.getByName(serverAddress);
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		
		return address;
		
	}

	public static void init(int id){
		
		playerID = id;
		
	}
	
	
}
