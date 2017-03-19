package tipos;

/**
 * @author Pedro Miguel Lagüera Cabrera
 * Email: laguerapedro@gmail.com
 * Mar 21, 2017
 * Racional.java
 */
public class Racional {
	
	/**
	 * Atributos que guardan los valores del numerador y el denominador.
	 */
	private int numerador, denominador;
	
	/**
	 * Constructor por defecto crea un número racional 1/1.
	 */
	public Racional(){
		this(1,1);
	}
	
	/**
	 * Constructor que crea el número racional a partir de los parámetros
	 * y comprueba si el denominador es 0, en cuyo caso lanza una excepción.
	 * @param num_p Numerador
	 * @param den_p Denominador
	 */
	public Racional(int num_p, int den_p){
		numerador = num_p;
		if (den_p == 0)
		    throw new IllegalArgumentException("Denominador es 0");
		denominador = den_p;
	}
	
	/**
	 * Permite mostrar por pantalla el objeto de manera formateada.
	 */
	public String toString(){
		return numerador + "/" + denominador;
	}
	
	/**
	 * Dado que numerador es 'private' se usará un getter para leerlo desde fuera del ámbito de la clase.
	 * @return Numerador
	 */
	public int getNum(){
		return numerador;
	}
	
	/**
	 * Dado que denominador es 'private' se usará un getter para leerlo desde fuera del ámbito de la clase.
	 * @return Denominador
	 */
	public int getDen(){
		return denominador;
	}
	
	/**
	 * Dado que numerador es 'private' se usará un setter para cambiarlo desde fuera del ámbito de la clase.
	 * @param nuevoNum Nuevo valor de 'numerador'
	 */
	public void setNum(int nuevoNum){
		numerador = nuevoNum;
	}
	
	/**
	 * Dado que denominador es 'private' se usará un setter para cambiarlo desde fuera del ámbito de la clase.
	 * @param nuevoDen Nuevo valor de 'denominador'
	 */
	public void setDen(int nuevoDen){
		denominador = nuevoDen;
	}
	
	/**
	 * Suma implícita del número racional pasado como parámetro y el propio objeto que hace la llamada
	 * @param b Número Racional a sumar.
	 * @return Un nuevo objeto Racional que vale la suma de 'this' y 'b'.
	 */
	public Racional suma(Racional b){
		int num = (numerador * b.denominador) + (b.numerador * denominador);
		int den = denominador * b.denominador;
		Racional resultado = new Racional(num, den);
		return resultado;
	}
	
	/**
	 * Resta implícita del número racional pasado como parámetro y el propio objeto que hace la llamada
	 * @param b Número Racional a restar.
	 * @return Un nuevo objeto Racional que vale la resta de 'this' y 'b'.
	 */
	public Racional resta(Racional b){
		int num = (numerador * b.denominador) - (b.numerador * denominador);
		int den = denominador * b.denominador;
		Racional resultado = new Racional(num, den);
		return resultado;
	}
	
	/**
	 * Producto implícito del número racional pasado como parámetro y el propio objeto que hace la llamada
	 * @param b Número Racional a multiplicar.
	 * @return Un nuevo objeto Racional que vale el producto de 'this' y 'b'.
	 */
	public Racional producto(Racional b){
		int num = numerador * b.numerador;
		int den = denominador * b.denominador;
		Racional resultado = new Racional(num, den);
		return resultado;
	}
	
	/**
	 * División implícita del número racional pasado como parámetro y el propio objeto que hace la llamada
	 * @param b Número Racional a dividir.
	 * @return Un nuevo objeto Racional que vale la dividisión de 'this' y 'b'.
	 */
	public Racional division(Racional b){
		int num = numerador * b.denominador;
		int den = denominador * b.numerador;
		Racional resultado = new Racional(num, den);
		return resultado;
	}
	
	public static Racional suma(Racional sumando1, Racional sumando2){
		return sumando1.suma(sumando2);
	}
	
	public static Racional resta(Racional minuendo, Racional sustraendo){
		return minuendo.resta(sustraendo);
	}
	
	public static Racional producto(Racional op1, Racional op2){
		return op1.producto(op2);
	}
	
	public static Racional division(Racional dividendo, Racional divisor){
		return dividendo.division(divisor);
	}
	
	public boolean equals(Racional b){
		return denominador == b.getDen() && numerador == b.getNum();
	}
	

}
