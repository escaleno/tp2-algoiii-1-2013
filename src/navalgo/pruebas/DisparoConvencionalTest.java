package navalgo.pruebas;

import navalgo.modelo.Buque;
import navalgo.modelo.Destructor;
import navalgo.modelo.Direccion;
import navalgo.modelo.DisparoConvencional;
import navalgo.modelo.EstrategiaDireccionDerAbajo;
import navalgo.modelo.EstrategiaOrientacionHorizontal;
import navalgo.modelo.GeneradorRandomDireccion;
import navalgo.modelo.GeneradorRandomOrientacion;
import navalgo.modelo.Lancha;
import navalgo.modelo.Orientacion;
import navalgo.modelo.Portaavion;
import navalgo.modelo.Punto;
import navalgo.modelo.Rompehielos;
import junit.framework.TestCase;

public class DisparoConvencionalTest extends TestCase {
	
	private DisparoConvencional unDisparoConvencional;
	private Punto posicion32;
	Orientacion orientacionHorizontal;
	Lancha unaLancha;
	Buque unBuque;
	Destructor unDestructor;
	Portaavion unPortaavion;
	Rompehielos unRompehielos;
	int direccionX;
	int direccionY;
	
	

	protected void setUp() throws Exception {
		super.setUp();
		posicion32 = new Punto(3,2);
		unDisparoConvencional = new DisparoConvencional(posicion32);
		
		GeneradorRandomOrientacion horizontal = new GeneradorRandomOrientacion(new EstrategiaOrientacionHorizontal());
		orientacionHorizontal = horizontal.getValue();
		
		GeneradorRandomDireccion DerAbajo = new GeneradorRandomDireccion(new EstrategiaDireccionDerAbajo());
		Direccion direccion = DerAbajo.getValue();
		direccionX = direccion.getX();
		direccionY = direccion.getY();
		
		unDisparoConvencional = new DisparoConvencional(posicion32);
		unaLancha = new Lancha(posicion32,orientacionHorizontal, direccionX, direccionY);
		unBuque = new Buque(posicion32, orientacionHorizontal, direccionX, direccionY);
		unDestructor = new Destructor(posicion32, orientacionHorizontal, direccionX, direccionY);
		unPortaavion = new Portaavion(posicion32, orientacionHorizontal, direccionX, direccionY);
		unRompehielos = new Rompehielos(posicion32, orientacionHorizontal, direccionX, direccionY);
	}

	public void testGetCosto() {
		assertEquals(200, unDisparoConvencional.getCosto());
	}

	public void testGetPosicion() {
		assertEquals(posicion32,unDisparoConvencional.getPosicion());
	}

	public void testAUnaLanchaLeSaca1DeResistencia(){
		unDisparoConvencional.atacar(unaLancha);
		assertEquals(0,unaLancha.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnBuqueLeSaca1DeResistencia(){
		unDisparoConvencional.atacar(unBuque);
		assertEquals(0,unBuque.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnDestructorLeSaca1DeResistencia(){
		unDisparoConvencional.atacar(unDestructor);
		assertEquals(0,unDestructor.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnPortaavionLeSaca1DeResistencia(){
		unDisparoConvencional.atacar(unPortaavion);
		assertEquals(0,unPortaavion.getCuerpo().get(0).getResistencia());
	}
	
	public void testAUnRompehielosLeSaca1DeResistencia(){
		unDisparoConvencional.atacar(unRompehielos);
		assertEquals(1,unRompehielos.getCuerpo().get(0).getResistencia());
	}
}
