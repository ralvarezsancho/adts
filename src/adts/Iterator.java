package adts;

import java.io.Serializable;

/**
 * @author Ricardo Alvarez Sancho
 * @version 1.0.0
 */
public interface Iterator<E> extends Serializable {
	
	public boolean isNext();
	
	public E next() throws ExceptionInvalidIndex;

}
