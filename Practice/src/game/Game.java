package game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import sprites.Animation;
import sprites.Frame;
import sprites.Sprite;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -4701693684670803303L;
	
	public static final int WIDTH = 500, HEIGHT = 500;
	
	private Thread thread;
	private boolean running = false;
	
	private Random r;
	private Handler handler;
	
	public static BufferedImage pImage;
	public static BufferedImage dImage;
	
	
	public Game() {
		
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Hello World!", this);
		
		init();
		r = new Random();
		for(int i = 0; i < 1; i++) {
			
			handler.addObject(new Player(WIDTH / 2, HEIGHT / 2, ID.PLAYER));
			
		}
		
	}
	
	public void init() {
//		Sprite.loadSprite("linkSheet");
//		pImage = Sprite.loadSprite("linkSheet");
//		dImage = pImage.getSubimage(2, 1, 128, 128);
		
		
		
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		final int TICKS_PER_SECOND = 30;
	    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
	    final int MAX_FRAMESKIP = 10;
	    
		Long next_game_tick = System.currentTimeMillis();
		int loops;
		
		long timer = System.currentTimeMillis();
		long frames = 0;
		
		while( running ) {
			
			
			
			loops = 0;
			while( System.currentTimeMillis() > next_game_tick && loops < MAX_FRAMESKIP ) {
				tick();
				next_game_tick += SKIP_TICKS;
				loops++;
				frames++;
			}
			
			render();
			
			if(System.currentTimeMillis() - timer > 1000) {
				
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
				System.out.println();
			}
			
			
		}
		stop();
		
		
		
		
		
//		long lastTime = System.nanoTime();
//		double amountOfTicks = 60.0;
//		double ns = 1000000000 / amountOfTicks;
//		double delta = 0;
//		long timer = System.currentTimeMillis();
//		int frames = 0;
//		while(running) {
//			long now = System.nanoTime();
//			delta += (now - lastTime) / ns;
//			lastTime = now;
//			while(delta >= 1) {
//				tick();
//				delta--;
//			}
//			if(running)
//				render();
//			frames++;
//			
//			if(System.currentTimeMillis() - timer > 1000) {
//				timer += 1000;
//				System.out.println("FPS: " + frames);
//				frames = 0;
//			}
//		}
//		stop();
	}
	
	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	
	public static void main(String[] args) {
		
		new Game();
		
	}
}