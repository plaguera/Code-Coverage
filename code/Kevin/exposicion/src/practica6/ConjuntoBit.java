package practica6;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class ConjuntoBit {
    
    private static final long SIZE_LONG = 64;
    private long conjunto;
    
    public ConjuntoBit(){
      conjunto = 0;
    }
    
    public ConjuntoBit(long conjunto){
      this.conjunto = conjunto;
    }
    
    public ConjuntoBit(String nombreFichero){
      this.conjunto = 0;
      Scanner fichero;
      try {
        fichero = new Scanner(new File(nombreFichero));
        while(fichero.hasNextLong())
          add(fichero.nextLong());
        fichero.close();
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    
    public String toString(){
      if(esVacio())
        return("{}");
      long aux = 1;
      String cadena = "{ ";
      
      for(int i = 0; i < SIZE_LONG; i++)
         if(((aux << i) & getConjunto()) != 0)
           cadena += Integer.toString(i) + " ";
      cadena += "}";
      return(cadena);
    }
    
    public boolean perteneceElemento(long elemento){
      long aux = 1 << elemento;
      return((conjunto & aux) != 0);
    }
    
    public void add(long elemento){
      long aux = 1 << elemento;
      conjunto |= aux;
    }
    
    public void eliminar(long elemento){
      long aux = 1 << elemento;
      aux = ~aux;
      conjunto &= aux;
    }
    
    public static ConjuntoBit union(ConjuntoBit conjunto1, ConjuntoBit conjunto2){
      return(new ConjuntoBit(conjunto1.getConjunto() | conjunto2.getConjunto()));
    }
    
    public static ConjuntoBit interseccion(ConjuntoBit conjunto1, ConjuntoBit conjunto2){
      return(new ConjuntoBit(conjunto1.getConjunto() & conjunto2.getConjunto()));
    }
    
    public long getConjunto(){
      return(conjunto);
    }
    
    public static boolean equals(ConjuntoBit conjunto1, ConjuntoBit conjunto2){
      return(conjunto1.getConjunto() == conjunto2.getConjunto());
    }
    
    public void borrar(){
      conjunto = 0;
    }
    
     public int cardinal(){
       int contador = 0;
       long aux = 1;
       for(int i = 0; i < SIZE_LONG; i++)
         if(((aux << i) & getConjunto()) != 0)
           contador++;
       return(contador);
     }
    
    public boolean esVacio(){
      return(conjunto == 0);
    }
  
  }
