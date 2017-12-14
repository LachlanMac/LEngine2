package com.lmac.lengine.ui;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import com.lmac.lengine.config.Options;
import com.lmac.lengine.input.LMouseListener;
import com.lmac.lengine.skills.Skill;
import com.lmac.lengine.utils.Log;

public class Hotbar {
	int highlightedSkill = 0;
	private ArrayList<SkillButton> skills;
	private GameContainer input;
	LMouseListener l;

	public Hotbar(GameContainer input) {
		this.input = input;
		skills = new ArrayList<SkillButton>(8);
		init();

		l = new LMouseListener() {
			@Override
			public void mouseWheelMoved(int delta) {
				if (delta < 0) {
					if (highlightedSkill == 1) {
						highlightedSkill = 8;

					} else {
						highlightedSkill -= 1;
					}
				}
				if (delta > 0) {

					if (highlightedSkill == 8) {
						highlightedSkill = 1;

					} else {
						highlightedSkill += 1;
					}

				}
			}
		};

		input.getInput().addMouseListener(l);

	}

	public void update(Rectangle cursor) {

		for (int i = 0; i < skills.size(); i++) {
			skills.get(i).update(input, cursor);
			
		}
		highlightSkill();

	}

	public void render(Graphics g) {

		for (int i = 0; i < skills.size(); i++) {
			skills.get(i).render(g);
		}
	}

	public void highlightSkill() {
		
		for (int i = 0; i < skills.size(); i++) {
			if((i + 1) == highlightedSkill){
				skills.get(i).setHighlighted(true);
			} else{
				skills.get(i).setHighlighted(false);
			}
			
		}
	
	}

	public void addSkill(Skill skill, int index) {
		int k = index - 1;
		skills.get(k).setSkill(skill);
	}

	public void init() {
		int widthSectors = Options.screenWidth / 16;
		int heightSectors = Options.screenHeight / 16;
		int startX = widthSectors * 3;
		int startY = heightSectors * 14;

		for (int i = 1; i <= 8; i++) {

			SkillButton btn = new SkillButton(startX + (i * widthSectors), startY, widthSectors, widthSectors, null, i);
			btn.setWidthPad(5);
			btn.setHeightPad(5);
			skills.add(btn);
		}

	}
}
