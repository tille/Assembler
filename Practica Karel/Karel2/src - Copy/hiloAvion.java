import java.util.logging.Level;
import java.util.logging.Logger;
import kareltherobot.*;
import java.awt.Color;
import java.util.*;
import java.awt.Color;


class hiloAvion extends Thread implements Directions {
	
    public Tren tren;
    public recorrido c = new recorrido();
    public Stack<Integer> ruta = new Stack<Integer>();
    public boolean salir= true;
    int ind=0;
    int cont=0;

    hiloAvion(String name, int street, int avenue, Direction direction, int beepers, Color color) {
	tren = new Tren(name,street,avenue,direction,beepers,color);
        tren.estado=0;
    }
   @Override
    public void run() {
        while( salir ){
            for( int i = 0; i<90; ++i ){
                if( tren.estado == 0 ){
                   calcularRuta(1);
                   seguirRuta(1);
                   //if( i == 8 ) tren.turnOff();
                  cargar();
                   tren.estado = 1;
                }else if( tren.estado == 1 ){
                   calcularRuta(0);
                   seguirRuta(0);
                   descargar();
                   tren.estado = 0;
                }
            }
            matarHilo();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(hiloAvion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //calcularRuta();
        //seguirRuta();
    }

    public void matarHilo(){
        this.salir = false;
    }

    public void cargar(){

                try {
               Thread.sleep(4000);
            } catch (InterruptedException ex) {
               Logger.getLogger(hiloAvion.class.getName()).log(Level.SEVERE, null, ex);
            }
        cont=0;
        while(tren.nextToABeeper() && cont<20){
            tren.pickBeeper();
            cont++;
        }
    }

    public void descargar(){
        try {
               Thread.sleep(4000);
            } catch (InterruptedException ex) {
               Logger.getLogger(hiloAvion.class.getName()).log(Level.SEVERE, null, ex);
            }
        while(tren.anyBeepersInBeeperBag()) tren.putBeeper();
    }


    public synchronized void seguirRuta( int id ){
        //ruta.pop();
        //ruta.pop();
        if( tren.myName=="Avion1" && ind==0){
        try {
           Thread.sleep(8500);
        } catch (InterruptedException ex) {
           Logger.getLogger(hiloAvion.class.getName()).log(Level.SEVERE, null, ex);
        }
        ind++;
        }

        while( !ruta.empty() ){
            int c = ruta.pop();
            int f = ruta.pop();
            determinarAvance(c,f);
        }
        vaciarPila();
    }

    public void determinarAvance(int c, int f){
        if( (tren.myStreet*2)-f > 0 ) while( !tren.facingSouth() ) tren.girarIzq();
        else if( (tren.myStreet*2)-f < 0 )  while( !tren.facingNorth() ) tren.girarIzq();
        else if( (tren.myAvenue*2)-c > 0 ) while( !tren.facingWest() ) tren.girarIzq();
        else if( (tren.myAvenue*2)-c < 0 ) while( !tren.facingEast() ) tren.girarIzq();

        int temp3 = 0;
        if( tren.facingSouth() ) temp3 = 0;
        else if ( tren.facingNorth() ) temp3 = 1;
        else if ( tren.facingWest() ) temp3 = 2;
        else if ( tren.facingEast() ) temp3 = 3;
        //evaluarColision(c,f,temp3);

        int temp1 = tren.myStreet*2, temp2 = tren.myAvenue*2;
        tren.avanzar();
        this.c.setCollisions(temp1,temp2,0);
        this.c.setCollisions(tren.myStreet*2,tren.myAvenue*2,0);
    }

    public void cosa(int c, int f){
        if( (tren.myStreet*2)-f > 0 ) while( !tren.facingSouth() ) tren.girarIzq();
        else if( (tren.myStreet*2)-f < 0 )  while( !tren.facingNorth() ) tren.girarIzq();
        else if( (tren.myAvenue*2)-c > 0 ) while( !tren.facingWest() ) tren.girarIzq();
        else if( (tren.myAvenue*2)-c < 0 ) while( !tren.facingEast() ) tren.girarIzq();

        int temp1 = tren.myStreet*2, temp2 = tren.myAvenue*2;
        tren.avanzar();
        this.c.setCollisions(temp1,temp2,0);
        this.c.setCollisions(tren.myStreet*2,tren.myAvenue*2,2);
    }

    public void evaluarColision(int c, int f, int temp3){
        int cMyStreet = tren.myStreet, cMyAvenue = tren.myAvenue;
        if(tren.facingNorth()) cMyStreet += 1;
        if(tren.facingSouth()) cMyStreet -= 1;
        if(tren.facingEast()) cMyAvenue += 1;
        if(tren.facingWest()) cMyAvenue -= 1;

        int cont = 0;


        //System.out.println(c + " " + f);
        while( this.c.getCollisions(f,c) == 2 ){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(hiloAvion.class.getName()).log(Level.SEVERE, null, ex);
            }
            cont++;

            if( cont > 2 ){
                cont = 0;
                int m[] = {0,0,0,0,0,0,0,0};

                m[0] = this.c.paths[tren.myStreet*2][tren.myAvenue*2].one;
                m[1] = this.c.paths[tren.myStreet*2][tren.myAvenue*2].two;
                if( m[0] != 0 && m[1] != 0 && this.c.getCollisions(m[0],m[1]) == 0 ){
                   //System.out.println(m[0] + " " + m[1] + tren.myName );
                   //System.out.println( this.c.paths[32][16].one + " " + this.c.paths[32][16].two );
                   //cosa(m[1],m[0]);
                   //cosa(tren.myStreet,tren.myAvenue);
                    m[2] = this.c.paths[m[0]][m[1]].one;
                    m[3] = this.c.paths[m[0]][m[1]].two;

                    //System.out.println(m[0] + " " + m[1]);
                    //cosa(m[3],m[2]);

                    m[4] = this.c.paths[m[2]][m[3]].one;
                    m[5] = this.c.paths[m[2]][m[3]].two;

                    //cosa(m[5],m[4]);


                    if( m[2] != 0 && m[3] != 0 && this.c.getCollisions(m[2],m[3]) == 0 ){
                        m[4] = this.c.paths[m[2]][m[3]].one;
                        m[5] = this.c.paths[m[2]][m[3]].two;
                        if( m[4] != 0 && m[5] != 0 && this.c.getCollisions(m[4],m[5]) == 0 ){
                            System.out.println(this.c.getCollisions(m[0],m[1]));
                            System.out.println(m[0] + " " + m[1]);
                            cosa(m[1],m[0]);
                            cosa(m[3],m[2]);
                            cosa(m[5],m[4]);
                            tren.girarIzq();
                            tren.avanzar();
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(hiloAvion.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            cosa(m[5],m[4]);
                            cosa(m[3],m[2]);
                            cosa(m[1],m[0]);

                            if( temp3 ==  0 ) while( !tren.facingSouth() ) tren.girarIzq();
                            else if( temp3 == 1 )  while( !tren.facingNorth() ) tren.girarIzq();
                            else if( temp3 == 2 ) while( !tren.facingWest() ) tren.girarIzq();
                            else if( temp3 == 3 ) while( !tren.facingEast() ) tren.girarIzq();
                            tren.avanzar();
                        }
                    }
                }
            }

        }
    }

    public void vaciarPila(){
        while( !ruta.empty() ){
            ruta.pop();
        }
    }

    public synchronized  void calcularRuta( int id ){
        int f2=0;
        int f1=0;
        if(id==0){
           f1=16; f2=8;
        }
        else{
            f1=32; f2=16;
        }
        c.bfs(tren.myStreet*2,tren.myAvenue*2,f1,f2,tren.myName);

        ancestors temp = c.paths[f1][f2];

        int error = 0;
        while( true ){
            if( temp.one == tren.myStreet*2 && temp.two == tren.myAvenue*2 ) break;
            if( temp.one == -1  || temp.two == -1 ){ error = 1; break; }
            temp = c.paths[temp.one][temp.two];
        }

        while( error == 1 ){
            c.bfs(tren.myStreet*2,tren.myAvenue*2,f1,f2,tren.myName);
            temp = c.paths[f1][f2];
            error = 0;
            while( true ){
                if( temp.one == tren.myStreet*2 && temp.two == tren.myAvenue*2 ) break;
                if( temp.one == -1  || temp.two == -1 ){ error = 1; break; }
                temp = c.paths[temp.one][temp.two];
            }
        }

        temp = c.paths[f1][f2];
        ruta.push(f1);
        ruta.push(f2);
        while( true ){
            if( temp.one == tren.myStreet*2 && temp.two == tren.myAvenue*2 ) break;
            if( temp.one == -1  || temp.two == -1 ){
                System.out.println("a que mierda");
                break;
            }
            //System.out.println(temp.one+" "+temp.two+" "+tren.myName);
            ruta.push(temp.one);
            ruta.push(temp.two);
            //System.out.println(c.paths[temp.one][temp.two].one + " " + c.paths[temp.one][temp.two].two + tren.myName);
            try{
                temp = c.paths[temp.one][temp.two];
            }catch( Exception ex ) {
                System.out.println(temp.one + " " + temp.two);
            }
        }

        /*while( !ruta.empty() ){
            System.out.println(ruta.pop() + tren.myName);
        }*/

    }
}
