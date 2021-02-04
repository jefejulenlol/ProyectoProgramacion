package acceso.bd;
/**
 * 
 * @author Julen
 *@version final
 */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import productos.y.herencia.Producto;
import programacion.visual.VentanaAdmin;
import programacion.visual.VentanaUsuario;

public class EscrituraYLecturaBD
{
	
	
	Statement stmt  = null;
	
    /**
     * Connect to the Usuarios.sqlite database
     * @return the Connection object
     */
    public static Connection connectDB(String rutaBD)
    {
        // SQLite connection string
    	
    	String rutaPredefinida = "jdbc:sqlite:";
		String ruta = rutaPredefinida + rutaBD;
		Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(ruta);
            System.out.println("Conexion establecida!");

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Conexion no establecida!");
        }
        return conn;
    }
    /**
     * Cierra la conexion con la base de datos que se le pasa
     * 
     */
    public static void closeConnection(String archivo) {
    	try {
    		Connection conn = connectDB(archivo);
			conn.close();
			System.out.println("Conexion cerrada con exito");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }


    /**
     * Lee todas las filas y columnas de la base de datos
     * @param name de usuario introducido via teclado
     * @param password introducida por el usuario via teclado
     * @return un boolean de si ha encontrado una coincidencia en nombre y contrasenya en la BD con la introducida por el usuario
     */
    public static boolean selectLoginData(String name, String password)
    {
        String sql = "SELECT * FROM Usuarios";
        boolean success=false;

        try
                (
                		Connection conn = connectDB("Usuarioss.db");
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql)
                )
        {

            // loop through the result set
            while (rs.next())
            {
                System.out.println
                        (
                                rs.getString("Nombre") +  "\t" +
                                rs.getString("Pass") + "\t" +
                                rs.getString("Poder")
                        );
                
                String nombre =rs.getString("Nombre");
                String pass = rs.getString("Pass");
                String poder = rs.getString("Poder");
                
                
                if (nombre.equals(name) && pass.equals(password) && poder.equals("U")) {
                	VentanaUsuario user = new VentanaUsuario();
                	user.mostrarVentanaUsuario();
                	success=true;
                }else if (nombre.equals(name) && pass.equals(password) && poder.equals("A")){
                	VentanaAdmin vtn = new VentanaAdmin();
                	vtn.mostrarVentanaAdmin();
                	success=true;
                }

            }
            
            closeConnection("Usuarioss.db");
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return success;
    }
    
    /**
     * Lee todas las filas y columnas de la base de datos
     * @return un BidiMap con el id y el usuario
     */
    
    public static BidiMap<Integer, String> cargarUsuarios()
    {
        String sql = "SELECT * FROM Usuarios";
        BidiMap<Integer, String> bidiMap = new DualHashBidiMap();
        
        try
                (
                		Connection conn = connectDB("Usuarioss.db");
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql)
                )
        {

            // loop through the result set
        	
            while (rs.next())
            {
                System.out.println
                        (
                        		rs.getInt("ID") +  "\t" +
                        		rs.getString("Nombre") +  "\t" +
                                rs.getString("Pass") + "\t" +
                                rs.getString("Poder")
                        );
                
                int ID = rs.getInt("ID");
                String nombre =rs.getString("Nombre");

                bidiMap.put(ID, nombre);
                

            }
            
            closeConnection("Usuarioss.db");
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return bidiMap;
    }
    
    /**
     * Elimina un usuario por su ID
     */
    
    public static void eliminarUsuario(int seleccion) {
    	String sql = "DELETE FROM Usuarios WHERE ID = "+seleccion;
    	try
        (
        		Connection conn = connectDB("Usuarioss.db");
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)
        )
{
    		closeConnection("Usuarioss.db");
			} catch (SQLException e)
{
				System.out.println(e.getMessage());
}


    	
    }
    
    /**
     * Realiza un Update de los datos de la BD de un usuario en concreto al seleccionar en VetanaModificarYBorrarUsuarios uno en la lista y rellenar el User y la Pass nueva
     */
    
    public static void updateUsuario(int ID, String user, String pass){
        String sql = "UPDATE Usuarios\r\n" + 
        		"SET Nombre = '"+user+"', Pass= '"+pass+"'\r\n" + 
        		"WHERE ID = "+ID;
        
        try
                (
                		Connection conn = connectDB("Usuarioss.db");
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql)
                )
        {

            // loop through the result set
            
            closeConnection("Usuarioss.db");
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Registra en la base de datos los datos introducidos por el usuario en su registro
     * @param usuario el usuario de registro
     * @param pass la contrasenya del registro
     * @param poder el nivel de poder del usuario, admin o usuario
     * 
     */
    public static void insert(String usuario, String pass, String poder)
    {
        String sql = "Insert into Usuarios (Nombre,Pass,Poder) values (?,?,?)";

        try
                (
                        Connection conn = connectDB("Usuarioss.db");
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setString(1, usuario);
            pstmt.setString(2, pass);
            pstmt.setString(3, poder);
            pstmt.executeUpdate();
            closeConnection("Usuarioss.db");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
	//----------------------------------- Ficheros de productos (los de arriba son del login)---------------------
    
    /**
     * Guarda en la base de datos un nuevo producto
     * @param sexo el sexo de la ropa
     * @param temporadaDeRopa la temporada en la que se usa la prenda
     * @param tipoProducto el tipo de ropa que es
     * @param talla la talla del producto
     * @param color el color del producto
     * @param precio , su precio
     * 
     */
    public static void insertProducto(String sexo, String temporadaDeRopa, String tipoProducto, int talla, String color, int precio)
    {
        String sql = "Insert into Productos (Sexo,TemporadaDeRopa,TipoProducto,Talla,Color,Precio) values (?,?,?,?,?,?)";

        try
                (
                        Connection conn = connectDB("Productos.db");
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setString(1, sexo);
            pstmt.setString(2, temporadaDeRopa);
            pstmt.setString(3, tipoProducto);
            pstmt.setInt(4, talla);
            pstmt.setString(5, color);
            pstmt.setInt(6, precio);
            pstmt.executeUpdate();
            closeConnection("Productos.db");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Lee la base de datos de productos para poder incluirlos en una Jlist
     * @return productoList , un arraylist para incluirlo en un Jlist
     * 
     */
    public static ArrayList<Producto> selectProductoData()
    {
        String sql = "SELECT * FROM Productos";
        ArrayList<Producto> productoList = new ArrayList<>();

        try
                (
                		Connection conn = connectDB("Productos.db");
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql)
                )
        {

            // loop through the result set
        	
            while (rs.next())
            {
                System.out.println
                        (
                        		rs.getString("TipoProducto") +  "\t" +
                        		rs.getString("TemporadaDeRopa") + "\t" +
                        		rs.getString("Sexo") + "\t" +
                        		rs.getInt("Talla") + "\t" +
                        		rs.getString("Color") + "\t" +
                        		rs.getInt("Precio")
                        );
                
                String tipoProducto =rs.getString("TipoProducto");
                String temporadaDeRopa = rs.getString("TemporadaDeRopa");
                String sexo = rs.getString("Sexo");
                int talla = rs.getInt("Talla");
                String color = rs.getString("Color");
                int precio = rs.getInt("Precio");
                
                Producto producto = new Producto(tipoProducto, temporadaDeRopa, sexo, talla, color, precio);
                productoList.add(producto);                                

            }
            
            closeConnection("Productos.db");
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return productoList;
    }
    
	//----------------------------------- Ficheros de pagos ---------------------------------------------
    
    /**
     * Guarda en la base de datos un pago realizado por la tienda de ropa a sus empleados, solamente la cantidad
     * @param pago el importe del mismo
     * 
     */
    public static void insertPago(int pago)
    {
        String sql = "Insert into Pagos (pagos) values (?)";

        try
                (
                        Connection conn = connectDB("Pagos.db");
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
        	pstmt.setInt(1, pago);
           
            pstmt.executeUpdate();
            closeConnection("Pagos.db");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Lee la base de datos de pagos y lo guarda en un arrayList para posteriormente anyadirlo en un Jlist
     * @return pagosList el arrayList que se anyadira mas tarde en la Jlist
     * 
     */
    public static ArrayList<Integer> selectPagosData()
    {
        String sql = "SELECT * FROM Pagos ORDER BY id DESC LIMIT 10;";
        ArrayList<Integer> pagosList = new ArrayList<>();

        try
                (
                		Connection conn = connectDB("Pagos.db");
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql)
                )
        {

            // loop through the result set
        	
            while (rs.next())
            {
                System.out.println
                        (
                        		rs.getInt("id") +  "\t" +
                        		rs.getInt("Pagos")
                        );
                
                Integer pago =rs.getInt("Pagos");
                
                pagosList.add(pago);                                

            }
            
            closeConnection("Pagos.db");
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return pagosList;
    }
    
    }