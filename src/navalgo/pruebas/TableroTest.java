package navalgo.pruebas;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import navalgo.modelo.*;


public class TableroTest extends TestCase 
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
		public void setUp()
		{
			alguntablero=new Tablero(1,10,1,10);
			//genero 4 barcos con direcciones
			GeneradorOrientacion horizontal = new GeneradorOrientacion(new EstrategiaOrientacionHorizontal());
			Orientacion orientacionHorizontal = horizontal.getValue();
			GeneradorOrientacion vertical = new GeneradorOrientacion(new EstrategiaOrientacionVertical());
			Orientacion orientacionVertical = vertical.getValue();
			unrompehielo=new Rompehielos(new Punto(2,1),orientacionVertical,0,1);//intento que la direccion sea hacia abajo, aunque el rango es de [1..10,1..10]
			unalancha=new Lancha(new Punto(1,1),orientacionHorizontal,1,0);
			unbuque=new Buque(new Punto(1,3),orientacionVertical,0,1);
			undestructor=new Destructor(new Punto(1,5),orientacionHorizontal,1,0);
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
		public void testGetCantidadMinimaDeFilas(){
			assertEquals(1,alguntablero.getInicioDeFilas());
		}
		
		@Test
		public void testGetCantidadMinimaDeColumnas(){
			assertEquals(1, alguntablero.getInicioDeColumnas());
		}
		
		@Test
		public void testCorrectoSeteoDeDimensiones()
		{
			assertEquals(10,alguntablero.getFinDeFilas());
			assertEquals(10,alguntablero.getFinDeColumnas());
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
		public void testObtengoMaximoCantidadDeColumnasYFilas()
		{
			assertEquals(10,alguntablero.obtenerMaximaDeColumnas());
			assertEquals(10,alguntablero.obtenerMaximaDeFilas());
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
		public void testNoDestruccionRompehielosX2DisparosDirectos()
		{
			alguntablero.ejecutarTurno();
			assertFalse(undestructor.estaDestruido());
		}
		
		
		@Test
		public void testCorretoDescuentoPorDisparoConvencional()
		{
			Tablero alguntablero=new Tablero(1,10,1,10);
			alguntablero.agregarBarco(unalancha);
			alguntablero.descontarPuntosPorDisparo(disparo);
			assertEquals(9800,alguntablero.getPuntos());
		}
		
		@Test
		public void testCorrectoDescuentoPuntosPorMinaSubmarinaPuntualConRetardo()
		{
			Tablero alguntablero=new Tablero(1,10,1,10);
			alguntablero.agregarBarco(unalancha);
			MinaSubmarinaPuntualConRetardo unamina=new MinaSubmarinaPuntualConRetardo(new Punto(3,2));
			alguntablero.descontarPuntosPorDisparo(unamina);
			assertEquals(9950,alguntablero.getPuntos());
		}
		
		@Test
		public void testCorrectoDescuentoPuntosPorMinaSubmarinaDobleConRetardo()
		{
			Tablero alguntablero=new Tablero(1,10,1,10);
			alguntablero.agregarBarco(unalancha);
			MinaSubmarinaDobleConRetardo unamina=new MinaSubmarinaDobleConRetardo(new Punto(3,2), alguntablero);
			alguntablero.descontarPuntosPorDisparo(unamina);
			assertEquals(9900,alguntablero.getPuntos());
		}
		
		@Test
		public void testCorrectoDescuentoPuntosPorMinaSubmarinaTripleConRetardo()
		{
			Tablero alguntablero=new Tablero(1,10,1,10);
			alguntablero.agregarBarco(unalancha);
			MinaSubmarinaTripleConRetardo unamina=new MinaSubmarinaTripleConRetardo(new Punto(3,2), alguntablero);
			alguntablero.descontarPuntosPorDisparo(unamina);
			assertEquals(9875,alguntablero.getPuntos());
		}
		
		@Test
		public void testCorrectoDescuentoPuntosPorMinaSubmarinaPuntualPorContacto()
		{
			Tablero alguntablero=new Tablero(1,10,1,10);
			alguntablero.agregarBarco(unalancha);
			MinaSubmarinaPorContacto unamina=new MinaSubmarinaPorContacto(new Punto(3,2));
			alguntablero.descontarPuntosPorDisparo(unamina);
			assertEquals(9850,alguntablero.getPuntos());
		}
		
		@Test
		public void testCorrectoSeteoDeCondicionesIniciales()
		{
			assertFalse(alguntablero.estaGanado());
			assertFalse(alguntablero.estaPerdido());
		}
		

		
		//intento setear las condiciones para que el juego este perdido
		@Test
		public void testProbarCuandoEstaPerdido()
		{
			for (int i=0; i<=51; i++)
			{	
				alguntablero.descontarPuntosPorDisparo(disparo);
			}
			alguntablero.ejecutarTurno();
			assertTrue(alguntablero.estaPerdido());
		}
		
}
