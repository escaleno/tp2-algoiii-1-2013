package navalgo.modelo;

import java.util.ArrayList;

public class Rompehielos extends Barco {

	public Rompehielos(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		Casilla casillaAux;
		this.tamanio = 3;
		this.resistencia = 2;
		this.cuerpo = new ArrayList<Casilla>();
		for (int i = 0; i < this.tamanio; i++) {
			casillaAux = new Casilla(this.resistencia);
			this.cuerpo.add(casillaAux);
			}
	}

}
