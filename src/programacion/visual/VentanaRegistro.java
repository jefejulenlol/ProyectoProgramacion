package programacion.visual;

/**
 * 
 * @author Julen
 *@version final
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import acceso.bd.EscrituraYLecturaBD;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro {

	private JFrame frmRegistroDeUsuarios;
	private JTextField introducirUsuarioRegistro;
	private JPasswordField introducirPasswordRegistro;
	private JTextField introducirClaveAdmin;
	private JButton botonInfoClaveAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro window = new VentanaRegistro();
					window.frmRegistroDeUsuarios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeUsuarios = new JFrame();
		frmRegistroDeUsuarios.setTitle("Registro de Usuarios");
		frmRegistroDeUsuarios.setBounds(100, 100, 625, 384);
		frmRegistroDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeUsuarios.getContentPane().setLayout(null);
		
		JLabel lblF = new JLabel("Registro de usuarios");
		lblF.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblF.setBounds(202, 26, 192, 54);
		frmRegistroDeUsuarios.getContentPane().add(lblF);
		
		JLabel lblTxt1 = new JLabel("Tenga en cuenta que a menos que inserte en el apartado correspondiente la clave");
		lblTxt1.setBounds(61, 62, 523, 46);
		frmRegistroDeUsuarios.getContentPane().add(lblTxt1);
		
		JLabel lblTxt2 = new JLabel("asignada por el departamento de trabajadores de la tienda su nivel sera de \"Usuario\"");
		lblTxt2.setBounds(62, 104, 552, 16);
		frmRegistroDeUsuarios.getContentPane().add(lblTxt2);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario*:");
		lblNombreDeUsuario.setBounds(95, 156, 123, 16);
		frmRegistroDeUsuarios.getContentPane().add(lblNombreDeUsuario);
		
		JLabel lblPassword = new JLabel("Password*:");
		lblPassword.setBounds(150, 184, 68, 16);
		frmRegistroDeUsuarios.getContentPane().add(lblPassword);
		
		JLabel lblClaveDeAdmin = new JLabel("Clave de admin:");
		lblClaveDeAdmin.setBounds(125, 213, 93, 16);
		frmRegistroDeUsuarios.getContentPane().add(lblClaveDeAdmin);
		
		introducirUsuarioRegistro = new JTextField();
		introducirUsuarioRegistro.setBounds(230, 153, 116, 22);
		frmRegistroDeUsuarios.getContentPane().add(introducirUsuarioRegistro);
		introducirUsuarioRegistro.setColumns(10);
		
		introducirPasswordRegistro = new JPasswordField();
		introducirPasswordRegistro.setBounds(230, 181, 116, 22);
		frmRegistroDeUsuarios.getContentPane().add(introducirPasswordRegistro);
		
		introducirClaveAdmin = new JTextField();
		introducirClaveAdmin.setBounds(230, 210, 116, 22);
		frmRegistroDeUsuarios.getContentPane().add(introducirClaveAdmin);
		introducirClaveAdmin.setColumns(10);
		
		/**
		 *Boton que le indica, Inigo, cual es la pass que hay que poner al registrarse para registrarse con poderes de admin, tambien le da la opcion de colocarla sola
		 */
		botonInfoClaveAdmin = new JButton("?");
		botonInfoClaveAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int hack =JOptionPane.showConfirmDialog(null, "Profesor: La clave es 123, ¿Quiere que se le ponga automáticamente?", "Hack para poner la clave", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				
				switch (hack) {
				case 0:
					//Has pulsado Sí
					introducirClaveAdmin.setText("123");
					break;
				case 1:
					//Has pulsado No
					break;
				}
			}
		});
		botonInfoClaveAdmin.setBounds(72, 209, 48, 25);
		frmRegistroDeUsuarios.getContentPane().add(botonInfoClaveAdmin);
		
		/**
		 *Al colocar las futuras credenciales y darle al boton registrarse se registran estas en la base de datos, tambien se preveen todos los errores posibles, como; dejar los jtextfield en balnco, la base de datos comprueba por su estructura que no se repitan los nombres etc
		 */
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Registro del usuario, pass, y admin en BD
				
				String nombre = introducirUsuarioRegistro.getText();
				String pass = new String(introducirPasswordRegistro.getPassword());
				
				
				EscrituraYLecturaBD db = new EscrituraYLecturaBD();
				db.connectDB("Usuarioss.db");
				if ((!nombre.equals("") && !pass.equals("")) && introducirClaveAdmin.getText().contentEquals("123")) {
					String poderAdmin = "A";
					db.insert(nombre,pass,poderAdmin);
					JOptionPane.showMessageDialog(btnRegistrarse, "Registro realizado correctamente, admin");
					frmRegistroDeUsuarios.setVisible(false);
					VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
					ventanaPrincipal.mostrarVentanaPrincipal();
				}else if ((!nombre.equals("") && !pass.equals("")) && (introducirClaveAdmin.getText().contentEquals("123")==false)){
					String poderUsuario = "U";
					db.insert(nombre,pass,poderUsuario);
					JOptionPane.showMessageDialog(btnRegistrarse, "Registro realizado correctamente, usuario");
					frmRegistroDeUsuarios.setVisible(false);
					VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
					ventanaPrincipal.mostrarVentanaPrincipal();
					
				}else if (nombre.equals("") || pass.equals("")) {
					JOptionPane.showMessageDialog(btnRegistrarse, "Por favor, no deje espacios en blanco");
				}
			}
		});
		btnRegistrarse.setBounds(230, 258, 97, 25);
		frmRegistroDeUsuarios.getContentPane().add(btnRegistrarse);
	}
	
	public void mostrarVentanaRegistro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro window = new VentanaRegistro();
					window.frmRegistroDeUsuarios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	}

