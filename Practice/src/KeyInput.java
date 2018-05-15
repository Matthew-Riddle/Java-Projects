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
				
				if (key == KeyEvent.VK_A) {
					tempObject.setVelX(tempObject.getVelX() - .5);
				}
				
				if (key == KeyEvent.VK_D) {
					tempObject.setVelX(tempObject.getVelX() + .5);
				}
				
				if (key == KeyEvent.VK_W) {
					tempObject.setVelY(tempObject.getVelY() - .5);
				}
				
				if (key == KeyEvent.VK_S) {
					tempObject.setVelY(tempObject.getVelY() + .5);
				}
					
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	}
}
