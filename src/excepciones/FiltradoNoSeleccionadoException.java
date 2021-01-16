package excepciones;

/**
 * 
 * @author Julen
 *@version final
 */

@SuppressWarnings("serial")
public class FiltradoNoSeleccionadoException extends Exception{
	
	/**
     * una excepcion que saltara cuando no se seleccione algo en el filtrado de la ventanausuario
     * @param mensaje , el mensaje de error que salta.
     * 
     */
	public FiltradoNoSeleccionadoException(String mensaje) {
		super(mensaje);
	}

}
