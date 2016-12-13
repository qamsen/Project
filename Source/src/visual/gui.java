package visual;
import javax.swing.JFrame;
import sort.*;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JCheckBox;
import java.util.ArrayList;
import java.lang.String;
/**
 * Created by Drew on 12/9/2016.
 */
public class gui extends WindowAdapter{

    private static void createGUI(){
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
                int sortCounter = 0;
                int intArraySize = 0;

                if(arraySize.getText() != "")
                    intArraySize = Integer.parseInt(arraySize.getText());

                if(HeapSort.isSelected()){
                    sortList.add(new HeapSort(VisualSorting.randomArray(intArraySize)));
                    sortCounter++;
                }
                if(MergeSort.isSelected()){
                    sortList.add(new MergeSort(VisualSorting.randomArray(intArraySize)));
                    sortCounter++;
                }
                if(QuickSort.isSelected()){
                    sortList.add(new QuickSort(VisualSorting.randomArray(intArraySize)));
                    sortCounter++;
                }
                if(ShellSort.isSelected()){
                    sortList.add(new ShellSort(VisualSorting.randomArray(intArraySize)));
                    sortCounter++;
                }
                if(InsertionSort.isSelected()){
                    sortList.add(new InsertionSort(VisualSorting.randomArray(intArraySize)));
                    sortCounter++;
                }

                sortArray = sortList.toArray();

                if(sortCounter>0 && intArraySize >= 2 && intArraySize <= 10000){
                    //call the function
                }

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

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

}
