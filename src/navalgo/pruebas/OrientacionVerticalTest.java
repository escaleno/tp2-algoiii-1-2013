package navalgo.pruebas;

import navalgo.modelo.Barco;
import navalgo.modelo.DisparoConvencional;
import navalgo.modelo.Lancha;
import navalgo.modelo.Orientacion;
import navalgo.modelo.OrientacionVertical;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class OrientacionVerticalTest extends TestCase {
	private Orientacion orientacion;
	private Punto punto;
	protected void setUp() throws Exception {
		super.setUp();
		this.orientacion = new OrientacionVertical();
		this.punto = new Punto(2, 3);
	}
	public void testCaluclarValorX(){
		int x = this.orientacion.calcularUltimaPosicionDelBarcoX(this.punto, 4);
		assertEquals(x,2);
	}
	
	public void testCaluclarValorY(){
		int x = this.orientacion.calcularUltimaPosicionDelBarcoY(this.punto, 4);
		assertEquals(x,7);
	}
	
	public void testImpactoDisparoEnBarco(){
		Barco barco = new Lancha(this.punto, this.orientacion);
		this.orientacion.asimilarImpacto(barco, new Punto(2, 4));
		assertTrue(barco.getCuerpo().get(1).estaDestruida());
	}
	

}
