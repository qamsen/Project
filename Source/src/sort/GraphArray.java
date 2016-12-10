package sort;
/**
 * Created by Drew on 12/5/2016.
 */

import java.lang.Thread;

import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Paint;
import java.awt.Color;
import java.awt.BasicStroke;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

import javax.swing.*;



public class GraphArray extends JPanel {

    private JFrame frame;
    private JFreeChart chart;
    private XYSeries plotData;
    private XYSeriesCollection dataset;
    private ChartPanel chartPanel;
    private final int ARR_LENGTH;

    public GraphArray(Integer[] a) {
    	
    	this.ARR_LENGTH = a.length;
    	
    	frame = new JFrame("Chart One");

        this.plotData = new XYSeries("List");

        for (int i = 0; i < a.length; i++) {
            plotData.add((double) i, (double) a[i]);
        }

        this.dataset = new XYSeriesCollection();
        dataset.addSeries(plotData);

        /* Creates the necessary bar chart */
        this.chart = ChartFactory.createXYBarChart(
                "Sort Visualization",
                "Array Index",
                false,
                "Array Value",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false);

        this.chartPanel = new ChartPanel(chart);

        add(chartPanel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }

    public void update(int x, int y) {
    	
    	updateXYSeries(x, y);

        
        int sleepTime = 4000 / ARR_LENGTH;

        try {
            Thread.sleep(sleepTime);
        }
        catch(InterruptedException e) {
        }     
        
    }
    
    private void updateXYSeries(int x, int y) {
    	int i = plotData.indexOf(x);
    	plotData.updateByIndex(i, y);
    }
    
/*     public void graph()
 *     {
 * 
 *         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 *         frame.getContentPane().add(new GraphArray(arr), BorderLayout.CENTER);
 *         frame.pack();
 *         frame.setVisible(true);
 *         int sleepTime = 4000/ ((arr.length) * (arr.length));
 * 
 *         try
 *         {
 *             Thread.sleep(0);
 *         }
 *         catch(InterruptedException e){}
 * 
 *     } */

}
