package Vista;

import java.util.Random;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class Grafico {
    static TimeSeries ts = new TimeSeries("f(x)", Millisecond.class);

    public static void graficar(String[] args) throws InterruptedException {


        
        gen myGen = new gen();
        new Thread(myGen).start();

        TimeSeriesCollection dataset = new TimeSeriesCollection(ts);
        JFreeChart grafico = ChartFactory.createTimeSeriesChart("Titulo", "Eje x", "Eje y", dataset, true, true, false);
        final XYPlot plot = grafico.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(20000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 200.0); 

        JFrame frame = new JFrame("Grafico");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChartPanel label = new ChartPanel(grafico);
        frame.getContentPane().add(label);
        //Suppose I add combo boxes and buttons here later


        
        frame.pack();
        frame.setVisible(true);
    }

    static class gen implements Runnable {
        private Random randGen = new Random();
        public void run() {
            while(true) {
                int num = Math.abs(randGen.nextInt()%200);
                System.out.println(num);               
                ts.addOrUpdate(new Millisecond(), num);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

}
