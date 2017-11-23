package adts;


public abstract class SetAbstract<E> implements Set<E> {
	
	public void union(Set<E> s) {
		Iterator<E> it = s.elements();
		while (it.isNext()) add(it.next());
	}
	
	public void intersect(Set<E> s) {
		List<E> elementsToDelete = new ListLinked<E>();
		Iterator<E> it = elements();
		while (it.isNext()) {
			E e = it.next();
			if (!s.member(e)) {
				elementsToDelete.addLast(e);
			}
		}
	}

}
