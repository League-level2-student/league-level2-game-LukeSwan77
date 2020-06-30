package source;

import javax.swing.JFrame;

public class roadyCross {
	
		static JFrame frame;
		gamePanel panel;
		public static final int gameWidth = 800;
		public static final int gameHeight = 500;
		public roadyCross() {
			frame = new JFrame("Roady Cross");
			panel = new gamePanel();
			frame.addKeyListener(panel);
		
}
	
	public static void main(String[] args) {
		roadyCross road = new roadyCross();
		road.setup();
	}
	
	void setup() {
		frame.setSize(gameWidth, gameHeight);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.addKeyListener(panel);
	}
}