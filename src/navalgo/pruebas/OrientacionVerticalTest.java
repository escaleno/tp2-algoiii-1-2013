package navalgo.pruebas;

import java.util.ArrayList;

import navalgo.modelo.Orientacion;
import navalgo.modelo.OrientacionVertical;
import navalgo.modelo.Parte;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class OrientacionVerticalTest extends TestCase {
	private Orientacion orientacion;
	int direccionX = 1;
	int direccionY = 1;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.orientacion = new OrientacionVertical();
	}
	
	
	public void testRetornaLaSiguientePosicion(){
		
ArrayList<Parte> partes = this.orientacion.getPartes(2, 1, "test", new Punto(2, 1));
		
		assertEquals(2, partes.size());
		
		assertEquals(new Punto(2, 1), partes.get(0).getPosicion());
		assertEquals(new Punto(2, 2), partes.get(1).getPosicion());
		
		assertEquals("testVertical1", partes.get(0).getNomber());
		assertEquals("testVertical2", partes.get(1).getNomber());
		
		assertEquals(1, partes.get(0).getResistencia());
		assertEquals(1, partes.get(1).getResistencia());
	}
	

}
