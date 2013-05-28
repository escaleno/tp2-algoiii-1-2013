package navalgo.pruebas;

import navalgo.modelo.Orientacion;
import navalgo.modelo.Punto;
import navalgo.modelo.Rompehielos;
import junit.framework.TestCase;

public class RompehielosTest extends TestCase {
	
	private Rompehielos unRompehielos;
	Punto unaPosicion;
	Orientacion unaOrientacion;

	protected void setUp() throws Exception {
		super.setUp();
		unaPosicion = new Punto(3,2);
		unaOrientacion = new Orientacion("VERTICAL");
		unRompehielos= new Rompehielos(unaPosicion,unaOrientacion);
	}

	public void testSeConstruyeConUnaPosicion(){
		
		assertEquals(unaPosicion,unRompehielos.getPosicion());
		
	}
	
	
	public void testAlConstruirseTieneOrientacionHorizontal(){
		
		assertEquals(unaOrientacion,unRompehielos.getOrientacion());
	}
	
	public void testAlConstruirseTieneTresCasillas(){
		
		assertEquals(3,unRompehielos.getCuerpo().size());
	}
			
	public void testAlConstruirseTieneResistencia2(){
		assertEquals(2,unRompehielos.getCuerpo().get(0).getResistencia());
	}
		
	public void testAlConstruirseTieneTamanio3(){
		assertEquals(3,unRompehielos.getTamanio());
	}
	
	public void testEstaDestruidoSiTieneTodasLasCasillasDestruidas(){
		unRompehielos.getCuerpo().get(0).setResistencia(0);
		unRompehielos.getCuerpo().get(1).setResistencia(0);
		unRompehielos.getCuerpo().get(2).setResistencia(0);
		assertTrue(unRompehielos.estaDestruido());
		
	}

	public void testNoEstaDestruidoSiTieneAlgunaCasillaSinDestruirTotalmente(){
		unRompehielos.getCuerpo().get(0).setResistencia(0);
		unRompehielos.getCuerpo().get(1).setResistencia(2);
		unRompehielos.getCuerpo().get(2).setResistencia(0);
		assertFalse(unRompehielos.estaDestruido());
		
	}
	
}
