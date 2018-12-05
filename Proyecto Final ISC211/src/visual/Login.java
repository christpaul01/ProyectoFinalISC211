package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Administrador;
import logico.Tienda;
import logico.Vendedor;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JPasswordField txtPass;
	private JButton btnAceptar;
	private Boolean loggedin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
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
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtname.setBounds(279, 55, 122, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(162, 59, 82, 19);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(162, 104, 107, 20);
		contentPane.add(lblContrasea);
		
		btnAceptar = new JButton("Iniciar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				
				
				
				if(existeCuenta() != -1 && concuerdaPassword(existeCuenta()) &&  Tienda.getInstance().getUsuarios().get(existeCuenta()) instanceof Administrador ) {
					Dashboard dash;
					try {
						dash = new Dashboard();
						dash.setVisible(true);
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				if(existeCuenta() != -1 && concuerdaPassword(existeCuenta()) &&  Tienda.getInstance().getUsuarios().get(existeCuenta()) instanceof Vendedor ) {
					Cliente cliente;
					cliente = new Cliente();
					cliente.setVisible(true);
				}
				
				if(existeCuenta()==-1) {
					JOptionPane.showMessageDialog(null, "No existe Cuenta", "Error", JOptionPane.ERROR_MESSAGE);
					clean();
				}
				
				if(existeCuenta()!=-1 && !(concuerdaPassword(existeCuenta()) )) {
					JOptionPane.showMessageDialog(null, "Contrasena incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
					clean();
				}
			}
		});
		btnAceptar.setBounds(213, 156, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clean();
			}
		});
		btnCancelar.setBounds(312, 156, 89, 23);
		contentPane.add(btnCancelar);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(279, 104, 122, 20);
		contentPane.add(txtPass);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/img/iconfinder_user_male2_172626 (1).png")));
		label.setBounds(10, 11, 142, 141);
		contentPane.add(label);
	}
	
	public int existeCuenta() {
		
		
		int index=-1;
		
		for (int i = 0; i < Tienda.getInstance().getUsuarios().size(); i++) {
			if( txtname.getText().equalsIgnoreCase(Tienda.getInstance().getUsuarios().get(i).getNombre()) )
			{
				index=i;
			}
		}
		return index;
	}
	
	
	public Boolean concuerdaPassword(int index)
	{
		Boolean login = false;
		
		if(Tienda.getInstance().getUsuarios().get(index).getClave() == (txtPass.getPassword()) || Arrays.equals(txtPass.getPassword(), Tienda.getInstance().getUsuarios().get(index).getClave()))
		{
			login = true;
			this.setVisible(false);
		}
			
		return login;
		
	}
	
	
	
	
	
	
	
	
	
	public void clean() {
		txtname.setText("");
		txtPass.setText("");
	}
}
