/* Performs merge sort on an Integer array.
 *
 * Name : Kameron Damaska
 * ID   : krd42
 * Date : 12/1/2016 */

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        Integer[] a = {7, 4, 5, 6, 3, 1, 8, 2};
        sort(a);
    }

    /**
     * Sorts an Integer array using merge sort.
     *
     * @param a the array being sorted.
     */
    public static Integer[] sort(Integer[] a) {

        /* A temporary array for storing sorted values. */
        Integer[] tmp = new Integer[a.length];

        /* Initializes the recursive merge sort */
        sort(a, tmp, 0, a.length - 1);

        return a;
    }

    /**
     * Recursively sorts the array by dividing it into subarrays.
     *
     * @param a     the array being sorted.
     * @param tmp   array for storing values while sorting.
     * @param left  index of left side of array.
     * @param right index of righ side of array.
     **/
    public static void sort(Integer[] a, Integer[] tmp, int left, int right) {

        /* Continues until using subarray lengh 1 */
        if (left < right) {

            int center = (left + right) / 2;

            /* Sorts the left half of the array */
            sort(a, tmp, left, center);

            /* Sorts the right half of the array */
            sort(a, tmp, center + 1, right);

            /* Merges the two subarrays */
            merge(a, tmp, left, center + 1, right);
        }

    }

    /**
     * Merges two subarrays together.
     *
     * @param a     the array being sorted.
     * @param tmp   the temporary array used for merging.
     * @param left  the start of the left subarray.
     * @param right the start of the right subarray.
     * @param end   the end of the subarrays.
     */
    private static void merge(Integer[] a, Integer[] tmp,
                            int left, int right, int end) {

        /* End of the left subarray */
        int leftEnd = right - 1;

        /* iterator for tmp array */
        int k = left;

        /* Total number of items in the two subarrays */
        int num = end - left + 1;


        /* Merges the subarrays in sorted order */
        while (left <= leftEnd && right <= end) {

            if (a[left] <= a[right])
                tmp[k++] = a[left++];
            else tmp[k++] = a[right++];
        }

        /* Finishes the merge if the left subarray has largest values */
        while (left <= leftEnd)
            tmp[k++] = a[left++];

        /* Finishes the merge if the right subarray has largest values */
        while (right <= end)
            tmp[k++] = a[right++];

        /* Copies tmp back to the array */
        for (int i = 0; i < num; i++, end--) {
            a[end] = tmp[end];
            System.out.println(Arrays.toString(a));
        }
    }

}
