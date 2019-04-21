import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer = new Timer(1000 / 60, this);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int INSTRUCTION_STATE = 3;
	int currentState = MENU_STATE;
	Font titleFont;
	Font enterFont;
	int kills;
	RocketShip r;
	ObjectManager OM;
	int x = 250;
	int y = 700;
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public static BufferedImage spaceImg;

	public GamePanel() {
		this.timer = timer;
		this.titleFont = new Font("Comic Sans", Font.PLAIN, 52);
		this.enterFont = new Font("Arial", Font.PLAIN, 30);
		this.r = new RocketShip(x, y, 50, 50);
		this.OM = new ObjectManager(r);
		try {

			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Works");
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}

		repaint();
	}

	@Override

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		} else if (currentState == INSTRUCTION_STATE) {

			drawInstructionState(g);
			
		}

	}

	void startGame() {
		timer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Works 1");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Works 2");
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			OM.addProjectile(new Projectile(r.x + 21, r.y, 10, 10));
		}
		if (e.getKeyCode() == KeyEvent.VK_I) {
			currentState = INSTRUCTION_STATE;
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (currentState == END_STATE) {
				r = new RocketShip(250, 700, 50, 50);
				OM = new ObjectManager(r);
				currentState = MENU_STATE;

			} else if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			r.up = true;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			r.down = true;
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			r.left = true;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			r.right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Works 3");
		if (e.getKeyCode() == KeyEvent.VK_W) {
			r.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			r.down = false;
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			r.left = false;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			r.right = false;
		}

	}

	void updateMenuState() {

	}

	void updateGameState() {
		OM.update();
		OM.manageEnemies();
		OM.checkCollision();
		OM.purgeObjects();
		if (r.isAlive == false) {
			currentState = END_STATE;
		}
	}

	void updateEndState() {

	}

	void updateInstructionState() {

	}

	void drawMenuState(Graphics g) {
		// g.setColor(Color.BLUE);
		// g.fillRect(0,0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.drawImage(spaceImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 200);
		g.setFont(enterFont);
		g.drawString("Press ENTER to start", 93, 400);
		g.drawString("Press I for instructions", 70, 550);
	}

	void drawGameState(Graphics g) {
		// g.setColor(Color.BLACK);
		// g.fillRect(0,0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.drawImage(spaceImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		g.setColor(Color.YELLOW);
		g.setFont(enterFont);
		g.drawString("Score: " + OM.getScore(), 20, 80);
		OM.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 115, 200);
		g.setFont(enterFont);
		g.drawString("You killed " + OM.getScore() + " enemies", 122, 400);
		g.drawString("Press ENTER to restart", 100, 550);
	}

	void drawInstructionState(Graphics g) {
		g.drawImage(spaceImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		g.setColor(Color.YELLOW);
		g.setFont(enterFont);
		g.drawString("WASD for movement,", 20, 30);
		g.drawString("SPACE to shoot", 40, 60);
	}
}
