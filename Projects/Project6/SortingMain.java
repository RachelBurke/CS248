/*
 * Sorting Main Program 
 * @author Rachel burke
 */

import java.util.*;

public class SortingMain {    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("What is the size of the list you would like to sort?");
        // Finding list size          
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("");
        
        //Creating arrays
        Comparable [] list = new Comparable[n];
        Comparable [] bubbleSort = new Comparable[n];
        Comparable [] selectionSort = new Comparable[n];
        Comparable [] insertionSort = new Comparable[n];
		Comparable [] quickSort = new Comparable[n];
        Comparable [] shellSort = new Comparable[n];
        Comparable [] mergeSort = new Comparable[n];
        
        //Inputing integers into the arrays and making them all identical
        int temp;
        for (int i = 0; i < n; i++){
            temp = (int)(1+n*Math.random());
            list[i] = temp;
            bubbleSort[i] = temp;
            selectionSort[i] = temp;
            insertionSort[i] = temp;
			quickSort[i] = temp;
            shellSort[i] = temp;
            mergeSort[i] = temp;
        }
        
        //Pringing out the original list
        if (n <= 100){
            System.out.println("Original List: ");
            for (int i = 0; i < n; i++){
              System.out.print(list[i]+" ");
            }
            System.out.println();
        }
        System.out.println("");
        
        //Sorting each list using the respective sort method
        //Keeping track of time of each sort
		SortTime.bubbleSortTime(bubbleSort);
        SortTime.selectionSortTime(selectionSort);
        SortTime.insertionSortTime(insertionSort);
		SortTime.quickSortTime(quickSort);
        SortTime.shellSortTime(shellSort);
        SortTime.mergeSortTime(mergeSort);        
    }
}