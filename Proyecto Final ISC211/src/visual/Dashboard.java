package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractListModel;
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
import logico.Administrador;
import logico.Componente;
import logico.DiscoDuro;
import logico.Kit;
import logico.Motherboard;
import logico.Procesador;
import logico.Ram;
import logico.Tienda;
import logico.Vendedor;
import logico.ux;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {

	private JPanel pnlAdminstracion;
	private JTextField txtIdVendedor;
	private JTextField txtNombreVendedor;
	private JPasswordField pswdVendedor;
	private JPasswordField pswdVendedor2;
	private JTextField txtFldidUsuario;
	private JTextField txtNombreAdmin;
	private JPasswordField passAdmin;
	private JPasswordField passConfAdmin;
	private JTextField txtSerial;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtSocketMobo;
	private JTextField txtIdSerialKit;
	private JTextField txtNombreKit;
	private JTextField txtCPUSocket;
	private JSeparator sprtrHDD;
	private JTextField txtUserAdmin;
	private DefaultCategoryDataset lcd_Stock;
	private String series1;
	private String series2;

	private String category1;
	private String category2;
	private String category3;
	private String category4;
	private String category5;
	
	private DefaultCategoryDataset lcd_Ventas;

	private static JTable tabInventario;
	private static String[] tabDetalles;
	private static JLabel lblForComponentes;
	private static DefaultTableModel DTMdetalles;
	private static Object[] filaListarComponentes;
	private static ArrayList<Componente> componentes;

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
	public Dashboard() throws IOException, ClassNotFoundException {
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

		try {
			Tienda.getInstance().cargarDatos();
		} catch (Exception e) {

			Tienda.getInstance().guardarDatos();
		}

		JTabbedPane tabs_Dashboard = new JTabbedPane(JTabbedPane.TOP);
		tabs_Dashboard.setBounds(203, 11, 918, 528);
		pnlAdminstracion.add(tabs_Dashboard);

		JPanel panel_1 = new JPanel();
		tabs_Dashboard.addTab("Ventas", null, panel_1, null);
		panel_1.setLayout(null);

		// Fuente de Datos
		lcd_Ventas = new DefaultCategoryDataset();

		// Creando el Grafico
		JFreeChart chartVentas = ChartFactory.createLineChart("Resumen de Ventas", "Mes", "Cantidad", lcd_Ventas,
				PlotOrientation.VERTICAL, true, true, false);

		// Mostrar Grafico
		ChartPanel pnlChartVentas = new ChartPanel(chartVentas);
		pnlChartVentas.setBounds(135, 11, 680, 420);
		panel_1.add(pnlChartVentas);

		// Agregango datos (Remplazar por funccion)
		
		graficaVenta();

		JPanel pnlStock = new JPanel();
		tabs_Dashboard.addTab("Stocks", null, pnlStock, null);

		// Test

		series1 = "Stock Disponible";
		series2 = "Ventas del mes actual";

		category1 = "Ram";
		category2 = "Motherboards";
		category3 = "Disco Duros";
		category4 = "Procesadores";
		category5 = "Kits";
		
		

		lcd_Stock = new DefaultCategoryDataset();

		graficarStock();

		JFreeChart chartStock = ChartFactory.createBarChart("Resumen de stocks", // chart title
				"Componentes", // domain axis label
				"Cantidad", // range axis label
				lcd_Stock, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips?
				false // URLs?
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

		JPanel pnlRegVend = new JPanel();
		tabsVendedores.addTab("Registrar", null, pnlRegVend, null);
		pnlRegVend.setLayout(null);

		JLabel lblIdUsuario = new JLabel("ID Usuario:");
		lblIdUsuario.setBounds(441, 100, 93, 14);
		pnlRegVend.add(lblIdUsuario);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(441, 131, 93, 14);
		pnlRegVend.add(lblNombre);

		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setBounds(441, 165, 93, 14);
		pnlRegVend.add(lblContrasena);

		txtIdVendedor = new JTextField();
		txtIdVendedor.setEditable(false);
		txtIdVendedor.setBounds(544, 100, 140, 17);
		pnlRegVend.add(txtIdVendedor);
		txtIdVendedor.setColumns(10);

		txtNombreVendedor = new JTextField();
		txtNombreVendedor.setColumns(10);
		txtNombreVendedor.setBounds(544, 131, 140, 17);
		pnlRegVend.add(txtNombreVendedor);

		pswdVendedor = new JPasswordField();
		pswdVendedor.setBounds(544, 165, 140, 17);
		pnlRegVend.add(pswdVendedor);

		JLabel lblConfirmar = new JLabel("Confirmar:");
		lblConfirmar.setBounds(441, 195, 80, 14);
		pnlRegVend.add(lblConfirmar);

		pswdVendedor2 = new JPasswordField();
		pswdVendedor2.setBounds(544, 193, 140, 17);
		pnlRegVend.add(pswdVendedor2);

		JButton btnAcceptarVendedor = new JButton("Acceptar");
		btnAcceptarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombreVendedor = txtNombreVendedor.getText();

				if (nombreVendedor.length() != 0
						&& (Arrays.equals(pswdVendedor.getPassword(), pswdVendedor2.getPassword()))
						&& pswdVendedor.getPassword().length >= 4) {
					Vendedor vendedor = new Vendedor(nombreVendedor, pswdVendedor.getPassword(),
							Tienda.getInstance().asignarIdUsuario());
					Tienda.getInstance().insertarVendedor(vendedor);
					;
					txtIdVendedor.setText(Tienda.getInstance().asignarIdUsuario());
					txtNombreVendedor.setText("");
					pswdVendedor.setText(null);
					pswdVendedor2.setText(null);

					try {
						Tienda.getInstance().guardarDatos();// Guarda los datos

						JOptionPane.showMessageDialog(null, "Administrador guardado en 'Mis Documentos'!", "�Guardado!",
								JOptionPane.PLAIN_MESSAGE);
					} catch (ClassNotFoundException x) {
						JOptionPane.showMessageDialog(null, "No Se Pudo Guardar", "�Error!", JOptionPane.PLAIN_MESSAGE);
						x.printStackTrace();
					} catch (IOException x) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "No Se Pudo Guardar", "�Error!", JOptionPane.PLAIN_MESSAGE);
						x.printStackTrace();
					}

				}

				if (nombreVendedor.length() < 4 && nombreVendedor.length() > 0) {
					JOptionPane.showMessageDialog(null, "Nombre no suficientemente largo!", "�Error!",
							JOptionPane.PLAIN_MESSAGE);
				}

				if (!(Arrays.equals(pswdVendedor.getPassword(), pswdVendedor2.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Verificar las contrasenas", "�Error!",
							JOptionPane.PLAIN_MESSAGE);
				}

				if (pswdVendedor.getPassword().length < 4 && pswdVendedor.getPassword().length > 0
						&& (Arrays.equals(pswdVendedor.getPassword(), pswdVendedor.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Insertar una contrasena de minimo 4 caracteres!", "�Error!",
							JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
		btnAcceptarVendedor.setBounds(573, 242, 103, 23);
		pnlRegVend.add(btnAcceptarVendedor);

		JButton btnCancelarVendedor = new JButton("Cancelar");
		btnCancelarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelarVendedor.setBounds(441, 242, 103, 23);
		pnlRegVend.add(btnCancelarVendedor);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(399, 47, 11, 400);
		pnlRegVend.add(separator);

		JPanel panel_2 = new JPanel();
		tabsVendedores.addTab("Listar", null, panel_2, null);
		panel_2.setLayout(null);

		JTabbedPane tabsAdmin = new JTabbedPane(JTabbedPane.TOP);
		tabsAdmin.setBounds(203, 11, 918, 528);
		pnlAdminstracion.add(tabsAdmin);

		JPanel pnlRegAdmin = new JPanel();
		pnlRegAdmin.setLayout(null);
		tabsAdmin.addTab("Registrar", null, pnlRegAdmin, null);

		JPanel panelLogAdmin = new JPanel();
		panelLogAdmin.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelLogAdmin.setBounds(420, 49, 381, 266);
		pnlRegAdmin.add(panelLogAdmin);
		panelLogAdmin.setLayout(null);

		JLabel lblUsuario = new JLabel("ID Usuario:");
		lblUsuario.setBounds(69, 38, 93, 14);
		panelLogAdmin.add(lblUsuario);

		JLabel lblNombreAdmin = new JLabel("Nombre:");
		lblNombreAdmin.setBounds(69, 104, 93, 14);
		panelLogAdmin.add(lblNombreAdmin);

		JLabel lblContAdmin = new JLabel("Contrasena:");
		lblContAdmin.setBounds(69, 136, 93, 14);
		panelLogAdmin.add(lblContAdmin);

		txtFldidUsuario = new JTextField();
		txtFldidUsuario.setBounds(172, 36, 140, 17);
		panelLogAdmin.add(txtFldidUsuario);
		txtFldidUsuario.setEditable(false);
		txtFldidUsuario.setColumns(10);

		txtNombreAdmin = new JTextField();
		txtNombreAdmin.setBounds(172, 102, 140, 17);
		panelLogAdmin.add(txtNombreAdmin);
		txtNombreAdmin.setColumns(10);

		passAdmin = new JPasswordField();
		passAdmin.setBounds(172, 136, 140, 17);
		panelLogAdmin.add(passAdmin);

		JLabel lblConfAdmin = new JLabel("Confirmar:");
		lblConfAdmin.setBounds(69, 166, 80, 14);
		panelLogAdmin.add(lblConfAdmin);

		passConfAdmin = new JPasswordField();
		passConfAdmin.setBounds(172, 164, 140, 17);
		panelLogAdmin.add(passConfAdmin);

		JButton btnAccptAdmin = new JButton("Acceptar");
		btnAccptAdmin.setBounds(209, 232, 103, 23);
		panelLogAdmin.add(btnAccptAdmin);

		JButton btnCnclAdmin = new JButton("Cancelar");
		btnCnclAdmin.setBounds(69, 232, 103, 23);
		panelLogAdmin.add(btnCnclAdmin);

		JLabel lblUserAdmin = new JLabel("Usuario:");
		lblUserAdmin.setBounds(69, 76, 46, 14);
		panelLogAdmin.add(lblUserAdmin);

		txtUserAdmin = new JTextField();
		txtUserAdmin.setBounds(172, 74, 140, 17);
		panelLogAdmin.add(txtUserAdmin);
		txtUserAdmin.setColumns(10);
		btnAccptAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String idAdmin = Tienda.getInstance().asignarIdUsuario();
				String nombreAdmin = txtNombreAdmin.getText();
				String username = txtUserAdmin.getText();

				if (nombreAdmin.length() != 0 && username.length() != 0
						&& (Arrays.equals(passAdmin.getPassword(), passConfAdmin.getPassword()))
						&& passAdmin.getPassword().length >= 4) {
					Administrador admin = new Administrador(nombreAdmin, passAdmin.getPassword(), username, idAdmin);
					Tienda.getInstance().insertarAdministrador(admin);
					txtFldidUsuario.setText(Tienda.getInstance().asignarIdUsuario());
					txtUserAdmin.setText("");
					txtNombreAdmin.setText("");
					passAdmin.setText(null);
					passConfAdmin.setText(null);

					try {
						Tienda.getInstance().guardarDatos();
						JOptionPane.showMessageDialog(null, "Administrador guardado en 'Mis Documentos'!", "�Guardado!",
								JOptionPane.PLAIN_MESSAGE);
					} catch (ClassNotFoundException e) {
						JOptionPane.showMessageDialog(null, "No Se Pudo Guardar", "�Error!", JOptionPane.PLAIN_MESSAGE);
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "No Se Pudo Guardar", "�Error!", JOptionPane.PLAIN_MESSAGE);
						e.printStackTrace();
					}

				}

				if (nombreAdmin.length() < 4) {
					JOptionPane.showMessageDialog(null, "Nombre no suficientemente largo!", "�Error!",
							JOptionPane.PLAIN_MESSAGE);
				}

				if (!(Arrays.equals(passAdmin.getPassword(), passConfAdmin.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Verificar las contrasenas", "�Error!",
							JOptionPane.PLAIN_MESSAGE);
				}

				if (passAdmin.getPassword().length < 4 && passAdmin.getPassword().length > 0
						&& (Arrays.equals(passAdmin.getPassword(), passConfAdmin.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Insertar una contrasena de minimo 4 caracteres!", "�Error!",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

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
		txtSerial.setHorizontalAlignment(SwingConstants.CENTER);
		txtSerial.setEditable(false);
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
		cmbProveedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				cmbProveedor.removeAllItems();

				for (int i = 0; i < Tienda.getInstance().getProveedores().size(); i++) {
					cmbProveedor.addItem(Tienda.getInstance().getProveedores().get(i));
				}
			}
		});
		cmbProveedor.setMaximumRowCount(100);
		cmbProveedor.setModel(new DefaultComboBoxModel(new String[] { "<Seleccionar>", "Test1", "Test2" }));
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

		txtSocketMobo = new JTextField();
		txtSocketMobo.setColumns(10);
		txtSocketMobo.setBounds(112, 50, 210, 20);
		panelMobo.add(txtSocketMobo);

		JLabel lblRam = new JLabel("Ram:");
		lblRam.setBounds(10, 84, 46, 14);
		panelMobo.add(lblRam);

		JComboBox cmbRam = new JComboBox();
		cmbRam.setModel(
				new DefaultComboBoxModel(new String[] { "<Seleccionar>", "DDR", "DDR2", "DDR3", "DDR3L", "DDR4" }));
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

		JComboBox cmbPrtoMobo = new JComboBox();
		cmbPrtoMobo.setModel(
				new DefaultComboBoxModel(new String[] { "<Seleccionar>", "IDE", "SATA", "SATA II", "SATA III" }));
		cmbPrtoMobo.setBounds(594, 51, 195, 18);
		panelMobo.add(cmbPrtoMobo);

		JPanel pnlKits = new JPanel();
		tabsComponentes.addTab("Kits", null, pnlKits, null);
		pnlKits.setLayout(null);

		DefaultListModel<Componente> modelKits = new DefaultListModel<>();
		JList<Componente> listKits = new JList<>(modelKits);

		listKits.setBounds(470, 40, 433, 319);
		pnlKits.add(listKits);

		JPanel pnlRegKit = new JPanel();
		pnlRegKit.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		pnlRegKit.setBounds(10, 40, 438, 319);
		pnlKits.add(pnlRegKit);
		pnlRegKit.setLayout(null);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(76, 30, 46, 14);
		pnlRegKit.add(lblId);

		txtIdSerialKit = new JTextField();
		txtIdSerialKit.setEditable(false);
		txtIdSerialKit.setBounds(186, 26, 179, 23);
		pnlRegKit.add(txtIdSerialKit);
		txtIdSerialKit.setColumns(10);

		JLabel lblMotherboard = new JLabel("Motherboard:");
		lblMotherboard.setBounds(76, 98, 100, 14);
		pnlRegKit.add(lblMotherboard);

		JComboBox cmbMoboKit = new JComboBox();
		cmbMoboKit.setToolTipText("Motherboards");
		cmbMoboKit.setBounds(186, 94, 179, 23);
		pnlRegKit.add(cmbMoboKit);
		cmbMoboKit.setModel(new DefaultComboBoxModel(new String[] { "Ninguno" }));

		JLabel lblRam_1 = new JLabel("RAM:");
		lblRam_1.setBounds(76, 132, 46, 14);
		pnlRegKit.add(lblRam_1);

		JComboBox cmbRamKit = new JComboBox();
		cmbRamKit.setToolTipText("Ram");
		cmbRamKit.setBounds(186, 128, 179, 23);
		pnlRegKit.add(cmbRamKit);
		cmbRamKit.setModel(new DefaultComboBoxModel(new String[] { "Ninguno" }));

		JComboBox cmbCPUKit = new JComboBox();
		cmbCPUKit.setToolTipText("?");
		cmbCPUKit.setBounds(186, 162, 179, 23);
		pnlRegKit.add(cmbCPUKit);
		cmbCPUKit.setModel(new DefaultComboBoxModel(new String[] { "Ninguno" }));

		JLabel lblProcesador = new JLabel("Procesador:");
		lblProcesador.setBounds(76, 166, 100, 14);
		pnlRegKit.add(lblProcesador);

		JComboBox cmbHDDkit = new JComboBox();
		cmbHDDkit.setToolTipText("??");
		cmbHDDkit.setBounds(186, 196, 179, 23);
		pnlRegKit.add(cmbHDDkit);
		cmbHDDkit.setModel(new DefaultComboBoxModel(new String[] { "Ninguno" }));

		JLabel lblHardDrive = new JLabel("Disco Duro:");
		lblHardDrive.setBounds(76, 200, 89, 14);
		pnlRegKit.add(lblHardDrive);

		txtNombreKit = new JTextField();
		txtNombreKit.setColumns(10);
		txtNombreKit.setBounds(186, 60, 179, 23);
		pnlRegKit.add(txtNombreKit);

		JSpinner spnrCantKit = new JSpinner();
		spnrCantKit.setModel(new SpinnerNumberModel(0, 0, 100, 10));
		spnrCantKit.setBounds(276, 233, 89, 17);
		pnlRegKit.add(spnrCantKit);

		JSpinner spnrTotal = new JSpinner();
		spnrTotal.setEnabled(false);
		spnrTotal.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		spnrTotal.setBounds(544, 380, 89, 23);
		pnlKits.add(spnrTotal);

		JSpinner spnrFinal = new JSpinner();
		spnrFinal.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		spnrFinal.setEnabled(false);
		spnrFinal.setBounds(544, 408, 89, 22);
		pnlKits.add(spnrFinal);

		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtNombreKit.getText().length() < 4 || (int) spnrCantKit.getValue() == 0) {
					if (txtNombreKit.getText().length() < 4 && !((int) spnrCantKit.getValue() == 0))
						JOptionPane.showMessageDialog(null, "Insertar un nombre correcto para el Kit!", "�Error!",
								JOptionPane.PLAIN_MESSAGE);

					if ((int) spnrCantKit.getValue() == 0 && !(txtNombreKit.getText().length() == 0)) {
						JOptionPane.showMessageDialog(null, "Insertar una cantidad correcta para el Kit!", "�Error!",
								JOptionPane.PLAIN_MESSAGE);
					}

					if (txtNombreKit.getText().length() < 4 && (int) spnrCantKit.getValue() == 0) {
						JOptionPane.showMessageDialog(null, "Verificar Datos!", "�Error!", JOptionPane.PLAIN_MESSAGE);
					}

				}

				if (Tienda.getInstance().calcRam() == 0 || Tienda.getInstance().calcCPU() == 0
						|| Tienda.getInstance().calcHDD() == 0 || Tienda.getInstance().calcMotherBoard() == 0) {
					JOptionPane.showMessageDialog(null, "Agregar todos los componentes!", "�Error!",
							JOptionPane.PLAIN_MESSAGE);
				}

				if (txtNombreKit.getText().length() > 4 && (int) spnrCantKit.getValue() > 0) {

					Double precioFinal = 0.00;

					modelKits.clear();

					if (Tienda.getInstance().calcRam() > 0) // Ram
					{
						Ram ramSeleccionada = (Ram) cmbRamKit.getSelectedItem();
						modelKits.addElement(ramSeleccionada);
						precioFinal += ramSeleccionada.getPrecioVenta();
					}

					if (Tienda.getInstance().calcCPU() > 0) // CPU
					{
						Procesador cpuSeleccionada = (Procesador) cmbCPUKit.getSelectedItem();
						modelKits.addElement(cpuSeleccionada);
						precioFinal += cpuSeleccionada.getPrecioVenta();
					}

					if (Tienda.getInstance().calcHDD() > 0) // Disco Duro
					{
						DiscoDuro hDDSeleccionada = (DiscoDuro) cmbHDDkit.getSelectedItem();
						modelKits.addElement(hDDSeleccionada);
						precioFinal += hDDSeleccionada.getPrecioVenta();
					}

					if (Tienda.getInstance().calcMotherBoard() > 0) // Motherboard
					{
						Motherboard moboSeleccionado = (Motherboard) cmbMoboKit.getSelectedItem();
						modelKits.addElement(moboSeleccionado);
						precioFinal += moboSeleccionado.getPrecioVenta();

					}

					spnrTotal.setValue(precioFinal);
					spnrFinal.setValue((precioFinal * 0.90));

				}

			}
		});
		btnVisualizar.setBounds(339, 285, 89, 23);
		pnlRegKit.add(btnVisualizar);

		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(76, 64, 46, 14);
		pnlRegKit.add(lblNombre_1);

		JLabel lblCantidad_1 = new JLabel("Cantidad:");
		lblCantidad_1.setBounds(76, 236, 89, 14);
		pnlRegKit.add(lblCantidad_1);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setForeground(Color.LIGHT_GRAY);
		separator_4.setBounds(458, 40, 2, 438);
		pnlKits.add(separator_4);

		JLabel lblPrecioFinal = new JLabel("Precio Final:");
		lblPrecioFinal.setBounds(470, 412, 89, 14);
		pnlKits.add(lblPrecioFinal);

		JLabel lblPrecioTotal = new JLabel("Precio Total:");
		lblPrecioTotal.setBounds(470, 384, 89, 14);
		pnlKits.add(lblPrecioTotal);

		// Insercion

		JPanel pnlInventario = new JPanel();
		pnlInventario.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		tabsComponentes.addTab("Inventario", null, pnlInventario, null);
		pnlInventario.setLayout(null);

		tabDetalles = new String[] { "Proveedor", "Serial", "Cantidad", "Precio Compra", "Precio Venta" };
		componentes = new ArrayList<Componente>();
		componentes = Tienda.getInstance().getComponentes();

		JList listInventario = new JList();

		listInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeLabelNameANDtableContents(listInventario.getSelectedIndex());
			}
		});

		listInventario.setModel(new AbstractListModel() {
			String[] values = new String[] { "  Disco Duro", "  Motherboard", "  Procesador", "  Ram" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listInventario.setSelectedIndex(0);
		listInventario.setSelectionBackground(Color.GRAY);
		listInventario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listInventario.setBorder(new LineBorder(Color.LIGHT_GRAY));
		listInventario.setBounds(10, 11, 150, 478);
		pnlInventario.add(listInventario);

		tabInventario = new ux();
		tabInventario.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		tabInventario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabInventario.setSelectionForeground(Color.GRAY);
		tabInventario.setSelectionBackground(Color.WHITE);
		tabInventario.setRowMargin(2);
		tabInventario.setFont(new Font("Verdana", Font.PLAIN, 12));
		tabInventario.setForeground(Color.BLACK);
		tabInventario.setBackground(Color.LIGHT_GRAY);

		DTMdetalles = new DefaultTableModel(null, tabDetalles);
		filaListarComponentes = new Object[DTMdetalles.getColumnCount()];

		tabInventario.setModel(DTMdetalles);
		tabInventario.getColumnModel().getColumn(0).setPreferredWidth(126);
		tabInventario.setForeground(Color.BLACK);
		tabInventario.setBackground(Color.GRAY);
		tabInventario.setBounds(0, 0, 1, 1);
		JScrollPane ScrolInventario = new JScrollPane(tabInventario);
		ScrolInventario.setBounds(172, 51, 729, 438);
		pnlInventario.add(ScrolInventario);

		lblForComponentes = new JLabel("Disco Duro", SwingConstants.CENTER);
		lblForComponentes.setBorder(new LineBorder(Color.BLACK, 1, true));
		lblForComponentes.setOpaque(true);
		lblForComponentes.setBackground(Color.GRAY);
		lblForComponentes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblForComponentes.setBounds(449, 13, 200, 25);
		pnlInventario.add(lblForComponentes);

		tabsVendedores.setVisible(false);
		tabsAdmin.setVisible(false);

		JButton btnCancelarKit = new JButton("Cancelar");
		btnCancelarKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modelKits.clear();
				spnrTotal.setValue(0.00);
				spnrFinal.setValue(0.00);
				txtNombreKit.setText("");
			}
		});
		btnCancelarKit.setBounds(814, 466, 89, 23);
		pnlKits.add(btnCancelarKit);

		JButton btnAcceptarKit = new JButton("Acceptar");
		btnAcceptarKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int kitIni = Tienda.getInstance().getKits().size();

				String nombreKit = txtNombreKit.getText();

				ArrayList<Componente> misComponentes = new ArrayList<Componente>();

				for (int i = 0; i < modelKits.size(); i++) {
					misComponentes.add(modelKits.get(i));
				}

				Kit miKit = new Kit(Tienda.getInstance().asignarIdKit(), nombreKit, misComponentes);
				
				miKit.setCantidad((int) spnrCantKit.getValue());

				Tienda.getInstance().insertarKits(miKit);

				txtIdSerialKit.setText(Tienda.getInstance().asignarIdKit());

				int kitFinal = Tienda.getInstance().getKits().size();

				if (kitIni != kitFinal)
					btnCancelarKit.doClick();
				
				
				try {
					Tienda.getInstance().guardarDatos();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnAcceptarKit.setBounds(715, 466, 89, 23);
		pnlKits.add(btnAcceptarKit);

		JPanel pnlHDD = new JPanel();
		pnlHDD.setLayout(null);
		pnlHDD.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlHDD.setBounds(10, 298, 893, 161);
		pnlRegComp.add(pnlHDD);

		JSeparator sprtrHDD = new JSeparator();
		sprtrHDD.setOrientation(SwingConstants.VERTICAL);
		sprtrHDD.setForeground(Color.LIGHT_GRAY);
		sprtrHDD.setBounds(447, 11, 2, 139);
		pnlHDD.add(sprtrHDD);

		JLabel lblConexionHdd = new JLabel("Conexion HDD");
		lblConexionHdd.setBounds(458, 53, 161, 14);
		pnlHDD.add(lblConexionHdd);

		JComboBox cmbHDDtipo = new JComboBox();
		cmbHDDtipo.setModel(
				new DefaultComboBoxModel(new String[] { "<Seleccionar>", "IDE", "SATA", "SATA II", "SATA III" }));
		cmbHDDtipo.setBounds(594, 51, 195, 18);
		pnlHDD.add(cmbHDDtipo);

		JLabel lblCapacidad = new JLabel("Capacidad (GB):");
		lblCapacidad.setBounds(10, 53, 92, 14);
		pnlHDD.add(lblCapacidad);

		JSpinner spnrHDDCapacidad = new JSpinner();
		spnrHDDCapacidad.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
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

		JSeparator sprtrCPU = new JSeparator();
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

		JSeparator sprtrRam = new JSeparator();
		sprtrRam.setOrientation(SwingConstants.VERTICAL);
		sprtrRam.setForeground(Color.LIGHT_GRAY);
		sprtrRam.setBounds(447, 11, 2, 139);
		pnlRam.add(sprtrRam);

		JLabel lblMemoriagb = new JLabel("Memoria (GB):");
		lblMemoriagb.setBounds(10, 36, 100, 14);
		pnlRam.add(lblMemoriagb);

		JSpinner spnrMemoria = new JSpinner();
		spnrMemoria.setModel(new SpinnerNumberModel(0.0, 0.0, 64.0, 1.0));
		spnrMemoria.setBounds(120, 33, 121, 20);
		pnlRam.add(spnrMemoria);

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

		JComboBox cmbTipoRam = new JComboBox();
		cmbTipoRam.setModel(new DefaultComboBoxModel(new String[] { "<Seleccionar>", "DDR", "DDR2", "DDR3", "DDR4" }));
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
		btnAcceptar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String serial = txtSerial.getText();
				String marca = txtMarca.getText();
				String modelo = txtModelo.getText();
				Double precioCompra = (Double) spnrCompra.getValue();
				Double precioVenta = (Double) spnrVenta.getValue();

				int cantProducto = (int) spnrCantComp.getValue();

				if (txtSerial.getText().length() > 0 && txtMarca.getText().length() > 0
						&& txtModelo.getText().length() > 0 && (Double) spnrCompra.getValue() > 0.00
						&& (Double) spnrVenta.getValue() > 0.00 && cmbProveedor.getSelectedIndex() > -1) {

					String proveedor = cmbProveedor.getSelectedItem().toString();

					if (rdbtnMotherboard.isSelected()) // Motherboard
					{

						String socket = txtSocketMobo.getText();
						String tipoRam = cmbRam.getSelectedItem().toString();
						String tipoHdd = cmbPrtoMobo.getSelectedItem().toString();

						Motherboard mobo = new Motherboard(marca, precioCompra, cantProducto, serial, modelo,
								precioVenta, proveedor, socket, tipoRam, tipoHdd);

						Tienda.getInstance().insertarProducto(mobo);
						if (serial != Tienda.getInstance().asignarSerial()) {
							txtSerial.setText("");
							txtMarca.setText(null);
							txtModelo.setText(null);
							spnrCompra.setValue(0);
							spnrVenta.setValue(0);
							txtSocketMobo.setText(null);
							cmbRam.setSelectedIndex(-1);
							cmbPrtoMobo.setSelectedIndex(-1);

						}

						try {
							Tienda.getInstance().guardarDatos();
							JOptionPane.showMessageDialog(null, "Componente guardado en 'Mis Documentos'!",
									"�Guardado!", JOptionPane.PLAIN_MESSAGE);
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "No se ha podido guardar en 'Mis Documentos'!",
									"�Error!", JOptionPane.PLAIN_MESSAGE);
							e.printStackTrace();
						}

						txtSerial.setText(Tienda.getInstance().asignarSerial()); // Autoincrementa el serial

					}

					if (rdbtnRam.isSelected()) // Memoria Ram
					{

						Double memoria = (Double) spnrMemoria.getValue();
						String tipoMemoria = cmbTipoRam.getSelectedItem().toString();

						Ram miRam = new Ram(marca, precioCompra, cantProducto, serial, modelo, precioVenta, proveedor,
								memoria, tipoMemoria);

						Tienda.getInstance().insertarProducto(miRam);
						if (serial != Tienda.getInstance().asignarSerial()) {
							txtSerial.setText("");
							txtMarca.setText(null);
							txtModelo.setText(null);
							spnrCompra.setValue(0);
							spnrVenta.setValue(0);

							spnrMemoria.setValue(0);
							cmbTipoRam.setSelectedIndex(-1);

						}

						try {
							Tienda.getInstance().guardarDatos();
							JOptionPane.showMessageDialog(null, "Componente guardado en 'Mis Documentos'!",
									"�Guardado!", JOptionPane.PLAIN_MESSAGE);
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "No se ha podido guardar en 'Mis Documentos'!",
									"�Error!", JOptionPane.PLAIN_MESSAGE);
							e.printStackTrace();
						}

						txtSerial.setText(Tienda.getInstance().asignarSerial()); // Autoincrementa el serial

					}

					if (rdbtnProcesador.isSelected()) // Procesador
					{

						String socket = txtCPUSocket.getText();
						Double velocidad = (Double) spnrCPUSpeed.getValue();

						Procesador CPU = new Procesador(marca, precioCompra, cantProducto, serial, modelo, precioVenta,
								proveedor, socket, velocidad);

						Tienda.getInstance().insertarProducto(CPU);
						if (serial != Tienda.getInstance().asignarSerial()) {
							txtSerial.setText("");
							txtMarca.setText(null);
							txtModelo.setText(null);
							spnrCompra.setValue(0);
							spnrVenta.setValue(0);

							txtCPUSocket.setText(null);
							;
							spnrCPUSpeed.setValue(0);

						}

						try {
							Tienda.getInstance().guardarDatos();
							JOptionPane.showMessageDialog(null, "Componente guardado en 'Mis Documentos'!",
									"�Guardado!", JOptionPane.PLAIN_MESSAGE);
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "No se ha podido guardar en 'Mis Documentos'!",
									"�Error!", JOptionPane.PLAIN_MESSAGE);
							e.printStackTrace();
						}

						txtSerial.setText(Tienda.getInstance().asignarSerial()); // Autoincrementa el serial

					}

					if (rdbtnDiscoDuro.isSelected()) // Hard Drive
					{
						Double capacidad = (Double) spnrHDDCapacidad.getValue();
						String conexion = cmbHDDtipo.getSelectedItem().toString();

						DiscoDuro miHDD = new DiscoDuro(marca, precioCompra, cantProducto, serial, modelo, precioVenta,
								proveedor, capacidad, conexion);

						Tienda.getInstance().insertarProducto(miHDD);
						if (serial != Tienda.getInstance().asignarSerial()) {
							txtSerial.setText("");
							txtMarca.setText(null);
							txtModelo.setText(null);
							spnrCompra.setValue(0);
							spnrVenta.setValue(0);

							cmbHDDtipo.setSelectedIndex(-1);
							spnrHDDCapacidad.setValue(0);

						}

						try {
							Tienda.getInstance().guardarDatos();
							JOptionPane.showMessageDialog(null, "Componente guardado en 'Mis Documentos'!",
									"�Guardado!", JOptionPane.PLAIN_MESSAGE);
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "No se ha podido guardar en 'Mis Documentos'!",
									"�Error!", JOptionPane.PLAIN_MESSAGE);
							e.printStackTrace();
						}

						txtSerial.setText(Tienda.getInstance().asignarSerial()); // Autoincrementa el serial

					}

				}
				
				
				changeLabelNameANDtableContents(0);
			}
		});
		btnAcceptar_2.setBounds(715, 466, 89, 23);
		pnlRegComp.add(btnAcceptar_2);

		JButton btnDashboard = new JButton("DASHBOARD");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				graficarStock();
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

				txtFldidUsuario.setText(Tienda.getInstance().asignarIdUsuario());

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
				txtIdVendedor.setText(Tienda.getInstance().asignarIdUsuario());
			}
		});
		btnVendedores.setBounds(10, 105, 163, 36);
		pnlMenu.add(btnVendedores);

		JButton btnComponente = new JButton("COMPONENTE");
		btnComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				changeLabelNameANDtableContents(0);

				tabsAdmin.setVisible(false);
				tabs_Dashboard.setVisible(false);
				tabsVendedores.setVisible(false);
				tabsComponentes.setVisible(true);

				rdbtnMotherboard.setSelected(true);
				panelMobo.setVisible(true);
				pnlRam.setVisible(false);

				txtSerial.setText(Tienda.getInstance().asignarSerial());
				txtIdSerialKit.setText(Tienda.getInstance().asignarIdKit());
				// modelInventario.clear();
				cmbMoboKit.removeAllItems();
				cmbRamKit.removeAllItems();
				cmbCPUKit.removeAllItems();
				cmbHDDkit.removeAllItems();
				cmbProveedor.removeAllItems();

				for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
					if (Tienda.getInstance().getComponentes().get(i) instanceof Motherboard)
						cmbMoboKit.addItem(Tienda.getInstance().getComponentes().get(i));

					if (Tienda.getInstance().getComponentes().get(i) instanceof Ram)
						cmbRamKit.addItem(Tienda.getInstance().getComponentes().get(i));

					if (Tienda.getInstance().getComponentes().get(i) instanceof Procesador)
						cmbCPUKit.addItem(Tienda.getInstance().getComponentes().get(i));

					if (Tienda.getInstance().getComponentes().get(i) instanceof DiscoDuro)
						cmbHDDkit.addItem(Tienda.getInstance().getComponentes().get(i));

					// modelInventario.addElement(Tienda.getInstance().getComponentes().get(i));

				}

			}
		});
		btnComponente.setBounds(10, 152, 163, 36);
		pnlMenu.add(btnComponente);

		JButton btnProveedores = new JButton("PROVEEDORES");
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarProveedor insercion;

				changeLabelNameANDtableContents(0);
					insercion = new InsertarProveedor();
					insercion.setVisible(true);

			}
		});
		btnProveedores.setBounds(10, 199, 163, 36);
		pnlMenu.add(btnProveedores);

	}

	private void changeLabelNameANDtableContents(int index) {
		tabInventario.setModel(DTMdetalles);
		DTMdetalles.setRowCount(0);
		filaListarComponentes = new Object[DTMdetalles.getColumnCount()];

		tabDetalles = new String[] { "Proveedor", "Serial", "Cantidad", "Precio Compra", "Precio Venta" };

		if (index == 0) {
			lblForComponentes.setText("Disco Duro");
			for (Componente comp : componentes) {

				if (comp instanceof DiscoDuro) {
					compAddrow(comp);
				}
			}
		} else if (index == 1) {
			lblForComponentes.setText("Motherboard");

			for (Componente comp : componentes) {

				if (comp instanceof Motherboard) {
					
					compAddrow(comp);
				}
				tabInventario.setModel(DTMdetalles);

			}

		} else if (index == 2) {
			lblForComponentes.setText("Procesador");
			for (Componente comp : componentes) {

				if (comp instanceof Procesador) {
					compAddrow(comp);
				}
			}

		} else if (index == 3) {
			lblForComponentes.setText("Ram");
			for (Componente comp : componentes) {

				if (comp instanceof Ram) {
					compAddrow(comp);
				}
			}
		}

	}

	private void compAddrow(Componente comp) {

		filaListarComponentes[0] = comp.getModelo();
		filaListarComponentes[1] = comp.getNumeroSerie();
		filaListarComponentes[2] = comp.getCantidad();
		filaListarComponentes[3] = comp.getPrecioVenta();
		filaListarComponentes[4] = comp.getProveedor();
		DTMdetalles.addRow(filaListarComponentes);

	}
	
	private void graficaVenta()
	{
		
		int cantMes = Tienda.getInstance().getMeses().size();
		
		if(cantMes == 1)
		{
			
			lcd_Ventas.addValue(0, "ventas", "Mes Anterior");
			lcd_Ventas.addValue(Tienda.getInstance().getMeses().get(0).getVentas().size(), "ventas",Tienda.getInstance().getMesActual().getMes() );
			//lcd_Ventas.1
			
		}
		
		if(cantMes <= 5 && cantMes > 1 )
		{
			for(int i = 0; i < cantMes; i++)
			{
				lcd_Ventas.addValue(Tienda.getInstance().getMeses().get(i).getVentas().size(), "ventas",Tienda.getInstance().getMeses().get(i).getMes() );
			}
		}
		
		if(cantMes > 5)
		{
			for(int i = cantMes, v = 5 ; v > 0; i-- ,v--)
			{
				lcd_Ventas.addValue(Tienda.getInstance().getMeses().get(i-v).getVentas().size(), "ventas",Tienda.getInstance().getMeses().get(i-v).getMes() );
			}
		}
		
	}
	
	private void graficarStock()
	{
		
		/*category1 = "Ram";
		category2 = "Motherboards";
		category3 = "Disco Duros";
		category4 = "Procesadores";
		category5 = "Kits";*/
		
		int mesActual = Tienda.getInstance().getMeses().size() -1;
		
		lcd_Stock.addValue(Tienda.getInstance().calcRam(), series1, category1);
		lcd_Stock.addValue(Tienda.getInstance().calcMotherBoard(), series1, category2);
		lcd_Stock.addValue(Tienda.getInstance().calcHDD(), series1, category3);
		lcd_Stock.addValue(Tienda.getInstance().calcCPU(), series1, category4);
		lcd_Stock.addValue(Tienda.getInstance().calcKits(), series1, category5);

		//Ventas
		
		lcd_Stock.addValue(Tienda.getInstance().getMeses().get(mesActual).getCantRam(), series2, category1);
		lcd_Stock.addValue(Tienda.getInstance().getMeses().get(mesActual).getCantMotherboard(), series2, category2);
		lcd_Stock.addValue(Tienda.getInstance().getMeses().get(mesActual).getCantHDD(), series2, category3);
		lcd_Stock.addValue(Tienda.getInstance().getMeses().get(mesActual).getCantCPU(), series2, category4);
		lcd_Stock.addValue(Tienda.getInstance().getMeses().get(mesActual).getCantKits(), series2, category5);
	}

}
