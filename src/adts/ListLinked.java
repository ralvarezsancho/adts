package adts;

public class ListLinked<E> implements List<E> {
	
	private static final long serialVersionUID = Utilities.getSerialVersionUID();
	
	protected int n;
	
	protected NodeLinked<E> last;
	
	public ListLinked() {
		last = null;
		n = 0;
	}
	
	public int size() { return n; }
	
	public boolean isEmpty() { return (n == 0); }
	
	public Position<E> addFirst(E e) { return newPosition(last, e); }
	
	public Position<E> addLast(E e) {
		last = newPosition(last, e);
		return last;
	}
	
	public Position<E> addBefore(Position<E> node, E e) {
		Position<E> newNode;
		NodeLinked<E> previousNode = previous((NodeLinked<E>) node);
		if (previousNode == last) { newNode = addFirst(e); }
		else { newNode = addAfter(previousNode, e); }
		return newNode;
	}
	
	public Position<E> addAfter(Position<E> node, E e) {
		Position<E> newNode;
		if (last == node) { newNode = addLast(e); }
		else { newNode = newPosition((NodeLinked<E>) node, e); }
		return newNode;
	}
	
	public E removeFirst() {
		if (isEmpty()) throw new ExceptionEmptyContainer();
		NodeLinked<E> first = last.getNext();
		if (n == 1) { last = null; }
		else { last.setNext(first.getNext());}
		n--;
		return first.getElem();
	}
	
	public E remove(Position<E> node) {
		if (n == 1) last = null;
		else {
			NodeLinked<E> curr = (NodeLinked<E>)node;
			NodeLinked<E> prev = previous(curr);
			prev.setNext(curr.getNext());
			if (curr == last) { last = prev; }
		}
		n--;
		return node.getElem();
	}
	
	public E removeNext(Position<E> node) {
		if (node == last) throw new ExceptionInvalidIndex();
		E removeElem;
		if (node == null) removeElem = removeFirst();
		else {
			NodeLinked<E> curr = (NodeLinked<E>)node;
			NodeLinked<E> next = curr.getNext();
			curr.setNext(next.getNext());
			if (next == last) last = curr;
			removeElem = next.getElem();
			n--;
		}
		return removeElem;
	}
	
	public E change(Position<E> node, E e) {
		E old = node.getElem();
		((NodeLinked<E>)node).setElem(e);
		return old;
	}
	
	public void exchange(Position<E> node1, Position<E> node2) {
		E tmp = node1.getElem();
		((NodeLinked)node1).setElem(node2.getElem());
		((NodeLinked)node2).setElem(tmp);
	}
	
	protected NodeLinked<E> previous(NodeLinked<E> node) {
		NodeLinked<E> prev = last;
		boolean found = false;
		while (!found) {
			found = prev.getNext() == node;
			if (!found) prev = prev.getNext();
		}
		return prev;
	}
	
	protected NodeLinked<E> newPosition(NodeLinked<E> node, E e) {
		NodeLinked<E> newNode = null;
		if (node == null) {
			newNode = new NodeLinked<E>(e, null);
			newNode.setNext(newNode);
			last = newNode;
		} else {
			newNode = new NodeLinked<E>(e, node.getNext());
			node.setNext(newNode);
		}
		n++;
		return newNode;
	}
	
	public Iterator<E> elements() { return new IteratorPathImpl<E, E>(positions()); }
	
	public Path<E> positions() { return new PathUnidirectionalList<E>(this); }
		
	protected static class NodeLinked<E> implements Position<E> {
		
		private static final long serialVersionUID = Utilities.getSerialVersionUID();
		
		private E element;
		
		protected NodeLinked<E> next;
		
		public NodeLinked() {
			element = null;
			next = null;
		}
		
		public NodeLinked(E e) {
			element = e;
			next = null;
		}
		
		public NodeLinked(E e, NodeLinked<E> n) {
			element = e;
			next = n;
		}
		
		public void setElem(E e) { element = e; }
		
		public E getElem() { return element; }
		
		public void setNext(NodeLinked<E> n) { next = n; }
		
		public NodeLinked<E> getNext() { return next; }
		
		public String toString() {
			return "[NodeLinked: " + ((element == null) ? "null" : element.toString()) + "]";
		}
	}

	
	
	protected static class PathUnidirectionalList<E> implements Path<E> {
		
		private static final long serialVersionUID = Utilities.getSerialVersionUID();
		
		protected NodeLinked<E> currentNode;
		
		protected NodeLinked<E> last;
		
		protected boolean isNext;
		
		public PathUnidirectionalList(ListLinked<E> l) {
			currentNode = l.last;
			last = l.last;
			isNext = (currentNode != null);
		}
		
		public boolean isNext() { return isNext; }
		
		public Position<E> next() {
			if (!isNext()) throw new ExceptionInvalidIndex();
			currentNode = currentNode.getNext();
			isNext = (currentNode != last);
			return currentNode;
		}
	}
}
