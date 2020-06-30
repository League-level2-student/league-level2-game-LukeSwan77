package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

public class gamePanel extends JPanel implements ActionListener, KeyListener{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Timer frameDraw;
	frog froppy = new frog (250, 2500, 50, 50);
	gamePanel(){
		titleFont = new Font("Ariel", Font.PLAIN, 36);
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	}
	void updateMenuState() {  }
	 void updateGameState() {  }
	 void updateEndState()  {  }
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, roadyCross.gameWidth, roadyCross.gameHeight);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Roady Cross", 280, 100);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, roadyCross.gameWidth, roadyCross.gameHeight);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 105, 100);
		froppy.draw(g);
	}
	void drawEndState(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, roadyCross.gameWidth, roadyCross.gameHeight);
		g.setFont(titleFont);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else if (currentState == MENU) {
		        currentState = GAME;
		    } else if (currentState == GAME) {
		    	currentState = END;
		    }
		}   
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
