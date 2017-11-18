package adts;

/**
 * @author Ricardo Alvarez Sancho
 * @version 1.0.0
 */
public interface Stack<E> extends Container<E> {
	
	public void push(E e);
	
	public E pop();
	
	public E top();

}
