
public class shellsort {
	
	/**
	 * Shellsort using Shell's increments.
	 * @param array an array of Comparable items.
	 */
	public static<AnyType extends Comparable<? super AnyType>>
	void shellSortSubOp(AnyType[] array) {
		counter.reset();
		int j;
		
		for(int gap = array.length / 2; gap > 0; gap /= 2)
			for(int i = gap; i < array.length; i++) {
				AnyType tmp = array[i];
				for(j = i; j >= gap &&
						counter.compare(tmp, array[j - gap]) < 0; j -= gap) {
					array[j] = array[j - gap];
					counter.doubleMove();
				}
				array[j] = tmp;
			}
	}
	
	/**
	 * Shellsort using Sedgewick's increments.
	 * @param array an array of Comparable items.
	 */
	public static<AnyType extends Comparable<? super AnyType>>
	void shellSortOp(AnyType[] array) {
		counter.reset();
		int j;
		int gap;
		int gap_index = 0;
		double[] inc = new double[array.length / 3];
		
		//Make array with Sedgewick's increments
		for(int k = 0, index = 0; index < inc.length; k++) {
			if(index < inc.length) {
				inc[index] = 9 * (Math.pow(4, k) - Math.pow(2, k)) + 1;
				index++;
			}
			if(index < inc.length) {
				inc[index] = Math.pow(2, k + 2) * (Math.pow(2, k + 2) - 3) + 1;
				index++;
			}
		}
		
		//Go to increment < N/3 of increment array. 
		while(inc[gap_index] < array.length / 3) {
			gap_index++;
		}
		
		//Sort
		while(gap_index >= 0) {
			gap = (int) inc[gap_index];
			for(int i = gap; i < array.length; i++) {
				AnyType tmp = array[i];
				for(j = i; j >= gap &&
						counter.compare(tmp, array[j - gap]) < 0; j -= gap) {
					array[j] = array[j - gap];
					counter.doubleMove();
				}
				array[j] = tmp;
			}
			gap_index--;
		}
	}
}
