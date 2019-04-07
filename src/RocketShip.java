import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {
int speed;
boolean up;
boolean down;
boolean left;
boolean right;
	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 5;
	
	}
	void update() {
		if(up == true) {
			y -= speed;
			if(y < 0) {
				y = 0;
			}
		}
		else if(down == true) {
			y += speed;
			if(y > 729) {
				y = 729;
			}
		}
		else if(left == true) {
			x -= speed;
			if(x < 0) {
				x = 0;
			}
		}
		else if(right == true) {
			x += speed;
			if(x > 450) {
				x = 450;
			}
		}
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);

	}
	
}
