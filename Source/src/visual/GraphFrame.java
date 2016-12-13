package visual;
import sort.*;
import java.awt.*;
import javax.swing.*;
/* Creates that frame that all the sorting algorithms will appear on.
 *
 * Name : Kameron Damaska
 * ID   : krd42
 * Date : 12/11/2016
 */
public class GraphFrame extends JFrame {

    private Sort[] sorts;
    private JPanel container;

    /**
     * Constructs the frame that all the sorting algorithms will exist in.
     *
     * @param sorts   an array of the sorting algorithms displayed.
     * @param manager the layout manager used to organize the sorts.  */ public GraphFrame(Sort[] sorts, LayoutManager manager) {

        super("Sorting Algorithms");
        this.sorts = sorts;
        constructContainer(manager);
        initializeFrame();

    }

    /**
     * Adds the container to the frame.
     */
    private void initializeFrame() {
        add(container);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    /**
     * Organizes the container for the given sorting algorithms.
     *
     * @param manager  the layout manager used to organize the sorts.
     */
    private void constructContainer(LayoutManager manager) {
        this.container = new JPanel();
        container.setLayout(manager);
        setGraphPanels();
    }

    /**
     * Adds each graph of sorting algorithms to the container.
     */
    private void setGraphPanels() {

        for (Sort s : sorts)
            container.add(s.getGraph().getChartPanel());
    }

}
