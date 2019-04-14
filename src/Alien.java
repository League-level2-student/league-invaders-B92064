import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update() {
		y ++;
	}
	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.drawRect(x, y, width, height);
	}

}
