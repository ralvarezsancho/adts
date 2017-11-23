package adts;

public interface List<E> extends Container<E> {
	
	public Position<E> addFirst(E e);
	
	public Position<E> addLast(E e);
	
	public Position<E> addBefore(Position<E> p, E e);
	
	public Position<E> addAfter(Position<E> p, E e);
	
	public E removeFirst();
	
	public E remove(Position<E> p);
	
	public E removeNext(Position<E> p);
	
	public E change(Position<E> p, E e);
	
	public void exchange(Position<E> p1, Position<E> p2);
	
	public Path<E> positions();

}
