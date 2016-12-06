/* Performs quicksort on an Integer array.
 *
 * Name : Drew Borneman
 * ID   : awb79
 * Date : 12/4/2016 */

package com.company;
import java.util.Arrays;

public class QuickSort{

    public static void main(String[] args) {
        Integer[] a = {7, 4, 5, 6, 3, 1, 8, 2};
        sort(a);
        for(int i = 0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * Sorts an Integer array using quicksort
     *
     * @param a the array being sorted.
     */
    public static Integer[] sort(Integer[] a) {

        /* Initializes recursive quicksort */
        sort(a, 0, a.length - 1);

        return a;
    }

    /**
     * Recursively sorts the array by dividing it into subarrays.
     *
     * @param a     the array being sorted.
     * @param left  index of left side of array.
     * @param right index of right side of array.
     * @param pivotIndex the index of the pivot
     **/
    public static void sort(Integer[] a, int left, int right) {

        int pivotIndex;
        if(left < right) {
            pivotIndex = partition(a, left, right);      //calculate the pivot and partition the array
            //System.out.println(left + ", "+ pivotIndex + ", " + right);
            sort(a, left, pivotIndex - 1);             //recursively call the two partitioned sides of the array
            sort(a, pivotIndex + 1, right);
        }


    }

    /**
     * Partition - choose a pivot and move lesser values to the left, and greater values to the right of the pivot
     *
     * @param a     the array being sorted.
     * @param left  index of left side of array.
     * @param right index of righ side of array.
     * @param pivot the pivot value
     * @param pivotIndex the index of the pivot
     **/
    public static int partition(Integer[] a, int left, int right) {
        int pivotIndex = left;
        int pivot = a[right];   //the last value in the (sub)array
        for (int i = left; i < right; i++) {
            if (a[i] <= pivot) {
                swap(a, pivotIndex, i);
                pivotIndex++;
            }
        }
        swap(a, pivotIndex, right);
        return pivotIndex;
    }

        /**
         * Swaps the values at two array indices
         *
         * @param a     the array being sorted
         * @param i, j  two array indices to be swapped
         **/
    public static void swap(Integer[] a, int i, int j){
    int temp = 0;   //temporary value holder
    temp = a[i];
    a[i] = a[j];
    a[j] = temp;

}

}

