package com.lmac.lengine.assets;

public class AssetManager {
	
	TextureLoader tL;
	UILoader uiL;
	
	public AssetManager() {
		tL = new TextureLoader();
		uiL = new UILoader();
		
		
		init();
		
		
	}
	
	public void init(){
		tL.init();
		uiL.init();
	}
	
	
}
