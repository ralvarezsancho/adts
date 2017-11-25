package adts;

import adts.PathBidirectional.PathInit;

public class ListDoubleLinked<E> extends ListLinked<E> {
	
	private static final long serialVersionUID = Utilities.getSerialVersionUID();
	
	public E removeFirst() throws ExceptionEmptyContainer {
		if (isEmpty()) throw new ExceptionEmptyContainer();
		NodeDoubleLinked<E> first = (NodeDoubleLinked)last.getNext();
		if (n == 1 ) last = null;
		else {
			NodeDoubleLinked<E> second = (NodeDoubleLinked<E>)first.getNext();
			removeMiddleNode((NodeDoubleLinked<E>)last, first, second);
		}
		n--;
		return first.getElem();
	}
	
	public E remove(Position<E> node) {
		NodeDoubleLinked<E> current = (NodeDoubleLinked<E>)node;
		if (n == 1) { last = null; }
		else {
			NodeDoubleLinked<E> next = (NodeDoubleLinked<E>)current.getNext();
			NodeDoubleLinked<E> prev = (NodeDoubleLinked<E>)current.getPrevious();
			removeMiddleNode(prev, current, next);
		}
		n--;
		return current.getElem();
	}
	
	public E removeNext(Position<E> node) {
		if (node == last) throw new ExceptionInvalidIndex();
		E removedElem;
		if (node == null) { removedElem = removeFirst(); }
		else {
			NodeDoubleLinked<E> current = (NodeDoubleLinked<E>)node;
			NodeDoubleLinked<E> next = (NodeDoubleLinked<E>)current.getNext();
			NodeDoubleLinked<E> nextNext = (NodeDoubleLinked<E>)next.getNext();
			removeMiddleNode(current, next, nextNext);
			if (next == last) { last = current; }
			removedElem = next.getElem();
		}
		n--;
		return removedElem;
	}
	
	public NodeLinked<E> previous(NodeLinked<E> node) {
		return ((NodeDoubleLinked<E>)node).getPrevious();
	}
	
	private void removeMiddleNode(NodeDoubleLinked<E> prev, NodeDoubleLinked<E> mid, NodeDoubleLinked<E> next) {
		prev.setNext(next);
		next.setPrevious(prev);
		mid.setPrevious(null);
		mid.setNext(null);
		if (mid == prev) last = prev;
	}
	
	protected NodeLinked<E> newPosition(NodeLinked<E> node, E e) {
		NodeDoubleLinked<E>newNode = null;
		if (node == null) {
			newNode = new NodeDoubleLinked<E>(e);
			newNode.setNext(newNode);
			newNode.setPrevious(newNode);
			last = newNode;
		} else {
			NodeDoubleLinked<E> current = (NodeDoubleLinked<E>)node;
			NodeDoubleLinked<E> next = (NodeDoubleLinked<E>)current.getNext();
			newNode = new NodeDoubleLinked<E>(next, e, (NodeDoubleLinked<E>)node);
			node.setNext(newNode);
			next.setPrevious(newNode);
		}
		n++;
		return newNode;
	}
	
/*	public IteratorBidirectional<E> elements(PathInit i) {
		return new ItertorPathBidirectionalImpl<E, E>(positions(i));
	}*/
	
	public PathBidirectional<E> positions(PathInit i) { return new PathBidirectionalList<E>(this, i); }
	
	protected static class NodeDoubleLinked<E> extends NodeLinked<E> {
		
		private static final long serialVersionUID = Utilities.getSerialVersionUID();
		
		protected NodeDoubleLinked<E> prev;
		
		public NodeDoubleLinked() {
			super();
			setPrevious(null);
		}
		
		public NodeDoubleLinked(E e) {
			super(e);
			setPrevious(null);
		}
		
		public NodeDoubleLinked(NodeDoubleLinked<E> prev, E e, NodeDoubleLinked<E> next) {
			super(e, next);
			setPrevious(prev);
		}
		
		public void setPrevious(NodeDoubleLinked<E> n) { prev = n; }
		
		public NodeDoubleLinked<E> getPrevious() { return prev; }
		
	}
	
	protected static class PathBidirectionalList<E> extends PathUnidirectionalList<E>
													implements PathBidirectional {
		
		private static final long serialVersionUID = Utilities.getSerialVersionUID();
		
		protected boolean isPrevious;
		
		public PathBidirectionalList(ListDoubleLinked<E> l, PathInit direction) {
			super(l);
			if (direction == PathInit.BEGINNING) { isPrevious = false; }
			else {
				isNext = false;
				if (last != null) currentNode = last.getNext();
				isPrevious = (currentNode != null);
			}
		}
		
		public boolean isPrevious() {
			return (last != null) && isPrevious;
		}
		
		public Position<E> next() {
			isPrevious = true;
			return super.next();
		}
		
		public Position<E> previous() {
			if (!isPrevious()) throw new ExceptionInvalidIndex();
			currentNode = ((NodeDoubleLinked<E>)currentNode).getPrevious();
			isPrevious = (currentNode != last.getNext());
			isNext = true;
			return currentNode;
		}
	}
}
