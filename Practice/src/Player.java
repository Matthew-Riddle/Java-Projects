import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Color color;
	public Player(double x, double y, ID id) {
		super(x, y, id);
		
		velX = r.nextInt(3) + 1;
		velY = r.nextInt(10) + 1;
		
		
		
		if(velY == 1)
			color = Color.DARK_GRAY;
		if(velY == 2)
			color = Color.GRAY;
		if(velY == 3)
			color = Color.LIGHT_GRAY;
		if(velY == 4)
			color = Color.WHITE;
			
	}

	public void onTick() {
		
		y += velY;
		x += velX;
		
		if(this.velX < -10) {
			int count = 5;
			while(count != 0) {
				velX += .1;
				count --;
			}
		}
		
		if(this.y > Game.HEIGHT) {
			y = 0;
			
		}
		
		if(this.y < 0) {
			y = Game.HEIGHT;
			
		}
		
		if(this.x < 0) {
			x = Game.WIDTH;
		}
		
		if(this.x > Game.WIDTH) {
			x = 0;
		}

	}

	public void onRender(Graphics g) {
		
		g.setColor(color);
		g.fillRect((int)x, (int)y, 3, 3);
	}
	
	

}
