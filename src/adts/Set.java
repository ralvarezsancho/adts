package adts;

public interface Set<E> extends Container<E> {
	
	public void add(E e);
	
	public boolean member(E e);
	
	public E remove(E e);
	
	public void union(Set<E> s);
	
	public void intersect(Set<E> s);
	
	public void difference(Set<E> s);

}
