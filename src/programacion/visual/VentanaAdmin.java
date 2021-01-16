package programacion.visual;

/**
 * 
 * @author Julen
 *@version final
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAdmin {

	private JFrame frmBienvenidoAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdmin window = new VentanaAdmin();
					window.frmBienvenidoAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBienvenidoAdmin = new JFrame();
		frmBienvenidoAdmin.setTitle("Bienvenido Admin!");
		frmBienvenidoAdmin.setBounds(100, 100, 625, 384);
		frmBienvenidoAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBienvenidoAdmin.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Bienvenido Admin!");
		label.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label.setBounds(194, 0, 218, 39);
		frmBienvenidoAdmin.getContentPane().add(label);
		
		JButton btnVersinUsuario = new JButton("Version Usuario");
		btnVersinUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaUsuario ventanaUsuario = new VentanaUsuario();
				ventanaUsuario.mostrarVentanaUsuario();
				frmBienvenidoAdmin.setVisible(false);
				
			}
		});
		btnVersinUsuario.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnVersinUsuario.setBounds(33, 97, 233, 145);
		frmBienvenidoAdmin.getContentPane().add(btnVersinUsuario);
		
		JButton btnVersinAdmin = new JButton("Version Admin");
		btnVersinAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaVersionAdmin ventanaVersionAdmin = new VentanaVersionAdmin();
				ventanaVersionAdmin.mostrarVentanaVersionAdmin();
				frmBienvenidoAdmin.setVisible(false);
			}
		});
		btnVersinAdmin.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnVersinAdmin.setBounds(332, 97, 233, 145);
		frmBienvenidoAdmin.getContentPane().add(btnVersinAdmin);
		
		JLabel lblPorFavorElija = new JLabel("Por favor elija la version a la que quiera acceder");
		lblPorFavorElija.setBounds(154, 37, 286, 16);
		frmBienvenidoAdmin.getContentPane().add(lblPorFavorElija);
	}
	
	/**
	 *Un metodo por el cual se muestra una nueva ventanaadmin
	 */
	public void mostrarVentanaAdmin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdmin window = new VentanaAdmin();
					window.frmBienvenidoAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
