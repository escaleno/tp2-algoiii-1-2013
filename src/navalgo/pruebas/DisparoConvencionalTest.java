package navalgo.pruebas;

import navalgo.modelo.DisparoConvencional;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class DisparoConvencionalTest extends TestCase {
	
	private DisparoConvencional unDisparoConvencional;
	private Punto unaPosicion;

	protected void setUp() throws Exception {
		super.setUp();
		unaPosicion = new Punto(4, 3);
		unDisparoConvencional = new DisparoConvencional(unaPosicion);
	}

	public void testGetCosto() {
		assertEquals(200, unDisparoConvencional.getCosto());
	}

	public void testGetPosicion() {
		assertEquals(unaPosicion,unDisparoConvencional.getPosicion());
	}

}
