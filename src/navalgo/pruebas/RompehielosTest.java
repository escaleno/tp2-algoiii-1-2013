package navalgo.pruebas;

import navalgo.modelo.Barco;
import navalgo.modelo.Direccion;
import navalgo.modelo.DisparoConvencional;
import navalgo.modelo.EstrategiaDireccionDerAbajo;
import navalgo.modelo.GeneradorDireccion;
import navalgo.modelo.GeneradorOrientacion;
import navalgo.modelo.Orientacion;
import navalgo.modelo.OrientacionHorizontal;
import navalgo.modelo.OrientacionVertical;
import navalgo.modelo.PosicionInvalidaException;
import navalgo.modelo.Punto;
import navalgo.modelo.Rompehielos;
import junit.framework.TestCase;

public class RompehielosTest extends TestCase {
	
	private Barco unRompehielosHorizontal;
	private Barco unRompehielosVertical;
	
	Punto posicion32;
	Punto posicion33;
	Punto posicion34;
	Punto posicion42;
	Punto posicion52;
	Punto posicion15Y3;
	
	OrientacionHorizontal orientacionHorizontal;
	OrientacionVertical orientacionVertical;
	
	DisparoConvencional disparoConvencional32;
	DisparoConvencional disparoConvencional33;
	DisparoConvencional disparoConvencional34;
	DisparoConvencional disparoConvencional42;
	DisparoConvencional disparoConvencional52;
	
	int direccionX;
	int direccionY;
	
	protected void setUp() throws Exception {
		super.setUp();
		posicion32 = new Punto(3,2);
		posicion33 = new Punto(3,3);
		posicion34 = new Punto(3,4);
		posicion42 = new Punto(4, 2);
		posicion52 = new Punto(5, 2);
		posicion15Y3 = new Punto(15, 3);
		
		orientacionHorizontal = new OrientacionHorizontal();
		orientacionVertical = new OrientacionVertical();
		
		GeneradorDireccion DerAbajo = new GeneradorDireccion(new EstrategiaDireccionDerAbajo());
		Direccion direccion = DerAbajo.getValue();
		direccionX = direccion.getX();
		direccionY = direccion.getY();
		
		unRompehielosHorizontal = new Rompehielos(posicion32,orientacionHorizontal, direccionX, direccionY);
		unRompehielosVertical = new Rompehielos(posicion32,orientacionVertical, direccionX, direccionY);
		
		disparoConvencional32 = new DisparoConvencional(posicion32);
		disparoConvencional33 = new DisparoConvencional(posicion33);
		disparoConvencional34 = new DisparoConvencional(posicion34);
		disparoConvencional42 = new DisparoConvencional(posicion42);
		disparoConvencional52 = new DisparoConvencional(posicion52);
	}

	public void testSeConstruyeConUnaPosicion(){
		
		assertEquals(posicion32,unRompehielosHorizontal.getPosicion());
		
	}
	
	public void testSeConstruyeEnUnaPosicionInvalida(){
		
		try{
			
			unRompehielosHorizontal = new Rompehielos(posicion15Y3,orientacionHorizontal, direccionX, direccionY);
			
		}
		catch(PosicionInvalidaException e){
			
			assertTrue(true);
			
		}
	}
	
	
	
	public void testAlConstruirseTieneOrientacionHorizontal(){
		
		assertEquals(orientacionHorizontal,unRompehielosHorizontal.getOrientacion());
	}
	
	public void testAlConstruirseTieneTresCasillas(){
		
		assertEquals(3,unRompehielosHorizontal.getCuerpo().size());
	}
			
	public void testAlConstruirseTieneResistencia2(){
		assertEquals(2,unRompehielosHorizontal.getCuerpo().get(0).getResistencia());
	}
		
	public void testAlConstruirseTieneTamanio3(){
		assertEquals(3,unRompehielosHorizontal.getTamanio());
	}
	
	public void testEstaDestruidoSiTieneTodasLasCasillasDestruidas(){
		unRompehielosHorizontal.getCuerpo().get(0).setResistencia(0);
		unRompehielosHorizontal.getCuerpo().get(1).setResistencia(0);
		unRompehielosHorizontal.getCuerpo().get(2).setResistencia(0);
		assertTrue(unRompehielosHorizontal.estaDestruido());
		
	}

	public void testNoEstaDestruidoSiTieneAlgunaCasillaSinDestruirTotalmente(){
		unRompehielosHorizontal.getCuerpo().get(0).setResistencia(0);
		unRompehielosHorizontal.getCuerpo().get(1).setResistencia(2);
		unRompehielosHorizontal.getCuerpo().get(2).setResistencia(0);
		assertFalse(unRompehielosHorizontal.estaDestruido());
		
	}
	
	public void testEstaDestruidoSiRecibeDosDisparosEnCadaCasilla(){
		
		unRompehielosVertical.recibirAtaque(disparoConvencional32);
		unRompehielosVertical.recibirAtaque(disparoConvencional32);
		unRompehielosVertical.recibirAtaque(disparoConvencional33);
		unRompehielosVertical.recibirAtaque(disparoConvencional33);
		unRompehielosVertical.recibirAtaque(disparoConvencional34);
		unRompehielosVertical.recibirAtaque(disparoConvencional34);
		assertTrue(unRompehielosVertical.estaDestruido());
	}
	
	
	public void testNoEstaDestruidoSiNoTieneTodasLasCasillaDestruidas(){
		unRompehielosVertical.recibirAtaque(disparoConvencional33);
		unRompehielosVertical.recibirAtaque(disparoConvencional33);
		unRompehielosVertical.recibirAtaque(disparoConvencional32);
		assertFalse(unRompehielosVertical.estaDestruido());
	}
}
