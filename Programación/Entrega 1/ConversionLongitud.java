import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class ConversionLongitud {

  public static void main(String[] args) {
    Scanner numeros = new Scanner(System.in)  ;
    System.out.println("Ingrese la longitud (n.dd): ");
    float Long = numeros.nextFloat();
    if(Long<0){
      Long=-Long;
    }
    System.out.println("Equivalencia de "+Long+"m:");
    System.out.println("  "+mAcm(Long)+" cm");
    System.out.println("  "+mAmm(Long)+" mm");
    System.out.println("  "+mApies(Long)+" pies");
    System.out.println("  "+mApulgadas(Long)+" pulgadas");
    System.out.println("  "+mAyardas(Long)+" yardas");
    System.out.println("  "+mAannosluz(Long)+" años luz");
    System.out.println("  "+mAangstroms(Long)+" Å (ångstroms)");
  } //  main

  static float mAcm(float M) {
    return 100 * M;
  } // mAcm

  static float mAmm(float M) {
    return 1000 * M;
  } // mAmm

  static float mApies(float M) {
    return 3.2808F * M;
  } // mApies

  static float mApulgadas(float M) {
    return 39.3701F * M;
  } // mApulgadas

  static float mAyardas(float M) {
    return 1.0936F * M;
  } // mAyardas

  static double mAannosluz(float M) {
    return 1.057E-16 * M;
    // WolframAlpha, recuperado de https://www.wolframalpha.com/input/?i=1+m+in+light+years 2021/mar/23
  } // mAyardas

  static double mAangstroms(float M) {
    return 1E10 * M;
    // WolframAlpha, recuperado de https://www.wolframalpha.com/input/?i=1+m+in+angstroms 2021/mar/23
  } // mAyardas

} // ConversionLongitud