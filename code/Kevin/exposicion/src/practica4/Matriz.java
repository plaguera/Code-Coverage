package practica4;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Matriz {
  private int filas, columnas;
  private int [] valores;
  //private Racional [] valores;
  
  public Matriz(int filas, int columnas){
    this.filas = filas;
    this.columnas = columnas;
    valores = new int[filas * columnas];
  }
  
  public Matriz(String nombreFichero){
    try {
      Scanner fichero = new Scanner(new File(nombreFichero));
      filas = fichero.nextInt();
      columnas = fichero.nextInt();
      valores = new int[filas * columnas];
      for(int i = 0; i < filas; i++)
        for(int j = 0; j < columnas; j++)
          setElemento(i, j, fichero.nextInt());
      fichero.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public String toString(){
    String aux = "";
    for(int i = 0; i < filas; i++)
      for(int j = 0; j < columnas; j++)
        aux += "[" + Integer.toString(i) + "][" + Integer.toString(j) + "] = " + getElemento(i, j) + "\n";
    return(aux);
  }
  
  public int getFilas() {
    return filas;
  }

  public int getColumnas() {
    return columnas;
  }

  public int getElemento(int fila, int columna){
    return(valores[getPosicion(fila, columna)]);
  }
  
  private int getPosicion(int fila, int columna){
     return(fila * this.columnas + columna);
  }
  
  public void setElemento(int fila, int columna, int elemento){
    valores[getPosicion(fila, columna)] = elemento;
  }
  
  public static Matriz multiplicar(Matriz operador1, Matriz operador2){
    Matriz resultado = new Matriz(operador1.getFilas(), operador1.getColumnas());
    for(int i = 0; i < resultado.getFilas(); i++)
      for(int j = 0; j < resultado.getColumnas(); j++)
        resultado.setElemento(i, j, operador1.getElemento(i, j) * operador2.getElemento(i, j));
    return(resultado);
  }
  
  public static Matriz dividir(Matriz operador1, Matriz operador2){
    Matriz resultado = new Matriz(operador1.getFilas(), operador1.getColumnas());
    for(int i = 0; i < resultado.getFilas(); i++)
      for(int j = 0; j < resultado.getColumnas(); j++)
        resultado.setElemento(i, j, operador1.getElemento(i, j) / operador2.getElemento(i, j));
    return(resultado);
  }
}