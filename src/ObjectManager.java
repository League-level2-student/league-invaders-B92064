import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class ObjectManager {
	RocketShip R;
	ArrayList<Projectile> list = new ArrayList<Projectile>();
	ArrayList<Alien> alist = new ArrayList<Alien>();
	long enemyTimer = 0;
	long enemySpawnTime = 500;
	int score = 0;
	public ObjectManager(RocketShip R) {
		this.R = R;
	}
	int getScore() {
		return score;
	}
	void setScore(int s) {
		score = s;
	}
	void update() {
		R.update();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).update();
		}
		for (int i = 0; i < alist.size(); i++) {
			alist.get(i).update();
		}
		for (int i = 0; i < alist.size(); i++) {
			if (alist.get(i).x > 450) {
				alist.get(i).right = false;
			}
		}
		for (int i = 0; i < alist.size(); i++) {
			if (alist.get(i).x < 0) {
				alist.get(i).right = true;
			}
		}
	}

	void draw(Graphics h) {
		if(R.isAlive == true) {
		R.draw(h);
		}
		for (int i = 0; i < list.size(); i++) {
			list.get(i).draw(h);
		}
		for (int i = 0; i < alist.size(); i++) {
			if(alist.get(i).isAlive == true) {
			alist.get(i).draw(h);
			}
		}
	}

	void addProjectile(Projectile e) {
		list.add(e);
	}

	void addAlien(Alien a) {
		alist.add(a);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isAlive == false) {
				list.remove(i);
				System.out.println("Dead");
			}
		}
		for (int i = 0; i < alist.size(); i++) {
			if (alist.get(i).isAlive == false) {
				alist.remove(i);
			}
		}
		
	}

	void checkCollision() {

		for (int i = 0; i < alist.size(); i++) {
			// System.out.println("checkCollision"+ R.collisionBox.getBounds().toString());
			if (R.collisionBox.intersects(alist.get(i).collisionBox)) {
				System.out.println("Alien Collison with Rocket");
				R.isAlive = false;
				
			}
		}
		for (int i = 0; i < list.size(); i++) {
			for(int k = 0; k < alist.size(); k++) {
			if (alist.get(k).collisionBox.intersects(list.get(i).collisionBox)) {
				alist.get(k).isAlive = false; 
				list.get(i).isAlive = false;
				score++;
			}
			}
		}
	}
}
