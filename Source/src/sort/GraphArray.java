package src.sort;
/**
 * Created by Drew on 12/5/2016.
 */

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

public class GraphArray extends JPanel {

    private JFreeChart chart;
    private XYSeries plotData;
    private XYSeriesCollection dataset;
    private volatile ChartPanel chartPanel;
    private final int ARR_LENGTH;

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

//formats the chart: sets bar color, removes effects, sets axis range, removes axis visibility


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

    public void update(int x, int y) {
    	
    	updateXYSeries(x, y);

        
        int sleepTime = 1000 / ARR_LENGTH;

        try {
            Thread.sleep(sleepTime);
        }
        catch(InterruptedException e) {
        }     
        
    }

    public ChartPanel getChartPanel(){
        return chartPanel;
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
