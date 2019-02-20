package game;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.PLAYER) {
				
				if (key == KeyEvent.VK_A)
					tempObject.left = true;
				if (key == KeyEvent.VK_D)
					tempObject.right = true;
				if (key == KeyEvent.VK_W) {
					if (tempObject.isOnGround) {
						tempObject.up = true;
					}
				}
				
				if (key == KeyEvent.VK_S) {
					tempObject.down = true;
					tempObject.setVelmY(tempObject.getVelmY() + 5);
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++ ) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.PLAYER) {
				if (key == KeyEvent.VK_W)
					tempObject.up = false;
				if (key == KeyEvent.VK_S)
					tempObject.down = false;
				if (key == KeyEvent.VK_A)
					tempObject.left = false;
				if (key == KeyEvent.VK_D)
					tempObject.right = false;
				
			}
		}
	}
}
