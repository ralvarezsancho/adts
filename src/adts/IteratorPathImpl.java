package adts;

public class IteratorPathImpl<E1, E2> implements Iterator<E1>{
	
	private static final long serialVersionUID = Utilities.getSerialVersionUID();
	
	protected Path<E2> path;
	
	public IteratorPathImpl(Path<E2> p) {
		this.path = p;
	}
	
	public boolean isNext() { return path.isNext(); }
	
	public E1 next() throws ExceptionInvalidIndex {
		return getElem(path.next());
	}
	
	protected E1 getElem(Position<E2> p) {
		return (E1)p.getElem();
	}

}
