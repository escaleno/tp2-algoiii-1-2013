package navalgo.modelo;

import java.util.ArrayList;



public class Lancha extends Barco {

	public Lancha(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		
		Casilla casillaAux;
		this.tamanio = 2;
		this.resistencia = 1;
		this.cuerpo = new ArrayList<Casilla>();
		for (int i = 0; i < this.tamanio; i++) {
			casillaAux = new Casilla(this.resistencia);
			this.cuerpo.add(casillaAux);
			}
	}

	



};

