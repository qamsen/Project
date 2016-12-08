/**
 * Created by Drew on 12/5/2016.
 */

package com.company;
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
import org.jfree.data.xy.DefaultIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

import javax.swing.*;



public class GraphArray extends JPanel
{
    private Integer[] arr;

    JFrame frame = new JFrame("Chart One");
    public GraphArray(Integer[] a) {
        super();
        this.arr = a;

// create a dataset...
        //Integer[] a = {7, 4, 5, 6, 3, 1, 8, 2};
        XYSeries plotData = new XYSeries("List");
        for (int i = 0; i < a.length; i++) {
            plotData.add((double) a[i], (double) i+1);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(plotData);

        JFreeChart chart = ChartFactory.createXYBarChart(
                "Sort Visualization",
                "Array Index",
                false,
                "Array Value",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false);

        XYPlot plot = (XYPlot) chart.getPlot();
        //plot.setSeriesPaint(0, Color.cyan);
        // draw a horizontal line across the chart at y == 0
        //plot.addRangeMarker(new Marker(0, Color.red, new BasicStroke(1), Color.red, 1f));

        ChartPanel chartPanel = new ChartPanel(chart);

        add(chartPanel);

    }

    public void graph()
    {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GraphArray(arr), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        int sleepTime = 4000/arr.length;

        try
        {
            Thread.sleep(sleepTime);
        }
        catch(InterruptedException e){}

    }

/*    public void updateGraph(Integer[] a)
    {
        //JFrame frame = new JFrame("Chart One");
        int sleepTime = 4000/a.length;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new GraphArray(a), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        try
        {

            Thread.sleep(sleepTime);
        }
        catch(InterruptedException e){}

    }*/
}