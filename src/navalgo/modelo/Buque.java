package navalgo.modelo;

import java.util.ArrayList;

public class Buque extends Barco {

	public Buque(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		Casilla casillaAux;
		this.tamanio = 4;
		this.resistencia = 1;
		this.cuerpo = new ArrayList<Casilla>();
		for (int i = 0; i < this.tamanio; i++) {
			casillaAux = new Casilla(this.resistencia);
			this.cuerpo.add(casillaAux);
			}
	}
	
	public boolean estaDestruido(){
		int i = 0;
		boolean sale = false;
		while ( (i < this.cuerpo.size()) && (!sale)) {
			if (this.cuerpo.get(i).estaDestruida()) {
				sale = true;
			}else {
				i++;
			}
		}

		return sale;
	}
	

}
