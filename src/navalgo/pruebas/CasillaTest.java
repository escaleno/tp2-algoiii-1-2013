package navalgo.pruebas;

import junit.framework.TestCase;
import navalgo.modelo.*;

public class CasillaTest extends TestCase {
	
	private Parte unaCasilla;
	protected void setUp() throws Exception {
		super.setUp();
		new Punto(2,3);
		unaCasilla = new Parte(3);
	}
	
	public void  testGetCasilla(){
		assertEquals(3, unaCasilla.getResistencia());
	}
	
	public void testConstructorDeCasilla(){
		
		assertEquals(3, unaCasilla.getResistencia());
	}


	public void testNoEstaDestruidoSiTieneResistenciaMayoraCero(){
	assertFalse(unaCasilla.estaDestruida());
	}
	
	public void testEstaDestruidaSiTieneResistenciaIgualACero(){
		unaCasilla.setResistencia(0);
		assertTrue(unaCasilla.estaDestruida());
	}
	
	public void testSeBajaLaResistenciaEnUnoSiRecibeUnDisparoConvencional(){
		unaCasilla.asimilarDisparo();
		assertEquals(2,unaCasilla.getResistencia());
	}
	
}
