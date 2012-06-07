import java.util.logging.Level;
import java.util.logging.Logger;
import kareltherobot.*;
import java.awt.Color;
import java.util.*;

class hiloTren extends Thread implements Directions {
	
    public Tren tren;
    public recorrido c = new recorrido();
    public Stack<Integer> ruta = new Stack<Integer>();    
    public boolean salir = true;
    
    public hiloTren(String name, int street, int avenue, Direction direction, int beepers, Color color) {
        this.tren = new Tren(name,street,avenue,direction,beepers,color);
    }
	
    @Override
    public void run() {
        /*while( salir ){
            calcularRuta();
            //seguirRuta();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(hiloTren.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        calcularRuta();
        seguirRuta();
    }
    
    public void matarHilo(){
        this.salir = false;
    }
    
    public void seguirRuta(){
        //ruta.pop();
        //ruta.pop();
        while( !ruta.empty() ){
            int c = ruta.pop();
            int f = ruta.pop();
            if( (tren.myStreet*2)-f > 0 ) while( !tren.facingSouth() ) tren.girarIzq(); 
            else if( (tren.myStreet*2)-f < 0 )  while( !tren.facingNorth() ) tren.girarIzq();
            else if( (tren.myAvenue*2)-c > 0 ) while( !tren.facingWest() ) tren.girarIzq(); 
            else if( (tren.myAvenue*2)-c < 0 ) while( !tren.facingEast() ) tren.girarIzq(); 
            tren.avanzar();
            System.out.println( (tren.myStreet*2) + " " + (tren.myAvenue*2) + " " + f + " " + c + " " +tren.myName);
        }
        //matarHilo();
    }
    
    public void calcularRuta(){
        //System.out.println("paso por aki");
        c.bfs(tren.myStreet*2,tren.myAvenue*2,40,6,tren.myName);
        //System.out.println(c.paths[40][6].one + " " + c.paths[40][6].two);
        
        ancestors temp = c.paths[40][6];
        ruta.push(40);
        ruta.push(6);
        //System.out.println("paso por aki"); 
        //System.out.println(tren.myStreet*2 +" "+tren.myAvenue*2+" "+tren.myName);
        while( temp.one != tren.myStreet*2 || temp.two != tren.myAvenue*2 ){
            //System.out.println(temp.one+" "+temp.two+" "+tren.myName);
            ruta.push(temp.one);
            ruta.push(temp.two);
            //System.out.println(c.paths[temp.one][temp.two].one + " " + c.paths[temp.one][temp.two].two + tren.myName);
            temp = c.paths[temp.one][temp.two];
        }
         
        /*while( !ruta.empty() ){
            System.out.println(ruta.pop() + tren.myName);
        }*/
       
    }
} 