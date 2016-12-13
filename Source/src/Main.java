import java.util.Arrays;

import java.util.Collections;
import java.awt.GridLayout;
import visual.*;
import sort.*;
/**
 * The main method of our graphing project.
 *
 * Name: Kameron Damaska
 * ID: krd42
 * Date: 12/13/2016
 */
public class Main {

    public static void main(String[] args) {
        
        /* Launch GUI */
        
        /* arrays = return value from GUI */
        
        /* sorts = return value from GUI */
        
        Integer[][] arrays = copyArrays(8, randomArray(1000));
        
        Sort[] sorts = {
                new HeapSort(arrays[5])

        };

        launchFrame(sorts);

        for (Sort s : sorts)
            (new Thread(s)).start();

    }

    /**
     * Creates the frame that shows shows sorting algorithm.
     *
     * @param sorts  the sorting algorithms being visualized.
     */
    private static void launchFrame(Sort[] sorts) {

        GridLayout manager = new GridLayout((sorts.length + 1) / 2, 2);

        /* A frame that visualizing all the sort arrays */
        GraphFrame f = new GraphFrame(sorts, manager);
        f.setVisible(true);
    }

    /**
     * Copies a given array and returns an array containing the copies.
     * 
     * @param nArrays   number of arrays copied.
     * @param arrCopied source array.
     * @return          an array of the copied arrays.
     */
    private static Integer[][] copyArrays(int nArrays, Integer[] arrCopied) {
        
        Integer[][] arrays = new Integer[nArrays][];
        
        for (int i = 0; i < nArrays; i++) {
            
            arrays[i] = new Integer[arrCopied.length];
            
            for (int j = 0; j < arrCopied.length; j++) { arrays[i][j] = arrCopied[j]; } }
        
        return arrays;
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

        Collections.shuffle(Arrays.asList(arr));
        return arr;
    }

}
