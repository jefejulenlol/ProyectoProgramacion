package programacion.visual;

/**
 * 
 * @author Julen
 *@version final
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import acceso.ficheros.EscrituraYLecturaBD;
import productos.y.herencia.Producto;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class VentanaPagos {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPagos window = new VentanaPagos();
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
	public VentanaPagos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 589, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAquiOrdenaremosDe = new JLabel("Aqui ordenaremos de menor a mayor los ultimos pagos realizados a trabajadores");
		lblAquiOrdenaremosDe.setBounds(12, 13, 475, 16);
		frame.getContentPane().add(lblAquiOrdenaremosDe);
		
		JLabel lblAnadirPago = new JLabel("Anadir pago:");
		lblAnadirPago.setBounds(12, 101, 82, 16);
		frame.getContentPane().add(lblAnadirPago);
		
		textField = new JTextField();
		textField.setBounds(92, 98, 110, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		/**
		 *En este actionperformed del boton btnanadir se convierte lo ingresado por el usuario en el textfield a un int y se almacena en la correspondiente base de datos
		 */
		JButton btnAnadir = new JButton("Anadir a Base de Datos");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer pago = Integer.parseInt(textField.getText());
				EscrituraYLecturaBD.insertPago(pago);
				
			}
		});
		btnAnadir.setBounds(214, 97, 183, 25);
		frame.getContentPane().add(btnAnadir);
		
		JList list = new JList();
		list.setBounds(12, 130, 157, 238);
		frame.getContentPane().add(list);
		DefaultListModel<String> listModel = new DefaultListModel<String>();

		JList list2 = new JList();
		list2.setBounds(402, 130, 157, 238);
		frame.getContentPane().add(list2);
		DefaultListModel<String> listModel2 = new DefaultListModel<String>();
		
		/**
		 *al presionar el boton ordenardemenor se carga el arraylist a ordenar en el jlist para resolverla posteriormente con el bubblesort
		 */
		JButton btnOrdenarDeMenor = new JButton("Cargar Lista");
		btnOrdenarDeMenor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Integer> arrayList = new ArrayList<Integer>();
				arrayList = EscrituraYLecturaBD.selectPagosData();
				
				for (int i=0;i<arrayList.size();i++) {
					Integer mostrado = arrayList.get(i);
					listModel.addElement(mostrado.toString());
					list.setModel(listModel);
				}
				btnOrdenarDeMenor.setEnabled(false);;
				
			}
		});
		btnOrdenarDeMenor.setBounds(207, 181, 157, 25);
		frame.getContentPane().add(btnOrdenarDeMenor);
		
		JLabel lblALaEmpresa = new JLabel("A la empresa solamente le interesan los ultimos 10 pagos");
		lblALaEmpresa.setBounds(12, 42, 364, 16);
		frame.getContentPane().add(lblALaEmpresa);
		
		JLabel label = new JLabel("<-----------------------------------");
		label.setBounds(189, 209, 187, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("----------------------------------->");
		label_1.setBounds(189, 302, 187, 16);
		frame.getContentPane().add(label_1);
		
		/**
		 *Al presionar el boton ordenar saca los numeros desordenados de la jlist 1 y los ordena en la jlist2 empleando bubblesort
		 */
		JButton btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//----------------------BubbleSort
				
				ArrayList<Integer> arrayList = new ArrayList<Integer>();
				arrayList = EscrituraYLecturaBD.selectPagosData();
				Integer[] array = arrayList.toArray(new Integer[0]);
				
				int variableAuxiliar;
				for (int i = 0; i < array.length-1; i++)
				{
				   for(int j = 0; j < array.length-i-1; j++)
				   {
				            if(array[j] > array[j + 1])
				            {
				                   variableAuxiliar = array [j + 1];
				                   array [j + 1]= array [j];
				                   array [j] = variableAuxiliar;
				            }
				   }
				}
				for (int i = 0; i < array.length; i++)
				{
				     System.out.println(array[i]);
				     String x = Integer.toString(array[i]);
				     listModel2.addElement(array[i].toString());
					list2.setModel(listModel2);
				}	
				btnOrdenar.setEnabled(false);
			}
		});
		btnOrdenar.setBounds(239, 264, 97, 25);
		frame.getContentPane().add(btnOrdenar);
		
		JLabel lblsePuedeHacer = new JLabel("(Se puede hacer con m\u00E1s pero he decidido usar 10 para no sobrecargar el programa)");
		lblsePuedeHacer.setBounds(12, 72, 547, 16);
		frame.getContentPane().add(lblsePuedeHacer);
		
		/**
		 *Boton que vuelve al menu de admin
		 */
		JButton btnVolverAlMenu = new JButton("Volver al Menu");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				VentanaAdmin vtn = new VentanaAdmin();
				vtn.mostrarVentanaAdmin();
				
			}
		});
		btnVolverAlMenu.setBounds(226, 343, 123, 25);
		frame.getContentPane().add(btnVolverAlMenu);
	}
}
