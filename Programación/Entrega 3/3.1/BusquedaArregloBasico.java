import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class BusquedaArregloBasico {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Cuántos elementos?");
    int Cuantos=key.nextInt();
    int[] Datos=new int[Cuantos]; // Crea el arreglo del número de elementos
    LlenarArreglo(Datos);
    System.out.println("Qué dato quiere buscar?");
    int Buscar = key.nextInt();
    int Posicion = BuscarDato(Datos,Buscar);
    if(Posicion==-1)
      System.out.format("El número %d no se encontró en el arreglo 'Datos'%n",Buscar);
    else {
      System.out.format("El número %d se encontró en Datos[%d]%n",Buscar,Posicion); 
    }
  } // main

  static void LlenarArreglo(int[] Arreglo){
    // Recibe los datos y llena el arreglo
    Scanner key = new Scanner(System.in);
    System.out.format("Se solicitaran %d enteros:%n",Arreglo.length);
    for(int n=0; n<Arreglo.length;n++){
      System.out.format("[%d]? ",n);
      Arreglo[n]=key.nextInt();
    }
  }
  
  static int BuscarDato(int[] Arreglo, int Dato){
    // Busca un dato en el arreglo, si no lo encuentra devuelve -1, si lo encuentra devuelve la posición
    int Encontrado=-1;
    for(int n=0;n<Arreglo.length;n++)
      if(Arreglo[n]==Dato)
        Encontrado=n;
    return Encontrado;
  }
}  // BusquedaArregloBasico
