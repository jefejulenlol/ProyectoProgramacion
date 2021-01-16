package productos.y.herencia;

/**
 * 
 * @author Julen
 *@version final
 */

public class TarjetaCliente extends Tarjeta{
	
	private String descuento = "10%";

	/**
	 * getter del descuento
	 * @return descuento , devuelve el porcentaje a descontar
	 *
	 */
	public String getDescuento() {
		return descuento;
	}

	/**
	 * setter de descuento
	 * @param descuento , asigna el descuento
	 *
	 */
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	
	/**
	 * un metodo por el que paga con descuento los articulos comprados
	 * @return devuelve un string confirmando el pago "Pagado con un descuento del " + descuento
	 *
	 */
	public String pagar() {
		return "Pagado con un descuento del " + descuento;
	}

}
