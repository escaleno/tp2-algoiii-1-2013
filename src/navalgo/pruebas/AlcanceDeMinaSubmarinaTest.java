package navalgo.pruebas;

import navalgo.modelo.MinaDeAlcanceSubmarina;
import navalgo.modelo.Buque;
import navalgo.modelo.Destructor;
import navalgo.modelo.Lancha;
import navalgo.modelo.MinaSubmarinaPorContacto;
import navalgo.modelo.Orientacion;
import navalgo.modelo.Portaavion;
import navalgo.modelo.Punto;
import navalgo.modelo.Rompehielos;
import junit.framework.TestCase;

public class AlcanceDeMinaSubmarinaTest extends TestCase {
	private MinaDeAlcanceSubmarina minaDeAlcanceSubmarina;
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
		minaDeAlcanceSubmarina = new MinaDeAlcanceSubmarina(posicion32);
		orientacionHorizontal = Orientacion.HORIZONTAL;
		minaDeAlcanceSubmarina = new MinaDeAlcanceSubmarina(posicion32);
		unaLancha = new Lancha(posicion32,orientacionHorizontal);
		unBuque = new Buque(posicion32, orientacionHorizontal);
		unDestructor = new Destructor(posicion32, orientacionHorizontal);
		unPortaavion = new Portaavion(posicion32, orientacionHorizontal);
		unRompehielos = new Rompehielos(posicion32, orientacionHorizontal);
	}
	
	public void testAUnaLanchaLeSaca1DeResistencia(){
		minaDeAlcanceSubmarina.atacar(unaLancha);
		assertEquals(0,unaLancha.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnBuqueLeSaca1DeResistencia(){
		minaDeAlcanceSubmarina.atacar(unBuque);
		assertEquals(0,unBuque.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnDestructorNoLeHaceNada(){
		minaDeAlcanceSubmarina.atacar(unDestructor);
		assertEquals(1,unDestructor.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnPortaavionLeSaca1DeResistencia(){
		minaDeAlcanceSubmarina.atacar(unPortaavion);
		assertEquals(0,unPortaavion.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnRompehielosLeSaca1DeResistencia(){
		minaDeAlcanceSubmarina.atacar(unRompehielos);
		assertEquals(1,unRompehielos.getCuerpo().get(0).getResistencia());
	}


}
