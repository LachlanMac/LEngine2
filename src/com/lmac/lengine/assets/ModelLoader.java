package com.lmac.lengine.assets;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class ModelLoader extends AssetLoader {

	public static SpriteSheet cat_1;
	public static Animation cat_1_down;
	public static Animation cat_1_up;
	public static Animation cat_1_left;
	public static Animation cat_1_right;
	public static Animation cat_1_down_idle;
	public static Animation cat_1_up_idle;
	public static Animation cat_1_left_idle;
	public static Animation cat_1_right_idle;
	public static Animation[] cat_1_set;
	
	
	
	public static SpriteSheet bearwarrior_1;
	public static Animation bearwarrior_1_down, bearwarrior_1_down_idle, bearwarrior_1_up, bearwarrior_1_up_idle, bearwarrior_1_left, bearwarrior_1_left_idle, bearwarrior_1_right, bearwarrior_1_right_idle;
	public static Animation[] bearwarrior_1_set;
	
	public static SpriteSheet snake_1;
	public static Animation snake_1_down, snake_1_up, snake_1_left, snake_1_right,  snake_1_down_idle, snake_1_up_idle, snake_1_left_idle, snake_1_right_idle;
	public static Animation[] snake_1_set;
	
	public static SpriteSheet butterlion_1;
	public static Animation butterlion_1_down, butterlion_1_up, butterlion_1_left, butterlion_1_right, butterlion_1_down_idle, butterlion_1_up_idle, butterlion_1_left_idle, butterlion_1_right_idle;
	public static Animation[] butterlion_1_set;
	
	
	@Override
	public void init() {
		try {
			cat_1 = new SpriteSheet("res/textures/spritesheets/creature_0.png", 64, 64);
			cat_1_down = new Animation(new Image[] { cat_1.getSprite(1, 0), cat_1.getSprite(2, 0) }, 100);
			cat_1_up = new Animation(new Image[] { cat_1.getSprite(1, 1), cat_1.getSprite(2, 1) }, 100);
			cat_1_left = new Animation(new Image[] { cat_1.getSprite(1, 2), cat_1.getSprite(2, 2) }, 100);
			cat_1_right = new Animation(new Image[] { cat_1.getSprite(1, 3), cat_1.getSprite(2, 3) }, 100);
			cat_1_down_idle = new Animation(new Image[] { cat_1.getSprite(0, 0) }, 100);
			cat_1_up_idle = new Animation(new Image[] { cat_1.getSprite(0, 1) }, 100);
			cat_1_left_idle = new Animation(new Image[] { cat_1.getSprite(0, 2) }, 100);
			cat_1_right_idle = new Animation(new Image[] { cat_1.getSprite(0, 3) }, 100);

			cat_1_set = new Animation[] { cat_1_down, cat_1_up, cat_1_left, cat_1_right, cat_1_down_idle, cat_1_up_idle,
					cat_1_left_idle, cat_1_right_idle };

			
			snake_1 = new SpriteSheet("res/textures/spritesheets/snek.png", 64, 64);
			snake_1_down = new Animation(new Image[] {snake_1.getSprite(0, 0).getFlippedCopy(false, true), snake_1.getSprite(1, 0).getFlippedCopy(false, true), snake_1.getSprite(2, 0).getFlippedCopy(false, true), snake_1.getSprite(3, 0).getFlippedCopy(false, true)}, 100);
			snake_1_up = new Animation(new Image[] {snake_1.getSprite(0, 0), snake_1.getSprite(1, 0), snake_1.getSprite(2, 0), snake_1.getSprite(3, 0)}, 100);
			snake_1_left = new Animation(new Image[] {snake_1.getSprite(4, 0), snake_1.getSprite(5, 0), snake_1.getSprite(6, 0), snake_1.getSprite(7, 0)}, 100);
			snake_1_right = new Animation(new Image[] {snake_1.getSprite(4, 0).getFlippedCopy(true, false), snake_1.getSprite(5, 0).getFlippedCopy(true, false), snake_1.getSprite(6, 0).getFlippedCopy(true, false), snake_1.getSprite(7, 0).getFlippedCopy(true, false)}, 100);
			snake_1_down_idle = new Animation(new Image[] {snake_1.getSprite(2, 0).getFlippedCopy(false, true)}, 100);
			snake_1_up_idle = new Animation(new Image[] {snake_1.getSprite(2, 0)}, 100);
			snake_1_left_idle = new Animation(new Image[] {snake_1.getSprite(5, 0)}, 100);
			snake_1_right_idle = new Animation(new Image[] {snake_1.getSprite(5, 0).getFlippedCopy(true, false)}, 100);
			
			snake_1_set = new Animation[]{snake_1_down, snake_1_up, snake_1_left, snake_1_right, snake_1_down_idle, snake_1_up_idle, snake_1_left_idle, snake_1_right_idle};
			
			
			butterlion_1 = new SpriteSheet("res/textures/spritesheets/butterlion_ss.png", 64, 64);
			butterlion_1_down = new Animation(new Image[] {butterlion_1.getSprite(1, 3), butterlion_1.getSprite(2, 3), butterlion_1.getSprite(3, 3), butterlion_1.getSprite(4, 3)}, 100);
			butterlion_1_up = new Animation(new Image[] {butterlion_1.getSprite(1, 0), butterlion_1.getSprite(2, 0), butterlion_1.getSprite(3, 0), butterlion_1.getSprite(4, 0)}, 100);
			butterlion_1_left = new Animation(new Image[] {butterlion_1.getSprite(1, 2), butterlion_1.getSprite(2, 2), butterlion_1.getSprite(3, 2), butterlion_1.getSprite(4, 2)}, 100);
			butterlion_1_right = new Animation(new Image[] {butterlion_1.getSprite(1, 1), butterlion_1.getSprite(2, 1), butterlion_1.getSprite(3, 1), butterlion_1.getSprite(4, 1)}, 100);
			butterlion_1_down_idle = new Animation(new Image[] {butterlion_1.getSprite(0, 3)}, 100);
			butterlion_1_up_idle = new Animation(new Image[] {butterlion_1.getSprite(0, 0)}, 100);
			butterlion_1_left_idle = new Animation(new Image[] {butterlion_1.getSprite(0, 2)}, 100);
			butterlion_1_right_idle = new Animation(new Image[] {butterlion_1.getSprite(0, 1)}, 100);
			
			butterlion_1_set = new Animation[]{butterlion_1_down, butterlion_1_up, butterlion_1_left, butterlion_1_right,butterlion_1_down_idle, butterlion_1_up_idle, butterlion_1_left_idle, butterlion_1_right_idle};
			
			
			
			
			bearwarrior_1 = new SpriteSheet("res/textures/spritesheets/BearWarrior.png", 64, 64);
			bearwarrior_1_down = new Animation(new Image[] {bearwarrior_1.getSprite(1, 0), bearwarrior_1.getSprite(2, 0), bearwarrior_1.getSprite(3, 0), bearwarrior_1.getSprite(4, 0)}, 100);
			bearwarrior_1_up = new Animation(new Image[] {butterlion_1.getSprite(1, 0), butterlion_1.getSprite(2, 0), butterlion_1.getSprite(3, 0), butterlion_1.getSprite(4, 0)}, 100);
			bearwarrior_1_left = new Animation(new Image[] {butterlion_1.getSprite(1, 2), butterlion_1.getSprite(2, 2), butterlion_1.getSprite(3, 2), butterlion_1.getSprite(4, 2)}, 100);
			bearwarrior_1_right = new Animation(new Image[] {butterlion_1.getSprite(1, 1), butterlion_1.getSprite(2, 1), butterlion_1.getSprite(3, 1), butterlion_1.getSprite(4, 1)}, 100);
			bearwarrior_1_down_idle = new Animation(new Image[] {bearwarrior_1.getSprite(0, 0)}, 100);
			bearwarrior_1_up_idle = new Animation(new Image[] {butterlion_1.getSprite(0, 0)}, 100);
			bearwarrior_1_left_idle = new Animation(new Image[] {butterlion_1.getSprite(0, 2)}, 100);
			bearwarrior_1_right_idle = new Animation(new Image[] {butterlion_1.getSprite(0, 1)}, 100);
			
			bearwarrior_1_set = new Animation[]{bearwarrior_1_down, butterlion_1_up, butterlion_1_left, butterlion_1_right, bearwarrior_1_down_idle, butterlion_1_up_idle, butterlion_1_left_idle, butterlion_1_right_idle};
			
			
		} catch (SlickException e) {

			e.printStackTrace();
		}

	}

}
