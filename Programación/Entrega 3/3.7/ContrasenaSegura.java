import java.util.Scanner;
// trae las funciones de leer datos del teclado
import java.util.Arrays;
// trae funciones de arreglos, incluido "sort"

public class ContrasenaSegura {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Contraseña a validar?");
    String Contrasena=key.nextLine();
    if(Contrasena.length()<10){
      System.out.format("El texto '%s' no se considera una contraseña segura!.%n",Contrasena);
    } else {
      if(TieneLetras(Contrasena,1) && (TieneDigitos(Contrasena,1) && TieneSimbolos(Contrasena,1)))
        System.out.println("La contraseña dada se considera segura.");
      else
        System.out.format("La contraseña '%s' no se considera segura!.%n",Contrasena);
    }
  } // main

  static boolean TieneLetras(String Cadena, int Minimo){
    int Cuantos=0;
    for(int n=0;n<Cadena.length();n++)
      if((Cadena.charAt(n)>='A' && Cadena.charAt(n)<='Z') || (Cadena.charAt(n)>='a' && Cadena.charAt(n)<='z'))
        // Está entre 'A' y 'Z' o 'a' y 'z'
        Cuantos++;
    if(Cuantos>=Minimo)
      return true;
    else
      return false;
  } // TieneLetras

  static boolean TieneLetras(String Cadena, int Minimo){
    int Cuantos=0;
    for(int n=0;n<Cadena.length();n++)
      if((Cadena.charAt(n)>='A' && Cadena.charAt(n)<='Z') || (Cadena.charAt(n)>='a' && Cadena.charAt(n)<='z'))
        // Está entre 'A' y 'Z' o 'a' y 'z'
        Cuantos++;
    if(Cuantos>=Minimo)
      return true;
    else
      return false;
  } // TieneLetras

  static boolean TieneDigitos(String Cadena, int Minimo){
    int Cuantos=0;
    for(int n=0;n<Cadena.length();n++)
      if((Cadena.charAt(n)>='0' && Cadena.charAt(n)<='9'))
        // Está entre '0' y '9'
        Cuantos++;
    if(Cuantos>=Minimo)
      return true;
    else
      return false;
  } // TieneDigitos

  static boolean TieneSimbolos(String Cadena, int Minimo){
    int Cuantos=0;
    for(int n=0;n<Cadena.length();n++)
      if((Cadena.charAt(n)>='!' && Cadena.charAt(n)<='/') || (Cadena.charAt(n)>=':' && Cadena.charAt(n)<='@') || (Cadena.charAt(n)>='[' && Cadena.charAt(n)<='`') || (Cadena.charAt(n)>='{' && Cadena.charAt(n)<='~'))
        // Se usaron los rangos de símbolos de la tabla de http://www.asciitable.com
        Cuantos++;
    if(Cuantos>=Minimo)
      return true;
    else
      return false;
  } // TieneSimbolos

}  // ContrasenaSegura
