package programacion.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.apache.commons.collections4.BidiMap;

import acceso.bd.EscrituraYLecturaBD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
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
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int index = list.getSelectedIndex();
			    if (index != -1) {
			    	String seleccion = listModel.getElementAt(index);
			        listModel.remove(index);
			        
			        BidiMap<Integer, String> bidiMap = EscrituraYLecturaBD.cargarUsuarios();
			        EscrituraYLecturaBD.eliminarUsuario(bidiMap.getKey(seleccion));
			}
				
				
			}
		});
		btnEliminar.setBounds(426, 258, 97, 25);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre =textField.getText();
				String pass = textField_1.getText();
				
				int index = list.getSelectedIndex();
			    if (index != -1) {
			    	String seleccion = listModel.getElementAt(index);
			        listModel.remove(index);
			        
			        BidiMap<Integer, String> bidiMap = EscrituraYLecturaBD.cargarUsuarios();
			        EscrituraYLecturaBD.updateUsuario(bidiMap.getKey(seleccion), nombre, pass);
			        //EscrituraYLecturaBD.eliminarUsuario(bidiMap.getKey(seleccion));
			}
				
			}
		});
		btnModificar.setBounds(380, 208, 97, 25);
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
		
		JButton btnCargarTodo = new JButton("Cargar Todo");
		btnCargarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BidiMap<Integer, String> bidiMap = EscrituraYLecturaBD.cargarUsuarios();
				
				for (int i=0;i<bidiMap.size();i++) {					
					String mostrado = bidiMap.get(i+1);
					listModel.addElement(mostrado);
					list.setModel(listModel);
				}
				
				
			}
		});
		btnCargarTodo.setBounds(195, 324, 123, 25);
		frame.getContentPane().add(btnCargarTodo);
		
		JLabel lblNombresDeUser = new JLabel("Nombres de User:");
		lblNombresDeUser.setBounds(12, 81, 105, 16);
		frame.getContentPane().add(lblNombresDeUser);
		
		JButton button = new JButton("?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Para modificar un usuario seleccione el usuario a modificar en la Jlist y posteriormente rellene el nuevo usuario y pass");
				
			}
		});
		button.setBounds(489, 208, 51, 25);
		frame.getContentPane().add(button);
	}
}
