package view;
import java.awt.Dimension;
import java.util.Map;
import javax.swing.JPanel;
import model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    
    private Histogram<String> hist;
    private String x,y;
    
    public HistogramDisplay(String title, Histogram p,String x,String y) {
        super(title);
        hist = p;
        this.x = x;
        this.y = y;
        setContentPane(CreatePanel());
        pack();
    }
    
    private JPanel CreatePanel(){
        ChartPanel chartPanel = new ChartPanel(CreateChart(CreateDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private JFreeChart CreateChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart(
                "Histogram",x,y,
                dataSet, PlotOrientation.VERTICAL,false,
                rootPaneCheckingEnabled,rootPaneCheckingEnabled);
        
        return chart;
    }
    
    private DefaultCategoryDataset CreateDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(Map.Entry<String,Integer> entry : this.hist.getMap().entrySet()){
            dataSet.addValue(entry.getValue(),"",entry.getKey());
        }
        
        return dataSet;
    }
    
    public void execute(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
}