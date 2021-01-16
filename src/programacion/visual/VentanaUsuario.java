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
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import acceso.ficheros.EscrituraYLecturaBD;
import excepciones.FiltradoNoSeleccionadoException;
import productos.y.herencia.Producto;
import productos.y.herencia.Tarjeta;
import productos.y.herencia.TarjetaCliente;
import programacion.visual.VentanaUsuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaUsuario{

	private JFrame frmBienvenidoUsuario;
	private JTextField textFieldTalla;
	private JLabel lblPrecioNumerico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario window = new VentanaUsuario();
					window.frmBienvenidoUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBienvenidoUsuario = new JFrame();
		frmBienvenidoUsuario.setTitle("Bienvenido Usuario!");
		frmBienvenidoUsuario.setBounds(100, 100, 625, 384);
		frmBienvenidoUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBienvenidoUsuario.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Usuario!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(179, 0, 218, 39);
		frmBienvenidoUsuario.getContentPane().add(lblNewLabel);
		
		JLabel lblElijaSuSexo = new JLabel("Elija su sexo:");
		lblElijaSuSexo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblElijaSuSexo.setBounds(12, 55, 125, 28);
		frmBienvenidoUsuario.getContentPane().add(lblElijaSuSexo);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(8, 82, 61, 25);
		frmBienvenidoUsuario.getContentPane().add(rdbtnMujer);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(76, 82, 81, 25);
		frmBienvenidoUsuario.getContentPane().add(rdbtnHombre);
		
		ButtonGroup btnGroupSexo = new ButtonGroup();
		btnGroupSexo.add(rdbtnHombre);
		btnGroupSexo.add(rdbtnMujer);
		
		JLabel lblElijaLaTemporada = new JLabel("Elija la temporada:");
		lblElijaLaTemporada.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblElijaLaTemporada.setBounds(12, 110, 169, 28);
		frmBienvenidoUsuario.getContentPane().add(lblElijaLaTemporada);
		
		JComboBox comboBoxTemporada = new JComboBox();
		comboBoxTemporada.setModel(new DefaultComboBoxModel(new String[] {"Primavera", "Verano", "Otono", "Invierno"}));
		comboBoxTemporada.setBounds(12, 139, 155, 22);
		frmBienvenidoUsuario.getContentPane().add(comboBoxTemporada);

		
		JLabel lblElijaElColor = new JLabel("Elija el color:");
		lblElijaElColor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblElijaElColor.setBounds(12, 216, 169, 28);
		frmBienvenidoUsuario.getContentPane().add(lblElijaElColor);
		
		JComboBox comboBoxColor = new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"Rojo", "Azul", "Verde", "Amarillo"}));
		comboBoxColor.setBounds(12, 245, 155, 22);
		frmBienvenidoUsuario.getContentPane().add(comboBoxColor);
		
		JLabel lblElijaSuTalla = new JLabel("Elija su talla:");
		lblElijaSuTalla.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblElijaSuTalla.setBounds(12, 271, 125, 28);
		frmBienvenidoUsuario.getContentPane().add(lblElijaSuTalla);
		
		textFieldTalla = new JTextField();
		textFieldTalla.setText("0");
		textFieldTalla.setBounds(125, 276, 42, 22);
		frmBienvenidoUsuario.getContentPane().add(textFieldTalla);
		textFieldTalla.setColumns(10);
		
		JLabel lblElijaElProducto = new JLabel("Elija el producto:");
		lblElijaElProducto.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblElijaElProducto.setBounds(12, 163, 155, 28);
		frmBienvenidoUsuario.getContentPane().add(lblElijaElProducto);
		
		JComboBox comboBoxTipoProducto = new JComboBox();
		comboBoxTipoProducto.setModel(new DefaultComboBoxModel(new String[] {"ZapatoHombre", "ZapatoMujer", "PantalonHombre", "PantalonMujer", "CamisetaHombre", "CamisetaMujer"}));
		comboBoxTipoProducto.setMaximumRowCount(15);
		comboBoxTipoProducto.setBounds(12, 193, 155, 22);
		frmBienvenidoUsuario.getContentPane().add(comboBoxTipoProducto);
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		
		JLabel lblDisfruteDeSu = new JLabel("Disfrute de su compra");
		lblDisfruteDeSu.setBounds(222, 36, 136, 16);
		frmBienvenidoUsuario.getContentPane().add(lblDisfruteDeSu);
		
		JList list = new JList();
		list.setBounds(179, 62, 204, 227);
		frmBienvenidoUsuario.getContentPane().add(list);
		
		/**
		 *Filtra lo que el usuario busca para ver si se encuentra en stock en la tienda y prevee distintos errores que puedan suceder, como que el usuario no seleccione la talla, sexo etc y también implementa la excepcion realizada en el paquete de excepciones
		 */
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Esto es solamente un filtrado que compara lo leido de la base de datos de productos con lo seleccionado en la opcion de filtrado de la ventanaUsuario para mostrar en la Jlist lo que nos interesa
				try {
					ArrayList<Producto> arrayList = new ArrayList<Producto>();
					arrayList = EscrituraYLecturaBD.selectProductoData();
					
					Integer talla = Integer.parseInt(textFieldTalla.getText());
					
					for (int i=0;i<arrayList.size();i++) {
					
					if((rdbtnHombre.isSelected() && arrayList.get(i).getSexo().equals("Hombre")) || (rdbtnMujer.isSelected() && arrayList.get(i).getSexo().equals("Mujer"))) {
						if(comboBoxTemporada.getSelectedItem().toString().equals(arrayList.get(i).getTemporadaDeRopa())) {
							if(comboBoxTipoProducto.getSelectedItem().toString().equals(arrayList.get(i).getTipoProducto())) {
								if(comboBoxColor.getSelectedItem().toString().equals(arrayList.get(i).getColor())) {
									if(talla.equals(arrayList.get(i).getTalla())) {
										String mostrado = arrayList.get(i).getSexo() + " "+arrayList.get(i).getTipoProducto() +" Talla: "+arrayList.get(i).getTalla();
										listModel.addElement(mostrado);
										list.setModel(listModel);
					}}}}}else if ((!rdbtnHombre.isSelected() && !rdbtnMujer.isSelected()) || (arrayList.get(i).getTalla()==0) || (arrayList.get(i).getPrecio()==0)){
						throw new FiltradoNoSeleccionadoException("Error en la seleccion del filtrado, por favor rellene todas las casillas");
					}
					}
				} catch (FiltradoNoSeleccionadoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}
		}});
		btnBuscar.setBounds(40, 305, 97, 25);
		frmBienvenidoUsuario.getContentPane().add(btnBuscar);
		
		lblPrecioNumerico = new JLabel("xxxxxx");
		lblPrecioNumerico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecioNumerico.setBounds(456, 86, 51, 28);
		frmBienvenidoUsuario.getContentPane().add(lblPrecioNumerico);
		
		/**
		 *Permite seleccionar el producto que desea comprar desde la jlist e indica el precio del mismo al cliente
		 */
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indicePresionado = list.getSelectedIndex();
				if (indicePresionado!= -1) {
					ArrayList<Producto> arrayList = new ArrayList<Producto>();
					arrayList = EscrituraYLecturaBD.selectProductoData();
					
					Integer talla = Integer.parseInt(textFieldTalla.getText());
					
					for (int i=0;i<arrayList.size();i++) {
					
					if((rdbtnHombre.isSelected() && arrayList.get(i).getSexo().equals("Hombre")) || (rdbtnMujer.isSelected() && arrayList.get(i).getSexo().equals("Mujer"))) {
						if(comboBoxTemporada.getSelectedItem().toString().equals(arrayList.get(i).getTemporadaDeRopa())) {
							if(comboBoxTipoProducto.getSelectedItem().toString().equals(arrayList.get(i).getTipoProducto())) {
								if(comboBoxColor.getSelectedItem().toString().equals(arrayList.get(i).getColor())) {
									if(talla.equals(arrayList.get(i).getTalla())) {
										
										Integer precio = arrayList.get(i).getPrecio();
										
										lblPrecioNumerico.setText(precio.toString());
										list.setModel(listModel);
					}}}}}}
					
				}
				
				}
		});
		btnSeleccionar.setBounds(229, 305, 112, 25);
		frmBienvenidoUsuario.getContentPane().add(btnSeleccionar);
		
		JLabel lblInformacionSobreEl = new JLabel("Informacion sobre el producto:");
		lblInformacionSobreEl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformacionSobreEl.setBounds(395, 55, 200, 28);
		frmBienvenidoUsuario.getContentPane().add(lblInformacionSobreEl);
		
		JLabel lblPrecioTexto = new JLabel("Precio:");
		lblPrecioTexto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecioTexto.setBounds(395, 86, 49, 28);
		frmBienvenidoUsuario.getContentPane().add(lblPrecioTexto);
		
		/**
		 *Permite comprar con tarjeta, sin descuento
		 */
		JButton btnComprar = new JButton("Comprar con Tarjeta");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Tarjeta trj = new Tarjeta();
				JOptionPane.showMessageDialog(null, trj.pagar());
				
				frmBienvenidoUsuario.setVisible(false);
			}
		});
		btnComprar.setBounds(426, 114, 153, 25);
		frmBienvenidoUsuario.getContentPane().add(btnComprar);
		
		/**
		 *Permite comprar con tarjeta cliente, aplicandole un descuento
		 */
		JButton button = new JButton("Comprar con Tarjeta Cliente");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TarjetaCliente trj = new TarjetaCliente();
				JOptionPane.showMessageDialog(null, trj.pagar());
				
				frmBienvenidoUsuario.setVisible(false);
				
			}
		});
		button.setBounds(395, 148, 200, 25);
		frmBienvenidoUsuario.getContentPane().add(button);
		
		/**
		 *Ayuda para que comprenda mejor la App
		 */
		JButton btnAyudaInigo = new JButton("Ayuda Inigo");
		btnAyudaInigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Pruebe con el producto predeterminado Hombre, Primavera, ZapatoHombre, Talla 47, Rojo");
				
			}
		});
		btnAyudaInigo.setBounds(12, 17, 112, 25);
		frmBienvenidoUsuario.getContentPane().add(btnAyudaInigo);
		
		
	}
	
	public void mostrarVentanaUsuario() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario window = new VentanaUsuario();
					window.frmBienvenidoUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
