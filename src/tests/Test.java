package tests;

import static org.junit.Assert.*;

import acceso.bd.Usuario;
import productos.y.herencia.Producto;
import productos.y.herencia.Tarjeta;
import productos.y.herencia.TarjetaCliente;

public class Test {

	@org.junit.Test
	public void testGetUsuario() {
		
		Usuario u1 = new Usuario("hola", null, false);
		assertEquals(u1.getUsuario(), "hola");
		
	}
	
	@org.junit.Test
	public void testSetUsuario() {
		
		Usuario u1 = new Usuario(null, null, false);
		u1.setUsuario("hola");;
		assertEquals(u1.getUsuario(), "hola");
		
	}
	
	@org.junit.Test
	public void testSetPassword() {
		
		Usuario u1 = new Usuario(null,null, false);
		u1.setPassword("hola");
		assertEquals(u1.getPassword(), "hola");
		
	}
	
	@org.junit.Test
	public void testGetPassword() {
		
		Usuario u1 = new Usuario(null, "hola", false);

		assertEquals(u1.getPassword(), "hola");
		
	}
	
	@org.junit.Test
	public void testIsAdmin() {
		
		Usuario u1 = new Usuario(null, null, true);

		assertEquals(u1.isAdmin(), true);
		
	}
	
	@org.junit.Test
	public void testSetAdmin() {
		
		Usuario u1 = new Usuario(null, null, false);
		u1.setAdmin(true);
		assertEquals(u1.isAdmin(), true);
		
	}
	
	@org.junit.Test
	public void testToString() {
		
		Usuario u1 = new Usuario("hola", "soy julen", false);

		assertEquals(u1.toString(), "hola soy julen");
		
	}
	
	///-------------------------------CLASE PRODUCTO---------------
	 @org.junit.Test
	 public void testGetColor() {
		 Producto p1 = new Producto(null, null, null, 0, "rojo", 0);
		 assertEquals(p1.getColor(), "rojo");
		 
	 }
	 
	 @org.junit.Test
	 public void testSetColor() {
		 Producto p1 = new Producto(null, null, null, 0, null, 0);
		 p1.setColor("rojo");
		 assertEquals(p1.getColor(), "rojo");
		 
	 }
	 
	 @org.junit.Test
	 public void testGetTalla() {
		 Producto p1 = new Producto(null, null, null, 10, null, 0);
		 assertEquals(p1.getTalla(), 10);
		 
	 }
	 
	 @org.junit.Test
	 public void testSetTalla() {
		 Producto p1 = new Producto(null, null, null, 0, null, 0);
		 p1.setTalla(25);
		 assertEquals(p1.getTalla(), 25);
		 
	 }
	 
	 @org.junit.Test
	 public void testGetPrecio() {
		 Producto p1 = new Producto(null, null, null, 0, null, 20);
		 assertEquals(p1.getPrecio(), 20);
		 
	 }
	 
	 @org.junit.Test
	 public void testSetPrecio() {
		 Producto p1 = new Producto(null, null, null, 0, null, 0);
		 p1.setPrecio(25);
		 assertEquals(p1.getPrecio(), 25);
		 
	 }
	 
	 @org.junit.Test
	 public void testGetTipoProducto() {
		 Producto p1 = new Producto("botas", null, null, 0, null, 0);
		 assertEquals(p1.getTipoProducto(), "botas");
		 
	 }
	 
	 @org.junit.Test
	 public void testSetTipoProducto() {
		 Producto p1 = new Producto(null, null, null, 0, null, 0);
		 p1.setTipoProducto("bota");
		 assertEquals(p1.getTipoProducto(), "bota");
		 
	 }
	 
	 @org.junit.Test
	 public void testGetTemporadaDeRopa() {
		 Producto p1 = new Producto(null, "primavera", null, 0, null, 0);
		 assertEquals(p1.getTemporadaDeRopa(), "primavera");
		 
	 }
	 
	 @org.junit.Test
	 public void testSetTemporadaDeRopa() {
		 Producto p1 = new Producto(null, null, null, 0, null, 0);
		 p1.setTemporadaDeRopa("verano");
		 assertEquals(p1.getTemporadaDeRopa(), "verano");
		 
	 }
	 
	 @org.junit.Test
	 public void testGetSexo() {
		 Producto p1 = new Producto(null, null, "hombre", 0, null, 0);
		 assertEquals(p1.getSexo(), "hombre");
		 
	 }
	 
	 @org.junit.Test
	 public void testSetSexo() {
		 Producto p1 = new Producto(null, null, null, 0, null, 0);
		 p1.setSexo("mujer");
		 assertEquals(p1.getSexo(),"mujer");
		 
	 }
	 
	 @org.junit.Test
	 public void testToStringTodo() {
		 Producto p1 = new Producto("hola", "tengo", "como", 10, "euros", 20);
		 assertEquals(p1.toStringTodo(), "hola tengo como 10 euros 20");
		 
	 }
	 
	 @org.junit.Test
	 public void testToStringProductos() {
		 Producto p1 = new Producto(null, null, null, 0, null, 0);
		 assertEquals(p1.toString(220), "220");
		 
	 }

	///-------------------------------CLASE TARJETA---------------
	 
	@org.junit.Test
	public void testPagar() {
		Tarjeta tr = new Tarjeta();
		assertEquals(tr.pagar(), "Pagado sin descuento");
	}
	
	///-------------------------------CLASE TARJETA CLIENTE---------------
	
	@org.junit.Test
	public void testSetDescuento() {
		TarjetaCliente trc = new TarjetaCliente();
		trc.setDescuento("50%");
		assertEquals(trc.getDescuento(), "50%");
	}
	
	@org.junit.Test
	public void testGetDescuento() {
		TarjetaCliente trc = new TarjetaCliente();
		trc.setDescuento("70%");
		assertEquals(trc.getDescuento(), "70%");
	}
	
	@org.junit.Test
	public void testPagar2() {
		TarjetaCliente trc = new TarjetaCliente();
		assertEquals(trc.pagar(), "Pagado con un descuento del 10%");
	}
	
	 
}
