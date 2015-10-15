package gui_utils;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Histogram {
    
    private NamedImage image = null;
    private HashMap<Color, Integer> pixelsCount = null;
    private HashMap<Integer, Integer> sortedPixels = new HashMap<Integer,Integer>();
    
    public Histogram(NamedImage image) {
     
        this.image = image; //Recuperar nombre y pixeles
        this.pixelsCount = image.getPixelColorCount();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowFrame();
            }
        });
    }
    
    private void initAndShowFrame() {
        
        JFrame frame = new JFrame("Histograma");
        JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Provisional

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
       });        
    }
    
    private void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createChart();
        fxPanel.setScene(scene);
    }
    
    private Scene createChart() {

        // Elementos
        CategoryAxis x = new CategoryAxis();
        NumberAxis y = new NumberAxis();
        BarChart<String, Number> chart = new BarChart<>(x,y);
        
        // Nombres
        chart.setTitle("Histograma de color");
        x.setLabel("Color");
        y.setLabel("Número de píxeles");
        
        // Ordenar píxeles por color
        sortPixelsCount();
        
        // Introducir datos
        XYChart.Series serie = new XYChart.Series();
        
        // Ordenar píxeles por color
        
        
        for (int i=0; i<=255; i++) {
            
            Integer pixel = sortedPixels.get(i);
            
            if (pixel != null)
                serie.getData().add(new XYChart.Data(String.valueOf(i), pixel));
            else
                serie.getData().add(new XYChart.Data(String.valueOf(i), 0));
        }
        
//        System.out.println(pixelsCount.size());
 
        
        Scene scene = new Scene(chart,400,400);
        chart.getData().addAll(serie);

        return scene;
    }    
    
    private void sortPixelsCount() {
        // TODO: provisional para imágenes en blanco y negro
        
        for (Entry<Color, Integer> entry : pixelsCount.entrySet()) {
            Color key = entry.getKey();
            Integer value = entry.getValue();
            
            sortedPixels.put(key.getBlue(), value);  
        }
    }
}
