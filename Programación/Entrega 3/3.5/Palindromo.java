import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class Palindromo {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Cadena de texto?");
    String Texto=key.nextLine();
    if(EsPalindrome(Texto))
      System.out.format("La cadena '%s' es palíndrome%n",Texto);
    else
      System.out.format("La cadena '%s' no es palíndrome (al revés es '%s')%n",Texto,Invertir(Texto));
  } // main

  static boolean EsPalindrome(String Cadena){
    // Devuelve verdadero si la palabra dada es palíndroma
    String Invertida=Invertir(Cadena);
    return Cadena.compareTo(Invertida)==0;
  } // EsPalindrome
  
  static String Invertir(String Cadena){
    // Devuelve invertida la Cadena. Se usó el ejemplo de "Escenario 7/Lectura Fundamental/Procesamiento de información textual"
    String Invertida="";
    for(int i=0;i<Cadena.length();i++)
      Invertida=Cadena.charAt(i)+Invertida;
    return Invertida;
  } // Invertir
}  // Palindromo
