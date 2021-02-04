package programacion.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VentanaModificarYBorrarUsuarios {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaModificarYBorrarUsuarios window = new VentanaModificarYBorrarUsuarios();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaModificarYBorrarUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 577, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblModificaYElimina = new JLabel("Modifica y Elimina los usuarios y sus contrasenyas");
		lblModificaYElimina.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModificaYElimina.setBounds(61, 13, 439, 36);
		frame.getContentPane().add(lblModificaYElimina);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 62, 205, 249);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(191, 329, 97, 25);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(399, 251, 97, 25);
		frame.getContentPane().add(btnModificar);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(358, 128, 56, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblPass = new JLabel("Pass:");
		lblPass.setBounds(358, 176, 56, 16);
		frame.getContentPane().add(lblPass);
		
		textField = new JTextField();
		textField.setBounds(407, 125, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(407, 173, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
