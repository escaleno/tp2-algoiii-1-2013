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
	
/*
 * 	public Lancha(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		
		Casilla casillaAux = null;
		Punto posicionAux = null;
		this.tamanio = 2;
		this.resistencia = 1;
		this.cuerpo = new ArrayList<Casilla>();
		for (int i = 0; i < this.tamanio; i++) {
			if(this.orientacion == Orientacion.HORIZONTAL){
				posicionAux = new Punto(this.posicion.getX(),this.posicion.getY() + i);
			}else if(this.orientacion == Orientacion.VERTICAL){
				posicionAux = new Punto(this.posicion.getX() + i,this.posicion.getY());
			}
			casillaAux = new Casilla(this.resistencia,posicionAux);
			this.cuerpo.add(casillaAux);
			}
		
	}
 * 	(non-Javadoc)
 * @see navalgo.modelo.Barco#asimilarDisparo(navalgo.modelo.Disparo)
 */

	
	public void asimilarDisparo(Disparo unDisparo) {
		for(Casilla unaCasilla : cuerpo){
			if( (unaCasilla.getPosicion().getX() == unDisparo.getPosicion().getX()) && (unaCasilla.getPosicion().getY() == unDisparo.getPosicion().getY()) ){
				unaCasilla.asimilarDisparo(unDisparo);
				break;
			}else{
				System.out.println("hola");
			}
		}
		
		
	}

	
}

