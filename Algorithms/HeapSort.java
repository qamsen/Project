/* Performs Heap Sort on an Integer array.
 * 
 * Name: Kameron Damaska
 * ID: krd42
 * Date: 11/29/2016 */
public class HeapSort {

    public static void main(String[] args) {
        Integer[] arr = {2, 1, 3, 4};
        sort(arr);
        for (int i : arr)
            System.out.print(i);
    }

    public static Integer[] sort(Integer[] arr) {

        /* Turns the array into a max heap */
        buildHeap(arr);

        /* Starts at the last value in the heap */
        for (int i = arr.length - 1; i > 0; i--) {

            /* Swaps the largest value with the last unsorted value */
            swap(arr, 0, i);

            /* bubbles the largest unsorted value up the heap */
            bubbleUp(arr, 0, i);
        }

        return arr;
    }

    /**
     * Swaps the values in an array at two giving indeces.
     *
     * @param arr the array in which values are being swapped.
     * @param i1  the index of a value to be swapped.
     * @param i2  the index of a value to be swapped.
     */
    private static void swap(Integer[] arr, int i1, int i2) {

        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    /**
     * Compares a given element with its parent. If they are not in the correct
     * heap order, swap the parent with the element. Continue until the element
     * is in the correct location.
     *
     * @param arr the array that the element is in.
     * @param i   the location in the array of the element.
     * @param n   furthest point from which a value bubbles up
     */
    private static void bubbleUp(Integer[] arr, int i, int n) {

        int child;
        int tmp;

        for (tmp = arr[i]; leftChild(i) < n; i = child) {

            child = leftChild(i);

            if (child != n - 1 && arr[child] < arr[child + 1])
                child++;
            if (tmp < arr[child])
                arr[i] = arr[child];
            else
                break;
        }
        arr[i] = tmp;
    }

    /**
     * Max heapifies a given array.
     *
     * @param arr the array that is heapified.
     */
    private static void buildHeap(Integer[] arr) {

        /* Orders each element in a max heap. */
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            bubbleUp(arr, i, arr.length);
    }

    /**
     * Returns the index of a left child for a given index.
     *
     * @param i the index of a given node.
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

}
