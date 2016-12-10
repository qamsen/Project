import java.util.Arrays;

import java.util.Collections;
import java.lang.*;
import java.util.List;
import sort.*;

public class Main {

    public static void main(String[] args) {
    	Integer[] arr = randomArray(10);
    	Integer[] arr2 = randomArray(50);
    	Integer[] arr3 = randomArray(100);
    	Sort[] sorts = {
    			new MergeSort(arr),
    			new MergeSort(arr2),
    			new MergeSort(arr3)
    	};
    	
    	for (Sort s : sorts)
    		s.graph();
    }

    /**
     * Runs the sorting algorithm
     *
     * @param sortName    the name of the sorting algorithm being run.
     * @param arrayLength the length of the array the program will sort.  */
    public static void launchProgram(String sortName, int arrayLength) {

        /* Creates a random array to be sorted */
        Integer[] arr = randomArray(arrayLength);

        /* Runs the given sorting algorithm */
        switch (sortName) {
            case "mergesort":
                    MergeSort mergeSort = new MergeSort(arr);
                    mergeSort.graph();
                    break;
            case "heapsort":
                    HeapSort heapSort = new HeapSort(arr);
                    heapSort.graph();
                    break;
            case "insertionsort":
                    InsertionSort insertionSort = new InsertionSort(arr);
                    insertionSort.graph();
                    break;
            case "quicksort":
                    QuickSort quickSort = new QuickSort(arr);
                    quickSort.graph();
                    break;
            case "shellsort":
                    ShellSort shellSort = new ShellSort(arr);
                    shellSort.graph();
                    break;
        }
    }

    /**
     * Removes all whitespaces in the String and decapitalizes it.
     *
     * @param s the String being stripped.
     * @return  the String with no capital letters or whitespace.
     */
    public static String parseString(String s) {

        s = s.toLowerCase();
        s = s.replaceAll("\\s+","");

        return s;
    }

    /**
     * Returns a randomly sorted array.
     *
     * @param arrayLength the length of the random array.
     * @return            a randomly sorted array.
     */
     public static Integer[] randomArray(int arrayLength) {

        Integer[] arr = new Integer[arrayLength];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        /* Randomizes the contents of the array */
//        List<Integer> solution = new ArrayList<>();
//        solution = Arrays.asList(arr);
        Collections.shuffle(Arrays.asList(arr));
        return arr;
    }

    /**
     * Checks to see if a String is the name of a sorting algorithm in this
     * program.
     *
     * @param sortName the String that is being checked.
     * @return         if the String is the name of a sorting algorithm.
     */
    private static boolean isValidSort(String sortName) {

        /* The valid sorting algorithms in this program */
        List validSorts = Arrays.asList(
                "mergesort", "heapsort", "insertionsort", "quicksort", "shellsort");

        /* Removes white space and decapitalizes the String */
        sortName = parseString(sortName);

        return validSorts.contains(sortName);
    }

}
