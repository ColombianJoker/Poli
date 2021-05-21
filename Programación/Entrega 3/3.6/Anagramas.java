import java.util.Scanner;
// trae las funciones de leer datos del teclado
import java.util.Arrays;
// trae funciones de arreglos, incluido "sort"

public class Anagramas {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Cadena 1?");
    String CadenaS=key.nextLine();
    System.out.println("Cadena 2?");
    String CadenaT=key.nextLine();
    if(CadenaS.length()!=CadenaT.length()){
      System.out.format("Las cadenas '%s' y '%s' no son anagramas.%n", CadenaS, CadenaT);
    } else {
        // Convertimos los arreglos ordenados a string para poder comparar con las funciones de cadena
        if(SonAnagramas(CadenaS,CadenaT))
          System.out.format("Las cadenas '%s' y '%s' son anagramas.%n",CadenaS,CadenaT);
        else
          System.out.format("Las cadenas '%s' y '%s' no son anagramas.%n",CadenaS,CadenaT);
    }
  } // main

  static boolean SonAnagramas(String CadS, String CadT){
    // Devuelve verdadero si las palabras son anagramas
    // Convertimos las dos cadenas a arreglo para poder usar las funciones de ordenado
    char[] ArrayS=CadS.toCharArray();
    char[] ArrayT=CadT.toCharArray();
    Arrays.sort(ArrayS);
    Arrays.sort(ArrayT);
    String OrdenadaS=String.valueOf(ArrayS);
    String OrdenadaT=String.valueOf(ArrayT);
    return OrdenadaS.compareTo(OrdenadaT)==0;
  }
}  // Anagramas
