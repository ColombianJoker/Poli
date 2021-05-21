import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class TipoTriangulo {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Lados del triángulo? (A B C)");
    long A = key.nextLong();
    long B = key.nextLong();
    long C = key.nextLong();
    if(Equilatero(A,B,C))
      System.out.format("El triángulo (%d,%d,%d) es equilátero%n",A,B,C);
    else
      if(Isosceles(A,B,C))
        System.out.format("El triángulo (%d,%d,%d) es isosceles%n",A,B,C);
      else
        System.out.format("El triángulo (%d,%d,%d) es escaleno%n",A,B,C);
  } // main
  
  static boolean Equilatero(long AA, long BB, long CC){
    if((AA==BB)&&(AA==CC))
      return true;
    else
      return false;
  }
  static boolean Isosceles(long AA, long BB, long CC){
    // Devuelve true si encuentra dos lados iguales sin validar si los tres son iguales
    if((AA==BB)||((AA==CC)||(BB==CC)))
      return true;
    else
      return false;
  }
}  // TipoTriangulo
