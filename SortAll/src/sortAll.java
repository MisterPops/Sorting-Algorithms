import java.util.Random;


public class sortAll {
	
	/**
	 * Randomizes the given array.
	 * @param array array to be shuffled.
	 */
	static<AnyType> void shuffle(AnyType[] array) {
		Random shuffler = new Random();
		for(int i = array.length - 1; i >0; i--) {
			int rndIndex = shuffler.nextInt(i + 1);
			
			AnyType temp = array[rndIndex];
			array[rndIndex] = array[i];
			array[i] = temp;
		}
	}

	public static void main(String[] args) {
		double startTime;				//Holds start time for sort clock.
		final int arraySize = 100000;	//Size of arrays that will be sorted.
		Integer[] tempRand = new Integer[arraySize];	//Randomized array
		Integer[] tempInc = new Integer[arraySize];		//Increasing order array
		Integer[] tempDec = new Integer[arraySize];		//Decreasing order array
		
		//Random Integer Array
		Integer[] randArray = new Integer[arraySize];
		for(int i = 0; i < randArray.length; i++)
			randArray[i] = i + 1;
		shuffle(randArray);
		
		//Increasing Integer Array
		Integer[] incArray = new Integer[arraySize];
		for(int i = 0; i < incArray.length; i++)
			incArray[i] = i + 1;
		
		//Decreasing Integer Array
		Integer[] decArray = new Integer[arraySize];
		int decNum = arraySize;
		for(int i = 0; i < incArray.length; i++)
			decArray[i] = decNum--;
		
		/*-------Sorting-----*/
		System.out.println("Sorting random, incrementing, and decrementing arrays, size: " + arraySize + "\n");
		
		//Doing QuickSort
		//Make Arrays
		System.arraycopy(randArray, 0, tempRand, 0, randArray.length);
		System.arraycopy(incArray, 0, tempInc, 0, incArray.length);
		System.arraycopy(decArray, 0, tempDec, 0, decArray.length);
		//Do quicksorts
		startTime = System.currentTimeMillis();
		quickSort.quicksort(tempRand);
		System.out.println("QuickSort Random Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		startTime = System.currentTimeMillis();
		quickSort.quicksort(tempInc);
		System.out.println("\nQuickSort Increasing Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		startTime = System.currentTimeMillis();
		quickSort.quicksort(tempDec);
		System.out.println("\nQuickSort Decreasing Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		//Doing Mergesort
		//Make Arrays
		System.arraycopy(randArray, 0, tempRand, 0, randArray.length);
		System.arraycopy(incArray, 0, tempInc, 0, incArray.length);
		System.arraycopy(decArray, 0, tempDec, 0, decArray.length);
		//Do mergesorts
		startTime = System.currentTimeMillis();
		mergesort.mergeSort(tempRand);
		System.out.println("\nMergesort Random Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		startTime = System.currentTimeMillis();
		mergesort.mergeSort(tempInc);
		System.out.println("\nMergesort Increasing Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		startTime = System.currentTimeMillis();
		mergesort.mergeSort(tempDec);
		System.out.println("\nMergesort Decreasing Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		//Doing Heapsort
		//Make Arrays
		System.arraycopy(randArray, 0, tempRand, 0, randArray.length);
		System.arraycopy(incArray, 0, tempInc, 0, incArray.length);
		System.arraycopy(decArray, 0, tempDec, 0, decArray.length);
		//Do heapsorts
		startTime = System.currentTimeMillis();
		heapsort.heapSort(tempRand);
		System.out.println("\nHeapsort Random Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		startTime = System.currentTimeMillis();
		heapsort.heapSort(tempInc);
		System.out.println("\nHeapsort Increasing Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		startTime = System.currentTimeMillis();
		heapsort.heapSort(tempDec);
		System.out.println("\nHeapsort Decreasing Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		//Doing sub-optimal Shellsort
		//Make Arrays
		System.arraycopy(randArray, 0, tempRand, 0, randArray.length);
		System.arraycopy(incArray, 0, tempInc, 0, incArray.length);
		System.arraycopy(decArray, 0, tempDec, 0, decArray.length);
		//Do sub-op shellsorts
		startTime = System.currentTimeMillis();
		shellsort.shellSortSubOp(tempRand);
		System.out.println("\nShell Sequence Shellsort Random Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		startTime = System.currentTimeMillis();
		shellsort.shellSortSubOp(tempInc);
		System.out.println("\nShell Sequence Shellsort Increasing Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		startTime = System.currentTimeMillis();
		shellsort.shellSortSubOp(tempDec);
		System.out.println("\nShell Sequence Shellsort Decreasing Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		//Doing optimal Shellsort
		//Make Arrays
		System.arraycopy(randArray, 0, tempRand, 0, randArray.length);
		System.arraycopy(incArray, 0, tempInc, 0, incArray.length);
		System.arraycopy(decArray, 0, tempDec, 0, decArray.length);
		//Do Op-Shellsorts
		startTime = System.currentTimeMillis();
		shellsort.shellSortOp(tempRand);
		System.out.println("\nSedgewick Sequence Shellsort Random Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		startTime = System.currentTimeMillis();
		shellsort.shellSortOp(tempInc);
		System.out.println("\nSedgewick Sequence Shellsort Increasing Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		startTime = System.currentTimeMillis();
		shellsort.shellSortOp(tempDec);
		System.out.println("\nSedgewick Sequence Shellsort Decreasing Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		//Doing InsertionSort
		//Make Arrays
		System.arraycopy(randArray, 0, tempRand, 0, randArray.length);
		System.arraycopy(incArray, 0, tempInc, 0, incArray.length);
		System.arraycopy(decArray, 0, tempDec, 0, decArray.length);
		//Do instertion sorts
		startTime = System.currentTimeMillis();
		insertionsort.insertionSort(tempRand);
		System.out.println("\nInsertionSort Random Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		startTime = System.currentTimeMillis();
		insertionsort.insertionSort(tempInc);
		System.out.println("\nInsertionSort Increasing Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
		
		startTime = System.currentTimeMillis();
		insertionsort.insertionSort(tempDec);
		System.out.println("\nInsertionSort Decreasing Array time taken: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
		counter.print();
	}
}
