package navalgo.pruebas;

import navalgo.modelo.Destructor;
import navalgo.modelo.Orientacion;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class DestructorTest extends TestCase {

	private Destructor unDestructor;
	Punto unaPosicion;
	Orientacion unaOrientacion;

	protected void setUp() throws Exception {
		super.setUp();
		unaPosicion = new Punto(3,2);
		unaOrientacion = Orientacion.VERTICAL;
		unDestructor = new Destructor(unaPosicion,unaOrientacion);
	}
	
	public void testSeConstruyeConUnaPosicion(){
		
		assertEquals(unaPosicion,unDestructor.getPosicion());
	}
	
	
	public void testAlConstruirseTieneOrientacionHorizontal(){
		
		assertEquals(unaOrientacion,unDestructor.getOrientacion());
	}
	
	public void testAlConstruirseTieneTresCasillas(){
		
		assertEquals(3,unDestructor.getCuerpo().size());
	}
		
	public void testAlConstruirseCadaCasillaTieneResistencia1(){
		assertEquals(1,unDestructor.getCuerpo().get(0).getResistencia());
		assertEquals(1,unDestructor.getCuerpo().get(1).getResistencia());
		assertEquals(1,unDestructor.getCuerpo().get(2).getResistencia());
	}
	
	public void testAlConstruirseTieneTamanio3(){
		assertEquals(3,unDestructor.getTamanio());
	}

	public void testEstaDestruidoSiTieneTodasLasCasillasDestruidas(){
		unDestructor.getCuerpo().get(0).setResistencia(0);
		unDestructor.getCuerpo().get(1).setResistencia(0);
		unDestructor.getCuerpo().get(2).setResistencia(0);
		assertTrue(unDestructor.estaDestruido());
		
	}
	
	public void testNoEstaDestruidoSiTieneAlgunaCasillaSinDestruirTotalmente(){
		unDestructor.getCuerpo().get(0).setResistencia(0);
		unDestructor.getCuerpo().get(1).setResistencia(0);
		unDestructor.getCuerpo().get(2).setResistencia(1);
		assertFalse(unDestructor.estaDestruido());
		
	}

}
