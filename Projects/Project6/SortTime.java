/**
 * Class for SortTime Methods
 * @author Rachel Burke
 */
public class SortTime {
        
    //Store before and after times for sorts
    public static long beforeTime;
    public static long afterTime;
    
    /**
     * List copy for bubble sort
     * @param bubbleSort 
	 * Comparable Array
     */
    public static void bubbleSortTime(Comparable [] bubbleSort){
        beforeTime = System.currentTimeMillis();
        Sorts.bubble(bubbleSort);
        afterTime = System.currentTimeMillis();
        
        //Print the list if less than 100
        if (bubbleSort.length <= 100){
            System.out.println("Bubble Sorted List: ");
            for (int i = 0; i < bubbleSort.length; i++) {
                System.out.print(bubbleSort[i] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Bubble Sort Time Taken: "+(double)(afterTime-beforeTime)+ " milliseconds.");
        System.out.println("");
    }
    /**
     * List copy for insertion sort
     * @param insertionSort 
     * Comparable Array
     */
    public static void insertionSortTime(Comparable [] insertionSort){
        beforeTime = System.currentTimeMillis();
        Sorts.insertion(insertionSort);
        afterTime = System.currentTimeMillis();
        
        //Print the list if less than 100
        if (insertionSort.length <= 100){
            System.out.println("Insertion Sorted List: ");
            for (int i = 0; i < insertionSort.length; i++){
              System.out.print(insertionSort[i]+" ");
            }
            System.out.println();
        }
        
        System.out.println("Insertion Sort Time Taken: "+(double)(afterTime-beforeTime)+ " milliseconds.");
        System.out.println("");
    }
    /**
     * List copy for selection sort
     * @param selectionSort 
     * Comparable array
     */
    public static void selectionSortTime(Comparable [] selectionSort){
        beforeTime = System.currentTimeMillis();
        Sorts.selection(selectionSort);
        afterTime = System.currentTimeMillis();
        
        //Print the list if less than 100
        if (selectionSort.length <= 100){
            System.out.println("Selection Sorted List: ");
            for (int i = 0; i < selectionSort.length; i++){
              System.out.print(selectionSort[i]+" ");
            }
            System.out.println();
        }
        
        System.out.println("Selection Sort Time Taken: "+(double)(afterTime-beforeTime)+ " milliseconds.");
        System.out.println("");
    }
	/**
     * List copy for quick sort
     * @param bubbleSort 
	 * Comparable Array
     */
    public static void quickSortTime(Comparable [] quickSort){
        beforeTime = System.currentTimeMillis();
        Sorts.quick(quickSort);
        afterTime = System.currentTimeMillis();
        
        //Print the list if less than 100
        if (quickSort.length <= 100){
            System.out.println("Quick Sorted List: ");
            for (int i = 0; i < quickSort.length; i++) {
                System.out.print(quickSort[i] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Quick Sort Time Taken: "+(double)(afterTime-beforeTime)+ " milliseconds.");
        System.out.println("");
    }
    /**
     * List copy for shell sort
     * @param shellSort 
     * Comparable array
     */
        public static void shellSortTime(Comparable [] shellSort){
        beforeTime = System.currentTimeMillis();
        Sorts.shell(shellSort);
        afterTime = System.currentTimeMillis();
        
        //Print the list if less than 100
        if (shellSort.length <= 100){
            System.out.println("Shell Sorted List: ");
            for (int i = 0; i < shellSort.length; i++){
              System.out.print(shellSort[i]+" ");
            }
            System.out.println();
        }
        
        System.out.println("Shell Sort Time Taken: "+(double)(afterTime-beforeTime)+ " milliseconds.");
        System.out.println("");
    }
    /**
     * List copy for merge sort
     * @param mergeSort 
     * Comparable array
     */
        public static void mergeSortTime(Comparable [] mergeSort){
        beforeTime = System.currentTimeMillis();
        Sorts.merge(mergeSort);
        afterTime = System.currentTimeMillis();
        
        //Print the list if less than 100
        if (mergeSort.length <= 100){
            System.out.println("Merge Sorted List: ");
            for (int i = 0; i < mergeSort.length; i++){
              System.out.print(mergeSort[i]+" ");
            }
            System.out.println();
        }
        
        System.out.println("Merge Sort Time Taken: "+(double)(afterTime-beforeTime)+ " milliseconds.");
        System.out.println("");
    }
}
