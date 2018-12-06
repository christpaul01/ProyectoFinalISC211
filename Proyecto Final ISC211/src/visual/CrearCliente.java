package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

import logico.Tienda;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private logico.Cliente client;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private Tienda tienda;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JFormattedTextField txtCedula;
	private JFormattedTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public CrearCliente(logico.Cliente cliente) {
		client=cliente;
		setBounds(100, 100, 697, 467);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		if(client==null) {
			setTitle("Registrar Cliente");
		}
		else if(client!=null) {
			setTitle("Modificar Cliente");
			btnAceptar.setText("Modificar");
		}
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CrearCliente.class.getResource("/img/iconfinder_user-id_285641.png")));
		label.setBounds(21, 102, 291, 178);
		contentPanel.add(label);
		{
			JLabel label_Cedula = new JLabel("Cedula:");
			label_Cedula.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_Cedula.setBounds(341, 103, 48, 19);
			contentPanel.add(label_Cedula);
		}
		{
			JLabel label_1 = new JLabel("Nombre:");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_1.setBounds(341, 155, 57, 19);
			contentPanel.add(label_1);
		}
		{
			JLabel labelDireccion = new JLabel("Direcci\u00F3n:");
			labelDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelDireccion.setBounds(341, 206, 62, 19);
			contentPanel.add(labelDireccion);
		}
		{
			JLabel label_1 = new JLabel("Telefono:");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_1.setBounds(341, 256, 62, 19);
			contentPanel.add(label_1);
		}
		{
			
			try {
				txtCedula = new JFormattedTextField(new MaskFormatter("###-#######-#"));
				txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtCedula.setBounds(418, 92, 167, 41);
				contentPanel.add(txtCedula);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNombre.setColumns(10);
			txtNombre.setBounds(419, 144, 167, 41);
			contentPanel.add(txtNombre);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(419, 195, 167, 41);
			contentPanel.add(txtDireccion);
		}
		
		try {
			txtTelefono = new JFormattedTextField(new MaskFormatter("###-###-####"));
			txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtTelefono.setBounds(418, 247, 167, 41);
		contentPanel.add(txtTelefono);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("Guardar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(client==null) {
							String nombre= txtNombre.getText();
							String cedula=txtCedula.getText();
							String direccion= txtDireccion.getText();
							String telefono= txtTelefono.getText();
							logico.Cliente cliente= new logico.Cliente(nombre,cedula,direccion,telefono);
							Tienda.getInstance().insertarCliente(cliente);
							try {
								Tienda.getInstance().guardarDatos();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							cleanCliente();
						}
						else {
							client.setNombre(txtNombre.toString());
							client.setDireccion(txtDireccion.toString());
							client.setTelefono(txtTelefono.toString());
							Cliente.loadCliente();
							try {
								Tienda.getInstance().guardarDatos();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							dispose();
						}
					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				btnCancelar = new JButton("Cancel");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
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
		try {
			txtTelefono.setValue(new MaskFormatter("###-###-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loadModificar(logico.Cliente client) {
		cleanCliente();
		txtCedula.setText(client.getCedula());
		txtNombre.setText(client.getNombre());
		txtDireccion.setText(client.getDireccion());
		txtTelefono.setText(client.getTelefono());
	}
}
