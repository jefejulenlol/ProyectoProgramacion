package conexionesBasesDeDatos;
/**
 * 
 * @author Julep
 *
 */

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionLogin {
	
	public void ConexionBDLogin() {
		String rutaPredefinida = "jdbc:sqlite:";
		String ruta = rutaPredefinida + "Desktop\\Eclipse workspace\\ProyectoProgramacion\\src\\conexionesBasesDeDatos\\UsuariosYPass.sqlite";
		
		Connection connect;
		
		try {
			connect = DriverManager.getConnection(ruta);
			if(connect!=null) {
				DatabaseMetaData meta = connect.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage().toString());
		}

	}
	
	
}
