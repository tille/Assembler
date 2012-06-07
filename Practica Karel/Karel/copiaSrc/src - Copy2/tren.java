import kareltherobot.*;
import java.awt.Color;

class Tren extends Robot {
    
    public String    myName      = null; //A variable in which to remember the name.
    public int       myStreet    = 0;
    public int       myAvenue    = 0;
    public Direction myDirection = null;
    public Color     myColor     = null;
    public boolean   bolVuelta   = false;
    public int       estado      = 0;
	
    public Tren (String name, int street, int avenue, Direction direction, int beepers, Color color) {	
        super(street, avenue, direction, beepers, color);
        myName      = name;
        myStreet    = street;
        myAvenue    = avenue;
        myColor     = color;
        myDirection = direction;
        World.setupThread(this);
    }
	
    public void run() {
        //karel.setPause(true);
	int numBeeperInBeeperBag = 0;
	while(nextToABeeper()) {
            girarIzq();
            pickBeeper();
        }   
    }

    public void avanzar() {
        move();
	if(facingNorth()) myStreet += 1;
	if(facingSouth()) myStreet -= 1;
	if(facingEast()) myAvenue+=1;
        if(facingWest()) myAvenue-=1;  
    }

    public void girarIzq() {       
        turnLeft();
        if(facingNorth()) myDirection = North;
        if(facingSouth()) myDirection = South;
        if(facingEast()) myDirection = East;
        if(facingWest()) myDirection = West;
    }

    public void girarDer() {
	turnLeft();
	turnLeft();
	turnLeft();
	if(facingNorth()) myDirection = North;
	if(facingSouth()) myDirection = South;
	if(facingEast()) myDirection = East;
	if(facingWest()) myDirection = West;
    }
                
    public  String    name()      { return myName; }
    public  int       street()    { return myStreet; }
    public  int       avenue()    { return myAvenue; }
    public  Direction direction() { return myDirection; }
    
}
