import java.util.*;

class recorrido {
    
    public ancestors paths[][] = new ancestors[50][30];
    static int collisions[][] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                                 {1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    
    public recorrido(){   
    }
    
    void bfs( int a, int b, int c, int d, String name ){
        
        ancestors nulo = new ancestors(-1,-1,0,0);
        for( int i = 0; i < 50-4; ++i ) for( int j = 0; j <30-4; ++j ) paths[i][j] = nulo;
        
        Queue<ancestors> q = new LinkedList<ancestors>();
        q.offer(new ancestors(a,b,0,0));
        
        while( !q.isEmpty() ){
            ancestors temp  = q.poll();
            int filas       = temp.one, 
                columnas    = temp.two, 
                antFilas    = temp.three, 
                antColumnas = temp.four;
           
            paths[filas][columnas] = new ancestors(antFilas,antColumnas,0,0);
            if( filas == c && columnas == d ) break;
            
            if( collisions[filas-1][columnas] == 0 && collisions[filas-2][columnas] == 0 && paths[filas-2][columnas].one == -1 && paths[filas-2][columnas].two == -1 ) 
                {q.offer(new ancestors(filas-2,columnas,filas,columnas));
                 //System.out.println(filas-2+ " " + columnas + " " +  " " + filas + " " + columnas + " primero" );
                }
            
            if( collisions[filas][columnas-1] == 0 && collisions[filas][columnas-2] == 0 && paths[filas][columnas-2].one == -1 && paths[filas][columnas-2].two == -1 )
                {q.offer(new ancestors(filas,columnas-2,filas,columnas));
                    //System.out.println(columnas-2+ " " + filas + " " +  " " + filas + " " + columnas+ " segundo" );
                }
                
            if( collisions[filas+1][columnas] == 0 && collisions[filas+2][columnas] == 0 && paths[filas+2][columnas].one == -1 && paths[filas+2][columnas].two == -1 )
                {q.offer(new ancestors(filas+2,columnas,filas,columnas));
                    //System.out.println(filas+2+ " " + columnas + " " +  " " + filas + " " + columnas+" tercero" );
                }
            
            if( collisions[filas][columnas+1] == 0 && collisions[filas][columnas+2] == 0 && paths[filas][columnas+2].one == -1 && paths[filas][columnas+2].two == -1 )
               {q.offer(new ancestors(filas,columnas+2,filas,columnas));
             //System.out.println(columnas+2+ " " + filas + " " +  " " + filas + " " + columnas + "cuarto" ); 
               }
        }
        
        /*ancestors temp = paths[32][16];
        while( temp.one != -1 && temp.two != -1 ){
            //results.add(temp.one);
            //results.add(temp.two);
            temp = paths[temp.one][temp.two];
        }
        
        //return results;*/
    }
    
    public void setCollisions(int n1, int n2, int n3){
        collisions[n1][n2] = n3;
    }
    
    public int getCollisions(int n1, int n2){
        return collisions[n1][n2];
    }
}