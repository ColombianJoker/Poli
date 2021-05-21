import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class CuantosDiferentes {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Cuántos elementos?");
    int Cuantos=key.nextInt();
    int[] Datos=new int[Cuantos]; // Crea el arreglo del número de elementos
    LlenarArreglo(Datos);
    System.out.format("En el arreglo 'Datos' hay %d elementos diferentes.%n",CuantosDiferentes(Datos));
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
  
  static int CuantosDiferentes(int[] Arreglo){
    // Devuelve cuántos elementos diferentes hay en el Arreglo
    int[] Diferentes=new int[Arreglo.length]; // Un arreglo para los diferentes del mismo tamaño
    int Cuantos=0;
    int Posicion=0;
    for(int n=0;n<Arreglo.length;n++){
      Posicion=BuscarDato(Diferentes,Arreglo[n],n);
      if(Posicion==-1){ // Si no está lo incluye
        Diferentes[Cuantos]=Arreglo[n];
        Cuantos++;
      }
      // Depurar
      // System.out.println("Arreglo:");
      // MostrarArreglo(Arreglo);
      // System.out.println("Diferentes:");
      // MostrarArreglo(Diferentes);
    }
    return Cuantos;
  }
  
  static int BuscarDato(int[] Arreglo, int Dato, int Hasta){
    // Busca un dato en el arreglo desde 0 hasta Hasta, si no lo encuentra devuelve -1, si lo encuentra devuelve la posición
    int Encontrado=-1;
    for(int n=0;n<Hasta;n++)
      if(Arreglo[n]==Dato)
        Encontrado=n;
    return Encontrado;
  }

  static void MostrarArreglo(int[] Arreglo){
    // Muestra los contenidos del arreglo. Uso temporal
    for(int a=0; a<Arreglo.length;a++)
      if(a!=(Arreglo.length-1))
        System.out.format("[%d]\t",a);
      else
        System.out.format("[%d]%n",a);
    for(int a=0; a<Arreglo.length;a++)
      if(a!=(Arreglo.length-1))
        System.out.format("%d\t",Arreglo[a]);
      else
        System.out.format("%d%n",Arreglo[a]);
  }

}  // CuantosDiferentes
