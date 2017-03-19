package tipos;

/**
 * @author Pedro Miguel Lagüera Cabrera
 * Email: laguerapedro@gmail.com
 * Feb 21, 2017
 * Complejo.java
 */
public class Complejo {
    // La representación de un número Complejo: parte real e imaginaria
    private Racional real;
    private Racional imag;
    
    /** Constructor para objetos Complejo vacíos */
    public Complejo(){
    	this(new Racional(), new Racional());
    }

    /** Constructor en el que se proporciona parte real e imaginaria */
    public Complejo(Racional re, Racional im){
		real = re;
		imag = im;
    }

    /**
     * producto(complejo1, complejo2)->complejo sobrecarga producto(racional1, racional2)->racional
     * @param  c1, c2 los dos factores
     * @return el número complejo producto de c1 y c2 
     */
    public static Complejo producto(Complejo c1, Complejo c2){
    	Racional realAux = Racional.resta(Racional.producto(c1.real, c2.real), Racional.producto(c1.imag, c2.imag));
    	Racional imagAux = Racional.suma(Racional.producto(c1.real, c2.imag), Racional.producto(c1.imag, c2.real));
    	return new Complejo(realAux, imagAux);
    }

    /**
     * division(complejo1, complejo2)->complejo sobrecarga division(racional1, racional2)->racional
     * @param c1, c2 dividendo y divisor
     * @return el cociente entre c1 y c2 
     */
    public static Complejo division(Complejo c1,  Complejo c2){
    	Racional realAuxDivid = Racional.suma(Racional.producto(c1.real, c2.real), Racional.producto(c1.imag, c2.imag));
    	Racional imagAuxDivid = Racional.resta(Racional.producto(c1.imag, c2.real), Racional.producto(c1.real, c2.imag));
    	
    	Racional auxDivisor = Racional.suma(Racional.producto(c2.real, c2.real), Racional.producto(c2.imag, c2.imag));
    	
    	Racional realAux = Racional.division(realAuxDivid, auxDivisor);
    	Racional imagAux = Racional.division(imagAuxDivid, auxDivisor);
    	
    	return new Complejo(realAux, imagAux);
    }

    /**
     * suma (complejo1, complejo2)->complejo sobrecarga suma(racional1, racional2)->racional
     * @param c1, c2 son los dos sumandos
     * @return la suma de c1 y c2 
     */
    public static Complejo suma(Complejo c1, Complejo c2){
    	Racional realAux = Racional.suma(c1.real, c2.real);
    	Racional imagAux = Racional.suma(c1.imag, c2.imag);
    	return new Complejo(realAux, imagAux);
    }

    /**
     * resta(complejo1, complejo2)->complejo sobrecarga resta(racional1, racional2)->racional
     * @param c1, c2 Minuendo y sustraendo
     * @return la diferencia entre c1 y c2 
     */
    public static Complejo resta(Complejo c1, Complejo c2){
    	Racional realAux = Racional.resta(c1.real, c2.real);
    	Racional imagAux = Racional.resta(c1.imag, c2.imag);
    	return new Complejo(realAux, imagAux);
    }

    /**
     * Calcula el conjugado de c
     * @param c número complejo con componentes racionales {re, im}
     * @return el complejo conjugado de c, {re, -im} (un cambio de signo en la parte imaginaria) 
     */
    public static Complejo conjugado(Complejo c){
    	return new Complejo(c.real, Racional.producto(c.imag, new Racional(-1,1)));
    }
    
    /** @return the real */
	public Racional getReal() {
		return real;
	}

	/** @return the imag */
	public Racional getImag() {
		return imag;
	}

	public String toString() {
    	return real + " + " + imag + "i";
    }

}
