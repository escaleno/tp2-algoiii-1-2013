package navalgo.pruebas;

import navalgo.modelo.Orientacion;
import navalgo.modelo.Portaavion;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class PortaavionTest extends TestCase {

	private Portaavion unPortaaviones;
	Punto unaPosicion;
	Orientacion unaOrientacion;

	protected void setUp() throws Exception {
		super.setUp();
		unaPosicion = new Punto(3,2);
		unaOrientacion = Orientacion.HORIZONTAL;
		unPortaaviones= new Portaavion(unaPosicion,unaOrientacion);
	}
	
	public void testSeConstruyeConUnaPosicion(){
		
		assertEquals(unaPosicion,unPortaaviones.getPosicion());
		
	}
	

	public void testAlConstruirseTieneOrientacionHorizontal(){
		
		assertEquals(unaOrientacion,unPortaaviones.getOrientacion());
	}
		
	public void testAlConstruirseTieneCincoCasillas(){
		
		assertEquals(5,unPortaaviones.getCuerpo().size());
	}
			
	public void testAlConstruirseTieneResistencia1(){
		assertEquals(1,unPortaaviones.getCuerpo().get(0).getResistencia());
	}
		
	public void testAlConstruirseTieneTamanio5(){
		assertEquals(5,unPortaaviones.getTamanio());
	}

	public void testEstaDestruidoSiTieneTodasLasCasillasDestruidas(){
		unPortaaviones.getCuerpo().get(0).setResistencia(0);
		unPortaaviones.getCuerpo().get(1).setResistencia(0);
		unPortaaviones.getCuerpo().get(2).setResistencia(0);
		unPortaaviones.getCuerpo().get(3).setResistencia(0);
		unPortaaviones.getCuerpo().get(4).setResistencia(0);
		assertTrue(unPortaaviones.estaDestruido());
		
	}

	public void testNoEstaDestruidoSiTieneAlgunaCasillaSinDestruirTotalmente(){
		unPortaaviones.getCuerpo().get(0).setResistencia(0);
		unPortaaviones.getCuerpo().get(1).setResistencia(0);
		unPortaaviones.getCuerpo().get(2).setResistencia(0);
		unPortaaviones.getCuerpo().get(3).setResistencia(1);
		unPortaaviones.getCuerpo().get(4).setResistencia(0);
		assertFalse(unPortaaviones.estaDestruido());
		
	}

}
