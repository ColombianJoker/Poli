import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class Primalidad {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Entero?");
    int Validar = key.nextInt();
    if( Primo(Validar) )
      System.out.println("El numero "+Validar+" es primo.");
    else
      System.out.println("El numero "+Validar+" no es primo.");
  } // main

  static boolean Primo(int N){
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
}  // Primalidad
