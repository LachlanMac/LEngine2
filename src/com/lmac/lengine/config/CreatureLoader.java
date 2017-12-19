package com.lmac.lengine.config;

import org.newdawn.slick.geom.Rectangle;

import com.lmac.lengine.animation.Animator;
import com.lmac.lengine.assets.ModelLoader;
import com.lmac.lengine.entities.Creature;
import com.lmac.lengine.utils.Log;

public class CreatureLoader {

	public static Animator getAnimator(int creatureID) {

		Animator a;

		switch (creatureID) {
		case 100:
			a = new Animator(ModelLoader.snake_1_set);
			break;

		default:
			a = new Animator(ModelLoader.butterlion_1_set);
			break;
		}
		return a;
	}

	public static void setDimensions(Creature c) {

		Log.print("Setting Dimensions");
		int width, height;
		
		switch (c.getCreatureType()) {
		case 100:
			Log.print("CASE IS 100!");
			c.setWidth(16);
			c.setHeight(60);
			c.setCollidable(false);
			break;

		default:

			break;
		}

	}

}
