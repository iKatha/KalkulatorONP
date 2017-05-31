import java.util.LinkedList;

public class Stos<T> {
	
	private LinkedList<T> stos = new LinkedList<T>();
	public void push(T e) { stos.addFirst(e); }
	public T top() { return stos.getFirst(); }
	public T pop() { return stos.removeFirst(); }
	public boolean isEmpty() { return stos.isEmpty(); }
	public String toString() { return stos.toString(); }
	public int size() {return stos.size();}
	
}
