package navalgo.pruebas;

import navalgo.modelo.Buque;
import navalgo.modelo.Direccion;
import navalgo.modelo.EstrategiaDireccionDerAbajo;
import navalgo.modelo.EstrategiaOrientacionHorizontal;
import navalgo.modelo.EstrategiaOrientacionVertical;
import navalgo.modelo.GeneradorDireccion;
import navalgo.modelo.GeneradorOrientacion;
import navalgo.modelo.Lancha;
import navalgo.modelo.MinaSubmarinaTripleConRetardo;
import navalgo.modelo.Orientacion;
import navalgo.modelo.Punto;
import navalgo.modelo.Tablero;
import junit.framework.TestCase;

public class MinaSubmarinaTripleConRetardoTest extends TestCase {
	
	Punto posX1Y1;
	Punto posX1Y2;
	Punto posX1Y3;
	Punto posX1Y4;
	Punto posX1Y5;
	Punto posX1Y6;
	Punto posX1Y7;
	Punto posX2Y1;
	Punto posX2Y2;
	Punto posX2Y3;
	Punto posX2Y4;
	Punto posX2Y5;
	Punto posX2Y6;
	Punto posX2Y7;
	Punto posX3Y1;
	Punto posX3Y2;
	Punto posX3Y3;
	Punto posX3Y4;
	Punto posX3Y5;
	Punto posX3Y6;
	Punto posX3Y7;
	Punto posX4Y2;
	Punto posX4Y3;
	Punto posX4Y4;
	Punto posX4Y5;
	Punto posX4Y6;
	Punto posX5Y2;
	Punto posX5Y3;
	Punto posX5Y4;
	Punto posX5Y5;
	Punto posX5Y6;
	Punto posX6Y2;
	Punto posX6Y3;
	Punto posX6Y4;
	Punto posX6Y5;
	Punto posX6Y6;
	Orientacion orientacionVertical;
	Orientacion orientacionHorizontal;
	MinaSubmarinaTripleConRetardo unaMinaEnX5Y5;
	MinaSubmarinaTripleConRetardo unaMinaEnX1Y1;
	MinaSubmarinaTripleConRetardo unaMinaEnX4Y4;
	MinaSubmarinaTripleConRetardo unaMinaEnX1Y5;
	MinaSubmarinaTripleConRetardo unaMinaEnX4Y5;
	Lancha unaLanchaHorizontalEnPosX1Y4;
	Lancha unaLanchaVerticalEnPosX4Y4;
	Buque unBuqueVerticalEnPosX3Y5;
	int direccionX;
	int direccionY;
	Tablero tablero;

	protected void setUp() throws Exception {
		super.setUp();
		posX5Y5 = new Punto(5, 5);
		posX1Y1 = new Punto(1, 1);
		posX1Y2 = new Punto(1, 2);
		posX1Y3 = new Punto(1, 3);
		posX1Y4 = new Punto(1, 4);
		posX1Y5 = new Punto(1, 5);
		posX1Y6 = new Punto(1, 6);
		posX1Y7 = new Punto(1, 7);
		posX2Y1 = new Punto(2, 1);
		posX2Y2 = new Punto(2, 2);
		posX2Y3 = new Punto(2, 3);
		posX2Y4 = new Punto(2, 4);
		posX2Y5 = new Punto(2, 5);
		posX2Y6 = new Punto(2, 6);
		posX2Y7 = new Punto(2, 7);
		posX3Y1 = new Punto(3, 1);
		posX3Y2 = new Punto(3, 2);
		posX3Y3 = new Punto(3, 3);
		posX3Y4 = new Punto(3, 4);
		posX3Y5 = new Punto(3, 5);
		posX3Y6 = new Punto(3, 6);
		posX3Y7 = new Punto(3, 7);
		posX4Y2 = new Punto(4, 2);
		posX4Y3 = new Punto(4, 3);
		posX4Y4 = new Punto(4, 4);
		posX4Y5 = new Punto(4, 5);
		posX4Y6 = new Punto(4, 6);
		posX5Y2 = new Punto(5, 2);
		posX5Y3 = new Punto(5, 3);
		posX5Y4 = new Punto(5, 4);
		posX5Y5 = new Punto(5, 5);
		posX5Y6 = new Punto(5, 6);
		posX6Y2 = new Punto(6, 2);
		posX6Y3 = new Punto(6, 3);
		posX6Y4 = new Punto(6, 4);
		posX6Y5 = new Punto(6, 5);
		posX6Y6 = new Punto(6, 6);
		GeneradorOrientacion horizontal = new GeneradorOrientacion(new EstrategiaOrientacionHorizontal());
		orientacionHorizontal = horizontal.getValue();
		GeneradorOrientacion vertical = new GeneradorOrientacion(new EstrategiaOrientacionVertical());
		orientacionVertical = vertical.getValue();
		
		GeneradorDireccion DerAbajo = new GeneradorDireccion(new EstrategiaDireccionDerAbajo());
		Direccion direccion = DerAbajo.getValue();
		direccionX = direccion.getX();
		direccionY = direccion.getY();
		
		tablero = new Tablero(1, 10, 1, 10);
		
		
		unaMinaEnX5Y5 = new MinaSubmarinaTripleConRetardo(posX5Y5, tablero);
		unaMinaEnX1Y1 = new MinaSubmarinaTripleConRetardo(posX1Y1, tablero);
		unaMinaEnX4Y4 = new MinaSubmarinaTripleConRetardo(posX4Y4, tablero);
		unaMinaEnX1Y5 = new MinaSubmarinaTripleConRetardo(posX1Y5, tablero);
		unaMinaEnX4Y5 = new MinaSubmarinaTripleConRetardo(posX4Y5, tablero);
		unaLanchaVerticalEnPosX4Y4 = new Lancha(posX4Y4, orientacionVertical, direccionX, direccionY);
		unaLanchaHorizontalEnPosX1Y4 = new Lancha(posX1Y4, orientacionHorizontal, direccionX, direccionY);
		unBuqueVerticalEnPosX3Y5 = new Buque(posX3Y5, orientacionVertical, direccionX, direccionY);
		
	}
	
	public void testCuandoNoEstaEnUnBordeDeTableroTiene24PuntosDealcance(){
		assertEquals(24,unaMinaEnX4Y4.getPuntosDeAlcance().size());
		assertEquals(posX2Y2,unaMinaEnX4Y4.getPuntosDeAlcance().get(0));
		assertEquals(posX2Y3,unaMinaEnX4Y4.getPuntosDeAlcance().get(1));
		assertEquals(posX2Y4,unaMinaEnX4Y4.getPuntosDeAlcance().get(2));
		assertEquals(posX2Y5,unaMinaEnX4Y4.getPuntosDeAlcance().get(3));
		assertEquals(posX2Y6,unaMinaEnX4Y4.getPuntosDeAlcance().get(4));
		assertEquals(posX3Y2,unaMinaEnX4Y4.getPuntosDeAlcance().get(5));
		assertEquals(posX3Y3,unaMinaEnX4Y4.getPuntosDeAlcance().get(6));
		assertEquals(posX3Y4,unaMinaEnX4Y4.getPuntosDeAlcance().get(7));
		assertEquals(posX3Y5,unaMinaEnX4Y4.getPuntosDeAlcance().get(8));
		assertEquals(posX3Y6,unaMinaEnX4Y4.getPuntosDeAlcance().get(9));
		assertEquals(posX4Y2,unaMinaEnX4Y4.getPuntosDeAlcance().get(10));
		assertEquals(posX4Y3,unaMinaEnX4Y4.getPuntosDeAlcance().get(11));
		assertEquals(posX4Y5,unaMinaEnX4Y4.getPuntosDeAlcance().get(12));
		assertEquals(posX4Y6,unaMinaEnX4Y4.getPuntosDeAlcance().get(13));
		assertEquals(posX5Y2,unaMinaEnX4Y4.getPuntosDeAlcance().get(14));
		assertEquals(posX5Y3,unaMinaEnX4Y4.getPuntosDeAlcance().get(15));
		assertEquals(posX5Y4,unaMinaEnX4Y4.getPuntosDeAlcance().get(16));
		assertEquals(posX5Y5,unaMinaEnX4Y4.getPuntosDeAlcance().get(17));
		assertEquals(posX5Y6,unaMinaEnX4Y4.getPuntosDeAlcance().get(18));
		assertEquals(posX6Y2,unaMinaEnX4Y4.getPuntosDeAlcance().get(19));
		assertEquals(posX6Y3,unaMinaEnX4Y4.getPuntosDeAlcance().get(20));
		assertEquals(posX6Y4,unaMinaEnX4Y4.getPuntosDeAlcance().get(21));
		assertEquals(posX6Y5,unaMinaEnX4Y4.getPuntosDeAlcance().get(22));
		assertEquals(posX6Y6,unaMinaEnX4Y4.getPuntosDeAlcance().get(23));
	}
	
	public void testCuandoEstaEnLaEsquinaTiene8PuntosDeAlcance(){
		assertEquals(8,unaMinaEnX1Y1.getPuntosDeAlcance().size());
		assertEquals(posX1Y2, unaMinaEnX1Y1.getPuntosDeAlcance().get(0));
		assertEquals(posX1Y3,unaMinaEnX1Y1.getPuntosDeAlcance().get(1));
		assertEquals(posX2Y1,unaMinaEnX1Y1.getPuntosDeAlcance().get(2));
		assertEquals(posX2Y2,unaMinaEnX1Y1.getPuntosDeAlcance().get(3));
		assertEquals(posX2Y3,unaMinaEnX1Y1.getPuntosDeAlcance().get(4));
		assertEquals(posX3Y1,unaMinaEnX1Y1.getPuntosDeAlcance().get(5));
		assertEquals(posX3Y2,unaMinaEnX1Y1.getPuntosDeAlcance().get(6));
		assertEquals(posX3Y3,unaMinaEnX1Y1.getPuntosDeAlcance().get(7));
	}
	
	public void testCuandoEstaEnElBordeSuperiorPeroNoEnEsquinaTiene14PuntosDeAlcance(){
		assertEquals(14,unaMinaEnX1Y5.getPuntosDeAlcance().size());
		assertEquals(posX1Y3,unaMinaEnX1Y5.getPuntosDeAlcance().get(0));
		assertEquals(posX1Y4,unaMinaEnX1Y5.getPuntosDeAlcance().get(1));
		assertEquals(posX1Y6,unaMinaEnX1Y5.getPuntosDeAlcance().get(2));
		assertEquals(posX1Y7,unaMinaEnX1Y5.getPuntosDeAlcance().get(3));
		assertEquals(posX2Y3,unaMinaEnX1Y5.getPuntosDeAlcance().get(4));
		assertEquals(posX2Y4,unaMinaEnX1Y5.getPuntosDeAlcance().get(5));
		assertEquals(posX2Y5,unaMinaEnX1Y5.getPuntosDeAlcance().get(6));
		assertEquals(posX2Y6,unaMinaEnX1Y5.getPuntosDeAlcance().get(7));
		assertEquals(posX2Y7,unaMinaEnX1Y5.getPuntosDeAlcance().get(8));
		assertEquals(posX3Y3,unaMinaEnX1Y5.getPuntosDeAlcance().get(9));
		assertEquals(posX3Y4,unaMinaEnX1Y5.getPuntosDeAlcance().get(10));
		assertEquals(posX3Y5,unaMinaEnX1Y5.getPuntosDeAlcance().get(11));
		assertEquals(posX3Y6,unaMinaEnX1Y5.getPuntosDeAlcance().get(12));
		assertEquals(posX3Y7,unaMinaEnX1Y5.getPuntosDeAlcance().get(13));
		
	}
	
	public void testSiHayLanchaEnX1Y4YEnPosX4Y4YUnBuqueEnPosX3Y5DestruyeElBuqueYLaSegundaLancha(){
		unaMinaEnX4Y5.setTurnosRestantes(0);
		unaMinaEnX4Y5.atacar(unaLanchaVerticalEnPosX4Y4);
		unaMinaEnX4Y5.atacar(unaLanchaHorizontalEnPosX1Y4);
		unaMinaEnX4Y5.atacar(unBuqueVerticalEnPosX3Y5);
		assertTrue(unaLanchaVerticalEnPosX4Y4.estaDestruido());
		assertTrue(unBuqueVerticalEnPosX3Y5.estaDestruido());
		assertFalse(unaLanchaHorizontalEnPosX1Y4.estaDestruido());
		assertFalse(unaLanchaHorizontalEnPosX1Y4.getCuerpo().get(0).estaDestruida());
		assertTrue(unaLanchaHorizontalEnPosX1Y4.getCuerpo().get(1).estaDestruida());
	}
}
