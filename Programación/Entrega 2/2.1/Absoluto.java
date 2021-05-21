import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class Absoluto {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Real?");
    double X = key.nextDouble();
    System.out.println("|"+X+"| = "+Absoluto(X));
  } // main
  
  static double Absoluto(double R){
    // Devuelve -R si R<0
    if(R>=0)
      return R;
    else
      return -R;
  }
}  // Absoluto
