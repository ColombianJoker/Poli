import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class Goldbach {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Entero?");
    int V = key.nextInt();
    int P=1;
    int R=0;
    boolean Siempre = true;
    while(Siempre){
      R = V - P;
      // System.out.format("Probando P=%d R=%d (V=%d)%n", P, R, V); // Solo pruebas
      if(Primo(P)){
        // Si es primo se mira si V-P es primo
        if(Primo(R)){
          System.out.format("El numero %d=%d+%d y ambos son primos!%n",V,P,R);
          Siempre=false;
        }
      }
      P=P+2; // Como los pares no son primos, se avanza de dos en dos, 1, 3, 5...
      if(P>(V/2)){
        // No hay que mirar más allá de la mitad del número inicial
        Siempre=false;
      }
    }
    if(P>(V/2))
      System.out.println("No se encontro par para "+V);
  } // main

  static int SigPrimo(int Ini){
    // Devuelve el siguiente número primo mayor que Ini
    int N=Ini+1;
    while(true){
      if(Primo(N))
        return N;
      else
        N=N+2;
    }
  }
  
  static boolean Primo(int N){
    // Devuelve true si el número N es primo, false si no
    int Raiz2 = (int)Math.round( Math.sqrt((double)N));
    if(N==1)
      return true ; // 1 es primo
    else
      if(N==2)
        return true ; // 2 es primo
      else
        if(N==3)
          return true ; // 3 es primo
        else
          if((N%2)==0)
            return false ; // Los pares mayores que 2 no son primos
          else {
            for(int I=3;I<=Raiz2;I++)
              if((N%I)==0)
                return false; // Si divide por alguno no es primo
            return true; // Si terminó es que es primo
          }
  }
}  // Goldbach
