package practica6;


/**
 * Fichero: ParseHexadecimal.java<br>
 * Fecha: 13/03/2017<br>
 * Asignatura: Programación de Aplicaciones Interactivas<br>
 * Práctica: 6, Fundamentos de interfaces gráficas de usuario<br>
 * Email: alu0100880625@ull.edu.es<br>
 * Finalidad de la clase: encapsular el uso de números hexadecimales
 * @author Kevin Díaz Marrero
 */
public class ParseHexadecimal {
  public static final int PRIMER_DIGITO = 2;        /** primer dígito (despues del 0x */
  public static final int BASE_HEXADECIMAL = 16;    /** base hexadecimal */
  
  public static int hex2Decimal(String cadena){
    if(cadena.length() < 3 || cadena.charAt(0) != '0' || cadena.charAt(1) != 'x')
      throw new NumberFormatException("El número hexadecimal debe empezar por 0x.");
    int numero = 0;
    int base = 1;
    for(int i = cadena.length() - 1 ; i >= PRIMER_DIGITO; i--){
      numero += valorDigito(cadena.charAt(i)) * base;
      base *= BASE_HEXADECIMAL;
    }
    return(numero);
  }
  
  /** método que indica el valor del dígito hexadecimal */
  public static int valorDigito(char digito){
    int valor = 0;
    switch(digito){
      case '0':
        valor = 0;
        break;
      case '1':
        valor = 1;
        break;
      case '2':
        valor = 2;
        break;
      case '3':
        valor = 3;
        break;
      case '4':
        valor = 4;
        break;
      case '5':
        valor = 5;
        break;
      case '6':
        valor = 6;
        break;
      case '7':
        valor = 7;
        break;
      case '8':
        valor = 8;
        break;
      case '9':
        valor = 9;
        break;
      case 'A':
      case 'a':
        valor = 10;
        break;
      case 'B':
      case 'b':
        valor = 11;
        break;
      case 'C':
      case 'c':
        valor = 12;
        break;
      case 'D':
      case 'd':
        valor = 13;
        break;
      case 'E':
      case 'e':
        valor = 14;
        break;
      case 'F':
      case 'f':
        valor = 15;
        break;
      default:
        throw new NumberFormatException("El número hexadecimal solo puede contener: 0123456789ABCDEF");
    }
    return(valor);
  }

}
