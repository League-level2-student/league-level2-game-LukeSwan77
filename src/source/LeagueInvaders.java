package source;

import javax.swing.JFrame;

public class LeagueInvaders {
	static JFrame frame;
	GamePanel panel;
	public static final int gameWidth = 500;
	public static final int gameHeight = 800;
	public LeagueInvaders() {
		frame = new JFrame("League Invaders");
		panel = new GamePanel();
	}
	
public static void main(String[] args) {
	LeagueInvaders invader = new LeagueInvaders();
	invader.setup();
	
}

void setup() {
	frame.setSize(gameWidth, gameHeight);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);
	frame.addKeyListener(panel);
}

}
