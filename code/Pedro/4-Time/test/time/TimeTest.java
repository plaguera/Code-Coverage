package time;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
* @author Pedro Miguel Lagüera Cabrera
* Email: laguerapedro@gmail.com
* Mar 16, 2017
* Time.java
*/
public class TimeTest {
	
	private Time time;

	@Before
	public void setUp() throws Exception {
		time = new Time(59, 59, 23);
	}

	/** Tests for previous and next second methods */
	@Test
	public void testSecond() {
		assertEquals(time.nextSecond().toString(), "0:0:0");			/* setSecond throws an exception */
		assertEquals(time.previousSecond().toString(), "23:59:59");		/* setSecond throws an exception */
		assertEquals(time.previousSecond().toString(), "23:59:58");
		assertEquals(time.nextSecond().toString(), "23:59:59");
	}
	
	/** Tests for previous and next minute methods */
	@Test
	public void testMinute() {
		assertEquals(time.nextMinute().toString(), "0:0:59");			/* setMinute throws an exception */
		assertEquals(time.previousMinute().toString(), "23:59:59");		/* setMinute throws an exception */
		assertEquals(time.previousMinute().toString(), "23:58:59");
		assertEquals(time.nextMinute().toString(), "23:59:59");
	}
	
	/** Tests for previous and next hour methods */
	@Test
	public void testHour() {
		assertEquals(time.nextHour().toString(), "0:59:59");			/* setHour throws an exception */
		assertEquals(time.previousHour().toString(), "23:59:59");		/* setHour throws an exception */
		assertEquals(time.previousHour().toString(), "22:59:59");
		assertEquals(time.nextHour().toString(), "23:59:59");
	}
	
	/** Tests getters for the Time Class */
	@Test
	public void testGetters() {
		assertEquals(time.getSecond(), 59);
		assertEquals(time.getMinute(), 59);
		assertEquals(time.getHour(), 23);
	}

}
