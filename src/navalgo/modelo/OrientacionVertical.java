package navalgo.modelo;

public class OrientacionVertical extends Orientacion {

	public OrientacionVertical() {
		super("Vertical");
	}

	public Punto getSiguientePosicion(Punto posicionDeReferencia) {
		Punto auxPosicion = new Punto(posicionDeReferencia.obtenerX(), posicionDeReferencia.obtenerY());
		auxPosicion.incrementarEnY();
		return auxPosicion;
		
	}

}
