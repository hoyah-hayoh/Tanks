package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class GraphicsHandler extends Thread{

	private Game game;
	public GraphicsHandler(Game game) {
		this.game = game;
	}
	public void run() {
		while(true){
			try {
				Graphics2D g = null;
				try {
					g = (Graphics2D) game.bs.getDrawGraphics();
					g.setColor(Color.BLACK);
					g.fillRect(0,0,game.f.getWidth(),game.f.getHeight());
					game.render(g);
				} finally {
					if (g != null)
						g.dispose();
				}
				game.bs.show();
			} catch (Exception err) {}
		}
	}
}
