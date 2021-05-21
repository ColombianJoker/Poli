import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class ConversionASegundos {

  public static void main(String[] args) {
    Scanner numeros = new Scanner(System.in)  ;
    System.out.println("Ingrese tres números enteros (H M S): ");
    int HH = numeros.nextInt();
    int MM = numeros.nextInt();
    int SS = numeros.nextInt();
    System.out.println("Las "+HH+":"+MM+":"+SS+" equivalen a "+CalcularSegundos(HH,MM,SS)+" segundos");
  } //  main

  static int CalcularSegundos(int H, int M, int S) {
    int TotS = 0; // total de segundos calculado

    if( H>=0 && H<=24 ) {
      if( M>=0 && H<=59 ) {
        if( S>=0 && H<=59) {
          TotS=H*(60*60)+M*(60)+S;
        }
      }
    } else if ( H==24 && M==0 && S==0) {
      TotS=24*60*60;
    }
    return TotS;
  } // CalcularSegundos

} // ConversionASegundos