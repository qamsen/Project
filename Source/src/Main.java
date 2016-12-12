import java.util.Arrays;

import java.util.Collections;
import java.lang.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sort.*;

public class Main {

    public static void main(String[] args) {
    	
        Integer[][] arrays = copyArrays(5, randomArray(100));

        Sort[] sorts = {
                new MergeSort(arrays[0]),
                new HeapSort(arrays[1]),
                new QuickSort(arrays[2]),
                new InsertionSort(arrays[3]),
                new ShellSort(arrays[4])
        };
        
        Thread t1 = new Thread(sorts[0]);
        Thread t2 = new Thread(sorts[1]);
        Thread t3 = new Thread(sorts[2]);
        Thread t4 = new Thread(sorts[3]);
        Thread t5 = new Thread(sorts[4]);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
    }
    
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
