package navalgo.modelo;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Lancha unaLancha;
		Lancha otraLancha;
		Punto unaPosicion;
		Orientacion unaOrientacion;
		Orientacion orientacionVertical;
		unaPosicion = new Punto(3,2);
		unaOrientacion = Orientacion.HORIZONTAL;
		orientacionVertical = Orientacion.VERTICAL;
		unaLancha = new Lancha(unaPosicion,unaOrientacion);
		otraLancha = new Lancha(unaPosicion,orientacionVertical);
		
		DisparoConvencional unDisparo = new DisparoConvencional(unaPosicion);
		unaLancha.asimilarDisparo(unDisparo);

	}

}
