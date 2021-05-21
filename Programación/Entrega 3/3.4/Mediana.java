import java.util.Scanner;
// trae las funciones de leer datos del teclado
import java.util.Arrays;
// trae funciones de arreglos, incluido "sort"

public class Mediana {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Cuántos elementos?");
    int Cuantos=key.nextInt();
    float[] Datos=new float[Cuantos]; // Crea el arreglo del número de elementos
    float[] ValoresMedianos=new float[2];
    LlenarArreglo(Datos);
    ValoresMedianos=ObtenerMediana(Datos);
    System.out.format("En el arreglo la mediana es %2.2f y va en la posición %2.1f%n",ValoresMedianos[1],ValoresMedianos[0]);
    MostrarArreglo(Datos);
  } // main

  static void LlenarArreglo(float[] Arreglo){
    // Recibe los datos y llena el arreglo
    Scanner key = new Scanner(System.in);
    if(Arreglo.length>=1)
      System.out.format("Se solicitaran %d reales:%n", Arreglo.length);
      for(int n=0; n<Arreglo.length;n++){
        System.out.format("[%d]? ",n);
        Arreglo[n]=key.nextFloat();
      }
  }
  
  static float[] ObtenerMediana(float[] Arreglo){
    // Recibe un arreglo de float y devuelve la posición y el valor de la mediana
    // Si el arreglo está vacío devuelve posición -1
    // Se usó la definición de Wikipedia: https://es.wikipedia.org/wiki/Mediana_(estad%C3%ADstica)
    float[] ValoresMedianos=new float[2];
    // en ValoresMedianos[0] se devolverá la posición de la mediana y en ValoresMedianos[1] el valor
    if(Arreglo.length==0){
      ValoresMedianos[0]=-1;
      ValoresMedianos[1]=0;
    } else if(Arreglo.length==1){ // Si el arreglo solo tiene una posición, esa es la mediana
      ValoresMedianos[0]=1;
      ValoresMedianos[1]=Arreglo[0];
    } else {
      Arrays.sort(Arreglo); // Lo modifica y lo deja ordenado!!!
      float ArregloLengthF=(float)Arreglo.length;
      if((Arreglo.length%2)==0){ // Si el tamaño es par la posición es la mitad-0.5
        ValoresMedianos[0]=ArregloLengthF/2F-0.5F; // Y el valor es el promedio del de la mitad con el anterior
        ValoresMedianos[1]=(Arreglo[(int)(ArregloLengthF/2F)]+Arreglo[(int)(ArregloLengthF/2F-1F)])/2F;
      } else { // Si el tamaño es impar es la mitad sin el 0.5
        int Posicion=(int)Math.floor(Arreglo.length/2F);
        ValoresMedianos[0]=Posicion;
        ValoresMedianos[1]=Arreglo[Posicion];
      }
    }
    return ValoresMedianos;    
  }
  
  static void MostrarArreglo(float[] Arreglo){
    // Muestra los contenidos del arreglo. Uso temporal
    for(int a=0; a<Arreglo.length;a++)
      if(a!=(Arreglo.length-1))
        System.out.format("[%d]\t",a);
      else
        System.out.format("[%d]%n",a);
    for(int a=0; a<Arreglo.length;a++)
      if(a!=(Arreglo.length-1))
        System.out.format("%2.2f\t",Arreglo[a]);
      else
        System.out.format("%2.2f%n",Arreglo[a]);
  }

}  // Mediana
