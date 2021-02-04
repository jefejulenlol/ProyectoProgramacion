package acceso.bd;

/**
 * 
 * @author Julen
 *@version final
 */

public class Usuario {

	private String usuario;
	private String password;
	private boolean admin;
	/**
     * Constructor de la clase Usuario
     * @param usuario el usuario del login
     * @param password , la pass del login
     * @param admin, si es admin o no 
     * 
     */
	public Usuario(String usuario, String password, boolean admin) {
		this.usuario = usuario;
		this.password = password;
		this.admin = admin;
	}
	/**
     * getter de usuario
     * @return usuario
     * 
     */
	public String getUsuario() {
		return usuario;
	}
	/**
     * setter de usuario
     * @param usuario el usuario del login
     * 
     */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
     * getter de password
     * @return password del login
     * 
     */
	public String getPassword() {
		return password;
	}
	/**
     * setter de password
     * @param password , la contrasenya del login del objeto
     * 
     */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
     * booleano que indica si un objeto Usuario es admin o no
     * @return admin devuelve true si es admin y false si no lo es
     */
	public boolean isAdmin() {
		return admin;
	}
	/**
     * setter de admin
     * @param admin pone a un usuario como admin o no
     * 
     */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	/**
     * Pasa el usuario y la pass como un String
     * @return string devuelve un String con el usuario y la pass.
     * 
     */
	public String toString() {
		
		String string = "";
		
		return string + usuario + " " + password;
	}
	
	
}
