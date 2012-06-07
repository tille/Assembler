import kareltherobot.*;
import java.util.*;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

class hiloCarro extends Thread implements Directions {
	
    public Tren carro;
    public recorrido r = new recorrido();
    public Stack<Integer> ruta = new Stack<Integer>();
    public boolean salir= true;
    public int inicio=0;


    hiloCarro(String name, int street, int avenue, Direction direction, int beepers, Color color) {
	carro = new Tren (name,street, avenue, direction, beepers, color);
        carro.estado=0;
    }
	
       public void run() {

           for( int i = 0; i<50; ++i ){
                if( carro.estado == 0 ){
                   calcularRuta(0);
                   seguirRuta();
                   cargar();
                   carro.estado = 1;
                }else if( carro.estado == 1 ){
                   calcularRuta(1);
                   seguirRuta();
                   descargar();
                   carro.estado = 0;
                }
            }


    }

    public void cargar(){
        for (int i=0; i<1;i++) carro.pickBeeper();
    }

    public void descargar(){
        for (int i=0; i<1;i++) carro.putBeeper();
    }

    public void seguirRuta(){
        if (inicio==0){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(hiloCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
        inicio=1;
        }
        while( !ruta.empty() ){
            int c = ruta.pop();
            int f = ruta.pop();
            if( (carro.myStreet*2)-f > 0 ) while( !carro.facingSouth() ) carro.girarIzq();
            else if( (carro.myStreet*2)-f < 0 )  while( !carro.facingNorth() ) carro.girarIzq();
            else if( (carro.myAvenue*2)-c > 0 ) while( !carro.facingWest() ) carro.girarIzq();
            else if( (carro.myAvenue*2)-c < 0 ) while( !carro.facingEast() ) carro.girarIzq();
            carro.avanzar();
            System.out.println( (carro.myStreet*2) + " " + (carro.myAvenue*2) + " " + f + " " + c + " " +carro.myName);
    }
}
    public void calcularRuta(int id){

        int x=0;
        int y=0;
        if(id==0){
            y=16; x=8;
        }
        else{
                if(carro.myName=="Carro1"){y=2; x=4;}
                else{
                    if(carro.myName=="Carro2"){y=2; x=10;}
                    else{
                        if(carro.myName=="Carro3"){y=2; x=14;}
                        else{
                            if(carro.myName=="Carro4"){y=2; x=20;}
                        }
                    }
                }
            }

        r.bfs(carro.myStreet*2,carro.myAvenue*2,y,x,carro.myName);
        ancestors temp = r.paths[y][x];
        ruta.push(y);
        ruta.push(x);
        while( temp.one != carro.myStreet*2 || temp.two != carro.myAvenue*2 ){
            ruta.push(temp.one);
            ruta.push(temp.two);

            temp = r.paths[temp.one][temp.two];

    }

    }
}