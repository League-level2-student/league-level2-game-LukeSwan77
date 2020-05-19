package source;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	ArrayList<Projectiles> projectiles = new ArrayList<Projectiles>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Rocketship rocket;
	int score = 0;
	public ObjectManager(Rocketship rock){
	this.rocket = rock;
}
void addProjectile(Projectiles pro){
	projectiles.add(pro);
}
void addAlien(){
	aliens.add(new Alien(new Random().nextInt(LeagueInvaders.gameWidth),0,50,50));
}
void update(){
	for (int i = 0; i < aliens.size(); i++) {
		aliens.get(i).update();;
		if(aliens.get(i).y > LeagueInvaders.gameHeight){
			aliens.get(i).isActive = false;
		}
	}
	for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).update();
		if(projectiles.get(i).y < 0){
			projectiles.get(i).isActive = false;
		}
	}
	rocket.update();
	
	checkCollision();
	purge();
	}
void draw(Graphics g){
	rocket.draw(g);
	for (int i = 0; i < aliens.size(); i++) {
		aliens.get(i).draw(g);
	}
	for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).draw(g);
	}
}
void purge(){
	for (int i = 0; i < aliens.size(); i++) {
		if(aliens.get(i).isActive == false){
			aliens.remove(i);
		}
	}
	for (int i = 0; i < projectiles.size(); i++) {
		if(projectiles.get(i).isActive == false){
			projectiles.remove(i);
		}
	}
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	addAlien();
}
void checkCollision(){
	for (int i = 0; i < aliens.size(); i++) {
		if(rocket.collisionBox.intersects(aliens.get(i).collisionBox)){
			rocket.isActive = false;
			aliens.get(i).isActive = false;
			
		}
}
	for (int i = 0; i < projectiles.size(); i++){
		for(int e = 0; e < aliens.size(); e++){
			if(aliens.get(e).collisionBox.intersects(projectiles.get(i).collisionBox)){
				aliens.get(e).isActive = false;
				score++;
			}
		}
	}
}
public int getScore(){
	return score;
}
}
