package game;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import sprites.Animation;
import sprites.Sprite;

public class Player extends GameObject {

	Random r = new Random();
	
	private Animation animation = null;
	
	private BufferedImage[] idleAnimation = { Sprite.getSprite(1, 1), Sprite.getSprite(2, 1), Sprite.getSprite(3, 1), Sprite.getSprite(2, 1), Sprite.getSprite(1, 1) };
	private BufferedImage[] leftAnimation = { Sprite.getSprite(1, 2), Sprite.getSprite(2, 2) };
	private BufferedImage[] rightAnimation = { Sprite.getSprite(1, 3), Sprite.getSprite(2, 3) };
	private Animation idle = new Animation(idleAnimation, 3);
	private Animation walkLeft = new Animation(leftAnimation, 1);
	private Animation walkRight = new Animation(rightAnimation, 1);
	
	private int speed = 4;
	private int jumpPower = 20;
	private double speedMult = 1.5;
	
	public Player(double x, double y, ID id) {
		super(x, y, id);
		
		velY = 10;
		animation = idle;
		animation.start();
			
	}

	public void onTick() {
		
		if(up == true && this.isOnGround == true) {
			velY = -jumpPower;
			
		}
		if(left == true) {
			velX = -speed;
			animation = walkLeft;
			animation.start();
		}
		if(right == true) {
			velX = speed;
			animation = walkRight;
			animation.start();
		}
		if(isOnGround != true) {
			velY++;
		}
		if(Math.abs(velX) < 0.1) {
			velX = 0;
		}
		if(!left && isOnGround && velX < 0 && velX >= -speed ) {
			velX+= (0 - velX)/2;
		}
		if(!right && isOnGround && velX > 0 && velX <= speed ) {
			velX-= (0 + velX)/2;
		}
		
		if(velX == 0) {
			animation = idle;
			animation.start();
		}
		
		
		x += velX;
		y += velY;
		
		animation.update();
		
		clamp();
		
		

	}
	
	public void clamp() {
		if(y > Game.HEIGHT) {
			y = 0;
			
		}
		
		if(y > 400) {
			y = 400;
			velY = 0;
			this.isOnGround = true;
		}
		
		if(y < 400) {
			this.isOnGround = false;
		}
		
		if(x < 0) {
			x = Game.WIDTH;
		}
		
		if(x > Game.WIDTH) {
			x = 0;
		}
		
	}

	public void onRender(Graphics g) {
		
		g.drawImage(animation.getSprite(), (int)x, (int)y, 64, 64, null);
		
	}
	
	

}
