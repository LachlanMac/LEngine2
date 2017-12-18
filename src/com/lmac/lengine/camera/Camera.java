package com.lmac.lengine.camera;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.lmac.lengine.config.Options;
import com.lmac.lengine.entities.player.Player;
import com.lmac.lengine.map.Map;


public class Camera {

	/*
	 * [CAMERA] This class applies offsets to the rendering engine that translate
	 * the coordinates on the screen to simulate a camera. Current implementation
	 * allows the user to move the camera with WASD
	 */

	private Map map;
	private GameContainer input;
	private Vector2f cameraPos;
	private float zoom = 1f;
	private float maxZoom = 3f;
	private float minZoom = 0.1f;
	private int xClamp, yClamp;
	Player p;

	// Constructor
	public Camera(Map map, Player p, GameContainer input) {
		this.map = map;
		this.input = input;
		this.p = p;
		// starts the camera centered
		cameraPos = new Vector2f((p.getCenter().getX()), (p.getCenter().getY()));
	}

	public void update() {
		getZoom();
		cameraPos.set(p.getCenter());

	}

	public void render(Graphics g) {
		// renders and indicator to show the camera coordinates
	
	}

	// translates the camera to render different parts of the gameworld
	public void translate(Graphics g) {
		// sets zoom

		g.scale(zoom, zoom);
		// translate params

		int xTrans = (int) (Options.screenWidth / (2 * zoom) - p.getCenter().getX());
		int yTrans = (int) (Options.screenHeight / (2 * zoom) - p.getCenter().getY());

		// clamps the camera to the size of the world
		xClamp = (int) Math.max((map.getWorldWidth() * zoom) + Options.screenWidth, Math.min(xTrans, 0));
		yClamp = (int) Math.max((map.getWorldHeight() * zoom) + Options.screenHeight, Math.min(yTrans, 0));
		// translates graphics based on range of clamps
		g.translate(xClamp, yClamp);

	}

	public void getZoom() {
		// input detection for zooming
		if (input.getInput().isKeyDown(Input.KEY_0)) {
			if (zoom <= minZoom) {
				zoom = minZoom;
			} else {
				zoom = zoom - 0.1f;
			}
		}
		if (input.getInput().isKeyDown(Input.KEY_9)) {
			if (zoom >= maxZoom) {
				zoom = maxZoom;
			} else {
				zoom = zoom + 0.1f;
			}
		}
	}

	public float getX() {
		return cameraPos.getX();
	}

	public float getY() {
		return cameraPos.getY();
	}
}
