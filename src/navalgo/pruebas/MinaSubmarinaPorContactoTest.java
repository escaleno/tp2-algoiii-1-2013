package navalgo.pruebas;

import navalgo.modelo.Buque;
import navalgo.modelo.Destructor;
import navalgo.modelo.Lancha;
import navalgo.modelo.MinaSubmarinaPorContacto;
import navalgo.modelo.Orientacion;
import navalgo.modelo.OrientacionHorizontal;
import navalgo.modelo.Portaavion;
import navalgo.modelo.Punto;
import navalgo.modelo.Rompehielos;
import junit.framework.TestCase;

public class MinaSubmarinaPorContactoTest extends TestCase {
	private MinaSubmarinaPorContacto unaMinaSubmarinaPorContacto;
	private Punto posicion32;
	Orientacion orientacionHorizontal;
	Lancha unaLancha;
	Buque unBuque;
	Destructor unDestructor;
	Portaavion unPortaavion;
	Rompehielos unRompehielos;

	protected void setUp() throws Exception {
		super.setUp();
		posicion32 = new Punto(3,2);
		unaMinaSubmarinaPorContacto = new MinaSubmarinaPorContacto(posicion32);
		orientacionHorizontal = new OrientacionHorizontal();
		unaMinaSubmarinaPorContacto = new MinaSubmarinaPorContacto(posicion32);
		unaLancha = new Lancha(posicion32,orientacionHorizontal);
		unBuque = new Buque(posicion32, orientacionHorizontal);
		unDestructor = new Destructor(posicion32, orientacionHorizontal);
		unPortaavion = new Portaavion(posicion32, orientacionHorizontal);
		unRompehielos = new Rompehielos(posicion32, orientacionHorizontal);
	}

	public void testGetCosto(){
		assertEquals(150, unaMinaSubmarinaPorContacto.getCosto());
		
	}
	
	public void testGetPosicion(){
		assertEquals(posicion32,unaMinaSubmarinaPorContacto.getPosicion());
	}
	
	public void testAUnaLanchaLeSaca1DeResistencia(){
		unaMinaSubmarinaPorContacto.atacar(unaLancha);
		assertEquals(0,unaLancha.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnBuqueLeSaca1DeResistencia(){
		unaMinaSubmarinaPorContacto.atacar(unBuque);
		assertEquals(0,unBuque.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnDestructorNoLeHaceNada(){
		unaMinaSubmarinaPorContacto.atacar(unDestructor);
		assertEquals(1,unDestructor.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnPortaavionLeSaca1DeResistencia(){
		unaMinaSubmarinaPorContacto.atacar(unPortaavion);
		assertEquals(0,unPortaavion.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnRompehielosLeSaca1DeResistencia(){
		unaMinaSubmarinaPorContacto.atacar(unRompehielos);
		assertEquals(1,unRompehielos.getCuerpo().get(0).getResistencia());
	}
}
