package source;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
public Rocketship(int x, int y, int width, int height) {
	super(x,y,width,height);
	speed = 10;
	if (needImage) {
	    loadImage ("rocket.png");
	}
}

void draw(Graphics g) {
	if (gotImage) {
		g.drawImage(image, x, y, width, height, null);
	} else {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
public void up() {
	if(y >= -10){
	y-=speed;
	}
}
public void down() {
	if(y<600){
		y+=speed;
	}
}
public void right() {
	if(x<440){
		x+=speed;
	}
}
public void left() {
	if(x >= 0){
		x-=speed;
	}
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
public Projectiles getProjectile() {
    return new Projectiles(x+width/2, y, 10, 10);
} 

}
