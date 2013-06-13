package navalgo.pruebas;

import navalgo.modelo.Barco;
import navalgo.modelo.Lancha;
import navalgo.modelo.Orientacion;
import navalgo.modelo.OrientacionHorizontal;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class OrientacionHorizontalTest extends TestCase {
	private Orientacion orientacion;
	private Punto punto;
	protected void setUp() throws Exception {
		super.setUp();
		this.orientacion = new OrientacionHorizontal();
		this.punto = new Punto(2, 3);
	}
	public void testCaluclarValorX(){
		int x = this.orientacion.calcularFinDePosicionDelBarcoX(this.punto, 4);
		assertEquals(x,6);
	}
	
	public void testCaluclarValorY(){
		int x = this.orientacion.calcularFinDePosicionDelBarcoY(this.punto, 4);
		assertEquals(x,3);
	}
	
	public void testImpactoDisparoEnBarco(){
		Barco barco = new Lancha(this.punto, this.orientacion);
		this.orientacion.asimilarImpacto(barco, new Punto(3, 3));
		assertTrue(barco.getCuerpo().get(1).estaDestruida());
	}

}
