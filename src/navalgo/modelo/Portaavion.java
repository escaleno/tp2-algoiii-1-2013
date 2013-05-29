package navalgo.modelo;

import java.util.ArrayList;

public class Portaavion extends Barco {

	public Portaavion(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		this.tamanio = 5;
		this.resistencia = 1;
		this.cuerpo = new ArrayList<Casilla>();
		this.construirCuerpo();
	}

}
