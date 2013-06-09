package navalgo.pruebas;

import navalgo.modelo.Buque;
import navalgo.modelo.DisparoConvencional;
import navalgo.modelo.MinaSubmarinaPorContacto;
import navalgo.modelo.Orientacion;
import navalgo.modelo.PosicionInvalidaException;
import navalgo.modelo.Punto;
import navalgo.modelo.Rompehielos;
import junit.framework.TestCase;

public class BuqueTest extends TestCase {
	
	private Buque unBuqueHorizontal;
	private Buque unBuqueVertical;
	
	Punto posicion32;
	Punto posicion33;
	Punto posicion34;
	Punto posicion35;
	Punto posicion42;
	Punto posicion52;
	Punto posicion62;
	Punto posicion20Y12;
	
	Orientacion orientacionHorizontal;
	Orientacion orientacionVertical;
	
	DisparoConvencional disparoConvencional32;
	DisparoConvencional disparoConvencional33;
	DisparoConvencional disparoConvencional34;
	DisparoConvencional disparoConvencional35;
	DisparoConvencional disparoConvencional42;
	DisparoConvencional disparoConvencional52;
	DisparoConvencional disparoConvencional62;
	
	MinaSubmarinaPorContacto minaSubmarinaPorContacto32;
	MinaSubmarinaPorContacto minaSubmarinaPorContacto33;
	

	protected void setUp() throws Exception {
		super.setUp();
		posicion32 = new Punto(3,2);
		posicion33 = new Punto(3,3);
		posicion34 = new Punto(3,3);
		posicion35 = new Punto(3,5);
		posicion42 = new Punto(4, 2);
		posicion52 = new Punto(5, 2);
		posicion62 = new Punto(6, 2);
		posicion20Y12 = new Punto(20, 12);
		
		orientacionHorizontal = Orientacion.HORIZONTAL;
		orientacionVertical = Orientacion.VERTICAL;
		
		unBuqueHorizontal = new Buque(posicion32,orientacionHorizontal);
		unBuqueVertical = new Buque(posicion32,orientacionVertical);
		
		disparoConvencional32 = new DisparoConvencional(posicion32);
		disparoConvencional33 = new DisparoConvencional(posicion33);
		disparoConvencional34 = new DisparoConvencional(posicion34);
		disparoConvencional35 = new DisparoConvencional(posicion35);
		disparoConvencional42 = new DisparoConvencional(posicion42);
		disparoConvencional52 = new DisparoConvencional(posicion52);
		disparoConvencional62 = new DisparoConvencional(posicion62);
		
		minaSubmarinaPorContacto32 = new MinaSubmarinaPorContacto(posicion32);
		minaSubmarinaPorContacto33 = new MinaSubmarinaPorContacto(posicion33);
	}

	public void testSeConstruyeConUnaPosicion(){
		
		assertEquals(posicion32,unBuqueHorizontal.getPosicion());
	}
	
	public void testSeConstruyeEnUnaPosicionInvalida(){
		
		try{
			
			unBuqueHorizontal = new Buque(posicion20Y12,orientacionHorizontal);
			
		}
		catch(PosicionInvalidaException e){
			
			assertTrue(true);
			
		}
	}
	
	
	
	public void testAlConstruirseTieneOrientacionHorizontal(){
		
		assertEquals(orientacionHorizontal,unBuqueHorizontal.getOrientacion());
	}
	
	public void testAlConstruirseTieneCuatroCasillas(){
		
		assertEquals(4,unBuqueHorizontal.getCuerpo().size());
	}
		
	public void testAlConstruirseCadaCasillaTieneResistencia1(){
		assertEquals(1,unBuqueHorizontal.getCuerpo().get(0).getResistencia());
		assertEquals(1,unBuqueHorizontal.getCuerpo().get(1).getResistencia());
		assertEquals(1,unBuqueHorizontal.getCuerpo().get(2).getResistencia());
	}
	
	public void testAlConstruirseTieneTamanio4(){
		assertEquals(4,unBuqueHorizontal.getTamanio());
	}

	public void testAlConstruirseNoEstaDestruido(){
		assertFalse(unBuqueHorizontal.estaDestruido());
	}
	
	public void testEstaDestruidoSiTieneAlgunaCasillaDestruida(){
		unBuqueHorizontal.getCuerpo().get(0).setResistencia(1);
		unBuqueHorizontal.getCuerpo().get(1).setResistencia(1);
		unBuqueHorizontal.getCuerpo().get(2).setResistencia(0);
		unBuqueHorizontal.getCuerpo().get(3).setResistencia(1);
		assertTrue(unBuqueHorizontal.estaDestruido());
		
	}
	
	public void testNoEstaDestruidoSiNoTieneAlgunaCasillaDestruida(){
		unBuqueHorizontal.getCuerpo().get(0).setResistencia(1);
		unBuqueHorizontal.getCuerpo().get(1).setResistencia(1);
		unBuqueHorizontal.getCuerpo().get(2).setResistencia(1);
		unBuqueHorizontal.getCuerpo().get(3).setResistencia(1);
		assertFalse(unBuqueHorizontal.estaDestruido());
		
	}
	
	public void testSiRecibeUnDisparoConvencionalEnCasillaUnoQuedaDestruido(){
		unBuqueHorizontal.recibirAtaque(disparoConvencional35);
		assertTrue(unBuqueHorizontal.estaDestruido());
	}
	
	public void testSiRecibeUnDisparoConvencionalEnCasillaTresQuedaDestruido(){
		unBuqueHorizontal.recibirAtaque(disparoConvencional34);
		assertTrue(unBuqueHorizontal.estaDestruido());
	}
	
	public void testSiRecibeUnaMinaPorContactoQuedaDestruido(){
		unBuqueHorizontal.recibirAtaque(minaSubmarinaPorContacto33);
		assertTrue(unBuqueHorizontal.estaDestruido());
	}
	
	public void testBuqueMoverseVertical(){
		Punto posicion = null;
		Buque Barco = new Buque(
			 new Punto(3,2),
			 Orientacion.VERTICAL,
			 1,1
		 	);
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(4, posicion.getX());
	 	assertEquals(3, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(5, posicion.getX());
	 	assertEquals(4, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(6, posicion.getX());
	 	assertEquals(5, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(7, posicion.getX());
	 	assertEquals(6, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(8, posicion.getX());
	 	assertEquals(5, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(9, posicion.getX());
	 	assertEquals(4, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(10, posicion.getX());
	 	assertEquals(3, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(9, posicion.getX());
	 	assertEquals(2, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(8, posicion.getX());
	 	assertEquals(1, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(7, posicion.getX());
	 	assertEquals(2, posicion.getY());
	}
	
	
	public void testBuqueMoverseHorizontal(){
		Punto posicion = null;
		Buque Barco = new Buque(
			 new Punto(3,2),
			 Orientacion.HORIZONTAL,
			 1,1
		 	);
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(4, posicion.getX());
	 	assertEquals(3, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(5, posicion.getX());
	 	assertEquals(4, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(6, posicion.getX());
	 	assertEquals(5, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(5, posicion.getX());
	 	assertEquals(6, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(4, posicion.getX());
	 	assertEquals(7, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(3, posicion.getX());
	 	assertEquals(8, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(2, posicion.getX());
	 	assertEquals(9, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(1, posicion.getX());
	 	assertEquals(10, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(2, posicion.getX());
	 	assertEquals(9, posicion.getY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(3, posicion.getX());
	 	assertEquals(8, posicion.getY());
	}
	
	

		
		

		

	
}
