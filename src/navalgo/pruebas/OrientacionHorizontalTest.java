package navalgo.pruebas;

import java.util.ArrayList;

import navalgo.modelo.Orientacion;
import navalgo.modelo.OrientacionHorizontal;
import navalgo.modelo.Parte;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class OrientacionHorizontalTest extends TestCase {
	private Orientacion orientacion;
	int direccionX = 1;
	int direccionY = 1;
	protected void setUp() throws Exception {
		super.setUp();
		this.orientacion = new OrientacionHorizontal();
	}
	
	public void testRetornaSiguientePosicion(){
		ArrayList<Parte> partes = this.orientacion.getPartes(2, 1, "test", new Punto(2, 1));
		
		assertEquals(2, partes.size());
		
		assertEquals(new Punto(2, 1), partes.get(0).getPosicion());
		assertEquals(new Punto(3, 1), partes.get(1).getPosicion());
		
		assertEquals("testHorizontal1", partes.get(0).getNomber());
		assertEquals("testHorizontal2", partes.get(1).getNomber());
		
		assertEquals(1, partes.get(0).getResistencia());
		assertEquals(1, partes.get(1).getResistencia());
		
	}

}
