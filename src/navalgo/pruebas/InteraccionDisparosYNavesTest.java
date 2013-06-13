package navalgo.pruebas;

//import java.util.ArrayList;
//
//import navalgo.modelo.Barco;
//import navalgo.modelo.Buque;
//import navalgo.modelo.Disparo;
//import navalgo.modelo.Lancha;
//import navalgo.modelo.MinaSubmarinaDobleConRetardo;
//import navalgo.modelo.Orientacion;
//import navalgo.modelo.Punto;
//
//import junit.framework.TestCase;

//public class InteraccionDisparosYNavesTest extends TestCase {
//	private ArrayList<Disparo> listaDeDisparos;
//	private ArrayList<Barco> listaDeBarcos;
//	private Punto posicionX3Y3;
//	private Punto posicionX8Y2;
//	private Punto posicionX7Y3;
//	private Lancha unaLanchaEnX8Y2;
//	private Buque  unBuqueEnX2Y3;
//	private Orientacion orientacionHorizontal;
//	private Orientacion orientacionVertical;
//	private MinaSubmarinaDobleConRetardo unaMinaDobleConRetardo;
//	
//	
//	
//	
//
//	protected void setUp() throws Exception {
//		super.setUp();
//		listaDeDisparos = new ArrayList<Disparo>();
//		listaDeBarcos = new ArrayList<Barco>();
//		posicionX3Y3 = new Punto(3, 3);
//		posicionX8Y2 = new Punto(8, 2);
//		posicionX7Y3 = new Punto(7, 3);
//		orientacionHorizontal = Orientacion.HORIZONTAL;
//		orientacionVertical = Orientacion.VERTICAL;
//		unaLanchaEnX8Y2 = new Lancha(posicionX8Y2, orientacionHorizontal);
//		unBuqueEnX2Y3 = new Buque(posicionX3Y3, orientacionVertical);
//		
//	}
	
//	public void testSiPlantoMinaSubmarinaConDobleRetardoEnX7Y3DestruyeElBuquePeroNoLaLancha(){
//		unaMinaDobleConRetardo = new MinaSubmarinaDobleConRetardo(posicionX7Y3);
//		unaMinaDobleConRetardo.setTurnosRestantes(0);
//		listaDeBarcos.add(unaLanchaEnX8Y2);
//		listaDeBarcos.add(unBuqueEnX2Y3);
//		for (Barco unBarco : listaDeBarcos){
//			for (MinaDeAlcanceSubmarina unaMinaDeAlcance : unaMinaDobleConRetardo.getMinasDeAlcance()) {
//				unaMinaDobleConRetardo.atacar(unBarco);
//				unaMinaDeAlcance.atacar(unBarco);
//			}
//		}
//
//		assertTrue(unaLanchaEnX8Y2.estaDestruido());
//		assertTrue(unBuqueEnX2Y3.estaDestruido());
//	}
//	
	
	

//}
