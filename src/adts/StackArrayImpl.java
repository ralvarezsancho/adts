package adts;

/**
 * @author Ricardo Alvarez Sancho
 * @version 1.0.0
 */
public class StackArrayImpl<E> implements Stack<E>, ContainerFit<E> {
	
	private static final long serialVersionUID = Utilities.getSerialVersionUID();
	
	public static final int MAXIMUM_DEFAULT_ELEMENTS = 256;
	
	protected int n;
	
	protected E[] elements;
	
	public StackArrayImpl() {
		this(MAXIMUM_DEFAULT_ELEMENTS);
	}
	
	public StackArrayImpl(int max) {
		elements = (E[]) new Object[max];
		n = 0;
	}
	
	public int size() { return n; }
	
	public boolean isEmpty() { return (n == 0); }
	
	public boolean isFull() { return (n == elements.length); }
	
	public void push(E e) {
		if (isFull()) throw new ExceptionFullContainer();
		elements[n] = e;
		n++;
	}
	
	public E pop() {
		if (isEmpty()) throw new ExceptionEmptyContainer();
		E aux = elements[n-1];
		elements[n-1] = null;
		n--;
		return aux;
	}
	
	public E top() {
		return elements[n-1];
	}
	
	public Iterator<E> elements() {
		return new IteratorArrayImpl<E> (elements, size(), 0);
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("STACK:");
		for (Iterator it = elements(); it.isNext();) {
			buffer.append(it.next());
			if (it.isNext()) buffer.append(',');
		}
		buffer.append("}");
		return buffer.toString();
	}

}
