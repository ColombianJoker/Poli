import java.util.Scanner;
// trae las funciones de leer datos del teclado
import java.util.Arrays;
// trae funciones de arreglos, incluido "sort"

public class ZapaticoCochinito {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    String Final;
    int Cuantos, Salto;
    
    System.out.print("Cuántos elementos? ");
    Cuantos=key.nextInt();
    System.out.print("De cuánto cada salto? ");
    Salto=key.nextInt();
    String[] Jugadores=new String[Cuantos]; // Crea el arreglo del número de elementos
    LlenarArreglo(Jugadores);
    Jugadores = LimpiarDeVacios(Jugadores);
    System.out.println("Inicial:");
    MostrarArreglo(Jugadores);
    Final=Eliminar(Jugadores,Salto);
    System.out.format("%nEl último jugador es '%s'!%n",Final);
  } // main

  static void LlenarArreglo(String[] Arreglo){
    // Recibe los datos y llena el arreglo
    Scanner key = new Scanner(System.in);
    
    if(Arreglo.length>=1)
      System.out.format("Se solicitaran %d nombres (cadenas):%n", Arreglo.length);
      for(int n=0; n<Arreglo.length;n++){
        System.out.format("[%d]? ",n);
        Arreglo[n]=key.nextLine();
      }
  } // LlenarArreglo
  
  static String[] LimpiarDeVacios(String[] Lleno){
    // Ajusta el arreglo de cadenas para que no tenga casillas vacías intercaladas
    int LongitudReal=0;
    Scanner key = new Scanner(System.in);
    
    if(Lleno.length>0){
      String[] ArregloTemporal=new String[Lleno.length]; // Primer arreglo temporal, igual al dado
      for(int n=0;n<Lleno.length;n++)
        if(Lleno[n].length()>0) { // Si la casilla tiene texto, cópiela
          ArregloTemporal[LongitudReal]=Lleno[n]; // Copia el texto
          LongitudReal++;
        }
      String[] CopiaReducida=new String[LongitudReal]; // Otro arreglo del tamaño justo
      for(int n=0;n<LongitudReal;n++)
        CopiaReducida[n]=ArregloTemporal[n]; // Se copia el arreglo temporal al que se va a devolver
      return CopiaReducida;
    } else { // Lleno está vacío lo devuelve igual
      return Lleno;
    } 
  } // LimpiarDeVacios
  
  static String Eliminar(String[] Lleno, int Salto){
    // Saca los jugadores del arreglo, según el salto
    boolean Siempre=true;
    String[] Eliminados=new String[Lleno.length]; // Temporal
    String Enter, Nulo, Final="";
    int LongitudReal=0, n=0;
    Scanner key = new Scanner(System.in);
    for(int i=0;i<Eliminados.length;i++)
      Eliminados[i]=""; // Inicializar

    while(Siempre) { // Solo va a terminar cuando Siempre sea falso
      if(Lleno.length==0){
        Siempre=false; // Debe salir del ciclo
        Final="";
      } else if(Lleno.length==1) {
        // Si tiene uno ese es el jugador final
        Siempre=false; // Debe salir del ciclo
        Final=Lleno[0];
      } else { // Eliminación
        n=n+Salto;
        if(n>=Lleno.length)
          n=n%Lleno.length; // Da la vuelta
        Eliminados[LongitudReal]=Lleno[n]; // Pasa al jugador al arreglo de eliminados
        Lleno[n]=""; // Lo saca de la lista
        LongitudReal++;
        Lleno=LimpiarDeVacios(Lleno); // Recompacta el arreglo de jugadores
        // System.out.println("Lleno:");       // Depurar
        // MostrarArreglo(Lleno);              // Depurar
        // System.out.println("Eliminados:");  // Depurar
        // MostrarArreglo(Eliminados);         // Depurar
        // System.out.println("");             // Depurar
        // Enter=key.nextLine();               // Depurar
      }
    }
    System.out.println("Eliminados:");
    MostrarArreglo(Eliminados);
    System.out.println("");
    return Final;
  } // Eliminar
  
  static void MostrarArreglo(String[] Arreglo){
    // Muestra los contenidos del arreglo. Uso temporal
    for(int a=0; a<Arreglo.length;a++)
      if(a!=(Arreglo.length-1))
        System.out.format("%10d |",a);
      else
        System.out.format("%10d |%n",a);
    for(int a=0; a<Arreglo.length;a++)
      if(a!=(Arreglo.length-1))
        System.out.format("%-11s|",Arreglo[a]);
      else
        System.out.format("%s%n",Arreglo[a]);
  } // MostrarArreglo

}  // Mediana
