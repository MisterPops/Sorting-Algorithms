
public class insertionsort {
	/**
	 * Insertion sort.
	 * @param array array of comparable items.
	 */
	public static<AnyType extends Comparable<? super AnyType>>
	void insertionSort(AnyType [] array) {
		counter.reset();
		int j;
		
		for(int p = 1; p < array.length; p++) {
			AnyType tmp = array[p];
			for(j = p; j > 0 && counter.compare(tmp, array[j - 1]) < 0; j--) {
				array[j] = array[j - 1];
				counter.doubleMove();
			}
			array[j] = tmp;
		}
	}
	
	
}
