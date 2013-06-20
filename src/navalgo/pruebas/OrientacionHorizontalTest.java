package navalgo.pruebas;

import navalgo.modelo.Orientacion;
import navalgo.modelo.OrientacionHorizontal;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class OrientacionHorizontalTest extends TestCase {
	private Orientacion orientacion;
	private Punto punto;
	int direccionX = 1;
	int direccionY = 1;
	protected void setUp() throws Exception {
		super.setUp();
		this.orientacion = new OrientacionHorizontal();
		this.punto = new Punto(2, 3);
	}
	public void testCaluclarValorX(){
		int x = this.orientacion.calcularFinDePosicionDelBarcoX(this.punto, 4);
		assertEquals(x,6);
	}
	
	public void testCalcularValorY(){
		int x = this.orientacion.calcularFinDePosicionDelBarcoY(this.punto, 4);
		assertEquals(x,3);
	}
	
	public void testRetornaSiguientePosicion(){
		
		assertEquals(new Punto(1, 2), orientacion.getSiguientePosicion(new Punto(1, 1)));
	}

}
