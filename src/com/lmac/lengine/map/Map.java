package com.lmac.lengine.map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.lmac.lengine.camera.Camera;
import com.lmac.lengine.config.Options;
import com.lmac.lengine.entities.player.Player;
import com.lmac.lengine.utils.Log;

public class Map {

	private int height, width, zoneID;

	private Tile[][] tileMap;
	private Player player;
	private Camera camera;

	private int minY, maxY, minX, maxX;

	public Map(int zoneID, GameContainer input, Player player) {
		this.zoneID = zoneID;
		this.player = player;
		this.camera = new Camera(this, player, input);
	}

	public void update() {

		camera.update();
	}

	public void render(Graphics g) {
		// translates the coordinates to simulate camera movement
		camera.translate(g);
		// render parameters
		
		
		minY = Math.max(0, ((int) player.getY() / Tile.TILE_SIZE) - Options.screenHeight / Tile.TILE_SIZE);
		maxY = Math.min((int) player.getY() / Tile.TILE_SIZE + Options.screenHeight / Tile.TILE_SIZE, getHeight());
		minX = Math.max(0, ((int) player.getX() / Tile.TILE_SIZE) - Options.screenWidth / Tile.TILE_SIZE);
		maxX = Math.min((int) player.getX() / Tile.TILE_SIZE + Options.screenWidth / Tile.TILE_SIZE, getWidth());
		for (int x = minX; x < maxX; x++) {
			for (int y = minY; y < maxY; y++) {

				tileMap[x][y].render(g); // Renders the tile at this location

			}

		}
		camera.render(g);
	}

	public void buildMap(String zoneFile) {
		Log.print("BUILDING MAP");
		String line = null;

		StringBuffer sb = new StringBuffer();

		try {
			BufferedReader br = new BufferedReader(new FileReader("res/maps/" + zoneFile));

			this.width = Integer.parseInt(br.readLine().trim()); // First entry equals the
			// width
			// of the map
			this.height = Integer.parseInt(br.readLine().trim());

			while ((line = br.readLine()) != null) {

				sb.append(line);

			}

			br.close();

			String[] tokens = sb.toString().split("\\s+"); // Split string by
															// white space

			// Second entry equals
			// the
			Log.print(width + ", " + height + "(map settings)"); // Height of
																	// the map

			tileMap = new Tile[this.width][this.height]; // creates an array of
															// Tiles

			int count = 0; // starts count at 2 to ignore first 2 entries

			for (int y = 0; y < height; y++) {

				for (int x = 0; x < width; x++) {

					tileMap[x][y] = Tile.getTileByID(x * Tile.TILE_SIZE, y * Tile.TILE_SIZE,
							Integer.parseInt(tokens[count]));

					count++; // increases count

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public Tile getTile(int x, int y) {

		return tileMap[x][y];

	}

	public Tile[][] getTileMap() {
		return this.tileMap;
	}

	public int getWorldWidth() {
		return -width * Tile.TILE_SIZE;
	}

	public int getWorldHeight() {
		return -height * Tile.TILE_SIZE;
	}

}
