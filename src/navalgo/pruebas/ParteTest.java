package navalgo.pruebas;

import junit.framework.TestCase;
import navalgo.modelo.*;

public class ParteTest extends TestCase {
	
	private Parte parte;
	protected void setUp() throws Exception {
		super.setUp();
		parte = new Parte(4, new Punto(3, 2), "");
	}
	
	public void  testGetResistencia(){
		assertEquals(4, parte.getResistencia());
	}
	
	public void testGetPosicion(){
		
		assertEquals(new Punto(3, 2),parte.getPosicion());
	}
	
	public void testSeConstruyeConUnaResistenciaYUnaPosicion(){
		
		assertEquals(4, parte.getResistencia());
		assertEquals(new Punto(3, 2),parte.getPosicion());
	}


	public void testNoEstaDestruidoSiTieneResistenciaMayoraCero(){
	assertFalse(parte.estaDestruida());
	}
	
	public void testEstaDestruidaSiTieneResistenciaIgualACero(){
		parte.setResistencia(0);
		assertTrue(parte.estaDestruida());
	}
	
	public void testSeBajaLaResistenciaEnUnoSiRecibeUnDisparoConvencional(){
		parte.asimilarDisparo();
		assertEquals(3,parte.getResistencia());
	}
	
}
