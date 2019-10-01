import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A priority queue class implemented using a min heap. Priorities cannot be
 * negative.
 *
 * @author Jiman Kim and Jack Riley
 * @version 20190930
 *
 */
public class PriorityQueue {

	protected Map<Integer, Integer> location;
	protected List<Pair<Integer, Integer>> heap;
	protected int size;

	/**
	 * Constructs an empty priority queue
	 */
	public PriorityQueue() {
		heap = new ArrayList<Pair<Integer, Integer>>();
		location = new HashMap<>();
		this.size = heap.size();
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
		if (isPresent(element) || priority < 0) {
			throw new AssertionError();
		} else {
			Pair<Integer, Integer> p = Pair.createPair(priority, element);
			heap.add(p);
			location.put(element, heap.indexOf(p));
			percolateUp(heap.indexOf(p));
		}
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
		if(isEmpty()){
			return;
		}
		//need to run an exhaustive search for the highest priority element
		int currentMaximumIndex = 0;
		int currentMaxPriority = 0;
		for (int i = 0; i < heap.size(); ++i) {
			if((int) heap.get(i).getPriority() > currentMaxPriority){
				currentMaximumIndex = i;
				currentMaxPriority =(int) heap.get(i).getPriority();
			}
		}
		//remove largest element and reheapify.
		Pair pairToRemove = heap.get(currentMaximumIndex);
		heap.remove(pairToRemove);
		location.remove(pairToRemove.getElem());
		heapify(0);
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
		// Returns error once
		if (isEmpty()) {
			return -1;
		} else {
			int highestCurrentPriority = -1;
			for (int i = 0; i < heap.size(); i++) {
				int thisPriority = heap.get(i).getPriority();
				if (thisPriority > highestCurrentPriority) {
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
		if (isEmpty()) {
			return -1;
		} else {
			int highestCurrentElement = -1;
			for (int i = 0; i < heap.size(); i++) {
				int thisElement = heap.get(i).getElem();
				if (thisElement > highestCurrentElement) {
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
		//preconditions
		if(newpriority < 0){
			return;
		}
		if(isPresent(element) == false){
			return;
		}
		//change the priority of an element already in the priority queue
		//this step is actually fairly simple
		//and then reheapify
		int index = location.get(element);
		Pair pairToAlter = heap.get(index);
		pairToAlter.setPriority(newpriority);
		System.out.println((int) pairToAlter.getPriority());
		heapify(index);
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
		if (isPresent(element)) {
			return (int) heap.get((int) location.get(element)).getPriority();
		}
		throw new AssertionError();

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
		return location.containsKey(element);
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
		size = heap.size();
		return size;
	}

	/*********************************************************
	 * Private helper methods
	 *********************************************************/
	//heapify resests the tree
	public void heapify(int root) {
		int parent = (int) heap.get(root).getPriority();
		int left;
		//need to check if we are still inbounds
		if(left(root) < heap.size()) {
			left = (int) heap.get(left(root)).getPriority();
		}else{
			left = -1;
		}
		int right;
		if(right(root) < heap.size()) {
			right = (int) heap.get(right(root)).getPriority();
		}else{
			right = -1;
		}
		if (!isLeaf(root) && left != -1 && right != -1) {
			if (parent > right || parent > left) {
				if (right < left) {
					swap(root, right(root));
					heapify(right(root));
				} else {
					swap(root, left(root));
					heapify(left(root));
				}
			}
		}
	}

	/**
	 * Push down the element at the given position in the heap
	 *
	 * @param start_index the index of the element to be pushed down
	 * @return the index in the list where the element is finally stored
	 */

	public int pushDown(int start_index) {
		// TODO: Fill in
		Pair pairToPushDown = heap.get(start_index);
		Pair leftChild = null;
		Pair rightChild = null;
		int currentIndex = start_index;
		int leftChildIndex = 2 * start_index + 1;
		int rightChildIndex = 2 * start_index + 2;
		if(leftChildIndex < heap.size()){
			leftChild = heap.get(leftChildIndex);
		}
		if(((2 * start_index) + 2) < heap.size()){
			rightChild = heap.get(rightChildIndex);
		}
		while(leftChild != null || rightChild != null){
			//only three possible cases
			//there are two children
			//or there is only a left child node
			//or there are no child nodes
			//but that can't happen at this point thanks to the while condition which leaves us the with the possibilities of one node or two

			//if right one is missing just take left one and try to repeat.
			//if the right child is missing jsut go with the left
			//want to make sure our pair to push down has a hgih priority tho
			if(rightChild == null && ((int) leftChild.getPriority() < (int) pairToPushDown.getPriority())){
				pairToPushDown = heap.get(leftChildIndex);
				swap(leftChildIndex, currentIndex);
				currentIndex = leftChildIndex;
				if(heap.size() > (2 * currentIndex) + 1) {
					leftChildIndex = (2 * leftChildIndex) + 1;
					leftChild = heap.get(leftChildIndex);
				}else{
					leftChild = null;
				}
				if(heap.size() > (2 * currentIndex) + 2){
					rightChildIndex = (2 * currentIndex) + 2;
					rightChild = heap.get(rightChildIndex);
				}else{
					rightChild = null;
				}
			}else {
				//else do this
				//if left child is smaller than its neighbor and smaller than the element to push down then we swap and set new children.
				if (((int) leftChild.getPriority() < (int) rightChild.getPriority()) && ((int) leftChild.getPriority() < (int) pairToPushDown.getPriority())) {
					swap(currentIndex, leftChildIndex);
					currentIndex = leftChildIndex;
					pairToPushDown = heap.get(currentIndex);
					if(heap.size() > (2 * currentIndex) + 1) {
						leftChildIndex = (2 * currentIndex) + 1;
						leftChild = heap.get(leftChildIndex);
					}else {
						leftChild = null;
					}
					if(heap.size() > (2 * currentIndex) + 2){
						rightChildIndex = (2 * currentIndex) + 2;
						rightChild = heap.get(rightChildIndex);
					}else{
						rightChild = null;
					}
					//if right child is smaller than its neighbor and smaller than the element to push down then we swap and set new children.
				} else if((int) leftChild.getPriority() > (int) rightChild.getPriority() && ((int) rightChild.getPriority() < (int) pairToPushDown.getPriority())){
					swap(currentIndex, rightChildIndex);
					currentIndex = rightChildIndex;
					pairToPushDown = heap.get(currentIndex);
					if(heap.size() > (2 * currentIndex) + 1) {
						leftChildIndex = (2 * currentIndex) + 1;
						leftChild = heap.get(leftChildIndex);
					}else {
						leftChild = null;
					}
					if(heap.size() > (2 * currentIndex) + 2){
						rightChildIndex = (2 * currentIndex) + 2;
						rightChild = heap.get(rightChildIndex);
					}else{
						rightChild = null;
					}
				}else{
					//neither child is ready, meaning we are at the end of the line, nothing occurs and we exit the while.
					leftChild = null;
					rightChild = null;
				}

			}
		}
		return currentIndex;
	}
	/*
n 	 * @param start_index the index of the element to be percolated up
	 * @return the index in the list where the element is finally stored
	 */
	private int percolateUp(int start_index) {
		while (isLeaf(start_index)) {
			int currentPriority = (int) heap.get(start_index).getPriority();
			int parent = (int) heap.get(parent(start_index)).getPriority();
			if (currentPriority < parent) {
				swap(start_index, parent(start_index));
				start_index = parent(start_index);
			} else {
				return start_index;
			}
		}
		return start_index;
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
		// swap the heap
		Pair temp = heap.get(i);
		Pair firstPair = heap.get(i);
		Pair secondPair = heap.get(j);
		firstPair = secondPair;
		secondPair = temp;
		heap.set(j, secondPair);
		heap.set(i, firstPair);
		// swap the hashmap
		// this is done by just switching the values and leaving the pairs where they
		// are in the hashmap
		location.replace((int) secondPair.getElem(), j);
		location.replace((int) firstPair.getElem(), i);

	}

	/**
	 * Computes the index of the element's left child
	 *
	 *
	 * * @param parent index of element in list
	 *
	 * * @return index of element's left child in list
	 */
	private int left(int parent) {
		return (parent * 2) + 1;

	}

	/**
	 * Computes the index of the element's right child
	 *
	 * @param parent index of element in list
	 * @return index of element's right child in list
	 */
	private int right(int parent) {
		return (parent * 2) + 2;
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
	 *********************************************************/

	/**
	 * Push down the root element
	 *
	 * @return the index in the list where the element is finally stored
	 */
	/*
	private int pushDownRoot() {
		// TODO: A one-line function that calls pushDown()
	}
	*/
	/**
	 * Percolate up the last leaf in the heap, i.e. the most recently added element
	 * which is stored in the last slot in the list
	 *
	 * @return the index in the list where the element is finally stored
	 */
	private int percolateUpLeaf() {
		// TODO: A one-line function that calls percolateUp()
		return 0;
	}

	/**
	 * Returns true if element is a leaf in the heap
	 *
	 * @param i index of element in heap
	 * @return true if element is a leaf
	 */

	private boolean isLeaf(int i) {
		if (i >= (size() / 2) && i <= size()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if element has two children in the heap
	 *
	 * @param i index of element in the heap
	 * @return true if element in heap has two children
	 */
	private boolean hasTwoChildren(int i) {
		// TODO: Fill in
		return false;
	}

	/**
	 * print the underlying list representation
	 */
	public void printHeap() {
		System.out.print("[");
		for (Pair p : heap) {
			System.out.print(p.toString());
			System.out.print(",");
		}
		System.out.print("]\n");
	}

	/**
	 * Print the entries in the location map
	 */
	public void printMap() {
		location.forEach((key, value) -> System.out.println("Element: " + key + " " + " Index: " + value));

	}
}
