public class VisualSorting {

    public static void main(String[] args) {

        /* Checks to make sure the inputs are valid */
        validInputs = false;

        /* The name of the sorting algorithm the user input */
        String sortName;

        /* Array length the user input */
        int arrayLength;

        /* Checks the sorting algorithm name */
        try {
            validInputs = isValidInput(args[0]);
        }
        catch (NullPointerException e) {
        }

        /* Checks that the array length is valid */
        try {
            arrayLength = String.parseInt(args[1]);
            validInputs = true;
        }
        catch (NullPointerException e || NumberFormatException f) {
        }

        /* Runs program when an algorithm and array length is supplied */
        if (validInputs) {
            launchProgram(sortName, arrayLength);
        }

        /* Error catching */
        else
            System.out.println("Please give valid inputs");
    }

    /**
     * Runs the sorting algorithm
     *
     * @param sortName    the name of the sorting algorithm being run.
     * @param arrayLength the length of the array the program will sort.  */
    public static void launchProgram(String sortName, int arrayLength) {

        /* Creates a random array to be sorted */
        Integer[] arr = randomArray(arrayLength);

        /* Runs the given sorting algorithm */
        switch (sortName) {
            case "mergesort":
                    MergeSort sort = new MergeSort(arr);
                    sort.getSortedArray();
            case "heapsort":
                    HeapSort sort = new HeapSort(arr);
                    sort.getSortedArray();
            case "insertionsort":
                    InsertionSort sort = new InsertionSort(arr);
                    sort.getSortedArray();
            case "quicksort":
                    QuickSort sort = new QuickSort(arr);
                    sort.getSortedArray();
            case "shellsort":
                    ShellSort sort = new ShellSort(arr);
                    sort.getSortedArray();
        }
    }

    /**
     * Removes all whitespaces in the String and decapitalizes it.
     *
     * @param s the String being stripped.
     * @return  the String with no capital letters or whitespace.
     */
    public static String parseString(String s) {

        s = s.toLowerCase();
        s = s.replaceAll("\\s+","");

        return s;
    }

    /**
     * Returns a randomly sorted array.
     *
     * @param arrayLength the length of the random array.
     * @return            a randomly sorted array.
     */
     * public static Integer[] randomArray(int arrayLength) {

        Integer[] arr = new Integer[arrayLength];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        /* Randomizes the contents of the array */
        return Collections.shuffle(arr);
    }

    /**
     * Checks to see if a String is the name of a sorting algorithm in this
     * program.
     *
     * @param sortName the String that is being checked.
     * @return         if the String is the name of a sorting algorithm.
     */
    private static boolean isValidSort(String sortName) {

        /* The valid sorting algorithms in this program */
        List validSorts = Arrays.toList(
                {"mergesort", "heapsort", "insertionsort", "quicksort", "shellsort"});

        /* Removes white space and decapitalizes the String */
        sortName = parseString(sortName);

        return validSorts.contains(sortName);
    }

}
