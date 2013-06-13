package navalgo.pruebas;

import navalgo.modelo.Buque;
import navalgo.modelo.Destructor;
import navalgo.modelo.Lancha;
import navalgo.modelo.MinaSubmarinaPorContacto;
import navalgo.modelo.MinaSubmarinaPuntualConRetardo;
import navalgo.modelo.Orientacion;
import navalgo.modelo.OrientacionHorizontal;
import navalgo.modelo.Portaavion;
import navalgo.modelo.Punto;
import navalgo.modelo.Rompehielos;
import junit.framework.TestCase;

public class MinaSubmarinaPuntualConRetardoTest extends TestCase {
	private MinaSubmarinaPuntualConRetardo unaMinaSubmarinaSubmarinaPuntualConRetardo;
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
		unaMinaSubmarinaSubmarinaPuntualConRetardo = new MinaSubmarinaPuntualConRetardo(posicion32);
		orientacionHorizontal = new OrientacionHorizontal();
		unaMinaSubmarinaSubmarinaPuntualConRetardo = new MinaSubmarinaPuntualConRetardo(posicion32);
		unaLancha = new Lancha(posicion32,orientacionHorizontal);
		unBuque = new Buque(posicion32, orientacionHorizontal);
		unDestructor = new Destructor(posicion32, orientacionHorizontal);
		unPortaavion = new Portaavion(posicion32, orientacionHorizontal);
		unRompehielos = new Rompehielos(posicion32, orientacionHorizontal);
	}
	
	public void testAUnaLanchaLeSaca1DeResistencia(){
		unaMinaSubmarinaSubmarinaPuntualConRetardo.setTurnosRestantes(0);
		unaMinaSubmarinaSubmarinaPuntualConRetardo.atacar(unaLancha);
		assertEquals(0,unaLancha.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnBuqueLeSaca1DeResistencia(){
		unaMinaSubmarinaSubmarinaPuntualConRetardo.setTurnosRestantes(0);
		unaMinaSubmarinaSubmarinaPuntualConRetardo.atacar(unBuque);
		assertEquals(0,unBuque.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnDestructorNoLeHaceNada(){
		unaMinaSubmarinaSubmarinaPuntualConRetardo.setTurnosRestantes(0);
		unaMinaSubmarinaSubmarinaPuntualConRetardo.atacar(unDestructor);
		assertEquals(1,unDestructor.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnPortaavionLeSaca1DeResistencia(){
		unaMinaSubmarinaSubmarinaPuntualConRetardo.setTurnosRestantes(0);
		unaMinaSubmarinaSubmarinaPuntualConRetardo.atacar(unPortaavion);
		assertEquals(0,unPortaavion.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnRompehielosLeSaca1DeResistencia(){
		unaMinaSubmarinaSubmarinaPuntualConRetardo.setTurnosRestantes(0);
		unaMinaSubmarinaSubmarinaPuntualConRetardo.atacar(unRompehielos);
		assertEquals(1,unRompehielos.getCuerpo().get(0).getResistencia());
	}

}
