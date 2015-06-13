
public class quickSort {
	private static final int CUTOFF = 10;	//Cutoff to do insertion sort.
	
	/**
	 * Driver for quicksort.
	 * @param array array of comparable items.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void quicksort(AnyType [] array) {
		counter.reset();
		quicksort(array, 0, array.length - 1);
	}
	
	/**
	 * Quicksort method using recursive calls and median-of-three
	 * and a CUTOFF.
	 * @param array array of comparable items.
	 * @param left left-most index of the subarray.
	 * @param right right-most index of the subarray.
	 */
	private static<AnyType extends Comparable<? super AnyType>>
	void quicksort(AnyType [] array, int left, int right) {
		if(left + CUTOFF <= right) {
			AnyType pivot = median3(array, left, right);
			
			//Partition
			int i = left, j = right - 1;
			for(;;) {
				while(counter.compare(array[++i], pivot) < 0) {}
				while(counter.compare(array[--j], pivot) > 0) {}
				if(i < j)
					swapReferences(array, i, j);
				else
					break;
			}
			
			swapReferences(array, i, right - 1);	//Restore Pivot
			
			quicksort(array, left, i - 1);	//Sort small elements
			quicksort(array, i + 1, right);	//Sort large elements
		} else {
			qs_InsertionSort(array, left, right);
		}
	}
	
	/**
	 * Return the median of left, center, and right.
	 * @param array array to be analyzed
	 * @param left left of array
	 * @param right right of array
	 * @return median of three in array
	 */
	private static <AnyType extends Comparable<? super AnyType>>
	AnyType median3(AnyType [] array, int left, int right) {
		int center = (left + right) / 2;
		if(counter.compare(array[center], array[left]) < 0)
			swapReferences(array, left, center);
		if(counter.compare(array[right], array[left]) < 0)
			swapReferences(array, left, right);
		if(counter.compare(array[right], array[center])  < 0)
			swapReferences(array, right, center);
		
		//Place pivot at position right - 1
		swapReferences(array, center, right - 1);
		return array[right - 1];
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
	
	/**
	 * Private insertion sort used when quicksort reaches cutoff.
	 * @param array an array of Comparable items.
	 * @param left left of array.
	 * @param right right of array.
	 */
	private static<AnyType extends Comparable<? super AnyType>>
	void qs_InsertionSort(AnyType [] array, int left, int right) {
		int j;
		
		for(int p = left; p < right + 1; p++) {
			AnyType tmp = array[p];
			for(j = p; j > 0 && counter.compare(tmp, array[j - 1]) < 0; j--) {
				array[j] = array[j - 1];
				counter.doubleMove();
			}
			array[j] = tmp;
		}
	}
}
