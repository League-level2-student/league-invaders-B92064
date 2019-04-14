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
public ObjectManager(RocketShip R) {
	this.R = R;
}
void update() {
	R.update();
	for(int i = 0; i < list.size(); i++) {
		list.get(i).update();
	}
	for(int i = 0; i < alist.size(); i++) {
		alist.get(i).update();
	}
}
void draw(Graphics h) {
	R.draw(h);
	for(int i = 0; i < list.size(); i++) {
		list.get(i).draw(h);
	}
	for(int i = 0; i < alist.size(); i++) {
		alist.get(i).draw(h);
	}
}
void addProjectile(Projectile e) {
	list.add(e);
}
void addAlien(Alien a) {
	alist.add(a);
}
public void manageEnemies(){
	if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
enemyTimer = System.currentTimeMillis();
    }
}
void purgeObjects() {
	for(int i = 0; i < list.size(); i++) {
		if(list.get(i).isAlive != true) {
			list.remove(i);
		}
	}
	for(int i = 0; i < alist.size(); i++) {
		if(alist.get(i).isAlive != true) {
			alist.remove(i);
		}
	}
}
}
