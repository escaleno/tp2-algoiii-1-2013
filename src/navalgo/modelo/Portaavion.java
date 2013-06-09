package navalgo.modelo;

import java.util.ArrayList;

public class Portaavion extends Barco {

	public Portaavion(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		this.tamanio = 5;
		this.resistencia = 1;
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
	}

	
//	public void recibirAtaque(MinaSubmarinaDobleConRetardo unaMinaSubmarinaDobleConRetardo) {
//		if(unaMinaSubmarinaDobleConRetardo.getTurnosRestantes() == 0){
//			for(Parte unaCasilla : cuerpo){
//				if( (unaCasilla.getPosicion().getX() == unaMinaSubmarinaDobleConRetardo.getPosicion().getX()) && (unaCasilla.getPosicion().getY() == unaMinaSubmarinaDobleConRetardo.getPosicion().getY()) ){
//					unaCasilla.asimilarDisparo();
//					break;
//				}
//			}
//			
//		}
//		
//	}

}
