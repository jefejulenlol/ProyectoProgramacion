package productos.y.herencia;

/**
 * 
 * @author Julen
 *@version final
 */

public interface IObligatorioEnElProducto {
		
	int getTalla();
	String getColor();
	int getPrecio();
	String getTipoProducto();
	String getTemporadaDeRopa();
	String getSexo();
	
	void setTalla(int x);
	void setColor(String x);
	void setPrecio(int x);
	void setTipoProducto(String x);
	void setTemporadaDeRopa(String x);
	void setSexo(String x);

}
