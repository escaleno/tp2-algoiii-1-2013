package navalgo.pruebas;

import navalgo.modelo.Buque;
import navalgo.modelo.Orientacion;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class BuqueTest extends TestCase {
	
	private Buque unBuque;
	Punto unaPosicion;
	Orientacion unaOrientacion;

	protected void setUp() throws Exception {
		super.setUp();
		unaPosicion = new Punto(3,2);
		unaOrientacion = new Orientacion("HORIZONTAL");
		unBuque = new Buque(unaPosicion,unaOrientacion);
	}

	public void testSeConstruyeConUnaPosicion(){
		
		assertEquals(unaPosicion,unBuque.getPosicion());
	}
	

	public void testAlConstruirseTieneOrientacionHorizontal(){
		
		assertEquals(unaOrientacion,unBuque.getOrientacion());
	}
	
	public void testAlConstruirseTieneCuatroCasillas(){
		
		assertEquals(4,unBuque.getCuerpo().size());
	}
		
	public void testAlConstruirseCadaCasillaTieneResistencia1(){
		assertEquals(1,unBuque.getCuerpo().get(0).getResistencia());
		assertEquals(1,unBuque.getCuerpo().get(1).getResistencia());
		assertEquals(1,unBuque.getCuerpo().get(2).getResistencia());
	}
	
	public void testAlConstruirseTieneTamanio4(){
		assertEquals(4,unBuque.getTamanio());
	}

	public void testEstaDestruidoSiTieneAlgunaCasillaDestruida(){
		unBuque.getCuerpo().get(0).setResistencia(1);
		unBuque.getCuerpo().get(1).setResistencia(1);
		unBuque.getCuerpo().get(2).setResistencia(0);
		unBuque.getCuerpo().get(3).setResistencia(1);
		assertTrue(unBuque.estaDestruido());
		
	}
	
	public void testNoEstaDestruidoSiNoTieneAlgunaCasillaDestruida(){
		unBuque.getCuerpo().get(0).setResistencia(1);
		unBuque.getCuerpo().get(1).setResistencia(1);
		unBuque.getCuerpo().get(2).setResistencia(1);
		unBuque.getCuerpo().get(3).setResistencia(1);
		assertFalse(unBuque.estaDestruido());
		
	}
		
		

		

	
}
