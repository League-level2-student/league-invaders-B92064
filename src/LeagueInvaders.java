import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	final static int HEIGHT = 800;
	final static int WIDTH = 500;
	JFrame gameFrame = new JFrame();

	LeagueInvaders() {
		this.gameFrame = new JFrame();
		gameFrame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	public static void main(String[] args) {
		LeagueInvaders LI = new LeagueInvaders();
		LI.setup();
	}

	void setup() {
		gameFrame.setVisible(true);
		gameFrame.setSize(WIDTH, HEIGHT);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
