package navalgo.pruebas;

import navalgo.modelo.Lancha;
import navalgo.modelo.MinaSubmarinaDobleConRetardo;
import navalgo.modelo.Orientacion;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class MinaSubmarinaDobleConRetardoTest extends TestCase {
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnPosX1Y1;
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnPosX1Y10;
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnX10Y1;
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnX10Y10;
	Orientacion orientacionHorizontal;
	Lancha unaLancha;
	Punto posicionX1Y1;
	Punto posicionX1Y10;
	Punto posicionX10Y1;
	Punto posicionX10Y10;
	Punto posicion23;
	Punto posicion14;
	Punto posicion13;
	Punto posicion12;
	Punto posicion22;
	Punto posicion32;
	Punto posicion33;
	Punto posicion34;
	Punto posicion24;
	Punto posicion31;
	

	protected void setUp() throws Exception {
		super.setUp();
		posicionX1Y1 = new Punto(1, 1);
		posicionX1Y10 = new Punto(1, 10);
		posicionX10Y1 = new Punto(10, 1);
		posicionX10Y10 = new Punto(10, 10);
		posicion23 = new Punto(2, 3);
		posicion14 = new Punto(1, 4);
		posicion13 = new Punto(1, 3);
		posicion12 = new Punto(1, 2);
		posicion22 = new Punto(2, 2);
		posicion32 = new Punto(3, 2);
		posicion33 = new Punto(3, 3);
		posicion34 = new Punto(3, 4);
		posicion24 = new Punto(2, 4);
		posicion31 = new Punto(3, 1);
		orientacionHorizontal = Orientacion.HORIZONTAL;
		unaLancha = new Lancha(posicion23, orientacionHorizontal);
		unaMinaDobleConRetardoEnPosX1Y1 = new MinaSubmarinaDobleConRetardo(posicionX1Y1);
		unaMinaDobleConRetardoEnX10Y1 = new MinaSubmarinaDobleConRetardo(posicionX10Y1);
		unaMinaDobleConRetardoEnPosX1Y10 = new MinaSubmarinaDobleConRetardo(posicionX1Y10);
		unaMinaDobleConRetardoEnX10Y10 = new MinaSubmarinaDobleConRetardo(posicionX10Y10);
	}
	
	public void testSeCreanLaMinasDeAlcanceSiEstaEnX1Y1(){
		assertEquals(2,unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(1,unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(2, unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(2, unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(1, unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(2, unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().get(2).getPosicion().getY());
	}
	
	public void testSeCreanMinasDeAlcanceSiEstaEnX10Y1(){
		assertEquals(10,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(2,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(9,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(2,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(9,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(1,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().get(2).getPosicion().getY());
	}
	
	public void testSeCreanMinasDeAlcanceSiEstaEnX1Y10(){
		assertEquals(1,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(9,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(2,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(9,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(2,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(10,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().get(2).getPosicion().getY());
	}
	
	public void testSeCreanMinasDeAlcanceSiEstaEnX10Y10(){
		assertEquals(9, unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(10, unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(9, unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(9, unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(10, unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(9, unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().get(2).getPosicion().getY());
		
	}
	

	
//	public void testCreaLasMinasDeAlcanceSiEstaEnElBordeIzquierdoPeroNoEnEsquina(){
//		unaMinaDobleConRetardo = new MinaSubmarinaDobleConRetardo(posicion31);
//		assertEquals(2,unaMinaDobleConRetardo.getMinasDeAlcance().get(0).getPosicion().getX());
//		assertEquals(2,unaMinaDobleConRetardo.getMinasDeAlcance().get(0).getPosicion().getY());
//		
//	}
	
	
//	public void testSiAtacaUnaLanchaQuedaDestruida(){
//		unaMinaDobleConRetardo.setTurnosRestantes(0);
//		unaMinaDobleConRetardo.atacar(unaLancha);
//		for (MinaDeAlcanceSubmarina unaMinaDeAlcance : unaMinaDobleConRetardo.getMinasDeAlcance() ) {
//			unaMinaDeAlcance.atacar(unaLancha);
//			
//		}
//		assertTrue(unaLancha.estaDestruido());
//	}
	
	
	
	
	
	
	

}
