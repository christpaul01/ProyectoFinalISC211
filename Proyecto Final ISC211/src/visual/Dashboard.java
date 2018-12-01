package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame {

	private JPanel pnlTabsDashboard;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtFldidUsuario;
	private JTextField textField_3;
	private JPasswordField passAdmin;
	private JPasswordField passConfAdmin;

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
		setResizable(false);
		setTitle("ADMINISTRACION -- Tienda V.0.98");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1153, 656);
		pnlTabsDashboard = new JPanel();
		pnlTabsDashboard.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlTabsDashboard);
		pnlTabsDashboard.setLayout(null);
		
		
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JTabbedPane tabs_Dashboard = new JTabbedPane(JTabbedPane.TOP);
        tabs_Dashboard.setBounds(203, 65, 918, 528);
        pnlTabsDashboard.add(tabs_Dashboard);
        
        JPanel panel_1 = new JPanel();
        tabs_Dashboard.addTab("Ventas", null, panel_1, null);
         panel_1.setLayout(null);
        
          
		 // Fuente de Datos
        DefaultCategoryDataset lcd_Ventas = new DefaultCategoryDataset();
        
 
        // Creando el Grafico
        JFreeChart chartVentas=ChartFactory.createLineChart("Resumen de Ventas",
                "Mes","Cantidad",lcd_Ventas,PlotOrientation.VERTICAL,
                true,true,false);
        
         
         // Mostrar Grafico
         ChartPanel pnlChartVentas = new ChartPanel(chartVentas);
         pnlChartVentas.setBounds(135, 11, 680, 420);
         panel_1.add(pnlChartVentas);
         
         //Agregango datos (Remplazar por funccion)
         lcd_Ventas.addValue(80, "visitas", "Julio");
         lcd_Ventas.addValue(300, "visitas", "Agosto");
         lcd_Ventas.addValue(600, "visitas", "Septiembre");
         lcd_Ventas.addValue(1200, "visitas", "Octubre"); 
         lcd_Ventas.addValue(2400, "visitas", "Noviembre");
         lcd_Ventas.addValue(1000, "Compras", "Octubre");
         lcd_Ventas.addValue(1100, "Compras", "Noviembre");
         
         
         
         
         
         
         JPanel pnlStock = new JPanel();
         tabs_Dashboard.addTab("Stocks", null, pnlStock, null);
         
         
         
         
         //Test
         
         
         String series1 = "Stock";
         String series2 = "Ventas";
         
         String category1 = "Ram";
         String category2 = "Motherboards";
         String category3 = "Disco Duros";
         String category4 = "Procesadores";
         String category5 = "Kits";
         
         DefaultCategoryDataset lcd_Stock = new DefaultCategoryDataset();
         
         lcd_Stock.addValue(1.5, series1, category1);
         lcd_Stock.addValue(4.0, series1, category2);
         lcd_Stock.addValue(3.0, series1, category3);
         lcd_Stock.addValue(5.0, series1, category4);
         lcd_Stock.addValue(5.0, series1, category5);
         
         lcd_Stock.addValue(5.0, series2, category1);
         lcd_Stock.addValue(7.0, series2, category2);
         lcd_Stock.addValue(6.0, series2, category3);
         lcd_Stock.addValue(8.0, series2, category4);
         lcd_Stock.addValue(4.0, series2, category5);
         
         JFreeChart chartStock = ChartFactory.createBarChart(
                 "Resumen de stocks",         // chart title
                 "Componentes",               // domain axis label
                 "Cantidad",                  // range axis label
                 lcd_Stock,                  // data
                 PlotOrientation.VERTICAL, // orientation
                 true,                     // include legend
                 true,                     // tooltips?
                 false                     // URLs?
             );
         
         
         ChartPanel pnlChartStock = new ChartPanel(chartStock);
         pnlChartStock.setBounds(135, 11, 680, 420);
         pnlStock.setBounds(144, 11, 680, 420);
         pnlStock.setLayout(null);
         pnlStock.add(pnlChartStock);
         
         JPanel pnlBotones = new JPanel();
         pnlBotones.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
         pnlBotones.setBounds(10, 11, 183, 582);
         pnlTabsDashboard.add(pnlBotones);
         pnlBotones.setLayout(null);
         
         
         
         JTabbedPane tabsVendedores = new JTabbedPane(JTabbedPane.TOP);
         tabsVendedores.setBounds(203, 65, 918, 528);
         pnlTabsDashboard.add(tabsVendedores);
         
         
         JPanel panel = new JPanel();
         tabsVendedores.addTab("Registrar", null, panel, null);
         panel.setLayout(null);
         
         JLabel lblIdUsuario = new JLabel("ID Usuario:");
         lblIdUsuario.setBounds(441, 100, 93, 14);
         panel.add(lblIdUsuario);
         
         JLabel lblNombre = new JLabel("Nombre:");
         lblNombre.setBounds(441, 131, 93, 14);
         panel.add(lblNombre);
         
         JLabel lblContrasena = new JLabel("Contrasena:");
         lblContrasena.setBounds(441, 165, 93, 14);
         panel.add(lblContrasena);
         
         textField = new JTextField();
         textField.setBounds(544, 100, 140, 17);
         panel.add(textField);
         textField.setColumns(10);
         
         textField_1 = new JTextField();
         textField_1.setColumns(10);
         textField_1.setBounds(544, 131, 140, 17);
         panel.add(textField_1);
         
         passwordField = new JPasswordField();
         passwordField.setBounds(544, 165, 140, 17);
         panel.add(passwordField);
         
         JLabel lblConfirmar = new JLabel("Confirmar:");
         lblConfirmar.setBounds(441, 195, 80, 14);
         panel.add(lblConfirmar);
         
         passwordField_1 = new JPasswordField();
         passwordField_1.setBounds(544, 193, 140, 17);
         panel.add(passwordField_1);
         
         JButton btnAcceptar = new JButton("Acceptar");
         btnAcceptar.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         	}
         });
         btnAcceptar.setBounds(573, 242, 103, 23);
         panel.add(btnAcceptar);
         
         JButton btnCancelar = new JButton("Cancelar");
         btnCancelar.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         	}
         });
         btnCancelar.setBounds(441, 242, 103, 23);
         panel.add(btnCancelar);
         
         JSeparator separator = new JSeparator();
         separator.setOrientation(SwingConstants.VERTICAL);
         separator.setForeground(Color.LIGHT_GRAY);
         separator.setBounds(399, 47, 11, 400);
         panel.add(separator);
         
         JPanel panel_2 = new JPanel();
         tabsVendedores.addTab("Listar", null, panel_2, null);
         panel_2.setLayout(null);
         
         
         
         
         
         JTabbedPane tabsAdmin = new JTabbedPane(JTabbedPane.TOP);
         tabsAdmin.setBounds(203, 65, 918, 528);
         pnlTabsDashboard.add(tabsAdmin);
         
         JPanel pnlRegAdmin = new JPanel();
         pnlRegAdmin.setLayout(null);
         tabsAdmin.addTab("Registrar", null, pnlRegAdmin, null);
         
         JLabel lblUsuario = new JLabel("ID Usuario:");
         lblUsuario.setBounds(441, 100, 93, 14);
         pnlRegAdmin.add(lblUsuario);
         
         JLabel lblNombreAdmin = new JLabel("Nombre:");
         lblNombreAdmin.setBounds(441, 131, 93, 14);
         pnlRegAdmin.add(lblNombreAdmin);
         
         JLabel lblContAdmin = new JLabel("Contrasena:");
         lblContAdmin.setBounds(441, 165, 93, 14);
         pnlRegAdmin.add(lblContAdmin);
         
         txtFldidUsuario = new JTextField();
         txtFldidUsuario.setColumns(10);
         txtFldidUsuario.setBounds(544, 100, 140, 17);
         pnlRegAdmin.add(txtFldidUsuario);
         
         textField_3 = new JTextField();
         textField_3.setColumns(10);
         textField_3.setBounds(544, 131, 140, 17);
         pnlRegAdmin.add(textField_3);
         
         passAdmin = new JPasswordField();
         passAdmin.setBounds(544, 165, 140, 17);
         pnlRegAdmin.add(passAdmin);
         
         JLabel lblConfAdmin = new JLabel("Confirmar:");
         lblConfAdmin.setBounds(441, 195, 80, 14);
         pnlRegAdmin.add(lblConfAdmin);
         
         passConfAdmin = new JPasswordField();
         passConfAdmin.setBounds(544, 193, 140, 17);
         pnlRegAdmin.add(passConfAdmin);
         
         JButton btnAccptAdmin = new JButton("Acceptar");
         btnAccptAdmin.setBounds(573, 242, 103, 23);
         pnlRegAdmin.add(btnAccptAdmin);
         
         JButton btnCnclAdmin = new JButton("Cancelar");
         btnCnclAdmin.setBounds(441, 242, 103, 23);
         pnlRegAdmin.add(btnCnclAdmin);
         
         JSeparator separator_1 = new JSeparator();
         separator_1.setOrientation(SwingConstants.VERTICAL);
         separator_1.setForeground(Color.LIGHT_GRAY);
         separator_1.setBounds(399, 47, 11, 400);
         pnlRegAdmin.add(separator_1);
         
         JPanel pnlListarAdmin = new JPanel();
         tabsAdmin.addTab("Listar", null, pnlListarAdmin, null);
         pnlListarAdmin.setLayout(null);
         
         JButton btnDashboard = new JButton("DASHBOARD");
         btnDashboard.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		tabsAdmin.setVisible(false);
         		tabsVendedores.setVisible(false);
         		tabs_Dashboard.setVisible(true);
         		
         	}
         });
         btnDashboard.setBounds(10, 11, 163, 36);
         pnlBotones.add(btnDashboard);
         
         
         JButton btnAdmin = new JButton("ADMINISTRADORES");
         btnAdmin.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		
         		tabsVendedores.setVisible(false);
         		tabs_Dashboard.setVisible(false);
         		tabsAdmin.setVisible(true);
         		
         	}
         });
         btnAdmin.setBounds(10, 58, 163, 36);
         pnlBotones.add(btnAdmin);
         
         JButton btnVendedores = new JButton("VENDEDORES");
         btnVendedores.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		tabsAdmin.setVisible(false);
         		tabs_Dashboard.setVisible(false);
         		tabsVendedores.setVisible(true);
         	}
         });
         btnVendedores.setBounds(10, 105, 163, 36);
         pnlBotones.add(btnVendedores);
         
         tabsVendedores.setVisible(false);
         tabsAdmin.setVisible(false);
         
/*         DefaultCategoryDataset lcd_Stock = new DefaultCategoryDataset();
         
         
         JFreeChart chartStock=ChartFactory.createLineChart("Stock",
                 "Componentes","Cantidad",lcd_Stock,PlotOrientation.VERTICAL,
                 true,true,false);
                
         
        ChartPanel pnlChartStock = new ChartPanel(chartStock);
         pnlStock.setBounds(144, 11, 680, 420);
         pnlStock.add(pnlChartStock);
         
         lcd_Stock.addValue(80, "Cantidad", "Ram");
         lcd_Stock.addValue(300, "Cantidad", "Motherboards");
         
         
         
         JPanel panel = new JPanel();
         panel.setBorder(new LineBorder(new Color(0, 0, 0)));
         panel.setBounds(10, 11, 218, 582);
         pnlVentas.add(panel);
         
         
         */
             
             
             
             
             
        
	}
}
