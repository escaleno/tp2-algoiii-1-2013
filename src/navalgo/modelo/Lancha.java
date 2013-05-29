package navalgo.modelo;

import java.util.ArrayList;

public class Lancha extends Barco {

	public Lancha(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		
		this.tamanio = 2;
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

