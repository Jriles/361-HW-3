import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A priority queue class implemented using a min heap. Priorities cannot be
 * negative.
 * 
 * @author Your names
 * @version Date
 *
 */
public class PriorityQueue {

	protected Map<Integer, Integer> location;
	protected List<Pair<Integer, Integer>> heap;

	/**
	 * Constructs an empty priority queue
	 */
	public PriorityQueue() {
		heap = new ArrayList<Pair<Integer, Integer>>();
		location = new HashMap<>();
	}

	/**
	 * Insert a new element into the queue with the given priority.
	 *
	 * @param priority priority of element to be inserted
	 * @param element  element to be inserted <br>
	 *                 <br>
	 *                 <b>Preconditions:</b>
	 *                 <ul>
	 *                 <li>The element does not already appear in the priority
	 *                 queue.</li>
	 *                 <li>The priority is non-negative.</li>
	 *                 </ul>
	 * 
	 */
	public void push(int priority, int element) {
		Pair<Integer, Integer> p = Pair.createPair(priority, element);
		heap.add(p);
		location.put(priority, element);
	}

	/**
	 * Remove the highest priority element <br>
	 * <br>
	 * <b>Preconditions:</b>
	 * <ul>
	 * <li>The priority queue is non-empty.</li>
	 * </ul>
	 * 
	 */
	public void pop() {
		// TODO: Fill in
		int topPriority = topPriority();
		int associatedElement = location.get(topPriority);
		System.out.println("top priority: " + topPriority + " associated element: " + associatedElement);
		location.remove(topPriority);
		Pair<Integer, Integer> p = Pair.createPair(topPriority, associatedElement);
		System.out.println(heap.remove(p));
	}

	/**
	 * Returns the highest priority in the queue
	 * 
	 * @return highest priority value <br>
	 *         <br>
	 *         <b>Preconditions:</b>
	 *         <ul>
	 *         <li>The priority queue is non-empty.</li>
	 *         </ul>
	 */
	public int topPriority() {
		// TODO: Fill in
		if(isEmpty()){
			return -1;
		}else{
			int highestCurrentPriority = -1;
			for(int i =0; i < heap.size();i++){
				int thisPriority = heap.get(i).getPriority();
				if(thisPriority > highestCurrentPriority){
					highestCurrentPriority = thisPriority;
				}
			}
			return highestCurrentPriority;
		}
	}

	/**
	 * Returns the element with the highest priority
	 * 
	 * @return element with highest priority <br>
	 *         <br>
	 *         <b>Preconditions:</b>
	 *         <ul>
	 *         <li>The priority queue is non-empty.</li>
	 *         </ul>
	 */
	public int topElement() {
		// TODO: Fill in
		if(isEmpty()){
			return -1;
		}else{
			int highestCurrentElement = -1;
			for(int i =0; i < heap.size();i++){
				int thisElement = heap.get(i).getElem();
				if(thisElement > highestCurrentElement){
					highestCurrentElement = thisElement;
				}
			}
			return highestCurrentElement;
		}
	}

	/**
	 * Change the priority of an element already in the priority queue.
	 * 
	 * @param newpriority the new priority
	 * @param element     element whose priority is to be changed <br>
	 *                    <br>
	 *                    <b>Preconditions:</b>
	 *                    <ul>
	 *                    <li>The element exists in the priority queue</li>
	 *                    <li>The new priority is non-negative</li>
	 *                    </ul>
	 */
	public void changePriority(int newpriority, int element) {
		// TODO: Fill in

	}

	/**
	 * Gets the priority of the element
	 * 
	 * @param element the element whose priority is returned
	 * @return the priority value <br>
	 *         <br>
	 *         <b>Preconditions:</b>
	 *         <ul>
	 *         <li>The element exists in the priority queue</li>
	 *         </ul>
	 */
	public int getPriority(int element) {
		// TODO: Fill in
		return 0;
	}

	/**
	 * Returns true if the priority queue contains no elements
	 * 
	 * @return true if the queue contains no elements, false otherwise
	 */
	public boolean isEmpty() {
		// TODO: Fill in
		if (heap.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns true if the element exists in the priority queue.
	 * 
	 * @return true if the element exists, false otherwise
	 */
	public boolean isPresent(int element) {
		// TODO: Fill in
		return true;
	}

	/**
	 * Removes all elements from the priority queue
	 */
	public void clear() {
		// TODO: Fill in
		heap.clear();
		location.clear();
	}

	/**
	 * Returns the number of elements in the priority queue
	 * 
	 * @return number of elements in the priority queue
	 */
	public int size() {
		// TODO: Fill in
		return 0;
	}

	/*********************************************************
	 * Private helper methods
	 *********************************************************/

	/**
	 * Push down the element at the given position in the heap
	 * 
	 * @param start_index the index of the element to be pushed down
	 * @return the index in the list where the element is finally stored
	 */
	private int pushDown(int start_index) {
		// TODO: Fill in
		return 0;
	}

	/**
	 * Percolate up the element at the given position in the heap
	 * 
	 * @param start_index the index of the element to be percolated up
	 * @return the index in the list where the element is finally stored
	 */
	private int percolateUp(int start_index) {
		Pair pairToPerc = heap.get(start_index);
		int pairToPercPriority = (int) pairToPerc.getPriority();
		int currentIndex = start_index;
		boolean swapped = false;
		do {
			//check this elements parent
			//ask if out current pair is less than the priority of the parent
			//if so our new indes becomes our parent index.
			int parentIndex = parent(currentIndex);
			Pair currentParent = heap.get(parentIndex);
			int currentParentPriority = (int) currentParent.getPriority();
			//want to swap this element with its parent if it has a lower priority
			System.out.println("pair to perc priority: " + pairToPercPriority + " parentPriortiy: " + currentParentPriority);
			if(pairToPercPriority < currentParentPriority){
				currentIndex = parentIndex;
				swapped = true;
			}else{
				swapped = false;
			}
		}while(swapped);
		return currentIndex;
	}

	/**
	 * Swaps two elements in the priority queue by updating BOTH the list
	 * representing the heap AND the map
	 * 
	 * @param i The index of the element to be swapped
	 * @param j The index of the element to be swapped
	 */
	private void swap(int i, int j) {
		// TODO: Fill in
		//swap the heap
		Pair firstPair = heap.get(i);
		Pair secondPair = heap.get(j);
		Pair middleMan = firstPair;
		firstPair = secondPair;
		secondPair = middleMan;
		//swap the hashmap
		//this is done by just switching the values and leaving the pairs where they are in the hashmap
		int firstElement = heap.get(i).getElem();
		int firstPriority = heap.get(i).getPriority();
		int secondElement = heap.get(j).getElem();
		int secondPriority = heap.get(j).getPriority();
		location.put(firstPriority, secondElement);
		location.put(secondPriority, firstElement);
	}

	/**
	 * Computes the index of the element's left child
	 * 
	 * @param parent index of element in list
	 * @return index of element's left child in list
	 */
	private int left(int parent) {
		// TODO: Fill in
		return 0;
	}

	/**
	 * Computes the index of the element's right child
	 * 
	 * @param parent index of element in list
	 * @return index of element's right child in list
	 */
	private int right(int parent) {
		// TODO: Fill in
		return 0;
	}

	/**
	 * Computes the index of the element's parent
	 * 
	 * @param child index of element in list
	 * @return index of element's parent in list
	 */

	private int parent(int child) {
		return (child - 1) / 2;
	}

	/*********************************************************
	 * These are optional private methods that may be useful
	 *********************************************************
	 **
	 * 
	 * Push down the root element
	 *
	 * @return the index in the list where the element is finally stored
	 *
	 *         private int pushDownRoot() { // TODO: A one-line function that calls
	 *         pushDown() }
	 * 
	 *         /** Percolate up the last leaf in the heap, i.e. the most recently
	 *         added element which is stored in the last slot in the list
	 *
	 * @return the index in the list where the element is finally stored
	 *
	 *         private int percolateUpLeaf() { // TODO: A one-line function that
	 *         calls percolateUp() }
	 * 
	 *         /** Returns true if element is a leaf in the heap
	 *
	 * @param i index of element in heap
	 * @return true if element is a leaf
	 *
	 *         private boolean isLeaf(int i) { // TODO: Fill in }
	 * 
	 *         /** Returns true if element has two children in the heap
	 *
	 * @param i index of element in the heap
	 * @return true if element in heap has two children
	 *
	 *         private boolean hasTwoChildren(int i) { // TODO: Fill in }
	 * 
	 *         /** Print the underlying list representation
	 *
	 *         public void printHeap() { System.out.print("["); for (Pair p : heap)
	 *         { System.out.print(p.toString()); System.out.print(","); }
	 *         System.out.print("]\n"); }
	 * 
	 *         /** Print the entries in the location map
	 *
	 *         private void printMap() { // TODO: Fill in }
	 */
	public void printHeap() {
		System.out.print("[");
		for (Pair p : heap) {
			System.out.print(p.toString());
			System.out.print(",");
		}
		System.out.print("]\n");
	}

	public void printMap() {
		location.forEach((key, value) -> System.out.println("Priority: " + key + " " + " Element: " + value));

	}
}
