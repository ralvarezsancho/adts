package adts;

/**
 * @author Ricardo Alvarez Sancho
 * @version 1.0.0
 */
public class IteratorArrayImpl<E> implements Iterator<E> {
	
	private static final long serialVersionUID = Utilities.getSerialVersionUID();
	
	private E[] elements;
	private int size;
	private int index;
	
	public IteratorArrayImpl(E[] elements, int size, int first) {
		this.elements = elements;
		this.size = size;
		index = first;
	}
	
	public boolean isNext() { return size > 0; }
	
	public E next() {
		E e = elements[index];
		index++;
		if (index == elements.length) index = 0;
		size--;
		return e;
	}

}
