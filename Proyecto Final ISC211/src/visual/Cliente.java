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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import java.awt.Panel;

public class Cliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Tienda tienda;
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
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ListarCliente = new JPanel();
		ListarCliente.setVisible(false);
		contentPanel.add(ListarCliente, BorderLayout.CENTER);
		ListarCliente.setLayout(new BoxLayout(ListarCliente, BoxLayout.X_AXIS));
		
		
		scrollPane = new JScrollPane();
		ListarCliente.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if(index>=0){
					btnAceptar.setEnabled(true);
					selecte = table.getValueAt(index, 0).toString();
				}
				}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel();
		String[] columnNames = {"Cedula","Nombre","Dirección","Telefono"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("Ok");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						logico.Cliente client=  Tienda.getInstance().buscarCliente(selecte);
						CrearCliente clie= new CrearCliente(client);
						clie.loadModificar(client);
						clie.setVisible(true);
					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
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
				int i=0;
				CrearCliente clie= new CrearCliente(Tienda.getInstance().buscarCliente(selecte));
				clie.setVisible(true);
			}
		});
		mnCliente.add(mntmCrearCliente);
		
		mntmListarCliente = new JMenuItem("Listar Cliente");
		mntmListarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadCliente();
				btnAceptar.setEnabled(false);
				ListarCliente.setVisible(true);
				btnAceptar.setText("Modificar");
				btnCancelar.setText("Cancelar");
			}
		});
		mnCliente.add(mntmListarCliente);
	}

	public static void loadCliente(){
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Tienda.getInstance().getClientes().size(); i++) {
			fila[0] = Tienda.getInstance().getClientes().get(i).getCedula();
			fila[1] = Tienda.getInstance().getClientes().get(i).getNombre();
			fila[2] = Tienda.getInstance().getClientes().get(i).getDireccion();
			fila[3] = Tienda.getInstance().getClientes().get(i).getTelefono();
			model.addRow(fila);		
	}
	}
}
