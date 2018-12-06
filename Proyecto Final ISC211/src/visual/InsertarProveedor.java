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
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class InsertarProveedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public InsertarProveedor() {
		setTitle("Proveedor");
		setBounds(100, 100, 450, 176);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			/*JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(InsertarProveedor.class.getResource("/img/iconfinder_contacts_1954532 (1).png")));
			lblNewLabel.setBounds(34, 23, 128, 128);
			contentPanel.add(lblNewLabel);*/
		}
		
		JLabel lblNombre = new JLabel("Nombre Proveedor:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 14));
		lblNombre.setBounds(10, 41, 177, 26);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setBounds(197, 41, 227, 26);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Insertar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						insertarProveedor();
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
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void insertarProveedor() {
		String proveedor = txtNombre.getText();
		boolean existe=false;
		for (int i = 0; i < Tienda.getInstance().getProveedores().size(); i++) {
			if(Tienda.getInstance().getProveedores().get(i).equalsIgnoreCase(proveedor)) {
				existe=true;
			}
		}
		if(existe==true) {
			JOptionPane.showMessageDialog(null, "Existe el proveedor", "Informacion", JOptionPane.ERROR_MESSAGE);
		}
		else {
			Tienda.getInstance().insertarProveedor(proveedor);
			JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			txtNombre.setText("");
		}
	}
}
