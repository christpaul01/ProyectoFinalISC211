package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Cliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Tienda tienda;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JFormattedTextField txtCedula;
	private JMenuBar menuBar;
	private JMenu mnCliente;
	private JMenuItem mntmCrearCliente;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JTable table;
	private JMenuItem mntmListarCliente;
	private JPanel ListarCliente;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String selecte="";
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Cliente() {
		setTitle("Cliente");
		setVisible(true);
		setBounds(100, 100, 697, 467);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		try {
			tienda.getInstance().cargarDatos();
		}catch(Exception e) {
			try {
				tienda.getInstance().guardarDatos();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		JPanel CrearCliente = new JPanel();
		CrearCliente.setVisible(false);
		contentPanel.add(CrearCliente, BorderLayout.CENTER);
		CrearCliente.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(39, 50, 256, 256);
		label.setIcon(new ImageIcon(Cliente.class.getResource("/img/iconfinder_user-id_285641.png")));
		CrearCliente.add(label);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(350, 75, 69, 17);
		CrearCliente.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Cedula:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(350, 126, 69, 17);
		CrearCliente.add(lblNewLabel);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccin.setBounds(350, 186, 86, 17);
		CrearCliente.add(lblDireccin);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefono.setBounds(350, 255, 86, 26);
		CrearCliente.add(lblTelefono);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(446, 71, 170, 26);
		CrearCliente.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDireccion.setBounds(446, 180, 170, 33);
		CrearCliente.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefono.setBounds(446, 254, 170, 33);
		CrearCliente.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		try {
			txtCedula = new JFormattedTextField(new MaskFormatter("###-#######-#"));
			txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCedula.setBounds(446, 123, 170, 26);
			CrearCliente.add(txtCedula);
			
			ListarCliente = new JPanel();
			ListarCliente.setVisible(false);
			contentPanel.add(ListarCliente, BorderLayout.CENTER);
			ListarCliente.setLayout(new BorderLayout(0, 0));
			
			scrollPane = new JScrollPane();
			ListarCliente.add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = table.getSelectedRow();
					if(index>=0){
						//eliminarButton.setEnabled(true);
						//modificarButton.setEnabled(true);
						selecte = table.getValueAt(index, 0).toString();
					}
					}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model = new DefaultTableModel();
			String[] columnNames = {"Nombre","Cedula","Dirección","Telefono"};
			model.setColumnIdentifiers(columnNames);
			table.setModel(model);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("OK");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						cleanCliente();
					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				btnCancelar = new JButton("Cancel");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		mntmCrearCliente = new JMenuItem("Crear Cliente");
		mntmCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente.setVisible(true);
				ListarCliente.setVisible(false);
				btnAceptar.setText("Guardar");
				btnCancelar.setText("Cancelar");
			}
		});
		mnCliente.add(mntmCrearCliente);
		
		mntmListarCliente = new JMenuItem("Listar Cliente");
		mntmListarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente.setVisible(false);
				ListarCliente.setVisible(true);
				btnAceptar.setText("Aceptar");
				btnCancelar.setText("Cancelar");
			}
		});
		mnCliente.add(mntmListarCliente);
	}
	public void cleanCliente() {
		txtNombre.setText("");
		try {
			txtCedula.setValue(new MaskFormatter("###-#######-#"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtDireccion.setText("");
		txtTelefono.setText("");
	}
	public static void loadCliente(){
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Tienda.getInstance().getClientes().size(); i++) {
			fila[0] = Tienda.getInstance().getClientes().get(i).getNombre();
			fila[1] = Tienda.getInstance().getClientes().get(i).getCedula();
			fila[2] = Tienda.getInstance().getClientes().get(i).getDireccion();
			fila[3] = Tienda.getInstance().getClientes().get(i).getTelefono();
			model.addRow(fila);		
	}
	}
}
