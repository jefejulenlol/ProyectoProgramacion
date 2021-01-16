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
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import acceso.ficheros.EscrituraYLecturaBD;
import productos.y.herencia.Producto;

import javax.swing.JButton;
import javax.naming.ldap.Rdn;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Color;

public class VentanaVersionAdmin {

	private JFrame frame;
	private JTextField textFieldTalla;
	private JTextField textFieldPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVersionAdmin window = new VentanaVersionAdmin();
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
	public VentanaVersionAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBienvenidoAdmin = new JLabel("Bienvenido Admin!");
		lblBienvenidoAdmin.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblBienvenidoAdmin.setBounds(178, 0, 218, 39);
		frame.getContentPane().add(lblBienvenidoAdmin);
		
		JLabel lblInserteOElimine = new JLabel("Inserte o elimine productos");
		lblInserteOElimine.setBounds(188, 36, 180, 16);
		frame.getContentPane().add(lblInserteOElimine);
		
		JLabel lblElijaElSexo = new JLabel("Elija el sexo:");
		lblElijaElSexo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblElijaElSexo.setBounds(12, 36, 115, 25);
		frame.getContentPane().add(lblElijaElSexo);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(12, 62, 61, 25);
		frame.getContentPane().add(rdbtnMujer);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(77, 62, 81, 25);
		frame.getContentPane().add(rdbtnHombre);
		
		JLabel label = new JLabel("Elija la temporada:");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(12, 83, 169, 28);
		frame.getContentPane().add(label);
		
		JComboBox comboBoxTemporada = new JComboBox();
		comboBoxTemporada.setModel(new DefaultComboBoxModel(new String[] {"Primavera", "Verano", "Otono", "Invierno"}));
		comboBoxTemporada.setBounds(12, 116, 155, 22);
		frame.getContentPane().add(comboBoxTemporada);
		
		JLabel label_1 = new JLabel("Elija el producto:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(12, 135, 155, 28);
		frame.getContentPane().add(label_1);
		
		JComboBox comboBoxProducto = new JComboBox();
		comboBoxProducto.setModel(new DefaultComboBoxModel(new String[] {"ZapatoHombre", "ZapatoMujer", "PantalonHombre", "PantalonMujer", "CamisetaHombre", "CamisetaMujer"}));
		comboBoxProducto.setMaximumRowCount(15);
		comboBoxProducto.setBounds(12, 164, 155, 22);
		frame.getContentPane().add(comboBoxProducto);
		
		JLabel label_2 = new JLabel("Elija el color:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(12, 189, 169, 28);
		frame.getContentPane().add(label_2);
		
		JComboBox comboBoxColor = new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"Rojo", "Azul", "Verde", "Amarillo"}));
		comboBoxColor.setBounds(12, 214, 155, 22);
		frame.getContentPane().add(comboBoxColor);
		
		JLabel label_3 = new JLabel("Elija su talla:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_3.setBounds(12, 241, 125, 28);
		frame.getContentPane().add(label_3);
		
		textFieldTalla = new JTextField();
		textFieldTalla.setText("0");
		textFieldTalla.setColumns(10);
		textFieldTalla.setBounds(125, 246, 42, 22);
		frame.getContentPane().add(textFieldTalla);

		ButtonGroup btnGroupSexo = new ButtonGroup();
		btnGroupSexo.add(rdbtnHombre);
		btnGroupSexo.add(rdbtnMujer);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setText("0");
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(135, 271, 42, 22);
		frame.getContentPane().add(textFieldPrecio);
		
		/**
		 *Permite escribir en la base de datos un nuevo producto acorde a las posibilidades de la tienda. También prevee los distintos errores que puede ocasionar esto
		 */
		JButton btnAnadir = new JButton("Anadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			if (rdbtnHombre.isSelected() && (!(Integer.parseInt(textFieldTalla.getText())==0) || !(Integer.parseInt(textFieldPrecio.getText())==0))) {
				String sexo = "Hombre";
				String temporada = comboBoxTemporada.getSelectedItem().toString();
				String producto = comboBoxProducto.getSelectedItem().toString();
				String color = comboBoxColor.getSelectedItem().toString();
				int talla = Integer.parseInt(textFieldTalla.getText());
				int precio = Integer.parseInt(textFieldPrecio.getText());
				
				EscrituraYLecturaBD conexion = new EscrituraYLecturaBD();
				conexion.insertProducto(sexo, temporada, producto, talla, color, precio);
				
			} else if(rdbtnMujer.isSelected() && (!(Integer.parseInt(textFieldTalla.getText())==0) || !(Integer.parseInt(textFieldPrecio.getText())==0))) {
				String sexo = "Mujer";
				String temporada = comboBoxTemporada.getSelectedItem().toString();
				String producto = comboBoxProducto.getSelectedItem().toString();
				String color = comboBoxColor.getSelectedItem().toString();
				int talla = Integer.parseInt(textFieldTalla.getText());
				int precio = Integer.parseInt(textFieldPrecio.getText());
				
				EscrituraYLecturaBD conexion = new EscrituraYLecturaBD();
				conexion.insertProducto(sexo, temporada, producto, talla, color, precio);
			} else if (Integer.parseInt(textFieldTalla.getText())==0 || Integer.parseInt(textFieldPrecio.getText())==0) {
				JOptionPane.showMessageDialog(null, "Ni el precio ni la talla pueden ser 0");
			} else if ((!rdbtnMujer.isSelected() || !rdbtnHombre.isSelected()) && (!(Integer.parseInt(textFieldTalla.getText())==0) || !(Integer.parseInt(textFieldPrecio.getText())==0))){
				JOptionPane.showMessageDialog(null, "Selecciona el sexo");
			}
				
			}
		});
		btnAnadir.setBounds(37, 312, 97, 25);
		frame.getContentPane().add(btnAnadir);
		
		JList list = new JList();
		list.setBounds(178, 65, 239, 227);
		frame.getContentPane().add(list);
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JLabel lblElijaElPrecio = new JLabel("Elija el precio:");
		lblElijaElPrecio.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblElijaElPrecio.setBounds(12, 271, 125, 28);
		frame.getContentPane().add(lblElijaElPrecio);
		
		/**
		 *Muestra en el jlist todos los productos guardados en la base de datos
		 */
		JButton btnCargarTodo = new JButton("Cargar Todos los Productos");
		btnCargarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<Producto> arrayList = new ArrayList<Producto>();
				arrayList = EscrituraYLecturaBD.selectProductoData();
				
				for (int i=0;i<arrayList.size();i++) {
					String mostrado = arrayList.get(i).getSexo() + " "+arrayList.get(i).getTipoProducto() + " "+arrayList.get(i).getPrecio()+"€" +" Talla: "+arrayList.get(i).getTalla();
					listModel.addElement(mostrado);
					list.setModel(listModel);
				}
				
			}
		});
		btnCargarTodo.setBounds(198, 305, 198, 25);
		frame.getContentPane().add(btnCargarTodo);
		
		/**
		 *Elimina el producto
		 */
		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int index = list.getSelectedIndex();
			    if (index != -1) {
			        listModel.remove(index);
			}			    				
			}
		});
		btnEliminarProducto.setBounds(432, 305, 148, 25);
		frame.getContentPane().add(btnEliminarProducto);
		
		/**
		 *Vuelve al menu de admin
		 */
		JButton btnVolver = new JButton("Volver al Menu");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaAdmin vtn = new VentanaAdmin();
            	vtn.mostrarVentanaAdmin();
            	frame.setVisible(false);
				
			}
		});
		btnVolver.setBounds(12, 11, 123, 25);
		frame.getContentPane().add(btnVolver);
		
		JButton btnAccesoAPagos = new JButton("Acceso a Pagos");
		btnAccesoAPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaPagos vtn = new VentanaPagos();
				vtn.mostrarVentanaPagos();
				frame.setVisible(false);
				
			}
		});
		btnAccesoAPagos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAccesoAPagos.setForeground(Color.RED);
		btnAccesoAPagos.setBounds(447, 163, 148, 25);
		frame.getContentPane().add(btnAccesoAPagos);
		
		JLabel lblbubblesortAqui = new JLabel("(BubbleSort) Aqui");
		lblbubblesortAqui.setBounds(462, 143, 133, 16);
		frame.getContentPane().add(lblbubblesortAqui);

	}
	
	public void mostrarVentanaVersionAdmin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVersionAdmin window = new VentanaVersionAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
