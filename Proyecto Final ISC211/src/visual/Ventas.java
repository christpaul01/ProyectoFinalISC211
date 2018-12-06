package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import logico.Componente;
import logico.Kit;
import logico.Tienda;
import logico.Cliente;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ListSelectionModel;

public class Ventas extends JFrame {

	private JPanel contentPane;
	private JTextField txtClient;
	private JTextField txtComp;
	private DefaultListModel listModelCliente;
	private DefaultListModel listModelComponente;
	private DefaultListModel listModelKits;
	private DefaultListModel listModelKitsCliente;
	private JComboBox cmbCliente;
	private JLabel lblClienteSelecionado;
	private JSpinner spnrCantTotal;
	
	private JSpinner spnrPrecioTotal;
	private JTextField txtKit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
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
	public Ventas() {
		setTitle("VENTAS -- Tiend v.0.90");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 764);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			Tienda.getInstance().cargarDatos();
		}
		catch(Exception e){
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
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		listModelComponente = new DefaultListModel();
		listModelCliente = new DefaultListModel();
		listModelKits = new DefaultListModel();
		listModelKitsCliente = new DefaultListModel();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 965, 703);
		contentPane.add(tabbedPane);
		
		JPanel pnlVentas = new JPanel();
		tabbedPane.addTab("Ventas", null, pnlVentas, null);
		pnlVentas.setLayout(null);
		
		txtClient = new JTextField();
		txtClient.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				borrarBusdquedaCientes();
			}
		});
		txtClient.setHorizontalAlignment(SwingConstants.CENTER);
		txtClient.setText("Cliente");
		txtClient.setBounds(646, 12, 200, 21);
		pnlVentas.add(txtClient);
		txtClient.setColumns(10);
		
		JButton btnBusqueda = new JButton("Busqueda");
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				buscarCliente();
			}
		});
		btnBusqueda.setBounds(844, 11, 106, 23);
		pnlVentas.add(btnBusqueda);
		
		txtComp = new JTextField();
		txtComp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				borrarBusdquedaComponentes();
			}
		});
		txtComp.setHorizontalAlignment(SwingConstants.CENTER);
		txtComp.setText("Componente");
		txtComp.setBounds(10, 12, 194, 21);
		pnlVentas.add(txtComp);
		txtComp.setColumns(10);
		
		JButton btnBusqueda_1 = new JButton("Busqueda");
		btnBusqueda_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busquedaComponente(txtComp.getText());
			}
		});
		btnBusqueda_1.setBounds(202, 11, 112, 23);
		pnlVentas.add(btnBusqueda_1);
		
		cmbCliente = new JComboBox();
		cmbCliente.setBounds(646, 45, 194, 21);
		pnlVentas.add(cmbCliente);
		
		JButton btnAcceptar = new JButton("Acceptar");
		btnAcceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente miCliente = (Cliente) cmbCliente.getSelectedItem();
				if(cmbCliente.getSelectedIndex() != -1)
					lblClienteSelecionado.setText(miCliente.getNombre());
			}
		});
		btnAcceptar.setBounds(844, 44, 106, 23);
		pnlVentas.add(btnAcceptar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(585, 102, 365, 258);
		pnlVentas.add(scrollPane_1);
		
		JList listCartCliente = new JList(listModelCliente);
		scrollPane_1.setViewportView(listCartCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 365, 258);
		pnlVentas.add(scrollPane);
		
		JList listComponentes = new JList(listModelComponente);
		listComponentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listComponentes);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Componentes", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(418, 160, 130, 118);
		pnlVentas.add(panel);
		panel.setLayout(null);
		
		JButton btnIN = new JButton(">>");
		btnIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				transaccionCliente("in", (Componente)listComponentes.getSelectedValue());
				actualizarPrecio();
				actualizarCantidad();
			}
		});
		btnIN.setBounds(20, 34, 89, 23);
		panel.add(btnIN);
		
		JButton btnOut = new JButton("<<");
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				transaccionCliente("out",(Componente)listCartCliente.getSelectedValue());
				actualizarPrecio();
				actualizarCantidad();
			}
		});
		btnOut.setBounds(20, 68, 89, 23);
		panel.add(btnOut);
		
		JLabel lblPreciototal = new JLabel("Precio Total:");
		lblPreciototal.setBounds(748, 599, 86, 14);
		pnlVentas.add(lblPreciototal);
		
		spnrPrecioTotal = new JSpinner();
		spnrPrecioTotal.setEnabled(false);
		spnrPrecioTotal.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		spnrPrecioTotal.setBounds(844, 596, 106, 21);
		pnlVentas.add(spnrPrecioTotal);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(748, 571, 86, 14);
		pnlVentas.add(lblCantidad);
		
		spnrCantTotal = new JSpinner();
		spnrCantTotal.setEnabled(false);
		spnrCantTotal.setBounds(844, 565, 106, 20);
		pnlVentas.add(spnrCantTotal);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(646, 77, 46, 14);
		pnlVentas.add(lblCliente);
		
		lblClienteSelecionado = new JLabel("Ninguno");
		lblClienteSelecionado.setBounds(702, 77, 248, 14);
		pnlVentas.add(lblClienteSelecionado);
		
		txtKit = new JTextField();
		txtKit.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				borrarBusquedKits();
			}
		});
		txtKit.setText("Kits");
		txtKit.setHorizontalAlignment(SwingConstants.CENTER);
		txtKit.setColumns(10);
		txtKit.setBounds(10, 372, 194, 21);
		pnlVentas.add(txtKit);
		
		JButton busquedKit = new JButton("Busqueda");
		busquedKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				busquedaKits(txtKit.getText());
			}
		});
		busquedKit.setBounds(202, 371, 112, 23);
		pnlVentas.add(busquedKit);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 415, 365, 139);
		pnlVentas.add(scrollPane_2);
		
		JList listKit = new JList(listModelKits);
		scrollPane_2.setViewportView(listKit);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(585, 415, 365, 139);
		pnlVentas.add(scrollPane_3);
		
		JList listKitCliente = new JList(listModelKitsCliente);
		scrollPane_3.setViewportView(listKitCliente);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kits", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(418, 415, 130, 118);
		pnlVentas.add(panel_1);
		
		JButton btnINKits = new JButton(">>");
		btnINKits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				transaccionKitCliente("in",(Kit)listKit.getSelectedValue());
				actualizarPrecio();
				actualizarCantidad();
				
				
			}
		});
		btnINKits.setBounds(20, 34, 89, 23);
		panel_1.add(btnINKits);
		
		JButton btnOutKits = new JButton("<<");
		btnOutKits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				transaccionKitCliente("out",(Kit)listKitCliente.getSelectedValue());
				actualizarPrecio();
				actualizarCantidad();
				
			}
		});
		btnOutKits.setBounds(20, 68, 89, 23);
		panel_1.add(btnOutKits);
		
		JButton btnAcceptar_1 = new JButton("Acceptar");
		btnAcceptar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(lblClienteSelecionado.getText() == "Ninguno" )
				{
					JOptionPane.showMessageDialog(null, "Seleccionar un cliente y componentes para finalizar.", "¡Error!", JOptionPane.PLAIN_MESSAGE);
				}
				
				if(lblClienteSelecionado.getText() != "Ninguno" && (Double) spnrPrecioTotal.getValue() > 0.00)
				{
					JOptionPane.showMessageDialog(null, "Compra Hecha!", "¡Exito!", JOptionPane.PLAIN_MESSAGE);
					FinalizarCompra();
				}
			}
		});
		btnAcceptar_1.setBounds(751, 641, 89, 23);
		pnlVentas.add(btnAcceptar_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(861, 641, 89, 23);
		pnlVentas.add(btnCancelar);
	}
	
	public void borrarBusdquedaCientes()
	{
		txtClient.setText("");
		//Test
	}
	
	public void borrarBusdquedaComponentes() {
		txtComp.setText("");
	}
	
	public void borrarBusquedKits()
	{
		txtKit.setText("");
	}
	
	public void transaccionCliente(String transaccion, Componente miComponente)
	{
		if(transaccion == "in" && miComponente != null)
		{
			listModelCliente.addElement(miComponente);
		}
		
		if(transaccion == "out" && miComponente != null)
		{
			listModelCliente.removeElementAt(listModelCliente.indexOf(miComponente));
		}
		
		
	}
	
	public void transaccionKitCliente(String transaccion, Kit miKit)
	{
		if(transaccion == "in" && miKit != null)
		{	
			listModelKitsCliente.addElement(miKit);
		}
		
		if(transaccion == "out" && miKit != null)
		{
			listModelKitsCliente.removeElementAt(listModelKitsCliente.indexOf(miKit));
		}
				

	}
	
	
	public void busquedaComponente(String busqueda) {
		
		listModelComponente.clear();
		for(int i = 0; i < Tienda.getInstance().getComponentes().size(); i++)
		{
			if(Tienda.getInstance().getComponentes().get(i).getCantidad() > 0 && Tienda.getInstance().getComponentes().get(i).getMarca().startsWith(busqueda))
			{
				
				listModelComponente.addElement(Tienda.getInstance().getComponentes().get(i));
			}
		}
		
	}
	
	
	public void busquedaKits(String busqueda) {
		
		listModelKits.clear();
		for(int i = 0; i < Tienda.getInstance().getKits().size(); i++)
		{
			if(Tienda.getInstance().getKits().get(i).getCantidad() > 0 && Tienda.getInstance().getKits().get(i).getNombre().startsWith(busqueda))
			{
				
				listModelKits.addElement(Tienda.getInstance().getKits().get(i));
			}
		}
		
	}
	
	public void actualizarPrecio()
	{
		Double precio = 0.00;
		
		ArrayList<Componente> carrito  = new ArrayList<Componente>();
		ArrayList<Kit> carritoKit  = new ArrayList<Kit>();
		
		for(int i = 0; i < listModelCliente.size(); i++)
		{
			carrito.add((Componente)listModelCliente.get(i));
			precio += carrito.get(i).getPrecioVenta();
		}
		
		for(int i = 0; i < listModelKitsCliente.size(); i++)
		{
			carritoKit.add((Kit)listModelKitsCliente.get(i));
			precio += carritoKit.get(i).getPrecioFinal();
		}
		
		spnrPrecioTotal.setValue(precio);
		
		
		
	}
	
	
	public void actualizarCantidad()
	{
		int cantidad = 0;
		
		cantidad = listModelKitsCliente.size() + listModelCliente.size();
		
		spnrCantTotal.setValue(cantidad);
		
	}
	
	public void buscarCliente()
	{
		//txtClient.getText()
		int cant = 0;
		
		cmbCliente.removeAllItems();
		
		for(int i = 0; i < Tienda.getInstance().getClientes().size(); i++)
		{
			if(Tienda.getInstance().getClientes().get(i).getNombre().startsWith(txtClient.getText()))
			{
				cant++;
				cmbCliente.addItem(Tienda.getInstance().getClientes().get(i));
			}
		}
		
		if(cant == 0)
		{
			int n = JOptionPane.showConfirmDialog(
		            null,
		            "Desea agregar un nuevo cliente?",
		            "Cliente No Encontrado",
		            JOptionPane.YES_NO_OPTION);

		        if(true){
		        	visual.Cliente cliente;
					cliente = new visual.Cliente();
					cliente.setVisible(true);
		        }
		        else {
		            JOptionPane.showMessageDialog(null, "Buscar Otro Cliente");
		        }
		}
	}
	
	
	public void FinalizarCompra()
	{
		listModelComponente.clear();
		listModelCliente.clear();
		listModelKitsCliente.clear();
		listModelKits.clear();
		lblClienteSelecionado.setText("Ninguno");
		cmbCliente.removeAllItems();
		actualizarCantidad();
		actualizarPrecio();
		
		
	}
	
}
