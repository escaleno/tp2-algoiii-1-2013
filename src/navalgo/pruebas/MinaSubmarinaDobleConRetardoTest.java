package navalgo.pruebas;

import navalgo.modelo.Buque;
import navalgo.modelo.MinaSubmarinaDobleConRetardo;
import navalgo.modelo.Orientacion;
import navalgo.modelo.OrientacionHorizontal;
import navalgo.modelo.OrientacionVertical;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class MinaSubmarinaDobleConRetardoTest extends TestCase {
	
	Punto posicionX2Y3;
	Punto posicionX1Y2;
	Punto posicionX1Y3;
	Punto posicionX1Y4;
	Punto posicionX2Y2;
	Punto posicionX2Y4;
	Punto posicionX3Y2;
	Punto posicionX3Y3;
	Punto posicionX3Y4;
	Punto posicionX1Y1;
	Punto posicionX2Y1;
	Punto posicionX4Y2;
	Orientacion unaOrientacionHorizontal;
	Orientacion unaOrientacionVertical;
	MinaSubmarinaDobleConRetardo unaMinaEnX2Y3;
	MinaSubmarinaDobleConRetardo unaMinaEnX1Y3;
	MinaSubmarinaDobleConRetardo unaMinaEnX1Y1;
	MinaSubmarinaDobleConRetardo unaMinaEnX3Y3;
	MinaSubmarinaDobleConRetardo unaMinaEnX4Y2;
	Buque unBuqueEnX3Y2;
	Buque unBuqueVerticalEnX3Y2;
	Buque unBuqueVerticaEnX1Y1;
	

	protected void setUp() throws Exception {
		super.setUp();
		posicionX2Y3 = new Punto(2, 3);
		posicionX1Y2 = new Punto(1, 2);
		posicionX1Y3 = new Punto(1, 3);
		posicionX1Y4 = new Punto(1, 4);
		posicionX2Y2 = new Punto(2, 2);
		posicionX2Y4 = new Punto(2, 4);
		posicionX3Y2 = new Punto(3, 2);
		posicionX3Y3 = new Punto(3, 3);
		posicionX3Y4 = new Punto(3, 4);
		posicionX1Y1 = new Punto(1, 1);
		posicionX2Y1 = new Punto(2, 1);
		posicionX4Y2 = new Punto(4, 2);
		unaOrientacionHorizontal = new OrientacionHorizontal();
		unaOrientacionVertical = new OrientacionVertical();
		unaMinaEnX2Y3 = new MinaSubmarinaDobleConRetardo(posicionX2Y3);
		unaMinaEnX1Y3 = new MinaSubmarinaDobleConRetardo(posicionX1Y3);
		unaMinaEnX1Y1 = new MinaSubmarinaDobleConRetardo(posicionX1Y1);
		unaMinaEnX3Y3 = new MinaSubmarinaDobleConRetardo(posicionX3Y3);
		unaMinaEnX4Y2 = new MinaSubmarinaDobleConRetardo(posicionX4Y2);
		unBuqueEnX3Y2 = new Buque(posicionX3Y2, unaOrientacionHorizontal);
		unBuqueVerticalEnX3Y2 = new Buque(posicionX3Y2, unaOrientacionVertical);
		unBuqueVerticaEnX1Y1 = new Buque(posicionX1Y1, unaOrientacionVertical);
		
	}
	
	public void testCuandoNoSeCreaEnUnBordeTiene8PuntosDeAlcance(){
		assertEquals(8,unaMinaEnX2Y3.getPuntosDeAlcance().size());
	}
	
	public void testSiNoEstaEnElBordeTiene8PuntosDeAlcance(){
		assertEquals(posicionX1Y2,unaMinaEnX2Y3.getPuntosDeAlcance().get(0));
		assertEquals(posicionX1Y3,unaMinaEnX2Y3.getPuntosDeAlcance().get(1));
		assertEquals(posicionX1Y4,unaMinaEnX2Y3.getPuntosDeAlcance().get(2));
		assertEquals(posicionX2Y2,unaMinaEnX2Y3.getPuntosDeAlcance().get(3));
		assertEquals(posicionX2Y4,unaMinaEnX2Y3.getPuntosDeAlcance().get(4));
		assertEquals(posicionX3Y2,unaMinaEnX2Y3.getPuntosDeAlcance().get(5));
		assertEquals(posicionX3Y3,unaMinaEnX2Y3.getPuntosDeAlcance().get(6));
		assertEquals(posicionX3Y4,unaMinaEnX2Y3.getPuntosDeAlcance().get(7));
		
	}
	
	public void testSiEstaEnElBordeSuperiorPeroNoEnUnaEsquinaTiene5PuntosDeAlcance(){
		assertEquals(posicionX1Y2,unaMinaEnX1Y3.getPuntosDeAlcance().get(0));
		assertEquals(posicionX1Y4,unaMinaEnX1Y3.getPuntosDeAlcance().get(1));
		assertEquals(posicionX2Y2,unaMinaEnX1Y3.getPuntosDeAlcance().get(2));
		assertEquals(posicionX2Y3,unaMinaEnX1Y3.getPuntosDeAlcance().get(3));
		assertEquals(posicionX2Y4,unaMinaEnX1Y3.getPuntosDeAlcance().get(4));
	}
	
	public void testSiEstaEnUnaEsquinaTiene3PuntosDeAlcance(){
		assertEquals(posicionX1Y2,unaMinaEnX1Y1.getPuntosDeAlcance().get(0));
		assertEquals(posicionX2Y1,unaMinaEnX1Y1.getPuntosDeAlcance().get(1));
		assertEquals(posicionX2Y2,unaMinaEnX1Y1.getPuntosDeAlcance().get(2));
		
	}
	
	public void testSiHayUnBuqueHorizontalEnPosX3Y2LePegaALasPrimeras3Partes(){
		unaMinaEnX3Y3.setTurnosRestantes(0);
		unaMinaEnX3Y3.atacar(unBuqueEnX3Y2);
		assertTrue(unBuqueEnX3Y2.getCuerpo().get(0).estaDestruida());
		assertTrue(unBuqueEnX3Y2.getCuerpo().get(1).estaDestruida());
		assertFalse(unBuqueEnX3Y2.getCuerpo().get(2).estaDestruida());
		assertFalse(unBuqueEnX3Y2.getCuerpo().get(3).estaDestruida());
		
	}
	
	public void testSiHayUnBuqueVerticalEnPosX3Y2LePegaAlasPrimeras3Partes(){
		unaMinaEnX4Y2.setTurnosRestantes(0);
		unaMinaEnX4Y2.atacar(unBuqueVerticalEnX3Y2);
		assertTrue(unBuqueVerticalEnX3Y2.getCuerpo().get(0).estaDestruida());
		assertTrue(unBuqueVerticalEnX3Y2.getCuerpo().get(1).estaDestruida());
		assertFalse(unBuqueVerticalEnX3Y2.getCuerpo().get(2).estaDestruida());
		assertFalse(unBuqueVerticalEnX3Y2.getCuerpo().get(3).estaDestruida());
		
	}
	
	public void testSiHayUnBuqueHorizontalEnPosX1Y1LePegaEnLas2PrimerasPartes(){
		unaMinaEnX1Y1.setTurnosRestantes(0);
		unaMinaEnX1Y1.atacar(unBuqueVerticaEnX1Y1);
		assertTrue(unBuqueVerticaEnX1Y1.getCuerpo().get(0).estaDestruida());
		assertTrue(unBuqueVerticaEnX1Y1.getCuerpo().get(1).estaDestruida());
		assertFalse(unBuqueVerticaEnX1Y1.getCuerpo().get(2).estaDestruida());
		assertFalse(unBuqueVerticaEnX1Y1.getCuerpo().get(3).estaDestruida());
		
	}

}
