package navalgo.pruebas;

import navalgo.modelo.Orientacion;
import navalgo.modelo.OrientacionVertical;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class OrientacionVerticalTest extends TestCase {
	private Orientacion orientacion;
	private Punto punto;
	int direccionX = 1;
	int direccionY = 1;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.orientacion = new OrientacionVertical();
		this.punto = new Punto(2, 3);
	}
	
	
	public void testRetornaLaSiguientePosicion(){
		
		assertEquals(new Punto(3, 3), orientacion.getSiguientePosicion(new Punto(3, 2)));
	}
	

}
