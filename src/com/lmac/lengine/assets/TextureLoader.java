package com.lmac.lengine.assets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.lmac.lengine.utils.Log;

public class TextureLoader extends AssetLoader {
	private final int ID = 1;
	
	
	
	public static Image player;
	
	
	
	private static HashMap<Integer, Image> skillGraphicMap = new HashMap<Integer, Image>();
	@Override
	public void init() {
		loadSkillMap();
		
		
		try {
			player = new Image("res/textures/player.png");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void loadSkillMap() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("data/skills.txt")));
			String parse;
			while((parse = br.readLine()) != null) {
				String parseMap[] = parse.split(" ");
				int key = Integer.valueOf(parseMap[0]);
				Image img = new Image(parseMap[1]);
				skillGraphicMap.put(key, img);
				
			}
			
	
			
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SlickException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public static HashMap<Integer, Image> getSkillMap() {
		return skillGraphicMap;
	}
	
}
