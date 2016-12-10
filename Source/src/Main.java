import java.util.Arrays;
import java.util.Collections;
import java.lang.String;
import java.util.List;
import java.lang.Integer;
import sort.*;

public class VisualSorting {

    public static void main(String[] args) {

        /* Checks to make sure the inputs are valid */
        boolean validSort = false;
        boolean validInputs = false;
        String sortName = "";

        /* Array length the user input */
        int arrayLength = 0;

        /* Checks the sorting algorithm name */
        try {
            validSort = isValidSort(args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
        }

        /* Checks that the array length is valid */
        try {
            arrayLength = Integer.parseInt(args[1]);
            if (validSort) {
                validInputs = true;
                sortName = args[0];
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
        }
        catch (NumberFormatException e) {
        }

        /* Runs program when an algorithm and array length is supplied */
        if (validInputs) {
            launchProgram(sortName, arrayLength);
        }

        /* Error catching */
        else
            System.out.println("Please give valid inputs");
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
                    heapSort.getSortedArray();
                    break;
            case "insertionsort":
                    InsertionSort insertionSort = new InsertionSort(arr);
                    insertionSort.getSortedArray();
                    break;
            case "quicksort":
                    QuickSort quickSort = new QuickSort(arr);
                    quickSort.getSortedArray();
                    break;
            case "shellsort":
                    ShellSort shellSort = new ShellSort(arr);
                    shellSort.getSortedArray();
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
