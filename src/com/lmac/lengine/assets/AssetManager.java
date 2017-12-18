package com.lmac.lengine.assets;

import javax.management.loading.MLet;

public class AssetManager {
	
	TextureLoader tL;
	UILoader uiL;
	ModelLoader mL;
	
	public AssetManager() {
		tL = new TextureLoader();
		uiL = new UILoader();
		mL = new ModelLoader();
		
		
		init();
		
		
	}
	
	public void init(){
		tL.init();
		uiL.init();
		mL.init();
	}
	
	
}
