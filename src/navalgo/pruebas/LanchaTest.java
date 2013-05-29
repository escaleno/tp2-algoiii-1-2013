package navalgo.pruebas;

import junit.framework.TestCase;
import navalgo.modelo.*;


public class LanchaTest extends TestCase {
	
	private Lancha unaLancha;
	private Lancha otraLancha;
	Punto unaPosicion;
	Orientacion unaOrientacion;
	Orientacion orientacionVertical;

	protected void setUp() throws Exception {
		super.setUp();
		unaPosicion = new Punto(3,2);
		unaOrientacion = Orientacion.HORIZONTAL;
		orientacionVertical = Orientacion.VERTICAL;
		unaLancha = new Lancha(unaPosicion,unaOrientacion);
		otraLancha = new Lancha(unaPosicion,orientacionVertical);
		
	}
	
	public void testSeConstruyeConUnaPosicion(){
		
		assertEquals(unaPosicion,unaLancha.getPosicion());
	}
	
	
	public void testAlConstruirseTieneOrientacionHorizontal(){
		
		assertEquals(unaOrientacion,unaLancha.getOrientacion());
	}
	
	public void testAlConstruirseTieneDosCasillas(){
		
		assertEquals(2,unaLancha.getCuerpo().size());
	}
	
	public void testAlConstruirseTieneResistencia1(){
		assertEquals(1,unaLancha.getCuerpo().get(0).getResistencia());
	}
	
	public void testAlConstruirseTieneTamanio2(){
		assertEquals(2,unaLancha.getTamanio());
	}
	
	public void testAlConstruirseSeCreaDosCasillaHorizontal(){
		Punto posicionCasillaUno = new Punto(3,2);
		Punto posicionCasillaDos = new Punto(3,3);
		assertEquals(posicionCasillaUno.getX(),unaLancha.getCuerpo().get(0).getPosicion().getX());
		assertEquals(posicionCasillaUno.getY(),unaLancha.getCuerpo().get(0).getPosicion().getY());
		assertEquals(posicionCasillaDos.getX(),unaLancha.getCuerpo().get(1).getPosicion().getX());
		assertEquals(posicionCasillaDos.getY(),unaLancha.getCuerpo().get(1).getPosicion().getY());
		
	}
	
	public void testAlConstruirseSeCreaDosCasillaVertical(){
		Punto posicionCasillaUno = new Punto(3,2);
		Punto posicionCasillaDos = new Punto(4,2);
		assertEquals(posicionCasillaUno.getX(),otraLancha.getCuerpo().get(0).getPosicion().getX());
		assertEquals(posicionCasillaUno.getY(),otraLancha.getCuerpo().get(0).getPosicion().getY());
		assertEquals(posicionCasillaDos.getX(),otraLancha.getCuerpo().get(1).getPosicion().getX());
		assertEquals(posicionCasillaDos.getY(),otraLancha.getCuerpo().get(1).getPosicion().getY());
		
	}
	
	public void testEstaDestruidoSiTieneTodasLasCasillasDestruidas(){
		unaLancha.getCuerpo().get(0).setResistencia(0);
		unaLancha.getCuerpo().get(1).setResistencia(0);
		assertTrue(unaLancha.estaDestruido());
		
	}

	public void testNoEstaDestruidoSiTieneAlgunaCasillaSinDestruirTotalmente(){
		unaLancha.getCuerpo().get(0).setResistencia(0);
		unaLancha.getCuerpo().get(0).setResistencia(1);
		assertFalse(unaLancha.estaDestruido());
		
	}
	
	
	public void testSeBajaEnUnoLaResistenciaDeLaCasillaUnoAlSerAfectadaPorUnDisparoConvencional(){
		DisparoConvencional unDisparo = new DisparoConvencional(unaPosicion);
		unaLancha.asimilarDisparo(unDisparo);
		assertEquals(0,unaLancha.getCuerpo().get(0).getResistencia());
	}
	
	public void testSeBajaEnUnoLaResistenciaDeLaCasillaDosAlSerAfectadaPorUnDisparoConvencional(){
		Punto otraPosicion = new Punto(3,3);
		DisparoConvencional unDisparo = new DisparoConvencional(otraPosicion);
		unaLancha.asimilarDisparo(unDisparo);
		assertEquals(0,unaLancha.getCuerpo().get(1).getResistencia());
	}
	
	public void testSeBajaEnUnoLaResistenciaDeLaCasillaUnoAlSerAfectadaPorUnDisparoConvencionalEnLanchaVertical(){
		DisparoConvencional unDisparo = new DisparoConvencional(unaPosicion);
		otraLancha.asimilarDisparo(unDisparo);
		assertEquals(0,otraLancha.getCuerpo().get(0).getResistencia());
	}
	
	public void testSeBajaEnUnoLaResistenciaDeLaCasillaDosAlSerAfectadaPorUnDisparoConvencionalEnLanchaVertical(){
		Punto otraPosicion = new Punto(4,2);
		DisparoConvencional unDisparo = new DisparoConvencional(otraPosicion);
		otraLancha.asimilarDisparo(unDisparo);
		assertEquals(0,otraLancha.getCuerpo().get(1).getResistencia());
	}
}
