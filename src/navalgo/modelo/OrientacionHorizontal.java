package navalgo.modelo;

public class OrientacionHorizontal implements Orientacion {

	@Override
	public int calcularFinDePosicionDelBarcoX(Punto puntoDeInicioBarco,
			int tamanio) {
		// TODO Auto-generated method stub
		return puntoDeInicioBarco.getX()+tamanio;
	}

	@Override
	public int calcularFinDePosicionDelBarcoY(Punto puntoDeInicioBarco,
			int tamanio) {
		// TODO Auto-generated method stub
		return puntoDeInicioBarco.getY();
	}

	@Override
	public Punto getSiguientePosicion(Punto posicionDeReferencia) {
		
		Punto auxPosicion = new Punto(posicionDeReferencia.getX(), posicionDeReferencia.getY());
		auxPosicion.incrementarEnX();
		return auxPosicion;
	}

}
