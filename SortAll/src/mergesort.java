
public class mergesort {
	/**
	 * Mergesort algorithm
	 * @param array an array of Comparable items.
	 */
	public static<AnyType extends Comparable<? super AnyType>>
	void mergeSort(AnyType [] array) {
		counter.reset();
		AnyType [] tmpArray = (AnyType[]) new Comparable[array.length];
		
		mergeSort(array, tmpArray, 0, array.length - 1);
	}
	
	/**
	 * Internal method that makes recursive calls.
	 * @param array an array of Comparable items.
	 * @param tmpArray array to place merged results.
	 * @param left the left-most index of the subarray.
	 * @param right the right-most index of the subarray.
	 */
	private static<AnyType extends Comparable<? super AnyType>>
	void mergeSort(AnyType [] array, AnyType [] tmpArray, int left, int right) {
		if(left < right) {
			int center = (left + right) / 2;
			mergeSort(array, tmpArray, left, center);
			mergeSort(array, tmpArray, center + 1, right);
			merge(array, tmpArray, left, center + 1, right);
		}
	}
	
	/**
	 * Internal method that merges two sorted halves of a subarray.
	 * @param array an array of Comparable items.
	 * @param tmpArray an array to place the merged result.
	 * @param leftPos left-most index of the subarray.
	 * @param rightPos right-most index of the subarray.
	 * @param rightEnd the end of the start of the second half.
	 */
	private static<AnyType extends Comparable<? super AnyType>>
	void merge(AnyType[] array, AnyType[] tmpArray,
			int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		
		//Main Loop
		while(leftPos <= leftEnd && rightPos <= rightEnd)
			if(counter.compare(array[leftPos], array[rightPos]) <= 0) {
				tmpArray[tmpPos++] = array[leftPos++];
				counter.singleMove();
			} else {
				tmpArray[tmpPos++] = array[rightPos++];
				counter.singleMove();
			}
		
		while(leftPos <= leftEnd) {	//Copy the rest of the first half
			tmpArray[tmpPos++] = array[leftPos++];
			counter.singleMove();
		}
		
		while(rightPos <= rightEnd)	{//Copy rest of right half
			tmpArray[tmpPos++] = array[rightPos++];
			counter.singleMove();
		}
		
		//Copy tmpArray back
		for(int i = 0; i < numElements; i++, rightEnd--) {
			array[rightEnd] = tmpArray[rightEnd];
			counter.singleMove();
		}
	}
}
