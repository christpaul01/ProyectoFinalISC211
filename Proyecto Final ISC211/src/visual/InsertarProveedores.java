package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class InsertarProveedores extends JDialog {
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertarProveedores dialog = new InsertarProveedores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			Tienda.getInstance().cargarDatos();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertarProveedores() throws IOException, ClassNotFoundException {
		setTitle("Insertar Proveedor");
		setBounds(100, 100, 468, 197);
		getContentPane().setLayout(null);
		
		try {
			Tienda.getInstance().cargarDatos();
		} catch (Exception e) {
			
			
		}
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txtNombre = new JTextField();
		txtNombre.setBounds(155, 37, 243, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombreProveedor = new JLabel("Nombre Proveedor:");
		lblNombreProveedor.setBounds(10, 40, 135, 14);
		getContentPane().add(lblNombreProveedor);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(353, 124, 89, 23);
		getContentPane().add(btnCancelar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				insertarPro();
				try {
					Tienda.getInstance().guardarDatos();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				
				
			}
		});
		btnAgregar.setBounds(254, 124, 89, 23);
		getContentPane().add(btnAgregar);
	}
	
	
	public void insertarPro()
	{
		String proveedor = txtNombre.getText();
		Boolean existe = false;
		
		
			for(int i = 0; i < Tienda.getInstance().getProveedores().size() ; i++)
			{
				if(Tienda.getInstance().getProveedores().get(i).equalsIgnoreCase(proveedor))
					existe = true;
			}
		
		
		if(existe == false)
		{
			Tienda.getInstance().insertarProveedor(proveedor);
			txtNombre.setText("");
			
			JOptionPane.showMessageDialog(null, "Proveedor guardado en 'Mis Documentos'!","¡Guardado!", JOptionPane.PLAIN_MESSAGE);
			
			dispose();
			
			
		}
		
		if(existe == true)
		{
			JOptionPane.showMessageDialog(null, "Ya existe este proveedor!","¡Error!", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	
}
