package main;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game {
	
	Key in;
	JFrame f;
	TimeHandler th;
	GraphicsHandler gh;
	BufferStrategy bs;
	public int mousex;
	public int mousey;
	
	public Game(int width, int height) {
		f = new JFrame();
		f.setTitle("Matt");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(width, height);
		f.setLocationRelativeTo(null);
		f.setUndecorated(false);
		f.setVisible(true);
		f.createBufferStrategy(3);
		
		in = new Key(this);
		f.addKeyListener(in);
		f.addMouseListener(in);
		f.addMouseMotionListener(in);
		f.addMouseWheelListener(in);
		
		bs = f.getBufferStrategy();
		gh = new GraphicsHandler(this);
		gh.start();
		th = new TimeHandler(this);
		th.start();
	}

	public void render(Graphics2D g) {
		
	}
	public void tick() {
		in.tick();
	}
}
