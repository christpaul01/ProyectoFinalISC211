package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Administrador;
import logico.Tienda;
import logico.Usuario;
import logico.Vendedor;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class CrearUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreUsuario;
	private JComboBox cbxTipo;
	private JPasswordField txtPassConfirmar;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearUsuario dialog = new CrearUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearUsuario() {
		setBounds(100, 100, 365, 209);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(12, 39, 143, 19);
		contentPanel.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setBounds(12, 12, 143, 15);
		contentPanel.add(lblNombreDeUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(186, 12, 115, 15);
		contentPanel.add(lblContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contraseña");
		lblConfirmarContrasea.setBounds(186, 70, 156, 15);
		contentPanel.add(lblConfirmarContrasea);
		
		cbxTipo = new JComboBox();
		cbxTipo.setBounds(12, 94, 143, 22);
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador", "Vendedor"}));
		contentPanel.add(cbxTipo);
		
		txtPassConfirmar = new JPasswordField();
		txtPassConfirmar.setBounds(186, 97, 156, 19);
		contentPanel.add(txtPassConfirmar);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(186, 39, 156, 19);
		contentPanel.add(txtPass);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtPass.getPassword().equals(txtPassConfirmar.getPassword())) {
							if (cbxTipo.getSelectedItem().equals("Vendedor")) {
								Usuario usuario = new Vendedor(txtNombreUsuario.getText(),txtPass.getPassword(),Tienda.getInstance().asignarIdUsuario());
								Tienda.getInstance().insertarVendedor(usuario);
							} else {
								Usuario usuario = new Administrador(txtNombreUsuario.getText(),txtPass.getPassword(),txtNombreUsuario.getText()+Tienda.getInstance().asignarIdUsuario(),Tienda.getInstance().asignarIdUsuario());
								Tienda.getInstance().insertarVendedor(usuario);
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
