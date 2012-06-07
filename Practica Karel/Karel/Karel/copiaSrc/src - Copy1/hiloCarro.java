import kareltherobot.*;
import java.awt.Color;

class hiloCarro extends Thread implements Directions {
	
    Tren carro;

    hiloCarro(String name, int street, int avenue, Direction direction, int beepers, Color color) {
	carro = new Tren (name,street, avenue, direction, beepers, color);
    }
	
    public void run() {
	carro.move();
	carro.move();
	carro.move();
    }
}