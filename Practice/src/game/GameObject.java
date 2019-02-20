package game;
import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject {
	
	protected double x, y;
	protected int sizex, sizey;
	protected double velX, velY, velmX, velmY;
	protected ID id;
	public Color color;
	boolean isOnGround;
	public boolean up = false, down = false, left = false, right = false;
	
	
	public GameObject(double x, double y, ID id) {
		
		this.x = x;
		this.y = y;
		this.id = id;
		
	}
	
	public GameObject() {
		
	}
	
	public abstract void onTick();
	public abstract void onRender(Graphics g);
	
	public double getVelmY() {
		return velmY;
	}
	
	public void setVelmY(double y) {
		this.velmY = y;
	}
	
	public double getVelmX() {
		return velmX;
	}
	
	public void setVelmX(double x) {
		this.velmX = x;
	}
	
	public void setSizex(int x) {
		this.sizex = x;
	}
	
	public int getSizex() {
		return sizex;
	}
	
	public void setSizey(int y) {
		this.sizey = y;
	}
	
	public int getSizey() {
		return sizey;
	}
	
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
