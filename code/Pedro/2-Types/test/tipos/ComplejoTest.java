package tipos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Pedro Miguel Lagüera Cabrera
 * Email: laguerapedro@gmail.com
 * Mar 12, 2017
 * ComplejoTest.java
 */
public class ComplejoTest {
	
	private Complejo complejoA;
	private Complejo complejoB;
	private Complejo complejoC;
	private Complejo complejoD;
	
	@Before
	public void setUp() throws Exception {
		complejoA = new Complejo(new Racional(27, 2), new Racional(34, -21));
		complejoB = new Complejo(new Racional(102, 1), new Racional(12, -7));
		complejoC = new Complejo();
		complejoD = new Complejo(new Racional(-7, -65), new Racional(-125, -3));
	}

	@Test
	public void testConst() {
		for(int i = 2; i >= 0; i--) {
			try {
				complejoD = new Complejo(new Racional(0, i), new Racional(0, i));
				if(i == 2)
					throw new Exception();
			} catch(IllegalArgumentException e){;}
			catch(Exception e){;}
			
		}
	}
	
	@Test
	public void testGettersSetters() {
		assertEquals(complejoA.getReal().toString(), "27/2"); 
		assertEquals(complejoA.getImag().toString(), "34/-21");
		assertEquals(complejoB.getReal().toString(), "102/1"); 
		assertEquals(complejoB.getImag().toString(), "12/-7"); 
		assertEquals(complejoC.getReal().toString(), "1/1"); 
		assertEquals(complejoC.getImag().toString(), "1/1"); 
		assertEquals(complejoD.getReal().toString(), "-7/-65"); 
		assertEquals(complejoD.getImag().toString(), "-125/-3"); 
	}
	
	@Test
	public void testToString() {
		assertEquals(complejoA.toString(), "27/2 + 34/-21i");
		assertEquals(complejoB.toString(), "102/1 + 12/-7i");
		assertEquals(complejoC.toString(), "1/1 + 1/1i");
		assertEquals(complejoD.toString(), "-7/-65 + -125/-3i");
	}
	
	@Test
	public void testSuma() {
		assertEquals(Complejo.suma(complejoA, complejoB).toString(), "231/2 + -490/147i");
		assertEquals(Complejo.suma(complejoB, complejoC).toString(), "103/1 + 5/-7i");
		assertEquals(Complejo.suma(complejoA, complejoD).toString(), "-1769/-130 + 2523/63i");
		assertEquals(Complejo.suma(complejoD, complejoC).toString(), "-72/-65 + -128/-3i");
	}
	
	@Test
	public void testResta() {
		assertEquals(Complejo.resta(complejoA, complejoB).toString(), "-177/2 + 14/147i");
		assertEquals(Complejo.resta(complejoB, complejoC).toString(), "101/1 + 19/-7i");
		assertEquals(Complejo.resta(complejoA, complejoD).toString(), "-1741/-130 + -2727/63i");
		assertEquals(Complejo.resta(complejoD, complejoC).toString(), "58/-65 + -122/-3i");
	}
	
	@Test
	public void testProducto() {
		assertEquals(Complejo.producto(complejoA, complejoB).toString(), "404022/294 + -55356/294i");
		assertEquals(Complejo.producto(complejoB, complejoC).toString(), "-726/-7 + -702/-7i");
		assertEquals(Complejo.producto(complejoA, complejoD).toString(), "-564407/-8190 + -4605447/-8190i");
		assertEquals(Complejo.producto(complejoD, complejoC).toString(), "-8104/195 + 8146/195i");
	}
	
	@Test
	public void testDivision() {
		assertEquals(Complejo.division(complejoA, complejoB).toString(), "19877046/149922360 + -2045652/149922360i");
		assertEquals(Complejo.division(complejoB, complejoC).toString(), "-702/-14 + 726/-14i");
		assertEquals(Complejo.division(complejoA, complejoD).toString(), "-918787655/494298756 + -862937561/494298756i");
		assertEquals(Complejo.division(complejoD, complejoC).toString(), "8146/390 + 8104/390i");
	}
	
	@Test
	public void testConjugado() {
		assertEquals(Complejo.conjugado(complejoA).toString(), "27/2 + -34/-21i");
		assertEquals(Complejo.conjugado(complejoB).toString(), "102/1 + -12/-7i");
		assertEquals(Complejo.conjugado(complejoC).toString(), "1/1 + -1/1i");
		assertEquals(Complejo.conjugado(complejoD).toString(), "-7/-65 + 125/-3i");
	}
	
}
