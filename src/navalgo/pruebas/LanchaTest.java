package navalgo.pruebas;

import junit.framework.TestCase;
import navalgo.modelo.*;


public class LanchaTest extends TestCase {
	
	private Lancha unaLancha;
	Punto unaPosicion;
	Orientacion unaOrientacion;

	protected void setUp() throws Exception {
		super.setUp();
		unaPosicion = new Punto(3,2);
		unaOrientacion = new Orientacion("HORIZONTAL");
		unaLancha = new Lancha(unaPosicion,unaOrientacion);
	}
	
	public void testSeConstruyeConUnaPosicion(){
		
		assertEquals(unaPosicion,unaLancha.getPosicion());
	}
	
	public void testAlConstruirseNoEstaDestruido(){
		
		assertEquals(false,unaLancha.getDestruido());
	}
	
	public void testAlConstruirseTieneOrientacionHorizontal(){
		
		assertEquals(unaOrientacion,unaLancha.getOrientacion());
	}
	
	public void testAlConstruirseTieneDosCasillas(){
		
		assertEquals(2,unaLancha.getCuerpo().size());
	}
	
	public void testAlConstruirseTieneResistencia1(){
		assertEquals(1,unaLancha.getCuerpo().get(0).getResistencia());
	}
	
	public void testAlConstruirseTieneTamanio2(){
		assertEquals(2,unaLancha.getTamanio());
	}
	
	public void testEstaDestruidoSiTieneTodasLasCasillasDestruidas(){
		unaLancha.getCuerpo().get(0).setResistencia(0);
		unaLancha.getCuerpo().get(1).setResistencia(0);
		assertTrue(unaLancha.estaDestruido());
		
	}

	public void testNoEstaDestruidoSiTieneAlgunaCasillaSinDestruirTotalmente(){
		unaLancha.getCuerpo().get(0).setResistencia(0);
		unaLancha.getCuerpo().get(0).setResistencia(1);
		assertFalse(unaLancha.estaDestruido());
		
	}
}
