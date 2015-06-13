
public class heapsort {
	
	/**
	 * Internal method for heapsort
	 * @param i the index of an item in the heap.
	 * @return the index of the left child.
	 */
	private static int leftChild(int i) {
		return 2 * i + 1;
	}
	
	/**
	 * Internal method for heapsort that is used in deleteMax and buildHeap.
	 * @param array an array of Comparable items.
	 * @param i the position from which to percolate down.
	 * @param n the logical size of the binary heap.
	 */
	private static <AnyType extends Comparable<? super AnyType>>
	void percDown(AnyType[] array, int i, int n) {
		int child;
		AnyType tmp;
		
		for(tmp = array[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if(child != n - 1 && counter.compare(array[child], array[child + 1]) < 0)
				child++;
			if(counter.compare(tmp, array[child]) < 0) {
				array[i] = array[child];
				counter.singleMove();
			} else
				break;
		}
		array[i] = tmp;
	}
	
	/**
	 * Standard heapsort
	 * @param array array of Comparable items.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void heapSort(AnyType[] array) {
		counter.reset();
		
		for(int i = array.length / 2 - 1; i >= 0; i--)	//Build heap
			percDown(array, i, array.length);
		for(int i = array.length - 1; i > 0; i--) {
			swapReferences(array, 0, i);				//Delete Max
			percDown(array, 0, i);
		}
	}

	/**
	 * Swap the two references in the array.
	 * @param array array to be swapped.
	 * @param swap1 will be swapped with swap2
	 * @param swap2 will be swapped with swap1
	 */
	private static <AnyType> 
	void swapReferences(AnyType [] array, int swap1, int swap2) {
		AnyType temp = array[swap2];
		array[swap2] = array[swap1];
		array[swap1] = temp;
		counter.doubleMove();
	}
}
