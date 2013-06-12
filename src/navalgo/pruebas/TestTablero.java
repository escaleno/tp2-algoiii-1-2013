package navalgo.pruebas;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import navalgo.modelo.*;


public class TestTablero extends TestCase 
{

		private Tablero alguntablero;
		private Lancha unalancha;
		private Buque unbuque;
		private DisparoConvencional undisparoConvencional;
		private Destructor undestructor;
		private DisparoConvencional otro;
		private DisparoConvencional otroDisparo;
		private DisparoConvencional disparo;
		private Rompehielos unrompehielo;
		private MinaSubmarinaPuntualConRetardo unaminasubmarina;
		
		@Before
		public void setUp() throws Exception 
		{
			super.setUp();
			alguntablero=new Tablero();
			//genero 4 barcos con direcciones
			unrompehielo=new Rompehielos(new Punto(2,1),Orientacion.VERTICAL,0,1);//intento que la direccion sea hacia abajo, aunque el rango es de [1..10,1..10]
			unalancha=new Lancha(new Punto(1,1),Orientacion.HORIZONTAL,1,0);
			unbuque=new Buque(new Punto(1,3),Orientacion.VERTICAL,0,1);
			undestructor=new Destructor(new Punto(1,5),Orientacion.HORIZONTAL,1,0);
			//los inserto en el tablero
			alguntablero.agregarBarco(unalancha);
			alguntablero.agregarBarco(unrompehielo);
			alguntablero.agregarBarco(unbuque);
			alguntablero.agregarBarco(undestructor);
			//genero 5 disparos
			unaminasubmarina=new MinaSubmarinaPuntualConRetardo(new Punto(1,3));	
			undisparoConvencional=new DisparoConvencional(new Punto(1,1));
			otro=new DisparoConvencional(new Punto(1,2));
			otroDisparo=new DisparoConvencional(new Punto(1,5));
			disparo=new DisparoConvencional(new Punto(1,6));
			//los agrego al tablero
			alguntablero.agregarDisparo(unaminasubmarina);
			alguntablero.agregarDisparo(undisparoConvencional);
			alguntablero.agregarDisparo(otro);			
			alguntablero.agregarDisparo(otroDisparo);
			alguntablero.agregarDisparo(disparo);			
		}
		@Test
		public void testCorrectoPosicionamientoDeBarcosInicial()
		{
			assertEquals(alguntablero.getBarcos().get(0),unalancha);
			assertEquals(alguntablero.getBarcos().get(1),unrompehielo);
			assertEquals(alguntablero.getBarcos().get(2),unbuque);
			assertEquals(alguntablero.getBarcos().get(3),undestructor);			
		}
		
		@Test
		public void testCorrectoPosicionamientoDeBarcosLuegoDeEjecutarElTurno()
		{
			alguntablero.ejecutarTurno();			
			assertEquals(alguntablero.getBarcos().get(0),unrompehielo);
			assertEquals(alguntablero.getBarcos().get(1),unbuque);
			assertEquals(alguntablero.getBarcos().get(2),undestructor);	
		}
		
		@Test
		public void testCorrectoConteoDeBarcosLuegoDeDestruirUno()
		{
			alguntablero.ejecutarTurno();
			assertEquals(3,alguntablero.getBarcos().size());
		}
		
		
		@Test
		public void testCorrectoConteoDeDisparosAgregados()
		{
			assertEquals(5,alguntablero.getDisparos().size());
		}
		
		@Test
		public void testCorrectoPosicionamientoDeDisparos()
		{
			
			assertEquals(alguntablero.getDisparos().get(0),unaminasubmarina);
			assertEquals(alguntablero.getDisparos().get(1),undisparoConvencional);
			assertEquals(alguntablero.getDisparos().get(2),otro);
			assertEquals(alguntablero.getDisparos().get(3),otroDisparo);
			assertEquals(alguntablero.getDisparos().get(4),disparo);
		}
		
		@Test
		public void testCorrectaDestruccionDeLancha()
		{
			alguntablero.ejecutarTurno();
			assertTrue(unalancha.estaDestruido());
		}
		@Test
		public void testCorrectoAñadidoDeLanchaaListaDestruidos()
		{
			alguntablero.ejecutarTurno();
			assertEquals(1,alguntablero.getDestruidos().size());
			assertEquals(unalancha,alguntablero.getDestruidos().get(0));
		}
		
		@Test
		public void testNoDestruccionRompehielosX2DisparosDirectos()
		{
			alguntablero.ejecutarTurno();
			assertFalse(undestructor.estaDestruido());
		}
		
		@Test
		public void testDestruccionRompehielosX3DisparosDirectos()
		{
			DisparoConvencional disparofinal=new DisparoConvencional (new Punto (1,7));
			alguntablero.agregarDisparo(disparofinal);
			alguntablero.ejecutarTurno();			
			assertTrue(undestructor.estaDestruido());
		}
		
		@ Test
		public void testCorrectoDesplazamientoDeBarcosNoHundidosLuegoDelTurno()
		{
			alguntablero.ejecutarTurno();
			assertTrue(unrompehielo.getPosicion().getX()==2);
			assertTrue(unrompehielo.getPosicion().getY()==2);
			assertTrue(unbuque.getPosicion().getX()==1);
			assertTrue(unbuque.getPosicion().getY()==4);
			assertTrue(undestructor.getPosicion().getX()==2);
			assertTrue(undestructor.getPosicion().getY()==5);			
		}
		@Test
		public void testNoMovimientoDeBarcosHundidos()
		{
			assertTrue(unalancha.getPosicion().getX()==1);
			assertTrue(unalancha.getPosicion().getY()==1);
		}
		
		@Test
		public void testCorrectoDañoPorBarcosSuperpuestos()
		{
			Destructor destructorSuperpuesto=new Destructor(new Punto(1,5),Orientacion.VERTICAL,0,1);//este destructor se mueve enVertical
			alguntablero.agregarBarco(destructorSuperpuesto);
			alguntablero.ejecutarTurno();			
			assertTrue(undestructor.getCuerpo().get(0).getResistencia()==0);
			assertTrue(destructorSuperpuesto.getCuerpo().get(0).getResistencia()==0);
			assertTrue(destructorSuperpuesto.getCuerpo().get(1).getResistencia()==1);
			assertTrue(destructorSuperpuesto.getCuerpo().get(2).getResistencia()==1);	
		}
}
