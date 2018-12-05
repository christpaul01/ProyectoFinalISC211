package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertarProveedores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreProveedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertarProveedores dialog = new InsertarProveedores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertarProveedores() {
		setTitle("Insertar Proveedor");
		setBounds(100, 100, 424, 112);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombreDelProveedor = new JLabel("Nombre del Proveedor:");
		lblNombreDelProveedor.setBounds(12, 12, 175, 15);
		contentPanel.add(lblNombreDelProveedor);
		
		txtNombreProveedor = new JTextField();
		txtNombreProveedor.setBounds(191, 10, 231, 17);
		contentPanel.add(txtNombreProveedor);
		txtNombreProveedor.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						for (int i = 0; i < Tienda.getInstance().getProveedores().size(); i++) {
							if (!(txtNombreProveedor.getText().equals(Tienda.getInstance().getProveedores().get(i)))) {
								Tienda.getInstance().insertarProveedor(txtNombreProveedor.getText());
							}
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
