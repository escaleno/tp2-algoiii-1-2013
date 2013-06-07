package navalgo.modelo;

import java.util.ArrayList;

public class Rompehielos extends Barco {

	public Rompehielos(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		this.tamanio = 3;
		this.resistencia = 2;
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
	}


	public void recibirAtaque(MinaSubmarinaDobleConRetardo unaMinaSubmarinaDobleConRetardo) {
		if(unaMinaSubmarinaDobleConRetardo.getTurnosRestantes() == 0){
			for(Parte unaCasilla : cuerpo){
				if( (unaCasilla.getPosicion().getX() == unaMinaSubmarinaDobleConRetardo.getPosicion().getX()) && (unaCasilla.getPosicion().getY() == unaMinaSubmarinaDobleConRetardo.getPosicion().getY()) ){
					unaCasilla.asimilarDisparo();
					break;
				}
			}
			
		}
		
	}
}
