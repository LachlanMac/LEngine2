package com.lmac.lengine.assets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.lmac.lengine.utils.Log;

public class TextureLoader extends AssetLoader {
	private final int ID = 1;
	
	
	
	public static Image player, water, grass, dirt, floor_base;
	public static SpriteSheet cat1, cat2, cat3, floor;
	
	
	private static HashMap<Integer, Image> skillGraphicMap = new HashMap<Integer, Image>();
	@Override
	public void init() {
		loadSkillMap();
		
		
		try {
			player = new Image("res/textures/player.png");
			
			
			water = new Image("res/textures/waterTile.png");
			
			grass = new Image("res/textures/grassTile.png");
			
			dirt = new Image("res/textures/dirtTile.png");
			
			floor = new SpriteSheet("res/textures/floorSpriteSheet.png", 64, 64);
			
			floor_base = floor.getSprite(0, 0);
			
			
			
			
			
			
			
			
			
			
			
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
