import java.awt.Graphics;

public class GameObject {
	 int x;
     int y;
     int width;
     int height;
    public GameObject(int x, int y, int width, int height){
    	 this.x = x;
    	 this.y = y;
    	 this.width = width;
    	 this.height = height;
     }
     void update() {
    	 x = 200; 
    	 y = 100;
    	 width = 100;
    	 height = 100;
     }
     void draw(Graphics g) {
    	 g.fillRect(x, y, width, height);
     }
}
