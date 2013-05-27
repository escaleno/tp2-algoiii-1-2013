package navalgo.pruebas;

import junit.framework.TestCase;
import navalgo.modelo.*;

public class CasillaTest extends TestCase {
	
	private Casilla unaCasilla;

	protected void setUp() throws Exception {
		super.setUp();
		unaCasilla = new Casilla(3);
	}
	
	public void  testGetCasilla(){
		assertEquals(3, unaCasilla.getResistencia());
	}
	
	public void testConstructorDeCasilla(){
		
		assertEquals(3, unaCasilla.getResistencia());
	}

	public void testSetResistencia(){
		
		unaCasilla.setResistencia(10);
		assertEquals(10, unaCasilla.getResistencia());
	}
	
	public void testNoEstaDestruidoSiTieneResistenciaMayoraCero(){
		assertFalse(unaCasilla.estaDestruida());
	}
	
	public void testEstaDestruidaSiTieneResistenciaIgualACero(){
		unaCasilla.setResistencia(0);
		assertTrue(unaCasilla.estaDestruida());
	}
	
}
