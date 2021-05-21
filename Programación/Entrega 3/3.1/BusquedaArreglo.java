import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class BusquedaArreglo {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Cuántos elementos?");
    int Cuantos=key.nextInt();
    int[] Datos=new int[Cuantos]; // Crea el arreglo del número de elementos
    LlenarArreglo(Cuantos,Datos);
    System.out.println("Qué dato quiere buscar?");
    int Buscar = key.nextInt();
    int Posicion = BuscarDato(Datos,Buscar);
    if(Posicion==-1)
      System.out.format("El número %d no se encontró en el arreglo 'Datos'%n",Buscar);
    else {
      System.out.format("El número %d se encontró en Datos[%d]%n",Buscar,Posicion); 
    }
    MostrarArreglo(Datos);
  } // main

  static void LlenarArreglo(int Cuantos, int[] Arreglo){
    // Recibe los datos y llena el arreglo
    Scanner key = new Scanner(System.in);
    System.out.format("Se solicitaran %d enteros:%n",Cuantos);
    for(int n=0; n<Arreglo.length;n++){
      System.out.format("[%d]? ",n);
      Arreglo[n]=key.nextInt();
    }
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
  
  static int BuscarDato(int[] Arreglo, int Dato){
    // Busca un dato en el arreglo, si no lo encuentra devuelve -1, si lo encuentra devuelve la posición
    int Encontrado=-1;
    for(int n=0;n<Arreglo.length;n++)
      if(Arreglo[n]==Dato)
        Encontrado=n;
    return Encontrado;
  }
}  // BusquedaArreglo
