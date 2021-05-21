import java.util.Scanner;
// trae las funciones de leer datos del teclado


public class Ofertas {

  public static void main(String[] args) {
    Scanner numeros = new Scanner(System.in)  ;
    System.out.println("Ingrese cuatro números (tienda A, tienda B, tienda C, descuento A): ");
    int A = numeros.nextInt();
    int B = numeros.nextInt();
    int C = numeros.nextInt();
    float D = numeros.nextFloat();
    
    // Todos los precios deben ser mayores a cero (no son gratis), y
    // el descuento no puede ser ni negativo ni mayor al 100%
    if(A>0 && (B>0 && (C>0 && (D>=0 && D<100)))) {
      // Calcular
      float TotA = totaliceA(A,D);
      float TotB = totaliceB(B);
      float TotC = totaliceC(C);
      muestraTotales(TotA,TotB,TotC);
      if(TotA==minimo(TotA,TotB,TotC)) {
        System.out.println("Compra más barata en A (3 en $"+TotA+")");
      } else if(TotB==minimo(TotA,TotB,TotC)) {
        System.out.println("Compra más barata en B (3 en $"+TotB+")");
      } else if(TotC==minimo(TotA,TotB,TotC)) {
        System.out.println("Compra más barata en C (3 en $"+TotC+")");
      }
    } else if(A<=0) {
      System.out.println("El precio en la tienda A debe ser mayor que cero (A= $"+A+")");
    } else if(B<=0) {
      System.out.println("El precio en la tienda B debe ser mayor que cero (B= $"+B+")");
    } else if(C<=0) {
      System.out.println("El precio en la tienda C debe ser mayor que cero (C= $"+C+")");
    } else if(D>=100) {
      System.out.println("El descuento en la tienda D debe ser menor que cien (D= "+D+"%)");
    } else if(D<0) {
      System.out.println("El descuento no puede ser negativo (D= "+D+"%)");
    }
    
  } //  main
  
  static float totaliceA( float Precio, float Desc) {
    // Calcula // 3 × (100% - descuento)/100% × A
    return 3*((100F-Desc)*Precio/100F);
  } // totaliceA

  static float totaliceB( float Precio) {
    // 2 × B (pero entregan 3)
    return 2*(Precio);
  } // totaliceB

  static float totaliceC( float Precio) {
    // 3 × C, entregan C
    return 3*(Precio);
  } // totaliceC

  static int muestraTotales( float tA, float tB, float tC) {
    // Solo muestra
    System.out.println("Total en A= $"+tA);
    System.out.println("Total en B= $"+tB);
    System.out.println("Total en C= $"+tC);
    return 0;
  } // muestraTotales
  
  static float minimo(float N1, float N2, float N3) {
    // Devuelve el valor menor de los tres
    return Math.min(N1,Math.min(N2,N3));
  } // minimo
  
} // Ofertas