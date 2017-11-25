package adts;

public interface IteratorBidirectional<E> extends Iterator<E> {
	
	public boolean isPrevious();
	
	public E previous() throws ExceptionInvalidIndex;

}
