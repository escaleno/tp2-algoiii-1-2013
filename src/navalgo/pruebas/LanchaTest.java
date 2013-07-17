package navalgo.pruebas;

import junit.framework.TestCase;
import navalgo.modelo.*;


public class LanchaTest extends TestCase {
	
	private Barco unaLanchaHorizontal;
	private Barco unaLanchaVertical;
	
	Punto posicion32;
	Punto posicion33;
	Punto posicion34;
	Punto posicion35;
	Punto posicion42;
	Punto posicion52;
	Punto posicion62;
	Punto posicion12Y15;
	
	Orientacion orientacionHorizontal;
	OrientacionVertical orientacionVertical;
	
	DisparoConvencional disparoConvencional32;
	DisparoConvencional disparoConvencional33;
	DisparoConvencional disparoConvencional34;
	DisparoConvencional disparoConvencional35;
	DisparoConvencional disparoConvencional42;
	DisparoConvencional disparoConvencional52;
	DisparoConvencional disparoConvencional62;
	
	int direccionX;
	int direccionY;
	
	MinaSubmarinaPorContacto minaSubmarinaPorContacto32;
	MinaSubmarinaPorContacto minaSubmarinaPorContacto33;

	protected void setUp() throws Exception {
		super.setUp();
		posicion32 = new Punto(3,2);
		posicion33 = new Punto(3,3);
		posicion34 = new Punto(3,4);
		posicion35 = new Punto(3,5);
		posicion42 = new Punto(4, 2);
		posicion52 = new Punto(5, 2);
		posicion62 = new Punto(6, 2);
		posicion12Y15 = new Punto(12, 15);
		
		GeneradorOrientacion horizontal = new GeneradorOrientacion(new EstrategiaOrientacionHorizontal());
		orientacionHorizontal = horizontal.getValue();
		orientacionVertical = new OrientacionVertical();
		
		GeneradorDireccion DerAbajo = new GeneradorDireccion(new EstrategiaDireccionDerAbajo());
		Direccion direccion = DerAbajo.getValue();
		direccionX = direccion.getX();
		direccionY = direccion.getY();
		
		unaLanchaHorizontal = new Lancha(posicion32, orientacionHorizontal, direccionX, direccionY);
		unaLanchaVertical = new Lancha(posicion32, orientacionVertical, direccionX, direccionY);
		
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
		
		assertEquals(posicion32,unaLanchaHorizontal.getPosicion());
	}
	
	
	public void testSeConstruyeEnUnaPosicionInvalida(){
		
		try{
			
			unaLanchaHorizontal = new Lancha(posicion12Y15,orientacionHorizontal, direccionX, direccionY);
			
		}
		catch(PosicionInvalidaException e){
			
			assertTrue(true);
			
		}
	}
	
	
	public void testAlConstruirseTieneOrientacionHorizontal(){
		
		assertEquals(orientacionHorizontal,unaLanchaHorizontal.getOrientacion());
	}
	
	public void testAlConstruirseTieneDosPartes(){
		
		assertEquals(2,unaLanchaHorizontal.getCuerpo().size());
	}
	
	public void testAlConstruirseTieneResistencia1(){
		
		assertEquals(1,unaLanchaHorizontal.getCuerpo().get(0).getResistencia());
		assertEquals(1,unaLanchaHorizontal.getCuerpo().get(1).getResistencia());
	}
	
	public void testAlConstruirseTieneTamanio2(){
		assertEquals(2,unaLanchaHorizontal.getTamanio());
	}
	

	public void testUnaLanchaHorizontalEstaDestruidaSiTieneTodasLasPartesDestruidas(){
		unaLanchaHorizontal.getCuerpo().get(0).setResistencia(0);
		unaLanchaHorizontal.getCuerpo().get(1).setResistencia(0);
		assertTrue(unaLanchaHorizontal.estaDestruido());
		
	}
	
	public void testUnaLanchaVerticalEstaDestruidaSiTieneTodasLasPartesDestruidas(){
		unaLanchaVertical.getCuerpo().get(0).setResistencia(0);
		unaLanchaVertical.getCuerpo().get(1).setResistencia(0);
		assertTrue(unaLanchaVertical.estaDestruido());
		
	}


	public void testNoEstaDestruidoSiTieneAlgunaCasillaSinDestruirTotalmente(){
		unaLanchaHorizontal.getCuerpo().get(0).setResistencia(0);
		unaLanchaHorizontal.getCuerpo().get(0).setResistencia(1);
		assertFalse(unaLanchaHorizontal.estaDestruido());
	}
	
	
	public void testSeBajaEnUnoLaResistenciaDeLaCasillaUnoAlSerAfectadaPorUnDisparoConvencional(){
		unaLanchaVertical.recibirAtaque(disparoConvencional32);
		assertEquals(0,unaLanchaVertical.getCuerpo().get(0).getResistencia());
	}
	
	public void testSeBajaEnUnoLaResistenciaDeLaParteDosAlSerAfectadaPorUnDisparoConvencional(){
		unaLanchaHorizontal.recibirAtaque(disparoConvencional42);
		assertEquals(0,unaLanchaHorizontal.getCuerpo().get(1).getResistencia());
	}
	
	public void testSeBajaEnUnoLaResistenciaDeLaCasillaUnoAlSerAfectadaPorUnDisparoConvencionalEnLanchaHorizontal(){
		unaLanchaHorizontal.recibirAtaque(disparoConvencional32);
		assertEquals(0,unaLanchaHorizontal.getCuerpo().get(0).getResistencia());
	}
	
	public void testSeBajaEnUnoLaResistenciaDeLaCasillaDosAlSerAfectadaPorUnDisparoConvencionalEnLanchaVertical(){
		unaLanchaVertical.recibirAtaque(disparoConvencional33);
		assertEquals(0,unaLanchaVertical.getCuerpo().get(1).getResistencia());
	}
	
	public void testEsDestruidaSiRecibeUnDisparoConvencionalEnCadaCasilla(){
		unaLanchaHorizontal.recibirAtaque(disparoConvencional32);
		unaLanchaHorizontal.recibirAtaque(disparoConvencional42);
		assertTrue(unaLanchaHorizontal.estaDestruido());
		
	}
	
	public void testNoEsDestruidaSiRecibeUnSoloDisparoConvencional(){
		unaLanchaVertical.recibirAtaque(disparoConvencional33);
		assertFalse(unaLanchaVertical.estaDestruido());
		
	}
	
	public void testEsDestruidaSiRecibeUnaMinaSubmarinaPorContactoEnCadaCasilla(){
		unaLanchaVertical.recibirAtaque(minaSubmarinaPorContacto32);
		unaLanchaVertical.recibirAtaque(minaSubmarinaPorContacto33);
		assertTrue(unaLanchaVertical.estaDestruido());
		
	}
}
