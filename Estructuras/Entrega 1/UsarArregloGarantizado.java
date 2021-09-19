import java.util.Scanner;       // trae las funciones de leer datos del teclado
import java.util.ArrayList;     // Para usar ArrayList

public class UsarArregloGarantizado {

  public UsarArregloGarantizado() {
    // Nada
  }
  
  public static void main(String[] args) {
    Scanner key=new Scanner(System.in);  // variable temporal para recibir de teclado
    int v;                                 // variable temporal para recibir el dato a almacenar
    System.out.println("Cuántos elementos?");
    int Cuantos=key.nextInt();
    ArregloGarantizado Datos=new ArregloGarantizado();   // Crea el arreglo minúsculo
    // LlenarLista
    for(int n=0; n<Cuantos;n++){
      System.out.format("[%d]? ",n);
      Datos.add(n,(E)key.nextInt());
    }
    
  } // main
