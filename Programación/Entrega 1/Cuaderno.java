import java.util.Scanner;
// trae las funciones de leer datos del teclado


public class Cuaderno {

  public static void main(String[] args) {
    Scanner numeros = new Scanner(System.in)  ;
    System.out.println("Ingrese dos numeros (largo, ancho): ");
    float L = numeros.nextFloat();
    float A = numeros.nextFloat();
    
    // Cada número debe ser entero (n.0) o con medio cm (n.5)
    float L10=10*L;
    float A10=10*A;
    // Multiplicar por diez y convertir a entero para poder determinar si es xx.0 o xx.5
    int iL10=(int)Math.floor(L10);
    int iA10=(int)Math.floor(A10);
    if((iL10%5)==0 && (iA10%5)==0) {
      // Solo calcula con páginas de ancho y alto xx.0 o xx.5
      float lRem=lRemanente(L); // Quita los márgenes superior e inferior
      float aRem=aRemanente(A); // Quita los márgenes izquierdo y derecho
      if(lRem>0 && aRem>0) {
        int TotalCuadritos=cuadritos(lRem,aRem,2); // Calcula los cuadritos si hay 2 por centímetro
        System.out.println("Con papel de "+L+"×"+A+" cm se tienen "+TotalCuadritos+" cuadritos");
      } else {
        System.out.println("Con papel de "+L+"×"+A+" cm no se pueden tener cuadritos");
      }
    } else {
      System.out.println("Solo se puede usar papel de dimensiones xx.0 o xx.5");
    }
  } //  main

  static float lRemanente(float LP) {
    // Calcula la longitud de la página menos 1cm arriba y abajo
    return LP-(2*1F);
  } // lRemanente
  
  static float aRemanente(float AP) {
    // Calcula el ancho de la página menos 0.5cm a la izquierda y a la derecha
    return AP-(2*0.5F);
  } // aRemanente
  
  static int cuadritos(float Largo, float Ancho, float porCm) {
    return (int)((porCm*Largo)*(porCm*Ancho));
  } // cuadritos
  
} // Cuaderno