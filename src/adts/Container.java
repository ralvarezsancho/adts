package adts;

import java.io.Serializable;

/**
 * @author Ricardo Alvarez Sancho
 * @version 1.0.0
 */
public interface Container<E> extends Serializable {
	
	public boolean isEmpty();
	
	public int size();
	
	public Iterator<E> elements();

}
