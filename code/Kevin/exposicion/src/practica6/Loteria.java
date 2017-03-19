package practica6;
/**
 * Fichero: Loteria.java<br>
 * Fecha: 13/03/2017<br>
 * Asignatura: Programación de Aplicaciones Interactivas<br>
 * Práctica: 6, Fundamentos de interfaces gráficas de usuario<br>
 * Email: alu0100880625@ull.edu.es<br>
 * Finalidad de la clase: representar una lotería
 * @author Kevin Díaz Marrero
 */
public class Loteria {
  
  public static final int PRIMER_PREMIO = 10000;  /** constante que indica el primer premio */
  public static final int SEGUNDO_PREMIO = 3000;  /** constante que indica el primer segundo */
  public static final int TERCER_PREMIO = 2000;   /** constante que indica el primer tercer */
  public static final int CUARTO_PREMIO = 1000;   /** constante que indica el primer cuarto */
  public static final int NUMERO_CIFRAS = 3;      /** constante que indica el número de cifras */
  public static final int ULTIMO_NUMERO = 999;    /** constante que indica el número máximo */
  public static final int PRIMER_NUMERO = 0;      /** constante que indica el número mínimo */
  public static final int PREMIO_NULO = 0;               /** constante que indica que no hay premio*/
  
  private int numeroGanador;                      /** almacena el número ganador */
  
  public Loteria(){
    numeroGanador = (int)(Math.random() * (10 * NUMERO_CIFRAS));
  }
  
  public int getNumeroGanador(){
    return(numeroGanador);
  }
  
  public void setNumeroGanador(int numeroGanador){
    this.numeroGanador = numeroGanador;
    if(this.numeroGanador < 0)
      this.numeroGanador *= -1;
    if(this.numeroGanador > ULTIMO_NUMERO)
      throw new IllegalArgumentException("número inválido");
  }
  
  /** retorna el premio para ese número */
  public int getPremio(int numero){
    if(numero < PRIMER_NUMERO)
      numero *= -1;
    if(numero > ULTIMO_NUMERO)
      throw new IllegalArgumentException("El número debe ser de 3 cifras como máximo");
    if(getNumeroGanador() == numero)
      return(PRIMER_PREMIO);
    String numeroGanadorString = Integer.toString(getNumeroGanador());
    while(numeroGanadorString.length() != NUMERO_CIFRAS)
      numeroGanadorString = "0" + numeroGanadorString;
    String numeroJugador = Integer.toString(numero);
    while(numeroJugador.length() != NUMERO_CIFRAS)
      numeroJugador = "0" + numeroJugador;
    int contadorCoincidencias = 0;
    boolean [] coincidencias = new boolean[NUMERO_CIFRAS];
    for(int i = 0; i < NUMERO_CIFRAS; i++)
      for(int j = 0; j < NUMERO_CIFRAS && !coincidencias[i]; j++)
        if(numeroGanadorString.charAt(i) == numeroJugador.charAt(j)){
          coincidencias[i] = true;
          contadorCoincidencias++;
        }
    if(contadorCoincidencias == 3)
      return(SEGUNDO_PREMIO);
    if(contadorCoincidencias == 2)
      return(TERCER_PREMIO);
    if(contadorCoincidencias == 1)
      return(CUARTO_PREMIO);
    return(PREMIO_NULO);
  }
}
