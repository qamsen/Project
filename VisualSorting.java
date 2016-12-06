import Algorithms.*;

public class VisualSorting {

    
    List validSorts = Arrays.toList(
            {"mergesort", "heapsort", "insertionsort", "quicksort", "shellsort"});

    public static void main(String[] args) {

        validInputs = false;
        String sortName;
        int arrayLength;

        try {
            sortName = parseString(args[0]);
            validInputs = validSorts.contains(sortName);
        }
        catch (NullPointerException e) {
        }

        try {
            arrayLength = String.parseInt(args[1]);
            validInputs = true;
        }
        catch (NullPointerException e || NumberFormatException f) {
        }

        if (validInputs) {
            launchProgram(sortName, arrayLength);
        }
        else System.out.println("Please give valid inputs"); }

    public static void launchProgram(String sortName, int arrayLength) {
        Integer[] arr = randomArray(arrayLength);

        switch (sortName) {
            case 1: sortName = "mergesort";
                    MergeSort sort = new MergeSort(arr);
                    sort.getSortedArray();
            case 2: sortName = "heapsort";
                    HeapSort sort = new HeapSort(arr);
                    sort.getSortedArray();
            case 3: sortName = "insertionsort";
                    InsertionSort sort = new InsertionSort(arr);
                    sort.getSortedArray();
            case 4: sortName = "quicksort";
                    QuickSort sort = new QuickSort(arr);
                    sort.getSortedArray();
            case 5: sortName = "shellsort";
                    ShellSort sort = new ShellSort(arr);
                    sort.getSortedArray();
        }
    }

    public static String parseString(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("\\s+","");
    }

    public static Integer[] randomArray(int arrayLength) {

        Integer[] arr = new Integer[arrayLength];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        return Collections.shuffle(arr);
    }

}
