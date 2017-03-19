/**
 * 
 */
package tipos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Pedro Miguel Lagüera Cabrera
 * Email: laguerapedro@gmail.com
 * Mar 12, 2017
 * RacionalTest.java
 */
public class RacionalTest {

	private Racional racionalA;
	private Racional racionalB;
	private Racional racionalC;
	private Racional racionalD;
	
	@Before
	public void setUp() throws Exception {
		racionalA = new Racional(27, 2);
		racionalB = new Racional(9, -17);
		racionalC = new Racional();
		racionalD = new Racional(-3, 7);
	}

	@Test
	public void testConst() {
		try {
			racionalD = new Racional(0, 0);
		} catch(Exception e){
			System.out.println("Exception Caught !!");
		}
	}
	
	@Test
	public void testGettersSetters() {
		racionalA.setNum(43);
		racionalA.setDen(27);
		racionalC.setNum(-65);
		racionalC.setDen(-10328);
		assertEquals(racionalA.getNum(), 43);
		assertEquals(racionalA.getDen(), 27);
		assertEquals(racionalB.getNum(), 9);
		assertEquals(racionalB.getDen(), -17);
		assertEquals(racionalC.getNum(), -65);
		assertEquals(racionalC.getDen(), -10328);
		assertEquals(racionalD.getNum(), -3);
		assertEquals(racionalD.getDen(), 7);
	}
	
	@Test
	public void testToString() {
		
		assertEquals(racionalA.toString(), "27/2");
		assertEquals(racionalB.toString(), "9/-17");
		assertEquals(racionalC.toString(), "1/1");
		assertEquals(racionalD.toString(), "-3/7");
	}
	
	@Test
	public void testSuma() {
		assertEquals(Racional.suma(racionalA, racionalB).toString(), "-441/-34");
		assertEquals(Racional.suma(racionalB, racionalC).toString(), "-8/-17");
		assertEquals(Racional.suma(racionalA, racionalD).toString(), "183/14");
		assertEquals(Racional.suma(racionalD, racionalC).toString(), "4/7");
	}
	
	@Test
	public void testResta() {
		
		assertEquals(Racional.resta(racionalA, racionalB).toString(), "-477/-34");
		assertEquals(Racional.resta(racionalB, racionalC).toString(), "26/-17");
		assertEquals(Racional.resta(racionalA, racionalD).toString(), "195/14");
		assertEquals(Racional.resta(racionalD, racionalC).toString(), "-10/7");
	}
	
	@Test
	public void testProducto() {
		assertEquals(Racional.producto(racionalA, racionalB).toString(), "243/-34");
		assertEquals(Racional.producto(racionalB, racionalC).toString(), racionalB.toString());
		assertEquals(Racional.producto(racionalA, racionalD).toString(), "-81/14");
		assertEquals(Racional.producto(racionalD, racionalC).toString(), racionalD.toString());
	}
	
	@Test
	public void testDivision() {
		assertEquals(Racional.division(racionalA, racionalB).toString(), "-459/18");
		assertEquals(Racional.division(racionalB, racionalC).toString(), racionalB.toString());
		assertEquals(Racional.division(racionalA, racionalD).toString(), "189/-6");
		assertEquals(Racional.division(racionalD, racionalC).toString(), racionalD.toString());
	}
	
	@Test
	public void testEquals() {
		assertFalse(racionalA.equals(racionalB));
		racionalA.setDen(-17);
		assertFalse(racionalA.equals(racionalB));
		racionalA = new Racional(9, -17);
		assertTrue(racionalA.equals(racionalB));
	}

}
