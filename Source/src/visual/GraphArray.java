package src.visual;
import java.awt.*;
import java.lang.Thread;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;

/**
 * Created by Drew on 12/5/2016.
 */

public class GraphArray extends JPanel {

    private JFreeChart chart;
    private XYSeries plotData;
    private XYSeriesCollection dataset;
    private volatile ChartPanel chartPanel;
    private final int ARR_LENGTH;

    /**
     * Initialzes the graph.
     *
     * @param a    the array being visualized.
     * @param name the name of the graph.
     */
    public GraphArray(Integer[] a, String name) {
        
        this.ARR_LENGTH = a.length;

        this.plotData = new XYSeries("List");

        for (int i = 0; i < a.length; i++) {
            plotData.add((double) i, (double) a[i]);
        }

        this.dataset = new XYSeriesCollection();
        dataset.addSeries(plotData);



        /* Creates the necessary bar chart */
       this.chart = ChartFactory.createXYBarChart(
                name,
                "",
                false,
                "",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false);

        this.chartPanel = new ChartPanel(chart);
        this.formatChart();

    }

    /**
     * Handles the visual aspect of the graph.
     */
    private void formatChart(){


        XYBarRenderer renderer = (XYBarRenderer)chart.getXYPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.darkGray);
        renderer.setDrawBarOutline(false);
        renderer.setShadowVisible(false);
        renderer.setBarPainter(new StandardXYBarPainter());
        renderer.setSeriesItemLabelsVisible(0, false);
        chart.getXYPlot().getRangeAxis().setVisible(false);
        chart.getXYPlot().getDomainAxis().setVisible(false);
        chart.getXYPlot().getRangeAxis().setRange(0, ARR_LENGTH);
        chart.getXYPlot().getDomainAxis().setRange(-0.5, ARR_LENGTH-0.5);

    }

    /**
     * Updates the array and sleeps the program for a given time.
     *
     * @param x  the index at which the value is changed.
     * @param y  the new value.
     */
    public void update(int x, int y) {
        
        updateXYSeries(x, y);
        
        int sleepTime = 1000 / ARR_LENGTH;
        
        if (sleepTime == 0)
            sleepTime = 1;

        try {
            Thread.sleep(sleepTime);
        }
        catch(InterruptedException e) {
        }     
        
    }

    /**
     * Returns the panel that the graph is visualized on.
     *
     * @return  the panel of the graph.
     */
    public ChartPanel getChartPanel(){
        return chartPanel;
    }
    
    /**
     * Updates the data in the series.
     *
     * @param x  the index at which the value is changed.
     * @param y  the new value.
     */
    private void updateXYSeries(int x, int y) {
        int i = plotData.indexOf(x);
        plotData.updateByIndex(i, y);
    }
    
}
