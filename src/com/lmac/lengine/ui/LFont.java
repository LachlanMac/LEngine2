package com.lmac.lengine.ui;

import java.awt.Font;

import org.newdawn.slick.TrueTypeFont;

public class LFont{

	private Font awtFont;
	private TrueTypeFont font;
	private String name; 
	private int type;
	private int size;
	private boolean aa;
	
	public LFont(String name, int type, int size, boolean aa) {
		this.name = name;
		this.type = type;
		this.size = size;
		this.aa = aa;
		
		awtFont = new Font(this.name, this.type, this.size);
	
		font = new TrueTypeFont(awtFont, this.aa);
	
		
		
	}

	public void resize(int newSize) {
		awtFont = new Font(name, type, newSize);
		font = new TrueTypeFont(awtFont, aa);
		
		
	}
	
	//awtMenuFont = new Font("Eras Bold ITC", Font.PLAIN, 24);
	//menuFont = new TrueTypeFont(awtMenuFont, false);
	
	public TrueTypeFont getFont() {
		return font;
	}


}
