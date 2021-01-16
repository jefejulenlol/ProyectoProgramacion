package productos.y.herencia;

/**
 * 
 * @author Julen
 *@version final
 */

public class Producto implements IObligatorioEnElProducto{
	
	private String color;
	private int talla;
	private int precio;
	private String tipoProducto;
	private String temporadaDeRopa;
	private String sexo;
	
	/**
	 * El constructor de la clase
	 * @param tipoProducto es el tipo de producto (zapatos...)
	 * @param temporadaDeRopa es la temporada del anyo en la que se usa la prenda
	 * @param sexo es el sexo empleado en la ropa
	 * @param talla , la talla del producto
	 * @param color , el color de la prenda
	 * @param precio , su precio
	 *
	 */
	public Producto(String tipoProducto,String temporadaDeRopa,String sexo, int talla, String color, int precio) {
		this.color = color;
		this.talla = talla;
		this.precio = precio;
		this.tipoProducto = tipoProducto;
		this.temporadaDeRopa = temporadaDeRopa;
		this.sexo = sexo;
	}
	/**
	 * getter de color
	 * @return color , devuelve el color
	 *
	 */
	public String getColor() {
		return color;
	}
	/**
	 * setter del color
	 * @param color , el color del que quieres que sea la prenda.
	 *
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * getter de la talla
	 * @return talla , devuelve la talla de la prenda
	 *
	 */
	public int getTalla() {
		return talla;
	}
	/**
	 * setter de la talla
	 * @param talla , la talla que tendra la prenda.
	 * 
	 */
	public void setTalla(int talla) {
		this.talla = talla;
	}
	/**
	 * getter del precio
	 * @return precio , devuelve el precio de la prenda
	 *
	 */
	public int getPrecio() {
		return precio;
	}
	/**
	 * setter del precio
	 * @param precio , el precio que tendra la prenda.
	 *
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	/**
	 * getter del tipo de producto
	 * @return tipoProducto , devuelve el tipo de producto de la prenda
	 *
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}
	/**
	 * setter del tipo de producto
	 * @param tipoProducto , el tipo de producto que tendra el objeto/prenda
	 *
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	/**
	 * getter de la temporada de ropa
	 * @return temporadaDeRopa , devuelve la temporada de la ropa de la prenda
	 *
	 */
	public String getTemporadaDeRopa() {
		return temporadaDeRopa;
	}
	/**
	 * setter de la temporada de la ropa
	 * @param temporadaDeRopa , la temporada del anyo de la ropa
	 *
	 */
	public void setTemporadaDeRopa(String temporadaDeRopa) {
		this.temporadaDeRopa = temporadaDeRopa;
	}
	/**
	 * setter del sexo
	 * @return sexo , devuelve el sexo para el que se ha confeccionado la ropa en un principio
	 *
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * setter de sexo
	 * @param sexo , el sexo de la ropa
	 *
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * Hace un string concatenando el tipodeproducto,temporadaderopa,sexo,talla,color y precio
	 * @return string un string concatenado de todas las variables privadas.
	 *
	 */
	public String toStringTodo() {
		
		String string = "";
		
		return string + tipoProducto + " " + temporadaDeRopa + " " + sexo + " " + talla + " " + color + " " + precio;
	}
	/**
	 * convierte el int talla en un string
	 * @param talla , el int talla a convertir en un string
	 * @return string , la talla convertida en string
	 *
	 */
	public String toString(int talla) {
		
		String string = "";
		
		return string + talla;
	}
	
	
	
	
}
