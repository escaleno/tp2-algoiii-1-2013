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

	public void asimilarDisparo(Disparo unDisparo) {
		for(Casilla unaCasilla : cuerpo){
			if( (unaCasilla.getPosicion().getX() == unDisparo.getPosicion().getX()) && (unaCasilla.getPosicion().getY() == unDisparo.getPosicion().getY()) ){
				unaCasilla.asimilarDisparo(unDisparo);
				break;
			}
		}
		
		
	}
	

}
