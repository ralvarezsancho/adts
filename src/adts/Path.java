package adts;

import java.io.Serializable;

/**
 * @author Ricardo Alvarez Sancho
 * @version 1.0.0
 */
public interface Path<E> extends Serializable {
	
	public boolean isNext();
	
	public Position<E> next() throws ExceptionInvalidIndex;

}
