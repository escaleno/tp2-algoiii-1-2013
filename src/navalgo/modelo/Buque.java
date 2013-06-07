package navalgo.modelo;

import java.util.ArrayList;

public class Buque extends Barco {

	public Buque(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		this.tamanio = 4;
		this.resistencia = 1;
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
	}
	

	public boolean estaDestruido(){
		for(Parte unaCasilla : cuerpo){
			if(unaCasilla.estaDestruida()){
				return true;
			}
		}
		return false;
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
