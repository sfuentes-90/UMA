/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author Santiago
 */
public class PanelIzquierdo extends JPanel{
    static TimeSeries ts = new TimeSeries("f(x)", Millisecond.class);
    
    public PanelIzquierdo(){
        TimeSeriesCollection dataset = new TimeSeriesCollection(ts);
        JFreeChart grafico = ChartFactory.createTimeSeriesChart("Titulo", "Eje x", "Eje y", dataset, true, true, false);
        final XYPlot plot = grafico.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(20000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 200.0); 
        ChartPanel label = new ChartPanel(grafico);
        
        this.setLayout(new BorderLayout());
        this.add(label);
    }
}
