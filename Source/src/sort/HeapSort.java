package sort;
import java.util.Arrays;
//package Algorithms;



/* Performs Heap Sort on an Integer array.
 *
 * Name: Kameron Damaska
 * ID: krd42
 * Date: 11/29/2016 */
public class HeapSort extends Sort {

    public HeapSort(Integer[] arr) {
        super(arr);
    }

    /**
     * Sorts the array using HeapSort.
     */
    GraphArray heapGraph = new GraphArray(getArray());
    public void sort() {

        /* Turns the array into a max heap */
        // heapGraph.graph();
        buildHeap();
        // heapGraph.graph();
        /* Starts at the last value in the heap */
        for (int i = getArray().length - 1; i > 0; i--) {

            /* Swaps the largest value with the last unsorted value */
            swap(0, i);

            /* bubbles the largest unsorted value up the heap */
            bubbleUp(0, i);
        }

    }

    /**
     * Swaps the values in an array at two giving indeces.
     *
     * @param i1  the index of a value to be swapped.
     * @param i2  the index of a value to be swapped.
     */
    private void swap(int i1, int i2) {

        int tmp = getArray()[i1];
        getArray()[i1] = getArray()[i2];
        getArray()[i2] = tmp;
    }

    /**
     * Compares a given element with its parent. If they are not in the correct
     * heap order, swap the parent with the element. Continue until the element
     * is in the correct location.
     *
     * @param i   the location in the array of the element.
     * @param n   furthest point from which a value bubbles up
     */
    private void bubbleUp(int i, int n) {

        int child;
        int tmp;

        for (tmp = getArray()[i]; leftChild(i) < n; i = child) {

            child = leftChild(i);

            if (child != n - 1 && getArray()[child] < getArray()[child + 1])
                child++;
            if (tmp < getArray()[child]) {
                getArray()[i] = getArray()[child];

                //System.out.println(Arrays.toString(getArray()));
                // heapGraph.graph();
            }
            else
                break;
        }
        getArray()[i] = tmp;
    }

    /**
     * Max heapifies a given array.
     *
     * @param arr the array that is heapified.
     */
    private void buildHeap() {

        /* Orders each element in a max heap. */
        for (int i = getArray().length / 2 - 1; i >= 0; i--)
            bubbleUp(i, getArray().length);
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
