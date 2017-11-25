package adts;

public interface PathBidirectional<E> {
	
	public enum PathInit { BEGINNING, END };
	
	public boolean isPrevious();
	
	public Position<E> previous() throws ExceptionInvalidIndex;

}
