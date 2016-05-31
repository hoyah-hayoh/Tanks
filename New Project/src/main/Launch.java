package main;

public class Launch {
	int width = 800;
	int height = 400;
	
	public Launch() {
		new Game(width, height);
	}
	public static void main(String args[]){
		new Launch();
	}

}
