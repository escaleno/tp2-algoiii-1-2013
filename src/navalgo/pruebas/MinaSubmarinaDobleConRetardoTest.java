package navalgo.pruebas;

import navalgo.modelo.Lancha;
import navalgo.modelo.MinaDeAlcanceSubmarina;
import navalgo.modelo.MinaSubmarinaDobleConRetardo;
import navalgo.modelo.Orientacion;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class MinaSubmarinaDobleConRetardoTest extends TestCase {
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnPosX1Y1;
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnPosX1Y10;
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnX10Y1;
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnX10Y10;
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEn32;
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoENX5Y10;
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnX1Y4;
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnX10Y5;
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnX2Y3;
	MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnElMedio;
	Orientacion orientacionHorizontal;
	Lancha unaLancha;
	Punto posicionX1Y1;
	Punto posicionX1Y10;
	Punto posicionX10Y1;
	Punto posicionX10Y10;
	Punto posicionX5Y10;
	Punto posicionX10Y5;
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
		posicionX5Y10 = new Punto(5, 10);
		posicionX10Y5 = new Punto(10, 5);
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
		unaMinaDobleConRetardoEn32 = new MinaSubmarinaDobleConRetardo(posicion31);
		unaMinaDobleConRetardoENX5Y10 = new MinaSubmarinaDobleConRetardo(posicionX5Y10);
		unaMinaDobleConRetardoEnX1Y4 = new MinaSubmarinaDobleConRetardo(posicion14);
		unaMinaDobleConRetardoEnX10Y5 = new MinaSubmarinaDobleConRetardo(posicionX10Y5);
		unaMinaDobleConRetardoEnX2Y3 = new MinaSubmarinaDobleConRetardo(posicion23);
		unaMinaDobleConRetardoEnElMedio = new MinaSubmarinaDobleConRetardo(posicion23);
		
		
	}
	
	public void testSeCreanLaMinasDeAlcanceSiEstaEnX1Y1(){
		assertEquals(2,unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(1,unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(2, unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(2, unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(1, unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(2, unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().get(2).getPosicion().getY());
	}
	
	public void testSiEstaENX1Y1Tiene3MinasDeAlcance(){
		assertEquals(3,unaMinaDobleConRetardoEnPosX1Y1.getMinasDeAlcance().size());
	}
	
	public void testSeCreanMinasDeAlcanceSiEstaEnX10Y1(){
		assertEquals(10,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(2,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(9,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(2,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(9,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(1,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().get(2).getPosicion().getY());
	}
	
	public void testSiEstaEnX10Y1Tiene3MinasDeAlcance(){
		assertEquals(3,unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance().size());
	}
	
	public void testSeCreanMinasDeAlcanceSiEstaEnX1Y10(){
		assertEquals(1,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(9,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(2,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(9,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(2,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(10,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().get(2).getPosicion().getY());
	}
	
	public void testSiEstaEnX1Y10Tiene3Minas(){
		assertEquals(3,unaMinaDobleConRetardoEnPosX1Y10.getMinasDeAlcance().size());
	}
	
	public void testSeCreanMinasDeAlcanceSiEstaEnX10Y10(){
		assertEquals(9, unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(10, unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(9, unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(9, unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(10, unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(9, unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().get(2).getPosicion().getY());
		
	}
	
	public void testSiEstaEnX10Y10Tiene3Minas(){
		assertEquals(3,unaMinaDobleConRetardoEnX10Y10.getMinasDeAlcance().size());
	}
	
	public void testSeCreanMinasDeAlcanceSiEstaEnElBordeIzquierdoPeroNoEnEsquina(){
		assertEquals(2,unaMinaDobleConRetardoEn32.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(2,unaMinaDobleConRetardoEn32.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(2,unaMinaDobleConRetardoEn32.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(1,unaMinaDobleConRetardoEn32.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(4,unaMinaDobleConRetardoEn32.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(1,unaMinaDobleConRetardoEn32.getMinasDeAlcance().get(2).getPosicion().getY());
		assertEquals(4,unaMinaDobleConRetardoEn32.getMinasDeAlcance().get(3).getPosicion().getX());
		assertEquals(2,unaMinaDobleConRetardoEn32.getMinasDeAlcance().get(3).getPosicion().getY());
		assertEquals(3,unaMinaDobleConRetardoEn32.getMinasDeAlcance().get(4).getPosicion().getX());
		assertEquals(2,unaMinaDobleConRetardoEn32.getMinasDeAlcance().get(4).getPosicion().getY());
	}
	
	public void testSiEstaEnX3Y2Tiene5Minas(){
		assertEquals(5,unaMinaDobleConRetardoEn32.getMinasDeAlcance().size());
	}
	
	public void testSeCreanMinasDeAlcanceSiEstaEnElBordeDerechoPeroNoEnEsquina(){
		assertEquals(4,unaMinaDobleConRetardoENX5Y10.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(10,unaMinaDobleConRetardoENX5Y10.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(4,unaMinaDobleConRetardoENX5Y10.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(9,unaMinaDobleConRetardoENX5Y10.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(5,unaMinaDobleConRetardoENX5Y10.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(9,unaMinaDobleConRetardoENX5Y10.getMinasDeAlcance().get(2).getPosicion().getY());
		assertEquals(6,unaMinaDobleConRetardoENX5Y10.getMinasDeAlcance().get(3).getPosicion().getX());
		assertEquals(9,unaMinaDobleConRetardoENX5Y10.getMinasDeAlcance().get(3).getPosicion().getY());
		assertEquals(6,unaMinaDobleConRetardoENX5Y10.getMinasDeAlcance().get(4).getPosicion().getX());
		assertEquals(10,unaMinaDobleConRetardoENX5Y10.getMinasDeAlcance().get(4).getPosicion().getY());
	}
	
	public void testSiEstaEnElBordeDerechoPeroNoEnEsquinaTiene5Minas(){
		assertEquals(5,unaMinaDobleConRetardoENX5Y10.getMinasDeAlcance().size());
	}
	
	public void testSeCreanMinasDeAlcanceSiEstaEnElBordeSuperiorPeroNoEnEsquinas(){
		assertEquals(1,unaMinaDobleConRetardoEnX1Y4.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(3,unaMinaDobleConRetardoEnX1Y4.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(2,unaMinaDobleConRetardoEnX1Y4.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(3,unaMinaDobleConRetardoEnX1Y4.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(2,unaMinaDobleConRetardoEnX1Y4.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(4,unaMinaDobleConRetardoEnX1Y4.getMinasDeAlcance().get(2).getPosicion().getY());
		assertEquals(2,unaMinaDobleConRetardoEnX1Y4.getMinasDeAlcance().get(3).getPosicion().getX());
		assertEquals(5,unaMinaDobleConRetardoEnX1Y4.getMinasDeAlcance().get(3).getPosicion().getY());
		assertEquals(1,unaMinaDobleConRetardoEnX1Y4.getMinasDeAlcance().get(4).getPosicion().getX());
		assertEquals(5,unaMinaDobleConRetardoEnX1Y4.getMinasDeAlcance().get(4).getPosicion().getY());
	}
	
	public void testSiEstaEnElBordeSuperiosPeroNoEnEsquinaTiene5Minas(){
		assertEquals(5,unaMinaDobleConRetardoEnX1Y4.getMinasDeAlcance().size());
	}
	
	public void testSeCreanMinasDeAlcanceSiEstaEnElBordeInferiorPeroNoEnEsquinas(){
		assertEquals(10,unaMinaDobleConRetardoEnX10Y5.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(6,unaMinaDobleConRetardoEnX10Y5.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(9,unaMinaDobleConRetardoEnX10Y5.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(6,unaMinaDobleConRetardoEnX10Y5.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(9,unaMinaDobleConRetardoEnX10Y5.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(5,unaMinaDobleConRetardoEnX10Y5.getMinasDeAlcance().get(2).getPosicion().getY());
		assertEquals(9,unaMinaDobleConRetardoEnX10Y5.getMinasDeAlcance().get(3).getPosicion().getX());
		assertEquals(4,unaMinaDobleConRetardoEnX10Y5.getMinasDeAlcance().get(3).getPosicion().getY());
		assertEquals(10,unaMinaDobleConRetardoEnX10Y5.getMinasDeAlcance().get(4).getPosicion().getX());
		assertEquals(4,unaMinaDobleConRetardoEnX10Y5.getMinasDeAlcance().get(4).getPosicion().getY());
	}
	
	public void testSiEstaEnElBordeInferiorPeroNoEnEsquinaTiene5Minas(){
		assertEquals(5,unaMinaDobleConRetardoEnX10Y5.getMinasDeAlcance().size());
	}
	
	public void testSeCreanMinasDeAlcanceSiEstaEnElMedio(){
		assertEquals(1,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(0).getPosicion().getX());
		assertEquals(4,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(0).getPosicion().getY());
		assertEquals(1,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(1).getPosicion().getX());
		assertEquals(3,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(1).getPosicion().getY());
		assertEquals(1,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(2).getPosicion().getX());
		assertEquals(2,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(2).getPosicion().getY());
		assertEquals(2,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(3).getPosicion().getX());
		assertEquals(2,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(3).getPosicion().getY());
		assertEquals(3,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(4).getPosicion().getX());
		assertEquals(2,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(4).getPosicion().getY());
		assertEquals(3,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(5).getPosicion().getX());
		assertEquals(3,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(5).getPosicion().getY());
		assertEquals(3,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(6).getPosicion().getX());
		assertEquals(4,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().get(6).getPosicion().getY());
		
	}
	
	public void testSiEstaEnElMedioTiene8Minas(){
		assertEquals(8,unaMinaDobleConRetardoEnElMedio.getMinasDeAlcance().size());
	}
	
	
	public void testSiAtacaUnaLanchaQuedaDestruida(){
		unaMinaDobleConRetardoEnX2Y3.setTurnosRestantes(0);
		unaMinaDobleConRetardoEnX2Y3.atacar(unaLancha);
		for (MinaDeAlcanceSubmarina unaMinaDeAlcance : unaMinaDobleConRetardoEnX2Y3.getMinasDeAlcance() ) {
			unaMinaDeAlcance.atacar(unaLancha);
			
		}
		assertTrue(unaLancha.estaDestruido());
	}
	
	
	
	
	
	
	

}
