import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class ConversionTemperatura {

  public static void main(String[] args) {
    Scanner numeros = new Scanner(System.in)  ;
    System.out.println("Ingrese la temperatura en °C (n.dd): ");
    float Temp = numeros.nextFloat();
    System.out.println("Equivalencia de "+Temp+"°C:");
    System.out.println("  "+cAfahr(Temp)+" °F");
    System.out.println("  "+cAkelv(Temp)+" °K");
    System.out.println("  "+mArank(Temp)+" °R");
  } //  main

  static float cAfahr(float C) {
    return C * (9F/5F) + 32F;
    // Recuperado de Google, 2021/mar/23, https://www.google.com/search?client=safari&rls=en&q=how+to+convert+c+to+f
  } // cAfahr 

  static float cAkelv(float C) {
    return C + 273.15F;
    // Recuperado de Google, 2021/mar/23, https://www.google.com/search?q=how+to+convert+c+to+k&client=safari
  } // cAkelv

  static float mArank(float C) {
    return C * (9F/5F) +491.67F;
    // Recuperado de Google, 2021/mar/23, https://www.google.com/search?q=how+to+convert+c+to+r&client=safari
  } // mArank


} // ConversionTemperatura