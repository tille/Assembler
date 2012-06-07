import java.util.logging.Level;
import java.util.logging.Logger;
import kareltherobot.*;
import java.awt.Color;
import java.util.*;
import java.awt.Color;


class hiloAvion extends Thread implements Directions {
	
    public Tren avion;
    public recorrido r = new recorrido();
    public Stack<Integer> ruta = new Stack<Integer>();
    public boolean salir= true;

    hiloAvion(String name, int street, int avenue, Direction direction, int beepers, Color color) {
	avion = new Tren(name,street,avenue,direction,beepers,color);
        avion.estado=0;
    }

    public void run() {
        
        while (salir){
           for( int i = 0; i<50; ++i ){
                if( avion.estado == 0 ){
                   calcularRuta(0);
                  
                   seguirRuta();
                   if( i == 8 ) avion.turnOff();
                   cargar();
                   avion.estado = 1;
                }else if( avion.estado == 1 ){
                   calcularRuta(1);
                   seguirRuta();
                   descargar();
                   avion.estado = 0;
                }
            }
           matarHilo();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(hiloAvion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public void matarHilo(){
        this.salir = false;
    }

    public void cargar(){
        for (int i=0; i<5;i++) avion.pickBeeper();
    }

    public void descargar(){
        for (int i=0; i<5;i++) avion.putBeeper();
    }

    public void seguirRuta(){

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(hiloAvion.class.getName()).log(Level.SEVERE, null, ex);
        }
        while( !ruta.empty() ){
            int c = ruta.pop();
            int f = ruta.pop();
            if( (avion.myStreet*2)-f > 0 ) while( !avion.facingSouth() ) avion.girarIzq();
            else if( (avion.myStreet*2)-f < 0 )  while( !avion.facingNorth() ) avion.girarIzq();
            else if( (avion.myAvenue*2)-c > 0 ) while( !avion.facingWest() ) avion.girarIzq();
            else if( (avion.myAvenue*2)-c < 0 ) while( !avion.facingEast() ) avion.girarIzq();
            avion.avanzar();
            System.out.println( (avion.myStreet*2) + " " + (avion.myAvenue*2) + " " + f + " " + c + " " +avion.myName);
    }
}
    public void calcularRuta(int id){
        int x=0;
        int y=0;
        if(id==0){
            y=32; x=16;
        }
        else{
            y=16; x=8;
        }

        r.bfs(avion.myStreet*2,avion.myAvenue*2,y,x,avion.myName);
        ancestors temp = r.paths[y][x];
        ruta.push(y);
        ruta.push(x);
        while( temp.one != avion.myStreet*2 || temp.two != avion.myAvenue*2 ){
            ruta.push(temp.one);
            ruta.push(temp.two);

            temp = r.paths[temp.one][temp.two];

    }

    }
}
