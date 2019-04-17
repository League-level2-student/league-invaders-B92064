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
		y ++;
		if(right == true) {
		x = x + r2;
		}
		else if(right == false) {
		x = x + r3;
		}
	}
	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.drawRect(x, y, width, height);
	}

}
