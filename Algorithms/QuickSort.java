/* Performs quicksort on an Integer array.
 *
 * Name : Drew Borneman
 * ID   : awb79
 * Date : 12/4/2016 */
public class QuickSort extends Sort{

    public QuickSort(Integer[] arr) {
        super(arr);
    }

    /**
     * Sorts an Integer array using quicksort
     *
     * @param a the array being sorted.
     */
    public void sort() {

        /* Initializes recursive quicksort */
        sort(0, getArray().length - 1);
    }

    /**
     * Recursively sorts the array by dividing it into subarrays.
     *
     * @param left  index of left side of array.
     * @param right index of right side of array.
     **/
    private void sort(int left, int right) {

        int pivotIndex;
        if(left < right) {
            pivotIndex = partition(left, right);      //calculate the pivot and partition the array
            //System.out.println(left + ", "+ pivotIndex + ", " + right);
            sort(left, pivotIndex - 1);             //recursively call the two partitioned sides of the array
            sort(pivotIndex + 1, right);
        }


    }

    /**
     * Partition - choose a pivot and move lesser values to the left, and
     * greater values to the right of the pivot
     *
     * @param left  index of left side of array.
     * @param right index of righ side of array.
     **/
    private int partition(int left, int right) {
        int pivotIndex = left;
        int pivot = getArray()[right];   //the last value in the (sub)array
        for (int i = left; i < right; i++) {
            if (getArray()[i] <= pivot) {
                swap(pivotIndex, i);
                pivotIndex++;
            }
        }
        swap(pivotIndex, right);
        return pivotIndex;
    }

    /**
     * Swaps the values at two array indices
     *
     * @param i, j  two array indices to be swapped
     **/
    private void swap(int i, int j){
        int temp = 0;   //temporary value holder
        temp = getArray()[i];
        getArray()[i] = getArray()[j];
        getArray()[j] = temp;

    }

}

