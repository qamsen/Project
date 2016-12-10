package sort;
import java.util.Arrays;

/* Performs merge sort on an Integer array.
 *
 * Name : Kameron Damaska
 * ID   : krd42
 * Date : 12/1/2016 */
public class MergeSort extends Sort {

    public MergeSort(Integer[] arr) {
        super(arr);
    }

    /**
     * Sorts an Integer array using merge sort.
     *
     * @param a the array being sorted.
     */
    public void sort() {

        /* A temporary array for storing sorted values. */
        Integer[] tmp = new Integer[getArray().length];

        /* Initializes the recursive merge sort */
        // mergeGraph.graph();
        sort(tmp, 0, getArray().length - 1);
    }

    /**
     * Recursively sorts the array by dividing it into subarrays.
     *
     * @param tmp   array for storing values while sorting.
     * @param left  index of left side of array.
     * @param right index of righ side of array.
     **/
    private void sort(Integer[] tmp, int left, int right) {

        /* Continues until using subarray lengh 1 */
        if (left < right) {

            int center = (left + right) / 2;

            /* Sorts the left half of the array */
            sort(tmp, left, center);

            /* Sorts the right half of the array */
            sort(tmp, center + 1, right);

            /* Merges the two subarrays */
            merge(tmp, left, center + 1, right);
        }

    }

    /**
     * Merges two subarrays together.
     *
     * @param tmp   the temporary array used for merging.
     * @param left  the start of the left subarray.
     * @param right the start of the right subarray.
     * @param end   the end of the subarrays.
     */
    private void merge(Integer[] tmp, int left, int right, int end) {

        /* End of the left subarray */
        int leftEnd = right - 1;

        /* iterator for tmp array */
        int k = left;

        /* Total number of items in the two subarrays */
        int num = end - left + 1;


        /* Merges the subarrays in sorted order */
        while (left <= leftEnd && right <= end) {

            if (getArray()[left] <= getArray()[right])
                tmp[k++] = getArray()[left++];
            else tmp[k++] = getArray()[right++];
        }

        /* Finishes the merge if the left subarray has largest values */
        while (left <= leftEnd)
            tmp[k++] = getArray()[left++];

        /* Finishes the merge if the right subarray has largest values */
        while (right <= end)
            tmp[k++] = getArray()[right++];

        /* Copies tmp back to the array */
        for (int i = 0; i < num; i++, end--) {

            if (!(getArray()[end] == tmp[end])) {
                getArray()[end] = tmp[end];
                getGraph().update(end, getArray()[end]);
            }

        }
    }

}
