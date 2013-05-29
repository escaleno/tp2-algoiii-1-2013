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

	public void asimilarDisparo(Disparo unDisparo) {
		for(Casilla unaCasilla : cuerpo){
			if( (unaCasilla.getPosicion().getX() == unDisparo.getPosicion().getX()) && (unaCasilla.getPosicion().getY() == unDisparo.getPosicion().getY()) ){
				unaCasilla.asimilarDisparo(unDisparo);
				break;
			}
		}
		
		
	}

}
