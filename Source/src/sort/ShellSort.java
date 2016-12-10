package sort;
import java.util.Arrays;
//package Algorithms;


/* Performs Shell Sort on an Integer array.
 *
 * Name: Drew Borneman
 * ID: awb79
 * Date: 12/6/2016 */

public class ShellSort extends Sort {


    public ShellSort(Integer[] arr) {
        super(arr);
    }

    /**
     * Sorts the array using Shellsort.
     */
    GraphArray shellGraph = new GraphArray(getArray());

    public void sort() {
        int n = getArray().length;
        int gap = getArray().length/2;
        int temp;
        int j;

        while(gap > 0){

            for(int i = gap; i<n;i++){

                temp = getArray()[i];

                for(j = i; (j>= gap)&&(getArray()[j-gap] > temp); j -= gap){

                    getArray()[j] = getArray()[j-gap];
                    getGraph().update(j, getArray()[j]);


                }

            getArray()[j] = temp;
            getGraph().update(j, getArray()[j]);
            }

            gap = gap/2;    //reduce the gap

        }

    }

}
