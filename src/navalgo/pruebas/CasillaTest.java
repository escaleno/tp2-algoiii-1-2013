package navalgo.pruebas;

import junit.framework.TestCase;
import navalgo.modelo.*;

public class CasillaTest extends TestCase {
	
	private Casilla unaCasilla;
	private Punto unaPosicion;

	protected void setUp() throws Exception {
		super.setUp();
		unaPosicion = new Punto(2,3);
		unaCasilla = new Casilla(3,unaPosicion);
	}
	
	public void  testGetCasilla(){
		assertEquals(3, unaCasilla.getResistencia());
	}
	
	public void testConstructorDeCasilla(){
		
		assertEquals(3, unaCasilla.getResistencia());
	}
	
	public void testGetPosicion(){
		assertEquals(unaPosicion,unaCasilla.getPosicion());
	}


	public void testNoEstaDestruidoSiTieneResistenciaMayoraCero(){
	assertFalse(unaCasilla.estaDestruida());
	}
	
	public void testEstaDestruidaSiTieneResistenciaIgualACero(){
		unaCasilla.setResistencia(0);
		assertTrue(unaCasilla.estaDestruida());
	}
	
	public void testSeBajaLaResistenciaEnUnoSiRecibeUnDisparoConvencional(){
		Punto unaPosicion = new Punto(4, 3);
		DisparoConvencional unDisparo = new DisparoConvencional(unaPosicion);
		unaCasilla.asimilarDisparo(unDisparo);
		assertEquals(2,unaCasilla.getResistencia());
	}
	
}
