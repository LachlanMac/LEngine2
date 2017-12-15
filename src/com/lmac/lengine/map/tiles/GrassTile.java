package com.lmac.lengine.map.tiles;

import org.newdawn.slick.Graphics;

import com.lmac.lengine.assets.TextureLoader;
import com.lmac.lengine.map.Tile;


public class GrassTile extends Tile {

	public GrassTile(float x, float y, int type) {
		super(x, y, type);
		this.tileName = "Grass Tile";
		tileImage = TextureLoader.grass;
		hCost = 30;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(tileImage, x, y);
	}

}
