import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class EstaOrdenado {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Cuántos elementos?");
    int Cuantos=key.nextInt();
    int[] Datos=new int[Cuantos]; // Crea el arreglo del número de elementos
    LlenarArreglo(Datos);
    if(Ordenado(Datos))
      System.out.println("El arreglo 'Datos' está ordenado.");
    else
      System.out.println("El arreglo 'Datos' no está ordenado.");
    MostrarArreglo(Datos);
  } // main

  static void LlenarArreglo(int[] Arreglo){
    // Recibe los datos y llena el arreglo
    Scanner key = new Scanner(System.in);
    if(Arreglo.length>=1){
      System.out.format("Se solicitaran %d enteros:%n",Arreglo.length);
      for(int n=0; n<Arreglo.length;n++){
        System.out.format("[%d]? ",n);
        Arreglo[n]=key.nextInt();
      }
    }
  }
  
  static boolean Ordenado(int[] Arreglo){
    // Devuelve true si el arreglo está ordenado
    // Asume que un arreglo vacío o unitario está ordenado
    boolean AhoraOrdenado=true; // Asume que sí está ordenado
    boolean Continua=true;
    int n=1; // Si toca, comienza desde la posición 1, es decir la segunda
    if(Arreglo.length!=1){
      // Comienza con arreglos de tamaño 2 (pos=1), y compara con el anterior
      while(AhoraOrdenado && Continua){ // Mientras se considere ordenado o haya que seguir
        if(Arreglo[n]<Arreglo[n-1])
          AhoraOrdenado=false;
        n++;
        if(n>=Arreglo.length)
          Continua=false;
      }
    }
    return AhoraOrdenado;
  }
  
  static void MostrarArreglo(int[] Arreglo){
    // Muestra los contenidos del arreglo. Uso temporal
    for(int a=0; a<Arreglo.length;a++)
      if(a!=(Arreglo.length-1))
        System.out.format("%-10d |",a);
      else
        System.out.format("%-10d |%n",a);
    for(int a=0; a<Arreglo.length;a++)
      if(a!=(Arreglo.length-1))
        System.out.format("%11d|",Arreglo[a]);
      else
        System.out.format("%11d%n",Arreglo[a]);
  } // MostrarArreglo

}  // EstaOrdenado
