package adts;

public class IteratorPathBidirectionalImpl<E1, E2> extends IteratorPathImpl<E1, E2> implements IteratorBidirectional<E1> {
	
	private static final long serialVersionUID = Utilities.getSerialVersionUID();
	
	public IteratorPathBidirectionalImpl(Path<E2> p) {
		super(p);
	}
	
	public boolean isPrevious() { return ((PathBidirectional<E2>)path).isPrevious(); }
	
	public E1 previous() throws ExceptionInvalidIndex {
		Position<E2> position = ((PathBidirectional<E2>)path).previous();
		return (E1)getElem(position);
	}

}
