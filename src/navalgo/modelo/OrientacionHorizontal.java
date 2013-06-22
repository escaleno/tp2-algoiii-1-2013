package navalgo.modelo;

public class OrientacionHorizontal implements Orientacion {

	@Override
	public int calcularFinDePosicionDelBarcoX(Punto puntoDeInicioBarco,
			int tamanio) {
		// TODO Auto-generated method stub
		return puntoDeInicioBarco.obtenerX()+tamanio;
	}

	@Override
	public int calcularFinDePosicionDelBarcoY(Punto puntoDeInicioBarco,
			int tamanio) {
		// TODO Auto-generated method stub
		return puntoDeInicioBarco.obtenerY();
	}

	@Override
	public Punto getSiguientePosicion(Punto posicionDeReferencia) {
		
		Punto auxPosicion = new Punto(posicionDeReferencia.obtenerX(), posicionDeReferencia.obtenerY());
		auxPosicion.incrementarEnX();
		return auxPosicion;
	}

}
