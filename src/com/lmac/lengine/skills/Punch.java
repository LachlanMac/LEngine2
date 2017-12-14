package com.lmac.lengine.skills;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Punch extends Skill {
	
	
	
	public Punch(){
		try {
			icon = new Image("skills/punch.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
		}
	}
	
	@Override
	public void doSkill() {
		System.out.println("DOING A PUNCH");
		
	}

	@Override
	public Image getImage() {
		return icon;
		
	}

}
