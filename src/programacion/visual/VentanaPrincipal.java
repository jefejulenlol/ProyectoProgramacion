package programacion.visual;
/**
 * 
 * @author Julen
 *@version final
 */

//SOY CONSCIENTE DE QUE DEBERÍA USAR EL GRIDLAYOUT Y NO EL ABSOLUTE, PERO PERDÍA MUCHA MOVILIDAD PARA COLOCAR LOS COMPONENTES COMO QUERÍA Y ERA MUY INCOMODO

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import acceso.ficheros.EscrituraYLecturaBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frmTiendaDeRopa;
	private JTextField introducirUsuario;
	private JPasswordField introducirContrasenya;
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
		frmTiendaDeRopa.setBounds(100, 100, 625, 384);
		frmTiendaDeRopa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTiendaDeRopa.getContentPane().setLayout(null);
		
		JLabel lblBienvenidoALa = new JLabel("BIENVENIDO A LA TIENDA DE ROPA JULEN'S");
		lblBienvenidoALa.setBounds(158, 48, 251, 33);
		frmTiendaDeRopa.getContentPane().add(lblBienvenidoALa);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(75, 133, 56, 16);
		frmTiendaDeRopa.getContentPane().add(lblUsuario);
		
		JLabel lblContrasenya = new JLabel("Password:");
		lblContrasenya.setBounds(75, 173, 65, 16);
		frmTiendaDeRopa.getContentPane().add(lblContrasenya);
		
		introducirUsuario = new JTextField();
		introducirUsuario.setBounds(158, 130, 116, 22);
		frmTiendaDeRopa.getContentPane().add(introducirUsuario);
		introducirUsuario.setColumns(10);
		
		introducirContrasenya = new JPasswordField();
		introducirContrasenya.setBounds(158, 170, 116, 22);
		frmTiendaDeRopa.getContentPane().add(introducirContrasenya);
		
		/**
		 *Al presionar el boton login e introducir las credenciales se comprueban estas con las guardadas en la base de datos y se le permite o no el acceso
		 */
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			//Establezco la  conexion a la base de datos al presionar el boton de Login para comprobar credenciales	
				String usuario = introducirUsuario.getText();
				String pass = new String(introducirContrasenya.getPassword());
				EscrituraYLecturaBD conexion = new EscrituraYLecturaBD();
				
				if(conexion.selectLoginData(usuario,pass)==true) {
					frmTiendaDeRopa.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Credenciales no validas");
				}

				
			}	
		});
		btnLogin.setBounds(240, 244, 97, 25);
		frmTiendaDeRopa.getContentPane().add(btnLogin);
		
		/**
		 *Abre la ventana de registro y cierra la ventanaprincipal
		 */
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaRegistro ventanaRegistro = new VentanaRegistro();
				ventanaRegistro.mostrarVentanaRegistro();
				frmTiendaDeRopa.setVisible(false);
				
			}
		});
		btnRegistrarse.setBounds(240, 292, 106, 25);
		frmTiendaDeRopa.getContentPane().add(btnRegistrarse);
	}
	
	public void mostrarVentanaPrincipal(){
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
}