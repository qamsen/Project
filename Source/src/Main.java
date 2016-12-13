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
        
        Integer[][] arrays = copyArrays(5, randomArray(100));
        
        Sort[] sorts = {
                new InsertionSort(arrays[4]),
                new MergeSort(arrays[1]),
                new QuickSort(arrays[2]),
                new ShellSort(arrays[3]),
                new HeapSort(arrays[0])
        };
        
        GridLayout manager = new GridLayout((sorts.length + 1) / 2, sorts.length/ 2);
        
        GraphFrame f = new GraphFrame(sorts, manager);
        
        f.setVisible(true);
        
        for (Sort s : sorts)
            (new Thread(s)).start();
        
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
            
            for (int j = 0; j < arrCopied.length; j++) {
                arrays[i][j] = arrCopied[j];
            }
            
        }
        
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
