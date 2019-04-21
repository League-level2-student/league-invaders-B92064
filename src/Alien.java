import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {
Random r = new Random();
int r2 = r.nextInt(10 - 0);
int r3 = - r.nextInt(10 -0);
boolean right = true;
	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update() {
		super.update();
		y +=  10;
		if(right == true) {
		x = x + r2;
		}
		else if(right == false) {
		x = x + r3;
		}
		collisionBox.setBounds(x,y,width,height);
		
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg,x,y,width,height,null);
	}

}
