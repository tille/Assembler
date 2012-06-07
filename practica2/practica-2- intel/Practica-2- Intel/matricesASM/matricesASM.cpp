
// matricesASM.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"
#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <fstream>
#include <conio.h>
#include <stdio.h>
#define limpiar() system("cls;");

using namespace std;

typedef long long ll;

template <class T> string toStr(const T &x)
{ stringstream s; s << x; return s.str(); }

template <class T> int toInt(const T &x)
{ stringstream s; s << x; int r; s >> r; return r; }

int op, filas = 0, columnas = 0, filas2 = 0,columnas2 = 0, tam = 100, enable = 0;
int A[100][100],B[100][100],TA[100][100],M[100][100];

void fill(){

	enable = 0;
    printf("ingrese filas de A: ");
    scanf("%d",&filas);
    printf("ingrese columnas de A: ");
    scanf("%d",&columnas);

    for( int i = 0; i < filas; ++i ){
        for( int j = 0; j < columnas; ++j ){
            printf("A[%d][%d]: ",i,j);
            scanf("%d", &A[i][j]);
        }
    }

    printf("\ningrese filas de B: ");
    scanf("%d",&filas2);
    printf("ingrese columnas de B: ");
    scanf("%d",&columnas2);

    for( int i = 0; i < filas2; ++i ){
        for( int j = 0; j <columnas2; ++j ){
            printf("B[%d][%d]: ",i,j);
            scanf("%d", &B[i][j]);
        }
    }

	if( filas != 0 && columnas != 0 && filas2 != 0 && columnas2 != 0 ) enable = 1;
    printf("\npresione una tecla para continuar...\n");
    getch();
    limpiar();
}


void transpose( int option, int id ){

	int indF = 0, indC = 0, result, result2;
	int tempRows = (!option)?filas:filas2;
	int tempCols = (!option)?columnas:columnas2;
	//int pos = (option==0)?int(&A[0]):int(&B[0]);

	_asm{

		MOV ECX,tempRows
ciclo1:	MOV EBX,ECX

		MOV ECX,tempCols
		MOV indC,0
ciclo2: MOV EDI,ECX

		MOV EAX,4
		MUL indC
		MOV result,EAX
		MOV EAX,4
		MUL tam
		MUL indF
		ADD EAX,result
		
		CMP option,0
		JNE tales
		LEA EDX,A
		JMP sig

tales:  LEA EDX,B

sig:	MOV EAX,[EDX+EAX]
		MOV result,EAX

		MOV EAX,4
		MUL indF
		MOV result2,EAX
		MOV EAX,4
		MUL tam
		MUL indC
		ADD EAX,result2
		LEA EDX,TA
		MOV ESI,result
		MOV [EDX+EAX],ESI

		MOV ECX,EDI
		INC indC
		LOOP ciclo2

		MOV ECX,EBX
		INC indF
		LOOP ciclo1
	
	}

	if( id ){
		cout << "La Matriz Traspuesta a quedado guardada exitosamente en TA: \n\n";
	
		if(option) swap(tempRows,tempCols);

		for( int i = 0; i<tempRows; i++ ){
			for( int j = 0; j<tempCols; j++ ){
				printf("%d ",TA[i][j]);
			}
			printf("\n");
		}

		printf("\n");
		printf("presione una tecla para continuar...\n");
		getch();
	}
    limpiar();
}

void multiply(){
	
	int indC,indF,indF2;
	int C1,C2,C3,result,result2,result3;

	for( int i = 0; i<100; ++i ) 
		for( int j = 0; j < 100; ++j )
			M[i][j] = 0;

	transpose(1,0);
	_asm{
		MOV ECX,filas
		MOV indF,0
cicloA: MOV C1,ECX
		
		MOV indF2,0
		MOV ECX,columnas2
cicloB: MOV C2,ECX

		MOV indC,0
		MOV ECX,columnas

cicloC:	MOV EAX,4

		JMP salto

marca:  INC indC
		LOOP cicloC

		MOV ECX,C2
		INC indF2
		LOOP cicloB

		MOV ECX,C1
		INC indF
		LOOP cicloA
		JMP fin

salto: 	MUL indC
		MOV result,EAX
		MOV EAX,4
		MUL tam
		MUL indF
		ADD EAX,result
		LEA EBX,A
		MOV EAX,[EBX+EAX]
		MOV result,EAX

		MOV EAX,4
		MUL indC
		MOV result2,EAX
		MOV EAX,4
		MUL tam
		MUL indF2
		ADD EAX,result2
		LEA EBX,TA
		MOV EAX,[EBX+EAX]
		MOV result2,EAX

		MOV EAX,4
		MUL indF2
		MOV result3,EAX
		MOV EAX,4
		MUL tam
		MUL indF
		ADD EAX,result3
		LEA EBX,M
		MOV ESI,EAX
		
		MOV EAX,result
		MUL result2
		ADD [EBX+ESI],EAX
		JMP marca

fin:	MOV EAX,0
	}

	printf("Las Matrices han sido multiplicadas exitosamente: \n\n");

	for( int i = 0; i<filas; ++i ){
		for( int j = 0; j<columnas2; ++j ){
			printf("%d ",M[i][j]);
		}
		printf("\n");
	}

    printf("\npresione una tecla para continuar...\n");
    getch();
    limpiar();
}

int choose(){
	int tmp = 0;
	printf("Entre 0 para trasponer la matriz A \n");
	printf("Cualquier otro valor para transponer la matriz B \n\nSeleccion: ");
	scanf("%d",&tmp);
	limpiar();
	return tmp;
}

void error( int option ){

	int salir = false;
	if( option > 3 ) printf("Por favor ingrese un numero dentro de la seleccion\n");
	else if( option == 2 ){
		
		if( columnas==0 || filas==0 || columnas2==0 || filas2==0 )
			printf("No se han ingresado matrices y/o las existentes no se pueden multiplicar\n");
		else{
			if( columnas != filas2 ) printf("Las columnas de la matriz A son diferentes a las filas de la matriz B\n");
			else printf("No se han ingresado matrices\n");
		}
	
	}else if( option == 3 ){
		int temp = choose();
		if( temp && (filas2==0 || columnas2==0)) printf("No se puede transponer la matriz B\n");
		else if( !temp && (columnas==0 || filas==0)) printf("No se puede transponer la matriz A\n");
		else{ 
			salir = true;
			transpose(temp,1);
		}
	}

    if(!salir){ 
		printf("presione una tecla para continuar...\n");
		getch();
	}
    limpiar();
}

int _tmain(int argc, _TCHAR* argv[]){
    printf("0 - Salir\n1 - Ingresar Matrices\n2 - Multiplicar\n3 - Transponer\n\nSeleccion: ");
    while( scanf("%d",&op) && op != 0 ){
        limpiar();
        ( op == 1 )?fill():( op  == 2 && enable && columnas == filas2 )?multiply():( op == 3 && enable )?transpose(choose(),1):error(op);
        printf("0 - Salir\n1 - Ingresar Matrices\n2 - Multiplicar\n3 - Transponer\n\nSeleccion: ");
    }
	system("pause");
    return 0;
}
