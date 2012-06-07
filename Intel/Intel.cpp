using namespace std;
#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <fstream>
#include <conio.h>
#define limpiar() system("cls");

typedef long long ll;

template <class T> string toStr(const T &x)
{ stringstream s; s << x; return s.str(); }

template <class T> int toInt(const T &x)
{ stringstream s; s << x; int r; s >> r; return r; }

int op;
int A[100][100], B[100][100], f1, c1, f2, c2, TA[100][100], TB[100][100];

void fill(){

    printf("ingrese filas de A: ");
    scanf("%d",&f1);
    printf("ingrese columnas de A: ");
    scanf("%d",&c1);

    for( int i = 0; i < f1; ++i ){
        for( int j = 0; j < c1; ++j ){
            printf("A[%d][%d]: ",i,j);
            scanf("%d", &A[i][j]);
        }
    }

    printf("\ningrese filas de B: ");
    scanf("%d",&f2);
    printf("ingrese columnas de B: ");
    scanf("%d",&c2);

    for( int i = 0; i < f2; ++i ){
        for( int j = 0; j <c2; ++j ){
            printf("B[%d][%d]: ",i,j);
            scanf("%d", &B[i][j]);
        }
    }

    cout << "\npresione una tecla para continuar..." << endl;
    getch();
    limpiar();
}

void multiply(){
    cout << "estamos multiplicando" << endl;
    cout << "presione una tecla para continuar..." << endl;
    getch();
    limpiar();
}

void transpose(){
    int CI = 0, CJ = 0,  I = 0, J = 0;
    _asm_{
        MOV ECX,C1
ciclo1: MOV I,ECX

        MOV EAX,C1
        SUB I
        MOV CI,EAX

        MOV ECX,f1
ciclo2: MOV J,ECX

        MOV EAX,f1
        SUB J
        MOV CJ,EAX

        MOV TA[CI*4][CJ*4],A[CJ*4][CI*4]

        LOOP ciclo2

        MOV ECX,I
        LOOP ciclo1
    }
    cout << sizeof(long) << endl;
    cout << "presione una tecla para continuar..." << endl;
    getch();
    limpiar();
}

void error(){
    cout << "Por favor ingrese un numero dentro de la seleccion" << endl;
    cout << "presione una tecla para continuar..." << endl;
    getch();
    limpiar();
}

int main(){
    printf("0 - Salir\n1 - Ingresar Matrices\n2 - Multiplicar\n3 - Transponer\n");
    while( scanf("%d",&op) && op != 0 ){
        limpiar();
        ( op == 1 )?fill():( op  == 2 )?multiply():( op == 3 )?transpose():error();
        printf("0 - Salir\n1 - Ingresar Matrices\n2 - Multiplicar\n3 - Transponer\n");
    }
    return 0;
}
