package acceso.bd;

import static org.junit.Assert.*;

import productos.y.herencia.Producto;

public class TestBD {

	
	@org.junit.Test
	public void testSelectInsertProducto() {
		
		EscrituraYLecturaBD.insertProducto("mujer", "invierno", "pantalon", 47, "rojo", 12);
		Producto prod = new Producto("mujer", "invierno", "pantalon", 47, "rojo", 12);
		assertEquals(EscrituraYLecturaBD.selectProductoData().get(5).getPrecio(), prod.getPrecio());
		assertEquals(EscrituraYLecturaBD.selectProductoData().get(5).getColor(), prod.getColor());
		
	}
	
	
	@org.junit.Test
	public void testSelectLoginData() {
		
		EscrituraYLecturaBD.insert("admin", "admin", "U");
		assertEquals(EscrituraYLecturaBD.selectLoginData("admin", "admin"), true);
		
	}
	
	@org.junit.Test
	public void testUpdateUsuario() {
		
		EscrituraYLecturaBD.insert("admin", "admin", "U");
		EscrituraYLecturaBD.updateUsuario(1, "hola", "123");
		assertEquals(EscrituraYLecturaBD.selectLoginData("hola", "123"), true);
		
	}
	

}
