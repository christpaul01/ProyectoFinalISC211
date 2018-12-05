package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import logico.Tienda;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JPasswordField txtPass;
	private Tienda tienda;
	private JButton btnAceptar;
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
		txtname.setBounds(224, 54, 107, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(154, 55, 60, 19);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(154, 106, 69, 14);
		contentPane.add(lblContrasea);
		
		btnAceptar = new JButton("Iniciar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setBounds(213, 156, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(312, 156, 89, 23);
		contentPane.add(btnCancelar);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(224, 103, 107, 20);
		contentPane.add(txtPass);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/img/iconfinder_user_male2_172626 (1).png")));
		label.setBounds(10, 11, 142, 141);
		contentPane.add(label);
	}
	public boolean existeCuenta() {
		boolean existe=false;
		for (int i = 0; i < Tienda.getInstance().getUsuarios().size(); i++) {
			if(Tienda.getInstance().getUsuarios().get(i).getNombre().equalsIgnoreCase(txtname.toString())&&
				Tienda.getInstance().getUsuarios().get(i).getClave().equalsIgnoreCase(txtPass.toString())) {
				existe=true;
			}
		}
		return existe;
	}
}
