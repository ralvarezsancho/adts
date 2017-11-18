package adts;

import java.io.Serializable;

/**
 * @author Ricardo Alvarez Sancho
 * @version 1.0.0
 */
public interface Position<E> extends Serializable {
	
	public E getElem();

}
