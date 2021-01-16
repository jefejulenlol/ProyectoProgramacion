package programacion.visual;
/**
 * 
 * @author Julen Peralta
 * @version 1.0
 * Se que el Layout deberia ser el de Gridlayout pero no he conseguido que quedara bien usando ese layout asi que empleo el Absolute
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import conexionesBasesDeDatos.ConexionLogin;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frmTiendaDeRopa;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmTiendaDeRopa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTiendaDeRopa = new JFrame();
		frmTiendaDeRopa.setTitle("Tienda de Ropa Julen's");
		frmTiendaDeRopa.setBounds(100, 100, 595, 406);
		frmTiendaDeRopa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTiendaDeRopa.getContentPane().setLayout(null);
		
		JLabel lblBienvenidoALa = new JLabel("BIENVENIDO A LA TIENDA DE ROPA JULEN'S");
		lblBienvenidoALa.setBounds(158, 48, 251, 33);
		frmTiendaDeRopa.getContentPane().add(lblBienvenidoALa);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(75, 133, 56, 16);
		frmTiendaDeRopa.getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(75, 173, 65, 16);
		frmTiendaDeRopa.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(158, 130, 116, 22);
		frmTiendaDeRopa.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 170, 116, 22);
		frmTiendaDeRopa.getContentPane().add(passwordField);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			//Establezco la  conexion a la base de datos al presionar el boton de Login para comprobar credenciales	
			ConexionLogin conexion = new ConexionLogin();
			conexion.ConexionBDLogin();
	
			
			}
		});
		btnLogin.setBounds(240, 244, 97, 25);
		frmTiendaDeRopa.getContentPane().add(btnLogin);
	}
}
