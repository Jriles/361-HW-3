/**
 * A wrapper class for priority queue elements
 * 
 * @author americachambers
 *
 */

public class Pair<P, E> {

	private P priority;
	private E element;

	public static <P, E> Pair<P, E> createPair(P priority, E element) {
		return new Pair<P, E>(priority, element);
	}

	public Pair(P p, E e) {
		this.priority = p;
		this.element = e;
	}

	public P getPriority() {
		return priority;
	}

	public E getElem() {
		return element;
	}

	@Override
	public String toString() {
		return "(" + priority + "," + element + ")";
	}
}
