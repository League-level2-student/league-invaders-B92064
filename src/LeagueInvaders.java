import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	final static int HEIGHT = 800;
	final static int WIDTH = 500;
	JFrame gameFrame = new JFrame();
GamePanel P = new GamePanel();
	public LeagueInvaders() {
		this.gameFrame = new JFrame();
		this.P = new GamePanel();
		gameFrame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	public static void main(String[] args) {
		LeagueInvaders LI = new LeagueInvaders();
		LI.setup();
	}

	void setup() {
		gameFrame.add(P);
		gameFrame.addKeyListener(P);
		gameFrame.setVisible(true);
		gameFrame.setSize(WIDTH, HEIGHT);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        gameFrame.pack();
        P.startGame();
	}
}
