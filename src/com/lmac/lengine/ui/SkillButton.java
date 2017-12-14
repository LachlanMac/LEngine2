package com.lmac.lengine.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import com.lmac.lengine.skills.Skill;


public class SkillButton extends LButton {
	boolean highlighted = false;
	Image icon;
	Skill skill = null;
	int button;
	Rectangle highlight;
	public SkillButton(int xLoc, int yLoc, int height, int width, Skill skill, int button) {
		super(xLoc, yLoc, height, width);
		highlight = bounds;
		this.skill = skill;
		this.button = button;
		if(skill != null){
			icon = skill.getImage();
		}
	}

	
	public void render(Graphics g) {
		if (skill != null) {
			g.setColor(Color.pink);
			icon.draw(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
		} else {
			g.setColor(Color.white);
		}
		g.draw(bounds);
		if(highlighted){
			g.setColor(Color.blue);
			g.draw(highlight);
		}
		g.setColor(Color.black);
		g.drawString(Integer.toString(button), (bounds.getX() + bounds.getWidth()) - 12, (bounds.getY() + bounds.getHeight()) -16 );
	}

	@Override
	public void action() {
		if (skill != null) {
			skill.doSkill();
		}

	}
	
	public void setSkill(Skill skill){
		this.skill = skill;
		icon = skill.getImage();
	}


	@Override
	public void update(GameContainer gc, Rectangle cursor) {
		if (this.getBounds().intersects(cursor)) {
			if (gc.getInput().isMousePressed(0)) {
				action();
			}
		}
		if(gc.getInput().isKeyDown(button + 1)){
			action();
		}
	}
	
	public void setHighlighted(boolean highlight){	
		this.highlighted = highlight;
	
	}




}
