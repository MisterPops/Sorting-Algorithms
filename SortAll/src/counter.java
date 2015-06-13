
public class counter {
	private static double compare = 0;
	private static double move = 0;
	
	/**
	 * Reset the static counter.
	 */
	public static void reset() {
		compare = 0;
		move = 0;
	}
	
	/**
	 * Compare main with toCompare, increments compare double.
	 * @param main main item to compare with.
	 * @param toCompare main is compared to this.
	 * @return main is less than, more than, or equal (-1, 1, 0)
	 */
	public static<AnyType extends Comparable<? super AnyType>>
	int compare(AnyType main, AnyType toCompare) {
		compare++;
		return main.compareTo(toCompare);
	}
	
	/**
	 * Counts a single item move.
	 */
	public static void singleMove() {
		move++;
	}
	
	/**
	 * Counts for an item swap with another item.
	 */
	public static void doubleMove(){
		move += 2;
	}
	
	/**
	 * Print comparison and move variables.
	 */
	public static void print() {
		System.out.println("Comparisons: " + compare + " Moves: " + move);
	}

}
