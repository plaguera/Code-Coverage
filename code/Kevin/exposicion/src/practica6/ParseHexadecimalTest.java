package practica6;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Fichero: ParseHexadecimalTest.java<br>
 * Fecha: 13/03/2017<br>
 * Asignatura: Programación de Aplicaciones Interactivas<br>
 * Práctica: 6, Fundamentos de interfaces gráficas de usuario<br>
 * Email: alu0100880625@ull.edu.es<br>
 * Finalidad de la clase: testear la clase ParseHexadecimal
 * @author Kevin Díaz Marrero
 */
public class ParseHexadecimalTest {
  
  /** pruebas del constructor */
  @Test
  public void constructorTest(){
    //assertTrue(ParseHexadecimal.hex2Decimal("0xF") == ParseHexadecimal.hex2Decimal("0xf"));
    //assertTrue(ParseHexadecimal.hex2Decimal("0xF") == 15);
    //assertTrue(ParseHexadecimal.hex2Decimal("0xF0") == ParseHexadecimal.hex2Decimal("0xF") * 16);
    //assertTrue(ParseHexadecimal.valorDigito('0') == 0);
    //assertTrue(ParseHexadecimal.valorDigito('1') == 1);
    //assertTrue(ParseHexadecimal.valorDigito('2') == 2);
    //assertTrue(ParseHexadecimal.valorDigito('3') == 3);
    //assertTrue(ParseHexadecimal.valorDigito('4') == 4);
    //assertTrue(ParseHexadecimal.valorDigito('5') == 5);
    //assertTrue(ParseHexadecimal.valorDigito('6') == 6);
    //assertTrue(ParseHexadecimal.valorDigito('7') == 7);
    //assertTrue(ParseHexadecimal.valorDigito('8') == 8);
    //assertTrue(ParseHexadecimal.valorDigito('9') == 9);
    //assertTrue(ParseHexadecimal.valorDigito('a') == 10);
    //assertTrue(ParseHexadecimal.valorDigito('A') == 10);
    //assertTrue(ParseHexadecimal.valorDigito('b') == 11);
    //assertTrue(ParseHexadecimal.valorDigito('B') == 11);
    //assertTrue(ParseHexadecimal.valorDigito('c') == 12);
    //assertTrue(ParseHexadecimal.valorDigito('C') == 12);
    //assertTrue(ParseHexadecimal.valorDigito('d') == 13);
    //assertTrue(ParseHexadecimal.valorDigito('D') == 13);
    //assertTrue(ParseHexadecimal.valorDigito('e') == 14);
    //assertTrue(ParseHexadecimal.valorDigito('E') == 14);
    //assertTrue(ParseHexadecimal.valorDigito('f') == 15);
    //assertTrue(ParseHexadecimal.valorDigito('F') == 15);
    /*
    try{
      ParseHexadecimal.valorDigito('x');
      fail("Error en valorDigito x");
    }catch(NumberFormatException e){
      assertTrue(true);
    }
    */
    /*
    try{
      ParseHexadecimal.hex2Decimal("0x");
      fail("Error en 0x");
    }catch(NumberFormatException e){
      assertTrue(true);
    }
    */
    /*
    try{
      ParseHexadecimal.hex2Decimal("");
      fail("Error en vacío");
    }catch(NumberFormatException e){
      assertTrue(true);
    }
    */
    /*
    try{
      ParseHexadecimal.hex2Decimal("0");
      fail("Error en 0x");
    }catch(NumberFormatException e){
      assertTrue(true);
    }
    */
    /*
    try{
      ParseHexadecimal.hex2Decimal("0xn");
      fail("Error en 0Xa");
    }catch(NumberFormatException e){
      assertTrue(true);
    }
    */
  }

}
