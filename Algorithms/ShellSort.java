package com.company;
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

        shellGraph.graph();

        while(gap > 0){

            for(int i = gap; i<n;i++){

                temp = getArray()[i];

                for(j = i; (j>= gap)&&(getArray()[j-gap] > temp); j -= gap){

                    getArray()[j] =getArray()[j-gap];


                }

            getArray()[j] = temp;
                shellGraph.graph();
            }

            gap = gap/2;    //reduce the gap

        }

    }

    /**
     * Swaps the values in an array at two giving indeces.
     *
     * @param i1 the index of a value to be swapped.
     * @param i2 the index of a value to be swapped.
     */

}
