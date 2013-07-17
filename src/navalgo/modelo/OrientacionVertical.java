package navalgo.modelo;

public class OrientacionVertical extends Orientacion {

	public OrientacionVertical() {
		super("Vertical");
	}

	public int calcularFinDePosicionDelBarcoX(Punto puntoDeInicioBarco, 
			int tamanio) {
		// TODO Auto-generated method stub
		return puntoDeInicioBarco.obtenerX();
	}
	
	public int calcularFinDePosicionDelBarcoY(Punto puntoDeInicioBarco, 
			int tamanio){
		// TODO Auto-generated method stub
		return (puntoDeInicioBarco.obtenerY()+tamanio);
	}


	public Punto getSiguientePosicion(Punto posicionDeReferencia) {
		Punto auxPosicion = new Punto(posicionDeReferencia.obtenerX(), posicionDeReferencia.obtenerY());
		auxPosicion.incrementarEnY();
		return auxPosicion;
		
	}

}
