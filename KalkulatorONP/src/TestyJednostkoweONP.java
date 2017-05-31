import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestyJednostkoweONP {

	SterownikONP onp;
	String wyrazenie;
	@Before
	public void prepare() {
		onp = new SterownikONP();
	}
	@Test
	public void testDodawanie() throws ArithmeticException, Exception {
		assertEquals(10,onp.obliczONP(onp.zamienNaONP("5+5=")),0.00000001);
		assertEquals(10,onp.obliczONP(onp.zamienNaONP("(5+5)=")),0.00000001);
		assertEquals(20,onp.obliczONP(onp.zamienNaONP("5+5+10=")),0.00000001);
		assertEquals(1.1,onp.obliczONP(onp.zamienNaONP("0.5+0.6=")),0.0001);
	}
	
	@Test
	public void testOdejmowanie() throws ArithmeticException, Exception {
		assertEquals(5,onp.obliczONP(onp.zamienNaONP("6-1=")),0.00000001);
		assertEquals(1,onp.obliczONP(onp.zamienNaONP("(3-2)=")),0.00000001);
		assertEquals(13,onp.obliczONP(onp.zamienNaONP("30-15-2=")),0.00000001);
		assertEquals(10,onp.obliczONP(onp.zamienNaONP("10.6-0.6=")),0.0001);
	}
	@Test
	public void testMnozenie() throws ArithmeticException, Exception {
		assertEquals(6,onp.obliczONP(onp.zamienNaONP("2x3=")),0.0001);
		assertEquals(8,onp.obliczONP(onp.zamienNaONP("(8x1)=")),0.0001);
		assertEquals(40,onp.obliczONP(onp.zamienNaONP("5x2x4=")),0.0001);
		assertEquals(7,onp.obliczONP(onp.zamienNaONP("3.5x2=")),0.0001);
	}
	
	@Test
	public void testDzielenie() throws ArithmeticException, Exception {
		assertEquals(2,onp.obliczONP(onp.zamienNaONP("6/3=")),0.00000001);
		assertEquals(1,onp.obliczONP(onp.zamienNaONP("(3/3)=")),0.00000001);
		assertEquals(5,onp.obliczONP(onp.zamienNaONP("100/10/2=")),0.00000001);
		assertEquals(20,onp.obliczONP(onp.zamienNaONP("10/0.5=")),0.0001);
	}
	@Test
	public void testSilnia() throws ArithmeticException, Exception {
		assertEquals(6,onp.obliczONP(onp.zamienNaONP("3!=")),0.00000001);
	}
	@Test
	public void testPierwiastkowanie() throws ArithmeticException, Exception {
		assertEquals(2,onp.obliczONP(onp.zamienNaONP("4v2=")),0.00000001);
		assertEquals(4,onp.obliczONP(onp.zamienNaONP("(64v3)=")),0.00000001);
		assertEquals(25,onp.obliczONP(onp.zamienNaONP("5v0.5=")),0.0001);
	}
	
	@Test
	public void testPotegowanie() throws ArithmeticException, Exception {
		assertEquals(8,onp.obliczONP(onp.zamienNaONP("2^3=")),0.00000001);
		assertEquals(49,onp.obliczONP(onp.zamienNaONP("(7^2)=")),0.00000001);
		assertEquals(64,onp.obliczONP(onp.zamienNaONP("2^2^3=")),0.00000001);
		assertEquals(2,onp.obliczONP(onp.zamienNaONP("4^0.5=")),0.0001);
	}
	
	@Test
	public void testModulo() throws ArithmeticException, Exception {
		assertEquals(0,onp.obliczONP(onp.zamienNaONP("6%3=")),0.00000001);
		assertEquals(1,onp.obliczONP(onp.zamienNaONP("(5%4)=")),0.00000001);
		assertEquals(0.5,onp.obliczONP(onp.zamienNaONP("8.5%4=")),0.0001);
	}
	
	@After
	public void clean() {
		onp=null;
	}

}
