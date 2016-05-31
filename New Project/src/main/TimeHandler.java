package main;

public class TimeHandler extends Thread{

	private Game m;
	private double tickcount = 0.0;
	private double tickrate = 64.0;
	boolean run = true;
	
	public TimeHandler(Game m) {
		this.m = m;
	}
	public double getTick(){
		return tickcount;
	}
	public double getTickrate(){
		return tickrate;
	}
	public double getTime(){
		return (tickcount/tickrate);
	}
	public void run(){
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerTick = 1.0 / (tickrate);
		
		while (run) {
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;
			while (unprocessedSeconds > secondsPerTick) {
				m.tick();
				tickcount++;
				unprocessedSeconds -= secondsPerTick;
				if (tickcount % tickrate == 0) {	
					previousTime += 1000;
				}
			}
		}
	}
}
