package com.mgstudios.game.entity.mob.player;

import com.mgstudios.game.entity.mob.EntityMob;
import com.mgstudios.game.graphics.Screen;
import com.mgstudios.game.graphics.sprites.Sprite;
import com.mgstudios.game.input.Controller;

public class EntityPlayer extends EntityMob {
	private Controller input;
	private Sprite sprite;
	private int anim;
	
	public EntityPlayer(Controller input) {
		this.input = input;
	}
	
	public EntityPlayer(int x, int y, Controller input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	@Override
	public void update() {		
		int xChange = 0, yChange = 0;
		
		if(anim < 7500) anim++;
		else anim = 0;
		
		if(input.up) yChange--;
		if(input.down) yChange++;
		if(input.left) xChange--;
		if(input.right) xChange++;
		
		if(xChange != 0 || yChange != 0) {
			move(xChange, yChange);
			moving = true;
		} else {
			moving = false;
		}
	}
	
	@Override
	public void render(Screen screen) {
		int flip = 0;
		if(dir == 0) {
			sprite = Sprite.player_up;
			
			if(moving) {
				if(anim % 20 > 10) {
					sprite = Sprite.player_up_1;
				} else {
					sprite = Sprite.player_up_2;
				}
			}
		}
		
		if(dir == 1) {
			sprite = Sprite.player_side;
			
			if(moving) {
				if(anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
		}
		
		if(dir == 2) {
			sprite = Sprite.player_down;
			
			if(moving) {
				if(anim % 20 > 10) {
					sprite = Sprite.player_down_1;
				} else {
					sprite = Sprite.player_down_2;
				}
			}
		}
		
		if(dir == 3) {
			sprite = Sprite.player_side;
			flip = 1;
			
			if(moving) {
				if(anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
}
