package com.lmac.lengine.assets;

public abstract class AssetLoader {
	
	private final int ID = 0;
	
	public AssetLoader() {
		
	}
	
	public abstract void init();
	
	public int getID() {
		return this.ID;
	}
	
}
