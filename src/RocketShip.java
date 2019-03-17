import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {
int speed;
int x = 250;
int y = 700;
	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 5;
		this.x = x;
		this.y = y;
	}
	void update() {
		
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, 20, 50);

	}
}
