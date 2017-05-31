import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestyJednostkoweStos {

	Stos stos;
	@Before
	public void prepare() {
		stos = new Stos();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testPop() throws NoSuchElementException{
		stos.pop();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testTop() throws NoSuchElementException{
		stos.top();
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(stos.isEmpty());
	}
	
	@Test
	public void testDodania() {
		String s= "abc";
		stos.push(s);
		for(int i=0;i<10;i++) {
			assertEquals("abc",stos.top());
		}
		assertFalse(stos.isEmpty());
	}
	

	@Test(expected=NoSuchElementException.class)
	public void testUsuniecia() throws NoSuchElementException{
		String s= "abc";
		stos.push(s);
		assertSame(s,stos.pop());
		assertTrue(stos.isEmpty());
		stos.pop();
	}
	
	@Test
	public void testUsuniecia2() {
		String [] tab= {"a","b","c"};
		for(int i=0;i<tab.length;i++) {
			stos.push(tab[i]);
		}
		for(int i=stos.size()-1;i>=0;i--) {
			assertSame(tab[i],stos.pop());
		}
	}
	
	@Test
	public void testOdlozenieNull() {
		stos.push(null);
		assertEquals(null,stos.pop());
	}
	
	@Test
	public void testWyjatku() {
		try {
			stos.top();
		}
		catch(Exception e) {	
			e.printStackTrace();
		}
		String s="abc";
		stos.push(s);
		assertEquals(s,stos.top());
	}
	
	@After
	public void clean() {
		stos=null;
	}

}
