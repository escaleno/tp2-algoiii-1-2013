package navalgo.modelo;

import java.util.ArrayList;

public class Lancha extends Barco {

	public Lancha(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		
		this.tamanio = 2;
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

