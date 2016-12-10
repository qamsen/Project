package sort;

/**
 * Abstract class for all sorting algorithms.
 *
 * Name : Kameron Damaska
 * ID   : krd42
 * Date : 12/5/2016 */
import java.lang.Thread;

public abstract class Sort {

    /* The array being sorted. */
    private Integer[] arr;

    /* Checks whether the array is sorted */
    private boolean isSorted;

    /* Graphic representation of the array */
    private GraphArray graph;

    /**
     * Constructs the Sort object.
     *
     * @param arr   the array of the sorting algorithm.
     * @param graph the visualize representation of the graph.
     */
    public Sort(Integer[] arr) {

        this.arr = arr;
        this.isSorted = isSorted(arr);

        /* this.graph = new GraphArray(arr); */
    }

    /* Sorts the array */
    public abstract void sort();

    /**
     * Returns the array.
     *
     * @return the array
     */
    public Integer[] getArray() {
        return arr;
    }

    /**
     * Returns the array sorted.
     *
     * @return the sorted array.
     */
    public Integer[] getSortedArray() {

        /* Sorts array if not already sorted */
        if (!isSorted) {
            sort();
        }

        return getArray();

    }

    public void graph() {
        graph = new GraphArray(getArray());
        getSortedArray();
    }

    public GraphArray getGraph() {
        return graph;
    }

    /**
     * Returns whether the given array is sorted.
     *
     * @param arr the array that is being checked.
     */
    private static boolean isSorted(Integer[] arr) {

        boolean isSorted = false;

        for(int i = 1; i < arr.length && isSorted == true; i++)
            isSorted = arr[i - 1] <= arr[i];

        return isSorted;
    }

}
