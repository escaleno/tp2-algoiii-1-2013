package navalgo.pruebas;

import navalgo.modelo.Barco;
import navalgo.modelo.Destructor;
import navalgo.modelo.Direccion;
import navalgo.modelo.DisparoConvencional;
import navalgo.modelo.EstrategiaDireccionDerAbajo;
import navalgo.modelo.EstrategiaOrientacionHorizontal;
import navalgo.modelo.EstrategiaOrientacionVertical;
import navalgo.modelo.GeneradorDireccion;
import navalgo.modelo.GeneradorOrientacion;
import navalgo.modelo.MinaSubmarinaPorContacto;
import navalgo.modelo.Orientacion;
import navalgo.modelo.PosicionInvalidaException;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class DestructorTest extends TestCase {

	private Barco unDestructorHorizontal;
	
	Punto posicion32;
	Punto posicion33;
	Punto posicion34;
	Punto posicion42;
	Punto posicion52;
	Punto posicion14Y2;
	
	Orientacion orientacionHorizontal;
	Orientacion orientacionVertical;
	
	DisparoConvencional disparoConvencional32;
	DisparoConvencional disparoConvencional33;
	DisparoConvencional disparoConvencional34;
	DisparoConvencional disparoConvencional42;
	DisparoConvencional disparoConvencional52;
	
	int direccionX;
	int direccionY;
	
	MinaSubmarinaPorContacto minaSubmarinaPorContacto32;
	MinaSubmarinaPorContacto minaSubmarinaPorContacto33;
	MinaSubmarinaPorContacto minaSubmarinaPorContacto34;
	
	
	protected void setUp() throws Exception {
		super.setUp();
		posicion32 = new Punto(3,2);
		posicion33 = new Punto(3,3);
		posicion34 = new Punto(3,4);
		posicion42 = new Punto(4,2);
		posicion52 = new Punto(5,2);
		posicion14Y2 = new Punto(14,2);
		
		
		GeneradorOrientacion horizontal = new GeneradorOrientacion(new EstrategiaOrientacionHorizontal());
		orientacionHorizontal = horizontal.getValue();
		GeneradorOrientacion vertical = new GeneradorOrientacion(new EstrategiaOrientacionVertical());
		orientacionVertical = vertical.getValue();
		GeneradorDireccion DerAbajo = new GeneradorDireccion(new EstrategiaDireccionDerAbajo());
		Direccion direccion = DerAbajo.getValue();
		direccionX = direccion.getX();
		direccionY = direccion.getY();
		
		unDestructorHorizontal = new Destructor(posicion32, orientacionHorizontal, direccionX, direccionY);
		
		disparoConvencional32 = new DisparoConvencional(posicion32);
		disparoConvencional33 = new DisparoConvencional(posicion33);
		disparoConvencional34 = new DisparoConvencional(posicion34);
		disparoConvencional42 = new DisparoConvencional(posicion42);
		disparoConvencional52 = new DisparoConvencional(posicion52);
		
		minaSubmarinaPorContacto32 = new MinaSubmarinaPorContacto(posicion32);
		minaSubmarinaPorContacto33 = new MinaSubmarinaPorContacto(posicion33);
		minaSubmarinaPorContacto34 = new MinaSubmarinaPorContacto(posicion34);
	}
	
	public void testSeConstruyeConUnaPosicion(){
		
		assertEquals(posicion32,unDestructorHorizontal.getPosicion());
	}
	
	
	public void testSeConstruyeEnUnaPosicionInvalida(){
		
		try{
			
			unDestructorHorizontal = new Destructor(posicion14Y2,orientacionHorizontal, direccionX, direccionY);
			
		}
		catch(PosicionInvalidaException e){
			
			assertTrue(true);
			
		}
	}
	
	public void testAlConstruirseTieneOrientacionHorizontal(){
		
		assertEquals(orientacionHorizontal,unDestructorHorizontal.getOrientacion());
	}
	
	public void testAlConstruirseTieneTresCasillas(){
		
		assertEquals(3,unDestructorHorizontal.getCuerpo().size());
	}
		
	public void testAlConstruirseCadaCasillaTieneResistencia1(){
		assertEquals(1,unDestructorHorizontal.getCuerpo().get(0).getResistencia());
		assertEquals(1,unDestructorHorizontal.getCuerpo().get(1).getResistencia());
		assertEquals(1,unDestructorHorizontal.getCuerpo().get(2).getResistencia());
	}
	
	public void testAlConstruirseTieneTamanio3(){
		assertEquals(3,unDestructorHorizontal.getTamanio());
	}

	public void testEstaDestruidoSiTieneTodasLasCasillasDestruidas(){
		unDestructorHorizontal.getCuerpo().get(0).setResistencia(0);
		unDestructorHorizontal.getCuerpo().get(1).setResistencia(0);
		unDestructorHorizontal.getCuerpo().get(2).setResistencia(0);
		assertTrue(unDestructorHorizontal.estaDestruido());
		
	}
	
	public void testNoEstaDestruidoSiTieneAlgunaCasillaSinDestruirTotalmente(){
		unDestructorHorizontal.getCuerpo().get(0).setResistencia(0);
		unDestructorHorizontal.getCuerpo().get(1).setResistencia(0);
		unDestructorHorizontal.getCuerpo().get(2).setResistencia(1);
		assertFalse(unDestructorHorizontal.estaDestruido());
		
	}
	
	public void testSiRecibeTresMinaPorContactoNoQuedaDestruido(){
		unDestructorHorizontal.recibirAtaque(minaSubmarinaPorContacto32);
		unDestructorHorizontal.recibirAtaque(minaSubmarinaPorContacto33);
		unDestructorHorizontal.recibirAtaque(minaSubmarinaPorContacto34);
		assertFalse(unDestructorHorizontal.estaDestruido());
		
	}

}
