package navalgo.pruebas;

import junit.framework.TestCase;
import navalgo.modelo.*;

public class OrientacionTest extends TestCase {
	
	private Orientacion unaOrientacion;

	protected void setUp() throws Exception {
		super.setUp();
		unaOrientacion = new Orientacion("HORIZONTAL");
	}
	
	public void testGetOrientacion(){
		
		assertEquals("HORIZONTAL",unaOrientacion.getOrientacion());
	}
	
	public void testSeConstruyeConTipoHorizontal(){
		
		assertEquals("HORIZONTAL", unaOrientacion.getOrientacion());
	}

}
