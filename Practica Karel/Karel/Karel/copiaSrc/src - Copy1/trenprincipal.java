import kareltherobot.*;
import java.awt.Color;
import java.util.*;

class TrenPrincipal implements Directions {
    
    static int intMax = 80+5;
    static int sirenas[] = {0,0,0,0,0,0,0,0};
    
    public static void main(String args[]) {
        
        World.readWorld("../res/models/mundopractica.kwld");
        World.setDelay(10);
        World.setVisible(true);
        World.showSpeedControl(false);
        
        hiloTren tren1 = new hiloTren("Chuchu1",16,1,East,0,Color.red);
	hiloTren tren2 = new hiloTren("Chuchu2",20,6,East,0,Color.red);		

	hiloCarro carro1 = new hiloCarro("Carro1",1,1,North,0,Color.red);
	hiloCarro carro2 = new hiloCarro("Carro2",1,4,North,0,Color.red);
	hiloCarro carro3 = new hiloCarro("Carro3",1,6,North,0,Color.red);
	hiloCarro carro4 = new hiloCarro("Carro3",1,8,North,0,Color.red);

	hiloAvion avion1 = new hiloAvion("Avion1",15,9,West,0,Color.blue);
	hiloAvion avion2 = new hiloAvion("Avion2",15,10,West,0,Color.blue);

	tren1.start();  tren2.start();  carro1.start();
	carro2.start(); carro3.start(); carro4.start();
	avion1.start(); avion2.start();
       
        //bfs( 40,6,32,16 );
        //RobotWork1.turnOff();
    }
    
}