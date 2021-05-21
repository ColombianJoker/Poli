import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class Dardos {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Use coordenadas decimales separadas por espacios, y si necesita, con signo.");
    System.out.println("Ingrese la coordenada del dardo: ");
    double XX = key.nextDouble();
    double YY = key.nextDouble();
    int Puntos = CalculaPuntos(XX,YY);
    System.out.format("El dardo que cae en (%2.2f,%2.2f) da %d puntos.%n",XX,YY,Puntos);
  } // main

  static int CalculaPuntos(double x, double y) {
    // Calcula puntos según la distancia a (0,0) y una tabla de puntos
    double Radio = Math.sqrt( (x*x + y*x)) ;
    if(Radio<=1D)
      return 15;
    else
      if(Radio<=2D)
        return 9;
      else
        if(Radio<=3D)
          return 5;
        else
          if(Radio<=4D)
            return 2;
          else
            if(Radio<=5D)
              return 1;
            else
              return 0;
  } // CalcularPuntos

} // Dardos
