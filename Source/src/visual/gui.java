package src.visual;
import javax.swing.JFrame;
import src.sort.*;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JCheckBox;
import java.util.ArrayList;
import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
/*
 * Created by Drew on 12/9/2016.
 */

public class gui extends WindowAdapter{

    private Integer[] arr;
    private Sort[] sort;
    private int arraySize;
    
    public gui(){

        //createGUI();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
        
        
    }

    public Sort[] getSortArray(){
        return this.sort;
    }
    public int getArraySize(){
        return this.arraySize;
    }
    
    private void createGUI(){
        //gets the screen dimensions for scaling purposes
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //double xSize = screenSize.getWidth()/3;
       // double ySize = screenSize.getHeight()/3;


        JFrame frame = new JFrame("Sorting Algorithm Comparison");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        //frame.setSize(new Dimension((int)xSize, (int)ySize));

        JFrame.setDefaultLookAndFeelDecorated(true);
        JPanel mainPanel = new JPanel();
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), BorderFactory.createEtchedBorder()));
        JPanel arraySizePanel = new JPanel();
        //arraySizePanel.setBorder(BorderFactory.createEtchedBorder());
        JPanel startButtonPanel = new JPanel();
        startButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
        FlowLayout arraySizeLayout = new FlowLayout();
        arraySizeLayout.setHgap(0);
        arraySizePanel.setLayout(arraySizeLayout);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel CheckLabel = new JLabel("Select Sorting Algorithms to compare:     ");
        checkBoxPanel.add(CheckLabel);
        JCheckBox HeapSort = new JCheckBox("Heap Sort");
        checkBoxPanel.add(HeapSort);
        JCheckBox InsertionSort = new JCheckBox("Insertion Sort");
        checkBoxPanel.add(InsertionSort);
        JCheckBox MergeSort = new JCheckBox("Merge Sort");
        checkBoxPanel.add(MergeSort);
        JCheckBox QuickSort = new JCheckBox("Quick Sort");
        checkBoxPanel.add(QuickSort);
        JCheckBox ShellSort = new JCheckBox("Shell Sort");
        checkBoxPanel.add(ShellSort);

        JLabel arraySizeLabel = new JLabel("Array size (2-10000): ");
        arraySizePanel.add(arraySizeLabel);
        JTextField arraySize = new JTextField(4);
        arraySizePanel.add(arraySize);
        //arraySizePanel.setSize(checkBoxPanel.getWidth(), arraySize.getHeight());

        //arraySizePanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JButton startButton = new JButton("Start");
        startButtonPanel.add(startButton);

        startButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                Object[] sortArray;
                ArrayList sortList = new ArrayList();
                int intArraySize = 0;
                Integer[] arr = {};
                int i = 0;

                if(arraySize.getText() != "") {
                    intArraySize = Integer.parseInt(arraySize.getText());
                    arr = randomArray(intArraySize);
                }

                Integer[][] arrays = copyArrays(5, arr);

                if(HeapSort.isSelected()){
                    sortList.add(new HeapSort(arrays[i]));
                    i++;
                    
                }
                if(MergeSort.isSelected()){
                    sortList.add(new MergeSort(arrays[i]));
                    i++;
                }
                if(QuickSort.isSelected()){
                    sortList.add(new QuickSort(arrays[i]));
                    i++;
                    
                }
                if(ShellSort.isSelected()){
                    sortList.add(new ShellSort(arrays[i]));
                    i++;
                    
                }
                if(InsertionSort.isSelected()){
                    sortList.add(new InsertionSort(arrays[i]));
                    i++;
                    
                }

                sortArray = sortList.toArray();
                gui.this.arraySize = intArraySize;
                gui.this.sort = Arrays.copyOf(sortArray, sortArray.length, Sort[].class);

                    if (intArraySize >= 2 && intArraySize <= 1000)
                        startSort(sort);



            }
        });

        mainPanel.add(checkBoxPanel);
        mainPanel.add(arraySizePanel);
        mainPanel.add(startButtonPanel);

        frame.add(mainPanel);
        
        //frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Copies a given array and returns an array containing the copies.
     *
     * @param nArrays   number of arrays copied.
     * @param arrCopied source array.
     * @return          an array of the copied arrays.
     */
    private static Integer[][] copyArrays(int nArrays, Integer[] arrCopied) {

        Integer[][] arrays = new Integer[nArrays][];

        for (int i = 0; i < nArrays; i++) {

            arrays[i] = new Integer[arrCopied.length];

            for (int j = 0; j < arrCopied.length; j++) {
                arrays[i][j] = arrCopied[j];
            }

        }

        return arrays;
    }

    private void startSort(Sort[] sort){

        GridLayout manager = new GridLayout(sort.length/ 2, (sort.length + 1) / 2);

        GraphFrame f = new GraphFrame(sort, manager);

        f.setVisible(true);

        for (Sort s : sort) {
            //switch(s.getClass())

            (new Thread(s)).start();

        }

    }


    /**
     * Returns a randomly sorted array.
     *
     * @param arrayLength the length of the random array.
     * @return            a randomly sorted array.
     */
    public static Integer[] randomArray(int arrayLength) {

        Integer[] arr = new Integer[arrayLength];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(arr));
        return arr;
    }

    public static void main(String[] args) {

        gui mainGUI = new gui();

    }

}
