/* Performs insertion sort on an Integer array.
 *
 * Name : Kameron Damaska
 * ID   : krd42
 * Date : 11/28/2016 */
public class InsertionSort extends Sort {

    public InsertionSort(Integer[] arr) {
        super(arr);
    }

    /** 
     * Sorts an Integer array using insertion sort.
     * */
    public void sort() {

        /* The item that needs to be inserted */
        int key;

        /* Sorts the entire array, first value is sorted. */
        for (int j = 1; j < getArray().length; j++) {

            /* The next unsorted value */
            key = getArray()[j];

            /* Color at arr[j] */

            /* Index through the unsorted array. */
            int i;

            /* Sorts the array from right to left */
            for (i = j - 1; (i >= 0) && (getArray()[i] > key); i--) {
                getArray()[i + 1] = getArray()[i];

                /* Color at arr[i + 1] */
            }

            getArray()[i + 1] = key;

            /* Color at arr[i + 1] */
        }

    }

}
