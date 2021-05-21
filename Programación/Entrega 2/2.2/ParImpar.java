import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class ParImpar {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Entero?");
    long N = key.nextLong();
    if(Par(N))
      System.out.println(N+" es par.");
    else
      System.out.println(N+" es impar.");
  } // main
  
  static boolean Par(long Z){
    if((Z%2)==0)
      return true;
    else
      return false;
  }
}  // ParImpar
