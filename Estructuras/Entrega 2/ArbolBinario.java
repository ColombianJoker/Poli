import java.util.Scanner;       // trae las funciones de leer datos del teclado
import java.util.ArrayList;     // Para usar ArrayList
import java.util.TreeSet;       // Para el abstracto TreeSet
import java.util.List;          // Para usar List
import java.util.LinkedList;    // Para usar LinkedList
import java.util.Queue;         // Para usar Queue

public class ArbolBinario<E> extends TreeSet<E> {      // Declaración de la clase, parecida a la del PDF del
                                                         // pero extiende la clasa y no implementa una interfaz
  
  // *********************************
  // * Constantes                    *
  // *********************************
  static final int LESSER  = -1;
  static final int EQUAL   = 0;
  static final int GREATER = 1;

  // *********************************
  // * Atributos básicos de la clase *
  // *********************************
  protected E val;
  protected ArbolBinario<E> izq;
  protected ArbolBinario<E> der;                                                    
  // *********************************
  // * Métodos de la clase           *
  // *********************************
  
  public ArbolBinario() {
    // El árbol vacío es representado como un árbol binario con raíz NULL, rama izquierda NULL y rama derecha NULL
    val=null;
    izq=null;
    der=null;
  } // constructor básico ArbolBinario()
  
  public ArbolBinario(E Val, ArbolBinario<E> Izq, ArbolBinario<E> Der) {
    // Constructor de un árbol o un nodo no nulo
    // Si el dato dado para la raíz es nulo, parar
    if(Val==null) {
      throw new NullPointerException("Un árbol binario no vació debe tener un valor para la raíz!");
    }
    // Si el dato dado para la izquierda es nulo, parar
    if(Izq==null) {
      throw new NullPointerException("Un árbol binario no vació debe tener un valor para la rama izquierda!");
    }
    // Si el dato dado para la izquierda es nulo, parar
    if(Der==null) {
      throw new NullPointerException("Un árbol binario no vació debe tener un valor para la rama derecha!");
    }
    // Inicializar con los valores (válidos)
    val=Val;
    izq=Izq;
    der=Der;
  }
  
  /**
    * Método analizador para obtener el valor almacenado directamente en el nodo dado
    */
  public E getVal() {
    return val; // Retorna el valor que almacena directamente el nodo
  } // .getVal()

  /**
    * Método analizador para obtener un "apuntador" al objeto rama izquierda del árbol dado
    */
  public ArbolBinario<E> getIzq() {
    return izq; // Retorna el valor al que apunta la rama izquierda
  } // .getIzq()

  /**
    * Método analizador para obtener un "apuntador" al objeto rama derecha del árbol dado
    */
  public ArbolBinario<E> getDer() {
    return der; // Retorna el valor al que apunta la rama derecha
  } // .getDer()

  /**
    * Método analizador para conocer si un árbol es vacío
    */
  public boolean esVacio() {
    return (val==null); // Retorna el resultado de la comparación, T o F;
  } // .esVacio()

  /**
    * Método analizador para conocer si un nodo es hoja
    */
  public boolean esHoja() {
    if(esVacio()) {  // Si este nodo es vacío ni siquiera es hoja
      return false;
    } else {
      if(!izq.esVacio() || !der.esVacio()) { // Si tiene un descendiente no es hoja
        return false;
      } else {
        return true;
      }
    }
  } // .esHoja()

  /**
    * Método comparador del nodo actual del árbol con un valor dado. Se crea para ser flexibles.
    * Devuelve -1 si Val compara menor que nodo.val, 0 si Val compara igual que nodo.val, y 1 si
    * Val compara mayor que nodo.val
    */
  public int compara(E Val) {
    if((int)Val==(int)getVal())
      return EQUAL;
    else if((int)Val<(int)getVal())
      return LESSER;
    else
      return GREATER;
  } // .compara

  /**
    * Método analizador para conocer el peso de un nodo con todos sus descendientes
    */
  public int peso() {
    if(esVacio()) {
      return 0;
    } else {
      // Pesa el nodo (que no es nulo, porque es el caso anterior), más lo que pesen sus dos ramas, izq y derecha
      return 1+izq.peso()+der.peso();
    }
  } // .peso
  
  /**
    * Método analizador para conocer la altura de un nodo/rama con todos los descendientes
    */
  public int altura() {
    if(esVacio()) { // Si es vació, pues tiene alto 0
      return 0;
    } else {
      return 1+Math.max(izq.altura(),der.altura());
    }
  }
  
  /**
    * Método analizador para obtener cuántas veces el valor del objeto dado como parámetro está en el árbol
    */
  public int numOcurrencias(Object Obj) {
    if(esVacio()) { // Un árbol vacío no contiene a ningún objeto
      return 0;
    } else { // Cuando "tiene"
      // Contar si y cúantas veces está en un descendiente (izq)
      int enIzq=izq.numOcurrencias(Obj);
      // Contar si y cuántas veces está en un otro (der)
      int enDer=der.numOcurrencias(Obj);
      // Mirar si el valor de Obj está contenido además en el nodo actual
      if(Obj.equals(val)) {   // Si el valor del dado es igual al valor que este nodo contiene
        return 1+enIzq+enDer; // es 1 + cuantas veces esté en izq + cuantas veces esté en der
      } else {
        return enIzq+enDer;   // si no, es cuantas veces esté en izq + cuantas veces esté en der
      }
    }
  }

  /**
    * Métodos para recorrer un árbol y dejar los elementos en una lista. Primero un constructor
    *   de una lista auxiliar
    */
  public List<E> preorden() {
    List<E> recorrido=new ArrayList<E>(); // Una lista nueva para el recorrido
    preorden(recorrido);                  // Llena la lista del recorrido con preorden
    return recorrido;                     // Retorna la lista del recorrido
  } // constructor de preorden
  
  /**
    * Método para recorrer un árbol en preorden y dejar lo recorrido en una lista auxiliar
    */
  private void preorden(List<E> Lista) {
    if(!esVacio()) {                       // Si este arbol es vacío, la lista sigue como estaba, si no
                                           // se debe recorrer
      Lista.add(val);                      // Preorden es primero la raíz,
      izq.preorden(Lista);                 // Luego recorrer la izquierda
      der.preorden(Lista);                 // y finalmente la derecha
    }
  } // .preorden()

  /**
    * Métodos para recorrer un árbol y dejar los elementos en una lista. Primero un constructor
    *   de una lista auxiliar
    */
  public List<E> inorden() {
    List<E> recorrido=new ArrayList<E>(); // Una lista nueva para el recorrido
    inorden(recorrido);                   // Llena la lista del recorrido con preorden
    return recorrido;                     // Retorna la lista del recorrido
  } // constructor de inorden
  
  /**
    * Método para recorrer un árbol en inorden y dejar lo recorrido en una lista auxiliar
    */
  private void inorden(List<E> Lista) {
    if(!esVacio()) {                       // Si este arbol es vacío, la lista sigue como estaba, si no
                                           // se debe recorrer
      izq.inorden(Lista);                 // Primero recorrer la izquierda
      Lista.add(val);                      // Luego, de segundo la raíz,
      der.inorden(Lista);                 // y finalmente la derecha
    }
  } // .inorden()

  /**
    * Métodos para recorrer un árbol y dejar los elementos en una lista. Primero un constructor
    *   de una lista auxiliar
    */
  public List<E> postorden() {
    List<E> recorrido=new ArrayList<E>(); // Una lista nueva para el recorrido
    postorden(recorrido);                 // Llena la lista del recorrido con postorden
    return recorrido;                     // Retorna la lista del recorrido
  } // constructor de postorden
  
  /**
    * Método para recorrer un árbol en postorden y dejar lo recorrido en una lista auxiliar
    */
  private void postorden(List<E> Lista) {
    if(!esVacio()) {                       // Si este arbol es vacío, la lista sigue como estaba, si no
                                           // se debe recorrer
      izq.postorden(Lista);                // Primero recorrer la izquierda
      der.postorden(Lista);                // Luego la derecha,
      Lista.add(val);                      // Finalmente, la raíz.
    }
  } // .postorden()

  /**
    * Métodos para recorrer un árbol y dejar los elementos en una lista. Primero un constructor
    *   de una lista auxiliar
    */
  public List<E> niveles() {
    List<E> recorrido=new ArrayList<E>();   // Una lista nueva para el recorrido
    // Crear una nueva cola vacía para realizar el proceso:
    Queue<ArbolBinario<E>> cola=new LinkedList<ArbolBinario<E>>();
    cola.offer(this);                       // Agregar este nodo a la cola
    while(!cola.isEmpty()) {                // Repita mientras no esté desocupada
      ArbolBinario<E> nodoTemp=cola.poll();   // Temporalmente mantener la cabeza de la cola
      if(!nodoTemp.esVacio()) {               // Si este es un nodo "real"
        recorrido.add(nodoTemp.val);        // Añadir al recorrido el nodo actual;
        cola.offer(nodoTemp.izq);           // Añadir al recorrido la rama izquierda
        cola.offer(nodoTemp.der);           // Añadir al recorrido la rama derecha
      }
    } // while
    return recorrido;                       // Retornar el recorrido como lista
  } // .niveles()
  
  /**
    * Métodos para recorrer un árbol y dejar los elementos en una lista. Primero un constructor
    *   de una lista auxiliar
    */
  public void addArbol(E Val) {                       // Intenta agregar un nodo nuevo al árbol
    if(esVacio()) {                                      // Cuando este nodo es nulo, llenarlo y
      E temp=new E();                                    // Ajustar sus ramas
      val=Val;                                           // Almacena el valor
      izq=new ArbolBinario();                            // Le pone una "rama nula" en la izquierda
      der=new ArbolBinario();                            // Le pone una "rama nula" en la derecha
    } else {                                             // Hay tres casos: (a) existe, (b) debe ir a la
      switch(compara(Val)) {                             // izquierda, o (c) debe ir a la derecha
        case EQUAL:                                      // Si son iguales no lo agrega        
          break;
        case LESSER:                                     // Si compara menor, agregue por la izq
          izq.addArbol(Val);
          break;
        case GREATER:
          der.addArbol(Val);
          break;
      } // switch
    } // else
  } // .niveles()
  
  
  public static void main(String[] args) {
    Scanner key=new Scanner(System.in);                  // variable temporal para recibir de teclado
    int num;                                             // entero temporal para recibir de la entrada
    ArbolBinario Datos=new ArbolBinario();               // Crea el arreglo base
    // LlenarLista
    System.err.println("----- Toma de datos -----");
    while(key.hasNextInt()) {                            // Repita mientras haya números
      num=key.nextInt();
      Datos.addArbol((E)num); 
    } // while
  } // main

} // fin ArbolBinario
