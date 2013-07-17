package navalgo.pruebas;

import navalgo.modelo.Barco;
import navalgo.modelo.Buque;
import navalgo.modelo.Direccion;
import navalgo.modelo.DisparoConvencional;
import navalgo.modelo.EstrategiaDireccionDerAbajo;
import navalgo.modelo.GeneradorDireccion;
import navalgo.modelo.GeneradorOrientacion;
import navalgo.modelo.MinaSubmarinaPorContacto;
import navalgo.modelo.Orientacion;
import navalgo.modelo.OrientacionHorizontal;
import navalgo.modelo.OrientacionVertical;
import navalgo.modelo.PosicionInvalidaException;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class BuqueTest extends TestCase {
	
	private Barco unBuqueHorizontal;
	private Barco unBuqueVertical;
	
	Punto posicion32;
	Punto posicion33;
	Punto posicion34;
	Punto posicion35;
	Punto posicion42;
	Punto posicion52;
	Punto posicion62;
	Punto posicion20Y12;
	
	int direccionX;
	int direccionY;
	
	OrientacionHorizontal orientacionHorizontal;
	OrientacionVertical orientacionVertical;
	
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
		
		GeneradorDireccion DerAbajo = new GeneradorDireccion(new EstrategiaDireccionDerAbajo());
		Direccion direccion = DerAbajo.getValue();
		direccionX = direccion.getX();
		direccionY = direccion.getY();
		orientacionHorizontal = new OrientacionHorizontal();
		orientacionVertical = new OrientacionVertical();

		
		unBuqueHorizontal = new Buque(posicion32, orientacionHorizontal, direccionX, direccionY);
		
		unBuqueVertical = new Buque(posicion32,orientacionVertical,direccionX, direccionY);
		
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

			unBuqueHorizontal = new Buque(posicion20Y12, orientacionHorizontal, direccionX, direccionY);
			
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
	
	public void testAlConstruirseUnBuqueVerticalCadaParteTienePosicionCorrecta(){
		
		assertEquals(4, unBuqueVertical.getCuerpo().size());
		assertEquals(new Punto(3, 2),unBuqueVertical.getCuerpo().get(0).getPosicion());
		assertEquals(new Punto(3, 3),unBuqueVertical.getCuerpo().get(1).getPosicion());
		assertEquals(new Punto(3, 4),unBuqueVertical.getCuerpo().get(2).getPosicion());
		assertEquals(new Punto(3, 5),unBuqueVertical.getCuerpo().get(3).getPosicion());

	}
	
	public void testAlConstruirseUnBuqueHorizontalCadaParteTienePosicionCorrecta(){
		
		assertEquals(4, unBuqueHorizontal.getCuerpo().size());
		assertEquals(new Punto(3, 2),unBuqueHorizontal.getCuerpo().get(0).getPosicion());
		assertEquals(new Punto(4, 2),unBuqueHorizontal.getCuerpo().get(1).getPosicion());
		assertEquals(new Punto(5, 2),unBuqueHorizontal.getCuerpo().get(2).getPosicion());
		assertEquals(new Punto(6, 2),unBuqueHorizontal.getCuerpo().get(3).getPosicion());
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
		unBuqueVertical.recibirAtaque(disparoConvencional32);
		assertTrue(unBuqueVertical.estaDestruido());
	}
	
	public void testSiRecibeUnDisparoConvencionalEnCasillaTresQuedaDestruido(){
		unBuqueVertical.recibirAtaque(disparoConvencional34);
		assertTrue(unBuqueVertical.estaDestruido());
	}
	
	public void testSiRecibeUnaMinaPorContactoQuedaDestruido(){
		unBuqueVertical.recibirAtaque(minaSubmarinaPorContacto32);
		assertTrue(unBuqueVertical.estaDestruido());
	}
	
	public void testBuqueMoverseVertical(){
		Punto posicion = null;
		GeneradorDireccion DerAbajo = new GeneradorDireccion(new EstrategiaDireccionDerAbajo());
		Direccion direccion = DerAbajo.getValue();
		Buque Barco = new Buque(
			 new Punto(3,2),
			 orientacionVertical,
			 direccion.getX(),direccion.getY()
		 	);
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(4, posicion.obtenerX());
	 	assertEquals(3, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(5, posicion.obtenerX());
	 	assertEquals(4, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(6, posicion.obtenerX());
	 	assertEquals(5, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(7, posicion.obtenerX());
	 	assertEquals(6, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(8, posicion.obtenerX());
	 	assertEquals(7, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(9, posicion.obtenerX());
	 	assertEquals(6, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(10, posicion.obtenerX());
	 	assertEquals(5, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(9, posicion.obtenerX());
	 	assertEquals(4, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(8, posicion.obtenerX());
	 	assertEquals(3, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(7, posicion.obtenerX());
	 	assertEquals(2, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(6, posicion.obtenerX());
	 	assertEquals(1, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(5, posicion.obtenerX());
	 	assertEquals(2, posicion.obtenerY());
	 	
	}
	
	
	public void testBuqueMoverseHorizontal(){
		Punto posicion = null;
		Buque Barco = new Buque(
			 new Punto(3,2),
			 orientacionHorizontal,
			 1,1
		 	);
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(4, posicion.obtenerX());
	 	assertEquals(3, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(5, posicion.obtenerX());
	 	assertEquals(4, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(6, posicion.obtenerX());
	 	assertEquals(5, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(7, posicion.obtenerX());
	 	assertEquals(6, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(6, posicion.obtenerX());
	 	assertEquals(7, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(5, posicion.obtenerX());
	 	assertEquals(8, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(4, posicion.obtenerX());
	 	assertEquals(9, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(3, posicion.obtenerX());
	 	assertEquals(10, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(2, posicion.obtenerX());
	 	assertEquals(9, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(1, posicion.obtenerX());
	 	assertEquals(8, posicion.obtenerY());
	 	
	 	Barco.mover();
	 	posicion = Barco.getPosicion();
	 	assertEquals(2, posicion.obtenerX());
	 	assertEquals(7, posicion.obtenerY());
	}
//	
//	public void testRandom(){
//		Barco barco = new Buque();
//		
//		System.out.println("Orientacio: " + barco.getOrientacion().name());
//		System.out.println("PosicionX: " + barco.getPosicion().getX() + ", PosicionY: " + barco.getPosicion().getY() );
//		System.out.println("DireccionX: " + barco.getDireccionX() + ", DireccionY: " + barco.getDireccionY() );
//		barco = new Buque();
//		System.out.println("Orientacio: " + barco.getOrientacion().name());
//		System.out.println("PosicionX: " + barco.getPosicion().getX() + ", PosicionY: " + barco.getPosicion().getY() );
//		System.out.println("DireccionX: " + barco.getDireccionX() + ", DireccionY: " + barco.getDireccionY() );
//	}

		
		

		

	
}
