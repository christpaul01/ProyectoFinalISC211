package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 976, 486);
		contentPane.add(panel);
		getContentPane().add(panel);
        // Fuente de Datos
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        line_chart_dataset.addValue(80, "visitas", "Julio");
        line_chart_dataset.addValue(300, "visitas", "Agosto");
        line_chart_dataset.addValue(600, "visitas", "Septiembre");
        line_chart_dataset.addValue(1200, "visitas", "Octubre"); 
        line_chart_dataset.addValue(2400, "visitas", "Noviembre");   
 
        // Creando el Grafico
        JFreeChart chart=ChartFactory.createLineChart("Trafico en el Blog",
                "Mes","Visitas",line_chart_dataset,PlotOrientation.VERTICAL,
                true,true,false);  
        
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
        chartPanel.setSize(300, 300);
	}
}
