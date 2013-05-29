package navalgo.modelo;

import java.util.ArrayList;

public class Rompehielos extends Barco {

	public Rompehielos(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		this.tamanio = 3;
		this.resistencia = 2;
		this.cuerpo = new ArrayList<Casilla>();
		this.construirCuerpo();
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
