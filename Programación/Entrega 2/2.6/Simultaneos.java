import java.util.Scanner;
// trae las funciones de leer datos del teclado

public class Simultaneos {

  public static void main(String[] args) {
    Scanner key = new Scanner(System.in);
    System.out.println("Cada cuántos días va Ana?");
    int Ana = key.nextInt();
    System.out.println("Cada cuántos días va Bernardo?");
    int Ber = key.nextInt();
    System.out.println("Cada cuántos días va Carlos?");
    int Car = key.nextInt();
    System.out.println("---------- ----------");
    int Inicial = (int)0;
    int Cuantos = CalcularProximo(0, Ana,Ber,Car);
    System.out.println("Irán simultáneamente en "+Cuantos+" días.");
  } // main

  static int CalcularProximo(int I, int A, int B, int C){
    boolean Siempre = true;
    int D = I+1; 
    while(Siempre){
      System.out.format("%3d\t",D);
      if((D%A)==0)
        // Hoy va Ana
        System.out.format("Ana\t");
      if((D%B)==0)
        // Hoy va Bernardo
        System.out.format("Bernardo\t");
      if((D%C)==0)
        // Hoy va Carlos
        System.out.format("Carlos\t");
      if(((D%A)==0) && (((D%B)==0) && ((D%C)==0))){
        System.out.format("*** Hoy van los tres!%n");
        Siempre=false;
        return D;
      }
      D=D+1;
      System.out.println();
    }
    return D;
  }
}  // Simultaneos
