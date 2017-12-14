package com.lmac.lengine.skills;

import org.newdawn.slick.Image;

public abstract class Skill {
	
	public Image icon;
	
	public abstract void doSkill();
	public abstract Image getImage();
}
