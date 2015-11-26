package gui.utils.histogram;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import i18n.GUIStr;
import i18n.I18n;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public abstract class AbstractHistogram {
    
    private String title = null;
    private String name = null;
    private int min = 0;
    private int max = 255;
    private ArrayList<Integer> pixelArray = null;
    
    public AbstractHistogram(String title, String name) {
        
        this.title = title;
        this.name = name;
    }
    
    /**
     * Muestra el histograma con los datos ya calculados
     * y ordenados correctamente
     */        
    public void showHistogram(ArrayList<Integer> pixelArray) {
        
        this.pixelArray = pixelArray;
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowFrame();
            }
        });        
    }
    
    /**
     * Crea la nueva ventana donde se mostrará el histograma
     * y invoca el hilo de ejecución de JavaFX
     */    
    private void initAndShowFrame() {
        
        JFrame frame = new JFrame(title + "(" + name + ")");
        frame.setLayout(new BorderLayout(0,1));
        
        JFXPanel fxPanel = new JFXPanel();
        JPanel infoPanel = addInformation();    
        frame.add(fxPanel,BorderLayout.CENTER);
        frame.add(infoPanel,BorderLayout.SOUTH);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
       });        
    }
    
    /**
     * Crea la escena y componentes de JavaFX
     */
    private void initFX(JFXPanel fxPanel) {
        Scene scene = createChart();
        fxPanel.setScene(scene);
    }
    
    /**
     * Devuelve la escena que contiene el histograma de color
     * @return  el gráfico del histograma
     */
    @SuppressWarnings("unchecked")
    private Scene createChart() {

        // Elementos
        CategoryAxis x = new CategoryAxis();
        NumberAxis y = new NumberAxis();
        AreaChart<String, Number> chart = new AreaChart<>(x,y);
        
        // Nombres
        chart.setTitle(title);
        chart.setLegendVisible(false);
        x.setLabel(I18n.getString(GUIStr.HISTOGRAM_LABEL_COLOR));
        y.setLabel(I18n.getString(GUIStr.HISTOGRAM_LABEL_PIXELS));
        
        // Introducir datos
        XYChart.Series<String, Number> serie = new XYChart.Series<String, Number>();

        for (int i=0; i<=255; i++) {
            serie.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), pixelArray.get(i)));
            min = i;
        }
        // Añadir a la escena
        Scene scene = new Scene(chart,600,400);
        chart.getData().addAll(serie);

        return scene;
    }    
    
    /**
     * Crea el panel con la informacion acerca del histograma
     * @return  jpanel
     */
    private JPanel addInformation() {
        
        calculateInformation();
        
//        JPanel panel = new JPanel(new GridLayout(0,2));
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(50,50));
        
        panel.add(new JLabel("Min: " + min));
        panel.add(new JLabel("Max: " + max));
        
        return panel;
    }
    
    /**
     * Calcula los diferentes parametros de informacion del histograma
     */
    private void calculateInformation() {
        
        for (int i=0; i<=255; i++) {
            if ((min == 0) && (pixelArray.get(i) > 0))
                min = i;
            if ((max == 255) && (pixelArray.get(255-i) > 0))
                max = 255-i;
            if ((min > 0) && (max < 255))
                break;
        }      
    }
}
