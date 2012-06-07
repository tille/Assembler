      CLA
      MOV CDA,AX ; carga 0 para poder utilizarlo para determinar la opción que se escoja en el menu
      INC AX
      MOV CDB,AX ; carga 1
      INC AX
      MOV CDC,AX ; carga 2
      INC AX
      MOV CDD,AX ; carga 3
      INC AX
      MOV CDE,AX ; carga 4
      INC AX
      MOV CDF,AX ; carga 5

      MSG "0 - PARA INGRESAR MATRIZ A"
      MSG "1 - PARA INGRESAR MATRIZ B"
      MSG "2 - PARA MULTIPLICAR MATRICES"
      MSG "3 - PARA TRANSPONER MATRIZ A"
      MSG "4 - PARA TRANSPONER MATRIZ B"
      MSG "5 o más - PARA SALIR"
      LDT


      CMP CDA
      JEQ 020 ; Ingresar datos de A
      CMP CDB
      JEQ 03B; Ingresar datos de B
      CMP CDC
      JEQ 052 ; multiplicar
      CMP CDD
      JEQ 0B1 ; transponser A
      CMP CDE
      JEQ 095 ; transponer B
      CMP CDE
      JMA 0CD;  Salir
      




      CLA AX ; setear Ax
      MOV FDA,AX
      INC AX
      MOV FDB,AX  ;Para recorrer las filas de A
      INC AX
      MOV FDC,AX

      MOV BX,FDA ; BX = 0


      LDT "ENTRE FILAS DE LA MATRIZ A"
      MOV DD0,AX
      LDT "ENTRE COLUMNAS DE LA MATRIZ A"
      MOV DD1,AX

      MOV AX,DD0
      CMP CDA
      JEQ 039
      MOV AX,DD1
      CMP CDA
      JEQ 039


      MOV AX,DD0  ; calcular cuantos datos tendrá la matriz para realizar la multiplicación
      MUL DD1
      MOV CX,AX
      MOV BX,28D

          LDT "ENTRE UN ELEMENTO A LA MATRIZ A " ; retorno de ciclo
          STB E00
          INC BX
          LOOP 034; CICLO PARA LLENAR LA MATRIZ A
      JMP 00C ; regresa al menu principal

      MSG "Matriz vacia"
      JMP 00C ; regresa al menu principal


      MOV BX,FDA ; BX = 0
      LDT "ENTRE FILAS DE LA MATRIZ B"
      MOV DD2,AX

      LDT "ENTRE COLUMNAS DE LA MATRIZ B"
      MOV DD3,AX

      MOV AX,DD2
      CMP CDA
      JEQ 050
      MOV AX,DD3
      CMP CDA
      JEQ 050

      MOV AX,DD2
      MUL DD3
      MOV CX,AX

      CLA
      MOV BX,AX

          LDT "ENTRE UN ELEMENTO A LA MATRIZ B "   ; retorno de ciclo
          STB F00
          INC BX
          LOOP 04B; CICLO PARA LLENAR LA MATRIZ B
      JMP 00C ; regresa al menu principal
      MSG "Matriz B vacia"
      JMP 00C


; multiplicación de matrices

      MOV AX,DD0 ; comprobar que existan elementos en la matriz A
      CMP CDA
      JEQ 08F
      MOV AX,DD1
      CMP CDA
      JEQ 08F
      
      MOV AX,DD2 ; comprobar que existan elementos en la matriz B
      CMP CDA
      JEQ  091
      MOV AX,DD3
      CMP CDA
      JEQ  091
      
      MOV AX,DD1 ; comprobar n*m m*k
      CMP DD2
      JNE 093
      
      CLA
      MOV BX,28D
      MOV FD9,28D; variable ctr=0 para recorrer matriz A a través de las filas
      MOV FD8,28d; variable var=0 para poder recorrer las posiciones de memoria que correspondan a la fila necesaria  de A
          MOV AX,FD9  ; retorno ciclo 1
          MSG "FILA"
          MUL DD1
          MOV FD8,AX   ; var= m*ctr
          MOV FDA,28D ; variable cont=0 para moverme a través de las columnas de B
            MOV FDB,28D ; variable con=0 para moverme a través de las filas de B         retorno ciclo 2
            MOV FDC,FDA ;variable indice=cont para poder recorrer las posiciones de memoria que corresponden a la columna necesaria de B
              MOV BX,FDC  ; bx=indice    retorno ciclo 3
              cla
              INC AX
              mov 28F,AX
              MUL FDC

              LDB F00      ; leer [F00]+bx
              ;MSG "VALOR DE B"
              ;EAP
              MOV FF0,AX

              MOV AX,FD8
              ADD FDB
              MOV BX,AX  ; BX= var+con
              LDB E00      ; leer [E00]+bx
              ;MSG "VALOR DE A"
              ;EAP
              MUL FF0
              ;MSG "PRIMERA"
              ;EAP
              ;MSG "SEGUNDA"
              ADD FF1
              MOV FF1,AX
              MOV AX,FF1
             ;EAP

              MOV AX,FDC
              ADD DD3
              MOV FDC,AX     ; indice= indice+k
              INC FDB        ; con++
              MOV AX,FDB
              CMP DD2
              JME 06C   ; fin ciclo 3
              
            MOV AX,FF1
            EAP
            CLA
            MOV FF1,AX
            INC FDA         ; cont++
            MOV AX,FDA
            CMP DD3
            JME 06A  ; fin ciclo 2
          INC FD9
          MOV AX,FD9
          CMP DD0
          JME  065  ; fin ciclo1
      JMP 00C ; regresa al menu principal

      MSG "Imposible multiplicar, matriz A vacia"
      JMP 00C
      
      MSG "Imposible multiplicar, matriz B vacía"
      JMP 00C
      
      MSG "Imposible multiplicar, no cumple con la condición n*m y m*k"
      JMP 00C

      ; comienza la transposición de matrices de B


      MOV AX,DD2
      CMP CDA
      JEQ 0AF
      MOV AX,DD3
      CMP CDA
      JEQ 0AF
      
      MOV CX,DD3 ; CICLO CX HASTA #COLUMNAS DE B '{'
          MOV 29A,CX ; retorno de ciclo 1
          MSG "FILA"
          MOV AX,DD3
          SUB 29A
          MOV 2D0,AX
          MOV CX,DD2 ; CICLO 2 '{'
              MOV BX,2D0 ; retorno de ciclo 2
              LDB F00
              MOV BX,2C0
              STB 320
              EAP
              INC 2C0
              MOV AX,DD3
              ADD 2D0
              MOV 2D0,AX
              LOOP 0A2; CIERRA CICLO 2 '}'
          MOV CX,29A
          LOOP 09C; CIERRA CICLO 1 '}'
      JMP 00C
      MSG "Imposible transponer, matriz B vacía"
      JMP 00C
      
        ; comienza la transposición de matrices de A

      MOV AX,DD0
      CMP CDA
      JEQ 0CB
      MOV AX,DD1
      CMP CDA
      JEQ 0CB
      
      MOV CX,DD1 ; CICLO CX HASTA #COLUMNAS DE A'{'
          MOV 29A,CX ; retorno de ciclo 1
          MSG "FILA"
          MOV AX,DD1
          SUB 29A
          MOV 2D0,AX
          MOV CX,DD0 ; CICLO 2 '{'
              MOV BX,2D0 ; retorno de ciclo 2
              LDB E00
              MOV BX,2C0
              STB 420
              EAP
              INC 2C0
              MOV AX,DD1
              ADD 2D0
              MOV 2D0,AX
              LOOP 0BE; CIERRA CICLO 2 '}'
          MOV CX,29A
          LOOP 0B8; CIERRA CICLO 1 '}'
      JMP 00C
      
      MSG "Imposible transponer, matriz A vacía"
      JMP 00C
       HLT        ;Termina el Programa

 ;A continuacion inicializare estas variables a partir de la Pos 28D
#28D
0;



