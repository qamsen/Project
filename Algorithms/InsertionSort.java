/* Performs insertion sort on an Integer array.
 *
 * Name : Kameron Damaska
 * ID   : krd42
 * Date : 11/28/2016 */

public class InsertionSort {

    /* Sorts an Integer array using insertion sort.
     *
     * @param arr the array being sorted.
     * @return    the sorted array.
     * */
    public static Integer[] sort(Integer[] arr) {

        /* The item that needs to be inserted */
        int key;

        /* Sorts the entire array, first value is sorted. */
        for (int j = 1; j < arr.length; j++) {

            /* The next unsorted value */
            key = arr[j];

            /* Color at arr[j] */

            /* Index through the unsorted array. */
            int i;

            /* Sorts the array from right to left */
            for (i = j - 1; (i >= 0) && (arr[i] > key); i--) {
                arr[i + 1] = arr[i];

                /* Color at arr[i + 1] */
            }

            arr[i + 1] = key;

            /* Color at arr[i + 1] */
        }

        return arr;
    }

}
