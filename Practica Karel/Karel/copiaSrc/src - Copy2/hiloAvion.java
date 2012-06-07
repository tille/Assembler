import kareltherobot.*;
import java.awt.Color;

class hiloAvion extends Thread implements Directions {
	
    Tren avion;

    hiloAvion(String name, int street, int avenue, Direction direction, int beepers, Color color) {
	avion = new Tren(name,street,avenue,direction,beepers,color);
    }

    public void run() {   
        
        avion.move();
	avion.move();
	avion.move();
    }
}