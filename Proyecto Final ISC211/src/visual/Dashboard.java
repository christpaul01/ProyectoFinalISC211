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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

public class Dashboard extends JFrame {

	private JPanel pnlAdminstracion;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtFldidUsuario;
	private JTextField textField_3;
	private JPasswordField passAdmin;
	private JPasswordField passConfAdmin;
	private JTextField txtSerial;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtCPUSocket;
	private JSeparator sprtrHDD;

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
		setBounds(100, 100, 1153, 636);
		pnlAdminstracion = new JPanel();
		pnlAdminstracion.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlAdminstracion);
		
		
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pnlAdminstracion.setLayout(null);
		
		JTabbedPane tabs_Dashboard = new JTabbedPane(JTabbedPane.TOP);
		tabs_Dashboard.setBounds(203, 11, 918, 528);
        pnlAdminstracion.add(tabs_Dashboard);
        
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
         
         JPanel pnlMenu = new JPanel();
         pnlMenu.setBounds(10, 11, 183, 582);
         pnlMenu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
         pnlAdminstracion.add(pnlMenu);
         pnlMenu.setLayout(null);
         
         
         
         JTabbedPane tabsVendedores = new JTabbedPane(JTabbedPane.TOP);
         tabsVendedores.setBounds(203, 11, 918, 528);
         pnlAdminstracion.add(tabsVendedores);
         
         
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
         tabsAdmin.setBounds(203, 11, 918, 528);
         pnlAdminstracion.add(tabsAdmin);
         
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
         
         
         
         
         
         
         
         JTabbedPane tabsComponentes = new JTabbedPane(JTabbedPane.TOP);
         tabsComponentes.setBounds(203, 11, 918, 528);
         pnlAdminstracion.add(tabsComponentes);
         
         JPanel pnlRegComp = new JPanel();
         tabsComponentes.addTab("Registrar", null, pnlRegComp, null);
         pnlRegComp.setLayout(null);
         
         tabsComponentes.setVisible(false);
         
         
         
         JPanel pnlCompComun = new JPanel();
         pnlCompComun.setBorder(new LineBorder(Color.LIGHT_GRAY));
         pnlCompComun.setBounds(10, 61, 893, 214);
         pnlRegComp.add(pnlCompComun);
         pnlCompComun.setLayout(null);
         
         txtSerial = new JTextField();
         txtSerial.setBounds(115, 25, 210, 20);
         pnlCompComun.add(txtSerial);
         txtSerial.setColumns(10);
         
         JLabel lblSerial = new JLabel("Serial:");
         lblSerial.setBounds(10, 28, 46, 14);
         pnlCompComun.add(lblSerial);
         
         txtMarca = new JTextField();
         txtMarca.setBounds(115, 50, 210, 20);
         pnlCompComun.add(txtMarca);
         txtMarca.setColumns(10);
         
         JLabel lblMarca = new JLabel("Marca:");
         lblMarca.setBounds(10, 53, 46, 14);
         pnlCompComun.add(lblMarca);
         
         JLabel lblModelo = new JLabel("Modelo:");
         lblModelo.setBounds(10, 78, 46, 14);
         pnlCompComun.add(lblModelo);
         
         txtModelo = new JTextField();
         txtModelo.setColumns(10);
         txtModelo.setBounds(115, 75, 210, 20);
         pnlCompComun.add(txtModelo);
         
         JLabel lblPrecioCompra = new JLabel("Precio Compra:");
         lblPrecioCompra.setBounds(10, 124, 90, 14);
         pnlCompComun.add(lblPrecioCompra);
         
         JLabel lblPrecioVenta = new JLabel("Precio Venta:");
         lblPrecioVenta.setBounds(10, 149, 90, 14);
         pnlCompComun.add(lblPrecioVenta);
         
         JLabel lblCantidad = new JLabel("Cantidad:");
         lblCantidad.setBounds(459, 78, 90, 14);
         pnlCompComun.add(lblCantidad);
         
         JSeparator separator_2 = new JSeparator();
         separator_2.setForeground(Color.LIGHT_GRAY);
         separator_2.setOrientation(SwingConstants.VERTICAL);
         separator_2.setBounds(447, 11, 2, 192);
         pnlCompComun.add(separator_2);
         
         JSpinner spnrCompra = new JSpinner();
         spnrCompra.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
         spnrCompra.setBounds(115, 118, 90, 20);
         pnlCompComun.add(spnrCompra);
         
         JSpinner spnrVenta = new JSpinner();
         spnrVenta.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
         spnrVenta.setBounds(115, 143, 90, 20);
         pnlCompComun.add(spnrVenta);
         
         JSpinner spnrCantComp = new JSpinner();
         spnrCantComp.setModel(new SpinnerNumberModel(new Integer(100), new Integer(0), null, new Integer(100)));
         spnrCantComp.setBounds(594, 75, 90, 20);
         pnlCompComun.add(spnrCantComp);
         
         JLabel lblProveedor = new JLabel("Proveedor:");
         lblProveedor.setBounds(459, 28, 90, 14);
         pnlCompComun.add(lblProveedor);
         
         JComboBox cmbProveedor = new JComboBox();
         cmbProveedor.setMaximumRowCount(100);
         cmbProveedor.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>"}));
         cmbProveedor.setBounds(594, 25, 195, 21);
         pnlCompComun.add(cmbProveedor);
         
         JPanel panelMobo = new JPanel();
         panelMobo.setBorder(new LineBorder(Color.LIGHT_GRAY));
         panelMobo.setBounds(10, 297, 893, 161);
         pnlRegComp.add(panelMobo);
         panelMobo.setLayout(null);
         
         JLabel lblSocket = new JLabel("Socket:");
         lblSocket.setBounds(10, 53, 46, 14);
         panelMobo.add(lblSocket);
         
         textField_2 = new JTextField();
         textField_2.setColumns(10);
         textField_2.setBounds(112, 50, 210, 20);
         panelMobo.add(textField_2);
         
         JLabel lblRam = new JLabel("Ram:");
         lblRam.setBounds(10, 84, 46, 14);
         panelMobo.add(lblRam);
         
         JComboBox cmbRam = new JComboBox();
         cmbRam.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "DDR", "DDR2", "DDR3", "DDR3L", "DDR4"}));
         cmbRam.setBounds(112, 81, 210, 20);
         panelMobo.add(cmbRam);
         
         JSeparator separator_3 = new JSeparator();
         separator_3.setForeground(Color.LIGHT_GRAY);
         separator_3.setOrientation(SwingConstants.VERTICAL);
         separator_3.setBounds(447, 11, 2, 139);
         panelMobo.add(separator_3);
         
         JLabel lblPuerto = new JLabel("Puerto Almacenamiento:");
         lblPuerto.setBounds(458, 53, 161, 14);
         panelMobo.add(lblPuerto);
         
         JComboBox comboBox = new JComboBox();
         comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "IDE", "SATA", "SATA II", "SATA III"}));
         comboBox.setBounds(594, 51, 195, 18);
         panelMobo.add(comboBox);
         
         JPanel pnlKits = new JPanel();
         tabsComponentes.addTab("Kits", null, pnlKits, null);
         pnlKits.setLayout(null);
         
         JButton btnCancelar_1 = new JButton("Cancelar");
         btnCancelar_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         	}
         });
         btnCancelar_1.setBounds(814, 466, 89, 23);
         pnlKits.add(btnCancelar_1);
         
         JButton btnAcceptar_1 = new JButton("Acceptar");
         btnAcceptar_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         	}
         });
         btnAcceptar_1.setBounds(715, 466, 89, 23);
         pnlKits.add(btnAcceptar_1);
         
         JPanel panel_3 = new JPanel();
         panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
         panel_3.setBounds(10, 40, 438, 319);
         pnlKits.add(panel_3);
         panel_3.setLayout(null);
         
         JLabel lblId = new JLabel("ID:");
         lblId.setBounds(76, 30, 46, 14);
         panel_3.add(lblId);
         
         textField_4 = new JTextField();
         textField_4.setEditable(false);
         textField_4.setBounds(186, 26, 179, 23);
         panel_3.add(textField_4);
         textField_4.setColumns(10);
         
         JLabel lblMotherboard = new JLabel("Motherboard:");
         lblMotherboard.setBounds(76, 98, 100, 14);
         panel_3.add(lblMotherboard);
         
         JComboBox comboBox_1 = new JComboBox();
         comboBox_1.setBounds(186, 94, 179, 23);
         panel_3.add(comboBox_1);
         comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Ninguno"}));
         
         JLabel lblRam_1 = new JLabel("RAM:");
         lblRam_1.setBounds(76, 132, 46, 14);
         panel_3.add(lblRam_1);
         
         JComboBox comboBox_2 = new JComboBox();
         comboBox_2.setBounds(186, 128, 179, 23);
         panel_3.add(comboBox_2);
         comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Ninguno"}));
         
         JComboBox comboBox_3 = new JComboBox();
         comboBox_3.setBounds(186, 162, 179, 23);
         panel_3.add(comboBox_3);
         comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Ninguno"}));
         
         JLabel lblProcesador = new JLabel("Procesador:");
         lblProcesador.setBounds(76, 166, 100, 14);
         panel_3.add(lblProcesador);
         
         JComboBox comboBox_4 = new JComboBox();
         comboBox_4.setBounds(186, 196, 179, 23);
         panel_3.add(comboBox_4);
         comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Ninguno"}));
         
         JLabel lblHardDrive = new JLabel("Disco Duro:");
         lblHardDrive.setBounds(76, 200, 89, 14);
         panel_3.add(lblHardDrive);
         
         JButton btnVisualizar = new JButton("Visualizar");
         btnVisualizar.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         	}
         });
         btnVisualizar.setBounds(339, 285, 89, 23);
         panel_3.add(btnVisualizar);
         
         textField_5 = new JTextField();
         textField_5.setColumns(10);
         textField_5.setBounds(186, 60, 179, 23);
         panel_3.add(textField_5);
         
         JLabel lblNombre_1 = new JLabel("Nombre:");
         lblNombre_1.setBounds(76, 64, 46, 14);
         panel_3.add(lblNombre_1);
         
         JLabel lblCantidad_1 = new JLabel("Cantidad:");
         lblCantidad_1.setBounds(76, 236, 89, 14);
         panel_3.add(lblCantidad_1);
         
         JSpinner spinner = new JSpinner();
         spinner.setModel(new SpinnerNumberModel(0, 0, 100, 10));
         spinner.setBounds(276, 233, 89, 17);
         panel_3.add(spinner);
         
         JSeparator separator_4 = new JSeparator();
         separator_4.setOrientation(SwingConstants.VERTICAL);
         separator_4.setForeground(Color.LIGHT_GRAY);
         separator_4.setBounds(458, 40, 2, 438);
         pnlKits.add(separator_4);
         
         JList list = new JList();
         list.setBounds(470, 40, 433, 319);
         pnlKits.add(list);
         
         JLabel lblPrecioFinal = new JLabel("Precio Final:");
         lblPrecioFinal.setBounds(470, 408, 89, 14);
         pnlKits.add(lblPrecioFinal);
         
         JLabel lblPrecioTotal = new JLabel("Precio Total:");
         lblPrecioTotal.setBounds(470, 383, 89, 14);
         pnlKits.add(lblPrecioTotal);
         
         JLabel lblRd = new JLabel("RD$ 0.00");
         lblRd.setBounds(543, 383, 89, 14);
         pnlKits.add(lblRd);
         
         JLabel label_1 = new JLabel("RD$ 0.00");
         label_1.setToolTipText("Con 10% de descuento");
         label_1.setBounds(543, 408, 89, 14);
         pnlKits.add(label_1);
         
         JPanel pnlInventario = new JPanel();
         tabsComponentes.addTab("Inventario", null, pnlInventario, null);
         pnlInventario.setLayout(null);
         
         JList listInventario = new JList();
         listInventario.setBorder(new LineBorder(Color.LIGHT_GRAY));
         listInventario.setBounds(10, 11, 893, 478);
         pnlInventario.add(listInventario);
         
         tabsVendedores.setVisible(false);
         tabsAdmin.setVisible(false);
         
         
         
         JPanel pnlHDD = new JPanel();
         pnlHDD.setLayout(null);
         pnlHDD.setBorder(new LineBorder(Color.LIGHT_GRAY));
         pnlHDD.setBounds(10, 298, 893, 161);
         pnlRegComp.add(pnlHDD);
         
         JSeparator 
         sprtrHDD = new JSeparator();
         sprtrHDD.setOrientation(SwingConstants.VERTICAL);
         sprtrHDD.setForeground(Color.LIGHT_GRAY);
         sprtrHDD.setBounds(447, 11, 2, 139);
         pnlHDD.add(sprtrHDD);
         
         JLabel lblConexionHdd = new JLabel("Conexion HDD");
         lblConexionHdd.setBounds(458, 53, 161, 14);
         pnlHDD.add(lblConexionHdd);
         
         JComboBox cmbHDDtipo = new JComboBox();
         cmbHDDtipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "IDE", "SATA", "SATA II", "SATA III"}));
         cmbHDDtipo.setBounds(594, 51, 195, 18);
         pnlHDD.add(cmbHDDtipo);
         
         JLabel lblCapacidad = new JLabel("Capacidad (GB):");
         lblCapacidad.setBounds(10, 53, 92, 14);
         pnlHDD.add(lblCapacidad);
         
         JSpinner spnrHDDCapacidad = new JSpinner();
         spnrHDDCapacidad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
         spnrHDDCapacidad.setBounds(112, 47, 210, 23);
         pnlHDD.add(spnrHDDCapacidad);
         
         JPanel pnlCPU = new JPanel();
         pnlCPU.setLayout(null);
         pnlCPU.setBorder(new LineBorder(Color.LIGHT_GRAY));
         pnlCPU.setBounds(10, 297, 893, 161);
         pnlRegComp.add(pnlCPU);
         
         JLabel lblCPUSocket = new JLabel("Socket:");
         lblCPUSocket.setBounds(10, 53, 46, 14);
         pnlCPU.add(lblCPUSocket);
         
         txtCPUSocket = new JTextField();
         txtCPUSocket.setColumns(10);
         txtCPUSocket.setBounds(112, 50, 210, 20);
         pnlCPU.add(txtCPUSocket);
         
         JSeparator
         sprtrCPU = new JSeparator();
         sprtrCPU.setOrientation(SwingConstants.VERTICAL);
         sprtrCPU.setForeground(Color.LIGHT_GRAY);
         sprtrCPU.setBounds(447, 11, 2, 139);
         pnlCPU.add(sprtrCPU);
         
         JLabel lblCPUSpeed = new JLabel("Velocidad:");
         lblCPUSpeed.setBounds(459, 53, 86, 14);
         pnlCPU.add(lblCPUSpeed);
         
         JSpinner spnrCPUSpeed = new JSpinner();
         spnrCPUSpeed.setModel(new SpinnerNumberModel(0.0, 0.0, 10.0, 0.0));
         spnrCPUSpeed.setBounds(597, 50, 210, 20);
         pnlCPU.add(spnrCPUSpeed);
         
         JPanel pnlRam = new JPanel();
         pnlRam.setLayout(null);
         pnlRam.setBorder(new LineBorder(Color.LIGHT_GRAY));
         pnlRam.setBounds(10, 297, 893, 161);
         pnlRegComp.add(pnlRam);
         
         JSeparator
         sprtrRam = new JSeparator();
         sprtrRam.setOrientation(SwingConstants.VERTICAL);
         sprtrRam.setForeground(Color.LIGHT_GRAY);
         sprtrRam.setBounds(447, 11, 2, 139);
         pnlRam.add(sprtrRam);
         
         JLabel lblMemoriagb = new JLabel("Memoria (GB):");
         lblMemoriagb.setBounds(10, 36, 100, 14);
         pnlRam.add(lblMemoriagb);
         
         JSpinner spinner_1 = new JSpinner();
         spinner_1.setModel(new SpinnerNumberModel(0.0, 0.0, 64.0, 1.0));
         spinner_1.setBounds(120, 33, 121, 20);
         pnlRam.add(spinner_1);
         
         JLabel lblTipo = new JLabel("Tipo de memoria:");
         lblTipo.setBounds(459, 36, 121, 14);
         pnlRam.add(lblTipo);
         
         JPanel panelTipo = new JPanel();
         panelTipo.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
         panelTipo.setBounds(10, 11, 893, 39);
         pnlRegComp.add(panelTipo);
         panelTipo.setLayout(null);
         
         JLabel label = new JLabel("Tipo :");
         label.setHorizontalAlignment(SwingConstants.LEFT);
         label.setBounds(10, 11, 46, 14);
         panelTipo.add(label);
         
         JRadioButton rdbtnMotherboard = new JRadioButton("Motherboard");
         rdbtnMotherboard.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		pnlHDD.setVisible(false);
         		pnlCPU.setVisible(false);
         		pnlRam.setVisible(false);
         		panelMobo.setVisible(true);
         		
         	}
         });
         rdbtnMotherboard.setSelected(true);
         rdbtnMotherboard.setBounds(62, 7, 109, 23);
         panelTipo.add(rdbtnMotherboard);
         
         JRadioButton rdbtnRam = new JRadioButton("Ram");
         rdbtnRam.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		panelMobo.setVisible(false);
         		pnlHDD.setVisible(false);
         		pnlCPU.setVisible(false);
         		pnlRam.setVisible(true);
         		
         	}
         });
         rdbtnRam.setBounds(173, 7, 59, 23);
         panelTipo.add(rdbtnRam);
         
         JRadioButton rdbtnProcesador = new JRadioButton("Procesador");
         rdbtnProcesador.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		panelMobo.setVisible(false);
         		pnlHDD.setVisible(false);
         		pnlRam.setVisible(false);
         		pnlCPU.setVisible(true);
         		
         		
         	}
         });
         rdbtnProcesador.setBounds(247, 7, 109, 23);
         panelTipo.add(rdbtnProcesador);
         
         JRadioButton rdbtnDiscoDuro = new JRadioButton("Disco Duro");
         rdbtnDiscoDuro.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		panelMobo.setVisible(false);
         		pnlRam.setVisible(false);
         		pnlCPU.setVisible(false);
         		pnlHDD.setVisible(true);
         		
         	}
         });
         rdbtnDiscoDuro.setBounds(358, 7, 109, 23);
         panelTipo.add(rdbtnDiscoDuro);
         
         JComboBox 
         cmbTipoRam = new JComboBox();
         cmbTipoRam.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "DDR", "DDR2", "DDR3", "DDR4"}));
         cmbTipoRam.setBounds(590, 34, 121, 18);
         pnlRam.add(cmbTipoRam);
         
         ButtonGroup groupTipo = new ButtonGroup();
         groupTipo.add(rdbtnDiscoDuro);
         groupTipo.add(rdbtnProcesador);
         groupTipo.add(rdbtnRam);
         groupTipo.add(rdbtnMotherboard);
         
         
         
         JButton btnCancelar_2 = new JButton("Cancelar");
         btnCancelar_2.setBounds(814, 466, 89, 23);
         pnlRegComp.add(btnCancelar_2);
         
         JButton btnAcceptar_2 = new JButton("Acceptar");
         btnAcceptar_2.setBounds(715, 466, 89, 23);
         pnlRegComp.add(btnAcceptar_2);
         
         
         JButton btnDashboard = new JButton("DASHBOARD");
         btnDashboard.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		tabsAdmin.setVisible(false);
         		tabsVendedores.setVisible(false);
         		tabs_Dashboard.setVisible(true);
         		tabsComponentes.setVisible(false);
         		
         	}
         });
         btnDashboard.setBounds(10, 11, 163, 36);
         pnlMenu.add(btnDashboard);
         
         
         JButton btnAdmin = new JButton("ADMINISTRADORES");
         btnAdmin.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		
         		tabsVendedores.setVisible(false);
         		tabs_Dashboard.setVisible(false);
         		tabsAdmin.setVisible(true);
         		tabsComponentes.setVisible(false);
         		
         	}
         });
         btnAdmin.setBounds(10, 58, 163, 36);
         pnlMenu.add(btnAdmin);
         
         JButton btnVendedores = new JButton("VENDEDORES");
         btnVendedores.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		tabsAdmin.setVisible(false);
         		tabs_Dashboard.setVisible(false);
         		tabsVendedores.setVisible(true);
         		tabsComponentes.setVisible(false);
         	}
         });
         btnVendedores.setBounds(10, 105, 163, 36);
         pnlMenu.add(btnVendedores);
         
         JButton btnComponente = new JButton("COMPONENTE");
         btnComponente.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		tabsAdmin.setVisible(false);
         		tabs_Dashboard.setVisible(false);
         		tabsVendedores.setVisible(false);
         		tabsComponentes.setVisible(true);
         		
         		
         	}
         });
         btnComponente.setBounds(10, 152, 163, 36);
         pnlMenu.add(btnComponente);
         
                          
             
        
	}
}
