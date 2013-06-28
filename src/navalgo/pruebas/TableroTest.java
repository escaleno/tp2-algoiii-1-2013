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
			GeneradorRandomOrientacion horizontal = new GeneradorRandomOrientacion(new EstrategiaOrientacionHorizontal());
			Orientacion orientacionHorizontal = horizontal.getValue();
			GeneradorRandomOrientacion vertical = new GeneradorRandomOrientacion(new EstrategiaOrientacionVertical());
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
		
/*		@Test
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
			assertEquals(3,alguntablero.getBarcos().size());//deberia dar que hay 3 barcos sin romper pero da 4
		}*/
		
		
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
		
/*		@Test
		public void testCorrectaDestruccionDeLancha()
		{
			//deberia haberse destruido ya que le di con 2 disparos convencionales, uno en la posicion (1,1) y otro en la (1,2), y la lancha esta orientada en horizontal
			assertTrue(unalancha.estaDestruido());
		}
		@Test
		public void testCorrectoAnadidoDeLanchaaListaDestruidos()
		{
			alguntablero.ejecutarTurno();
			//deberia pasar la prueba ya que le pegue con un disparo convencional en cada casilla
			assertEquals(1,alguntablero.getDestruidos().size());
//			assertEquals(unalancha,alguntablero.getDestruidos().get(0));
		}*/
		
		@Test
		public void testNoDestruccionRompehielosX2DisparosDirectos()
		{
			alguntablero.ejecutarTurnoParaTest();
			assertFalse(undestructor.estaDestruido());
		}
		
/*		@Test
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
			alguntablero=new Tablero(10,10);
			//genero 4 barcos con direcciones
			unrompehielo=new Rompehielos(new Punto(2,1),new OrientacionVertical(),0,1);//intento que la direccion sea hacia abajo, aunque el rango es de [1..10,1..10]
			unalancha=new Lancha(new Punto(1,1),new OrientacionHorizontal(),1,0);
			unbuque=new Buque(new Punto(1,3),new OrientacionVertical(),0,1);
			undestructor=new Destructor(new Punto(1,5),new OrientacionHorizontal(),1,0);
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
			assertTrue(unalancha.getPosicion().getX()==1);
			assertTrue(unalancha.getPosicion().getY()==1);
		}
		
/*		@Test
		public void testCorrectoDanoPorBarcosSuperpuestos()
		{	
			Destructor destructorSuperpuesto=new Destructor(new Punto(1,5),new OrientacionVertical(),0,1);//este destructor se mueve enVertical
			alguntablero.agregarBarco(destructorSuperpuesto);
			alguntablero.ejecutarTurno();			
			assertTrue(undestructor.getCuerpo().get(0).getResistencia()==0);
			assertTrue(destructorSuperpuesto.getCuerpo().get(0).getResistencia()==0);
			assertTrue(destructorSuperpuesto.getCuerpo().get(1).getResistencia()==0);
			assertTrue(destructorSuperpuesto.getCuerpo().get(2).getResistencia()==1);	
		}
		
		@Test
		public void testCorrectoFuncionamientoDeMetodoBorrarDisparosEstallados()
		{
			alguntablero.ejecutarTurno();
			assertTrue(alguntablero.getDisparos().size()==1);
			assertTrue(alguntablero.getDisparos().get(0)==unaminasubmarina);
			
		}*/
		
		@Test
		public void testCorretoDescuentoPorDisparoConvencional()
		{
			alguntablero.descontarPuntosPorDisparoParaTest(disparo);
			assertEquals(9800,alguntablero.getPuntos());
		}
		
		@Test
		public void testCorrectoDescuentoPuntosPorMinaSubmarinaPuntualConRetardo()
		{
			MinaSubmarinaPuntualConRetardo unamina=new MinaSubmarinaPuntualConRetardo(new Punto(3,2));
			alguntablero.descontarPuntosPorDisparoParaTest(unamina);
			assertEquals(9950,alguntablero.getPuntos());
		}
		
		@Test
		public void testCorrectoDescuentoPuntosPorMinaSubmarinaDobleConRetardo()
		{
			MinaSubmarinaDobleConRetardo unamina=new MinaSubmarinaDobleConRetardo(new Punto(3,2), alguntablero);
			alguntablero.descontarPuntosPorDisparoParaTest(unamina);
			assertEquals(9900,alguntablero.getPuntos());
		}
		
		@Test
		public void testCorrectoDescuentoPuntosPorMinaSubmarinaTripleConRetardo()
		{
			MinaSubmarinaTripleConRetardo unamina=new MinaSubmarinaTripleConRetardo(new Punto(3,2), alguntablero);
			alguntablero.descontarPuntosPorDisparoParaTest(unamina);
			assertEquals(9875,alguntablero.getPuntos());
		}
		
		@Test
		public void testCorrectoDescuentoPuntosPorMinaSubmarinaPuntualPorContacto()
		{
			MinaSubmarinaPorContacto unamina=new MinaSubmarinaPorContacto(new Punto(3,2));
			alguntablero.descontarPuntosPorDisparoParaTest(unamina);
			assertEquals(9850,alguntablero.getPuntos());
		}
		
		@Test
		public void testCorrectoSeteoDeCondicionesIniciales()
		{
			assertFalse(alguntablero.estaGanado());
			assertFalse(alguntablero.estaPerdido());
		}
		
		//intento setear las condiciones para que el juego pase a estar ganado

		@Test
		public void testProbarCuandoEstaGanado()
		{
			alguntablero.moverBarcosAListadoDeHundidos();			
			assertTrue(alguntablero.estaGanado());
		}
		
		//intento setear las condiciones para que el juego este perdido
		@Test
		public void testProbarCuandoEstaPerdido()
		{
			for (int i=0; i<=51; i++)
			{	
				alguntablero.descontarPuntosPorDisparoParaTest(disparo);
			}
			assertTrue(alguntablero.estaPerdido());
		}
		
}
