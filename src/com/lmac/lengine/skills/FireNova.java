package com.lmac.lengine.skills;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FireNova extends Skill {

	public FireNova(){
		try {
			icon = new Image("skills/firenova.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
		}
	}
	
	@Override
	public void doSkill() {
		System.out.println("DOING A FIRENOVA");
		
	}

	@Override
	public Image getImage() {
		
		return icon;
	}

}
