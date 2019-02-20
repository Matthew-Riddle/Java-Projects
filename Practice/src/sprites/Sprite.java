package sprites;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.GameObject;
import game.ID;

public class Sprite {

	private static BufferedImage spriteSheet;
	private static final int TILE_SIZE = 32;
	
	public Sprite() {
		// TODO Auto-generated constructor stub
	}

	public static BufferedImage loadSprite( String file ) {
		
		BufferedImage sprite = null;
		
		try {
            sprite = ImageIO.read(new File("res/" + file + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("LOADED IMAGE FOOL");
		return sprite;
		
	}
	
	public static BufferedImage getSprite(int xGrid, int yGrid) {

        if (spriteSheet == null) {
            spriteSheet = loadSprite("linkSheet");
        }

        return spriteSheet.getSubimage(xGrid * TILE_SIZE - TILE_SIZE, yGrid * TILE_SIZE - TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

}
