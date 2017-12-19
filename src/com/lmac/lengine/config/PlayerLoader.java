package com.lmac.lengine.config;

import com.lmac.lengine.entities.Creature;
import com.lmac.lengine.entities.player.Player;
import com.lmac.lengine.utils.Log;

public class PlayerLoader {

	public static void setDimensions(Player p) {

		Log.print("Setting Dimensions");
		int width, height;

		switch (p.getPlayerType()) {
		case 1:
			p.setWidth(40);
			p.setHeight(60);
			break;

		default:

			break;
		}

	}
}
