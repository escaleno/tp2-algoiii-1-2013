package navalgo.modelo;

import java.util.ArrayList;

public class Buque extends Barco {

	public Buque(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		this.tamanio = 4;
		this.resistencia = 1;
		this.cuerpo = new ArrayList<Casilla>();
		this.construirCuerpo();
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

	@Override
	public void asimilarDisparo(Disparo unDisparo) {
		// TODO Auto-generated method stub
		
	}
	

}
