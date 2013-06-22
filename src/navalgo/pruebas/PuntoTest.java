package navalgo.pruebas;

import navalgo.modelo.*;
import junit.framework.TestCase;

public class PuntoTest extends TestCase {
	public Punto unPunto;
	public Punto otroPunto;
	public Punto unPuntoIgualAOUnPunto;

	protected void setUp() throws Exception {
		super.setUp();
		unPunto = new Punto(5,3);
		otroPunto = new Punto (4,2);
		unPuntoIgualAOUnPunto = new Punto(5, 3);
		
	}
	
	public void testGetX(){
		
		assertEquals(5, unPunto.obtenerX());
	}
	
	public void testGetY(){
		
		assertEquals(3, unPunto.obtenerY());
	}
	
	public void testConstructorConXY(){
		
		assertEquals(5,unPunto.obtenerX());
		assertEquals(3, unPunto.obtenerY());
	}
	
	public void testSetX(){
		
		unPunto.ponerX(10);
		assertEquals(10,unPunto.obtenerX());
	}
	
	public void testSetY(){
		
		unPunto.ponerY(15);
		assertEquals(15,unPunto.obtenerY());
	}
	
	public void testUnPuntoEsIgualAlOtro(){
		assertEquals(unPunto,unPuntoIgualAOUnPunto);
		
	}
	

}
