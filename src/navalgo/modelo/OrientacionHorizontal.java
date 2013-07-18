package navalgo.modelo;


public class OrientacionHorizontal extends Orientacion {

	public OrientacionHorizontal() {
		super("Horizontal");
	}

	public Punto getSiguientePosicion(Punto posicionDeReferencia) {
		
		Punto auxPosicion = new Punto(posicionDeReferencia.obtenerX(), posicionDeReferencia.obtenerY());
		auxPosicion.incrementarEnX();
		return auxPosicion;
	}

}
