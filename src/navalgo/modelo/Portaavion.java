package navalgo.modelo;

import java.util.ArrayList;

public class Portaavion extends Barco {

	public Portaavion(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		Casilla casillaAux;
		this.tamanio = 5;
		this.resistencia = 1;
		this.cuerpo = new ArrayList<Casilla>();
		for (int i = 0; i < this.tamanio; i++) {
			casillaAux = new Casilla(this.resistencia);
			this.cuerpo.add(casillaAux);
			}
	}

}
