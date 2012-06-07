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
        this.tren.estado = 0;
    }
	
    @Override
    public void run() {
        while( salir ){            
            for( int i = 0; i<20; ++i ){
                if( tren.estado == 0 ){
                   calcularRuta(1);
                   seguirRuta();
                   if( i == 8 ) tren.turnOff();
                   cargar();
                   tren.estado = 1;
                }else if( tren.estado == 1 ){
                   calcularRuta(0);
                   seguirRuta();
                   descargar();
                   tren.estado = 0;
                }
            }
            matarHilo();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(hiloTren.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //calcularRuta();
        //seguirRuta();
    }
    
    public void matarHilo(){
        this.salir = false;
    }
        
    public void cargar(){
        for( int i = 0; i < 10; ++i ) tren.pickBeeper();
    }
    
    public void descargar(){
        for( int i = 0; i < 10; ++i ) tren.putBeeper();
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
            
            int cMyStreet = tren.myStreet, cMyAvenue = tren.myAvenue;
            if(tren.facingNorth()) cMyStreet += 1;
            if(tren.facingSouth()) cMyStreet -= 1;
            if(tren.facingEast()) cMyAvenue += 1;
            if(tren.facingWest()) cMyAvenue -= 1;
            
            while( this.c.getCollisions(cMyStreet*2,cMyAvenue*2) == 2 ){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(hiloTren.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            this.c.setCollisions(tren.myStreet*2,tren.myAvenue*2,0);
            tren.avanzar();
            this.c.setCollisions(tren.myStreet*2,tren.myAvenue*2,2);
            
            System.out.println( (tren.myStreet*2) + " " + (tren.myAvenue*2) + " " + f + " " + c + " " +tren.myName);
        }
        //matarHilo();
    }
    
    public void calcularRuta( int id ){
        int f1 = 32, f2 = 16;
        if( id == 1 ){
            f1 = 40;
            if( tren.myName == "Chuchu1" ) f2 = 6; 
            else f2 = 14;
        }
        c.bfs(tren.myStreet*2,tren.myAvenue*2,f1,f2,tren.myName);
        //System.out.println(c.paths[40][6].one + " " + c.paths[40][6].two);
        
        ancestors temp = c.paths[f1][f2];
        ruta.push(f1);
        ruta.push(f2);
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