package navalgo.modelo;

import java.util.ArrayList;

public class Destructor extends Barco {

	public Destructor(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		Casilla casillaAux;
		this.tamanio = 3;
		this.resistencia = 1;
		this.cuerpo = new ArrayList<Casilla>();
		for (int i = 0; i < this.tamanio; i++) {
			casillaAux = new Casilla(this.resistencia);
			this.cuerpo.add(casillaAux);
			}
	}

}
