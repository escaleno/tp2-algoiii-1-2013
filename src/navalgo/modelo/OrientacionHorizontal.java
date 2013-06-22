package navalgo.modelo;


public class OrientacionHorizontal extends Orientacion {

	public OrientacionHorizontal() {
		super("Horizontal");
	}
	
	public int calcularFinDePosicionDelBarcoX(Punto puntoDeInicioBarco,
			int tamanio) {
		// TODO Auto-generated method stub
		return puntoDeInicioBarco.obtenerX()+tamanio;
	}

	public int calcularFinDePosicionDelBarcoY(Punto puntoDeInicioBarco,
			int tamanio) {
		// TODO Auto-generated method stub
		return puntoDeInicioBarco.obtenerY();
	}

	public Punto getSiguientePosicion(Punto posicionDeReferencia) {
		
		Punto auxPosicion = new Punto(posicionDeReferencia.obtenerX(), posicionDeReferencia.obtenerY());
		auxPosicion.incrementarEnX();
		return auxPosicion;
	}

}
