package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Timer frameDraw;
	Timer alienSpawn;
	Font titleFont;
	Rocketship rocket = new Rocketship(250,500,50,50);
	ObjectManager manager = new ObjectManager(rocket);
	GamePanel(){
		titleFont = new Font("Ariel", Font.PLAIN, 36);
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	    if (needImage) {
	        loadImage ("space.png");
	    }

	}
	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		manager.update();
		if(rocket.isActive == false){
			currentState = END;
		}
	}
	void updateEndState() { 

	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.gameWidth, LeagueInvaders.gameHeight);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 100);
	}
	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.gameWidth, LeagueInvaders.gameHeight, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.gameWidth, LeagueInvaders.gameHeight);
		}
		manager.draw(g);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		int gameScore = manager.getScore();
		g.drawString("Score: " + gameScore +"", 50, 50);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.gameWidth, LeagueInvaders.gameHeight);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 105, 100);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_SPACE){
			manager.addProjectile(rocket.getProjectile());
			System.out.println("hi");
		}
		if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		        rocket = new Rocketship(250,500,50,50);
		        manager = new ObjectManager(rocket);
		    } else if(currentState == MENU) {
		        currentState = GAME;
		        startGame();
		    } else {
		    	currentState = END;
		    	alienSpawn.stop();
		    }
		}   
		if (arg0.getKeyCode()==KeyEvent.VK_UP) {
		    rocket.up();
		}
		if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
		    	rocket.down();
		    
		}
		if (arg0.getKeyCode()==KeyEvent.VK_LEFT) {
		    	rocket.left();
		    
		}
		if (arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
			
		    	rocket.right();
		    
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	void startGame(){
		alienSpawn = new Timer(1000 , manager);
	    alienSpawn.start();
	}
}
