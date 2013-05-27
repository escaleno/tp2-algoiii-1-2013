package navalgo.pruebas;

import navalgo.modelo.*;
import junit.framework.TestCase;

public class PuntoTest extends TestCase {
	public Punto unPunto;
	public Punto otroPunto;

	protected void setUp() throws Exception {
		super.setUp();
		unPunto = new Punto(5,3);
		otroPunto = new Punto (4,2);
		
	}
	
	public void testGetX(){
		
		assertEquals(5, unPunto.getX());
	}
	
	public void testGetY(){
		
		assertEquals(3, unPunto.getY());
	}
	
	public void testConstructorConXY(){
		
		assertEquals(5,unPunto.getX());
		assertEquals(3, unPunto.getY());
	}
	
	public void testSetX(){
		
		unPunto.setX(10);
		assertEquals(10,unPunto.getX());
	}
	
	public void testSetY(){
		
		unPunto.setY(15);
		assertEquals(15,unPunto.getY());
	}
	

}
