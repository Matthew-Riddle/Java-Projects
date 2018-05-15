import java.awt.Graphics;

public abstract class GameObject {
	
	protected double x, y;
	protected double velX, velY;
	protected ID id;
	
	public GameObject(double x, double y, ID id) {
		
		this.x = x;
		this.y = y;
		this.id = id;
		
	}
	
	public abstract void onTick();
	public abstract void onRender(Graphics g);
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setId(ID id) {
		this.id = id;
	}
	
	public ID getId() {
		return id;
	}
	
	public double getVelX() {
		return velX;
	}
	
	public void setVelX(double velX) {
		this.velX = velX;
	}
	
	public double getVelY() {
		return velY;
	}
	
	public void setVelY(double velY) {
		this.velY = velY;
	}
}
