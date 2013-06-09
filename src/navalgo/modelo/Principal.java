package navalgo.modelo;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Orientacion orientacionHorizontal = Orientacion.HORIZONTAL;
		Orientacion orientacionVertical = Orientacion.VERTICAL;
		Punto posicion42 = new Punto(4, 2);
		Punto posicion32 = new Punto(3, 2);
		DisparoConvencional disparoConvencional42 = new DisparoConvencional(posicion42);
		Lancha unaLanchaVertical = new Lancha(posicion32, orientacionVertical); 
		unaLanchaVertical.recibirAtaque(disparoConvencional42);
	}
	
}


