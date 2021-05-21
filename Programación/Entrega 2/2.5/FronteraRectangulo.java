import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class FronteraRectangulo {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Use coordenadas decimales separadas por espacios, y si necesita, con signo.");
    System.out.println("Ingrese el tamaño del rectángulo (ancho alto):");
    double W = key.nextDouble();
    double H = key.nextDouble();
    W = Math.abs(W);  // le quita el signo negativo si lo tiene
    H = Math.abs(H);
    System.out.println("Ingrese el punto interior (horizontal vertical):");
    double X = key.nextDouble();
    double Y = key.nextDouble();
    X = Math.abs(X);
    Y = Math.abs(Y);
    if( (X>W) || (Y>H) )
      System.out.format("El punto (%2.2f,%2.2f) está por fuera del rectángulo (%2.2f,%2.2f)!%n",X,Y,W,H);
    else {
      double AlN = Norte(W,H,X,Y);
      double AlS = Sur(W,H,X,Y);
      double AlE = Este(W,H,X,Y);
      double AlO = Oeste(W,H,X,Y);
      double Minimo = ValorMinimo(AlN,AlS,AlE,AlO);
      if(AlN==Minimo)
        System.out.format("Con el rectángulo (%2.2f,%2.2f) y el punto (%2.2f,%2.2f) es más cerca tomar al norte %2.2f%n",W,H,X,Y,AlN);
      else
        if(AlS==Minimo)
          System.out.format("Con el rectángulo (%2.2f,%2.2f) y el punto (%2.2f,%2.2f) es más cerca tomar al sur %2.2f%n",W,H,X,Y,AlS);
        else
          if(AlE==Minimo)
            System.out.format("Con el rectángulo (%2.2f,%2.2f) y el punto (%2.2f,%2.2f) es más cerca tomar al este %2.2f%n",W,H,X,Y,AlE);
          else
            System.out.format("Con el rectángulo (%2.2f,%2.2f) y el punto (%2.2f,%2.2f) es más cerca tomar al oeste %2.2f%n",W,H,X,Y,AlO);
    }
  } // main

  static double Norte(double WW, double HH, double XX, double YY){
    return HH-YY;
  }
  static double Sur(double WW, double HH, double XX, double YY){
    return YY;
  }
  static double Este(double WW, double HH, double XX, double YY){
    return WW-XX;
  }
  static double Oeste(double WW, double HH, double XX, double YY){
    return XX;
  }
  static double ValorMinimo(double A, double B, double C, double D){
    return Math.min( A, Math.min(B, Math.min(C,D)));
  }
}  // FronteraRectangulo

//        |
//        b----------------------------------------+
//        |                                        |
//        |           norte                        |
//        |                                        |
//        |                                        |
//        y      oeste   p   este                  |
//        |                                        |
//        |             sur                        |
//      --+--------------x-------------------------a--------------
//        |
// distancia sur = y
// distancia norte = b - y
// distancia oeste = x
// distancia este = a - x
//
