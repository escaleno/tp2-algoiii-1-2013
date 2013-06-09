package navalgo.pruebas;

import navalgo.modelo.DisparoConvencional;
import navalgo.modelo.Orientacion;
import navalgo.modelo.Portaavion;
import navalgo.modelo.Punto;
import junit.framework.TestCase;

public class PortaavionTest extends TestCase {

	private Portaavion unPortaavionHorizontal;
	private Portaavion unPortaavionVertical;
	Punto posicion32;
	Punto otraPos32;
	Punto posicion33;
	Punto posicion34;
	Punto posicion35;
	Punto posicion36;
	Punto posicion42;
	Punto posicion52;
	Punto posicion62;
	Punto posicion72;
	Orientacion orientacionHorizontal;
	Orientacion orientacionVertical;
	DisparoConvencional disparoConvencional32;
	DisparoConvencional disparoConvencional33;
	DisparoConvencional disparoConvencional34;
	DisparoConvencional disparoConvencional35;
	DisparoConvencional disparoConvencional36;
	DisparoConvencional disparoConvencional42;
	DisparoConvencional disparoConvencional52;
	DisparoConvencional disparoConvencional62;
	DisparoConvencional disparoConvencional72;

	protected void setUp() throws Exception {
		super.setUp();
		posicion32 = new Punto(3,2);
		otraPos32 = new Punto(3, 2);
		posicion33 = new Punto(3,3);
		posicion34 = new Punto(3,4);
		posicion35 = new Punto(3,5);
		posicion36 = new Punto(3,6);
		posicion42 = new Punto(4, 2);
		posicion52 = new Punto(5, 2);
		posicion62 = new Punto(6, 2);
		posicion72 = new Punto(7, 2);
		orientacionHorizontal = Orientacion.HORIZONTAL;
		orientacionVertical = Orientacion.VERTICAL;
		unPortaavionHorizontal = new Portaavion(otraPos32,orientacionHorizontal);
		unPortaavionVertical = new Portaavion(posicion32,orientacionVertical);
		disparoConvencional32 = new DisparoConvencional(posicion32);
		disparoConvencional33 = new DisparoConvencional(posicion33);
		disparoConvencional34 = new DisparoConvencional(posicion34);
		disparoConvencional35 = new DisparoConvencional(posicion35);
		disparoConvencional36 = new DisparoConvencional(posicion36);
		disparoConvencional42 = new DisparoConvencional(posicion42);
		disparoConvencional52 = new DisparoConvencional(posicion52);
		disparoConvencional62 = new DisparoConvencional(posicion62);
		disparoConvencional72 = new DisparoConvencional(posicion72);
	}
	
	public void testSeConstruyeConUnaPosicion(){
		
		assertEquals(posicion32,unPortaavionHorizontal.getPosicion());
	}
	

	public void testAlConstruirseTieneOrientacionHorizontal(){
		
		assertEquals(orientacionHorizontal,unPortaavionHorizontal.getOrientacion());
	}
		
	public void testAlConstruirseTieneCincoCasillas(){
		
		assertEquals(5,unPortaavionHorizontal.getCuerpo().size());
	}
			
	public void testAlConstruirseTieneResistencia1(){
		assertEquals(1,unPortaavionHorizontal.getCuerpo().get(0).getResistencia());
	}
		
	public void testAlConstruirseTieneTamanio5(){
		assertEquals(5,unPortaavionHorizontal.getTamanio());
	}
	
	public void testAlRecibirUnDisparoConvencionalDisminuyeLaResistencia(){
		unPortaavionHorizontal.recibirAtaque(disparoConvencional32);
		unPortaavionHorizontal.recibirAtaque(disparoConvencional33);
		unPortaavionHorizontal.recibirAtaque(disparoConvencional34);
		unPortaavionHorizontal.recibirAtaque(disparoConvencional35);
		unPortaavionHorizontal.recibirAtaque(disparoConvencional36);
		
		assertEquals(0,unPortaavionHorizontal.getCuerpo().get(0).getResistencia());
		assertEquals(0,unPortaavionHorizontal.getCuerpo().get(1).getResistencia());
		assertEquals(0,unPortaavionHorizontal.getCuerpo().get(2).getResistencia());
		assertEquals(0,unPortaavionHorizontal.getCuerpo().get(3).getResistencia());
		assertEquals(0,unPortaavionHorizontal.getCuerpo().get(4).getResistencia());
	}

	public void testEstaDestruidoSiTieneTodasLasCasillasDestruidas(){
		unPortaavionHorizontal.getCuerpo().get(0).setResistencia(0);
		unPortaavionHorizontal.getCuerpo().get(1).setResistencia(0);
		unPortaavionHorizontal.getCuerpo().get(2).setResistencia(0);
		unPortaavionHorizontal.getCuerpo().get(3).setResistencia(0);
		unPortaavionHorizontal.getCuerpo().get(4).setResistencia(0);
		assertTrue(unPortaavionHorizontal.estaDestruido());
		
	}

	public void testNoEstaDestruidoSiTieneAlgunaCasillaSinDestruirTotalmente(){
		unPortaavionHorizontal.getCuerpo().get(0).setResistencia(0);
		unPortaavionHorizontal.getCuerpo().get(1).setResistencia(0);
		unPortaavionHorizontal.getCuerpo().get(2).setResistencia(0);
		unPortaavionHorizontal.getCuerpo().get(3).setResistencia(1);
		unPortaavionHorizontal.getCuerpo().get(4).setResistencia(0);
		assertFalse(unPortaavionHorizontal.estaDestruido());
		
	}
	
	public void testSiTieneAlgunaCasillaSinDestruirNoEstaTotalmenteDestruido(){
		unPortaavionHorizontal.recibirAtaque(disparoConvencional32);
		unPortaavionHorizontal.recibirAtaque(disparoConvencional33);
		unPortaavionHorizontal.recibirAtaque(disparoConvencional34);
		unPortaavionHorizontal.recibirAtaque(disparoConvencional35);
		assertFalse(unPortaavionHorizontal.estaDestruido());
	}
	
	public void testSiTieneTodasLasCasillaDestruidasEstaTotalmenteDestruido(){
		unPortaavionHorizontal.recibirAtaque(disparoConvencional32);
		unPortaavionHorizontal.recibirAtaque(disparoConvencional33);
		unPortaavionHorizontal.recibirAtaque(disparoConvencional34);
		unPortaavionHorizontal.recibirAtaque(disparoConvencional35);
		unPortaavionHorizontal.recibirAtaque(disparoConvencional36);
		assertTrue(unPortaavionHorizontal.estaDestruido());
		
	}
	
	
}
