package navalgo.modelo;

import java.util.ArrayList;

public class Destructor extends Barco {

	public Destructor(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		this.tamanio = 3;
		this.resistencia = 1;
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();

	}


	public void recibirAtaque(DisparoConvencional unDisparoConvencional) {
		if(unDisparoConvencional.getTurnosRestantes() == 0){
			for(Parte unaCasilla : cuerpo){
				if( (unaCasilla.getPosicion().getX() == unDisparoConvencional.getPosicion().getX()) && (unaCasilla.getPosicion().getY() == unDisparoConvencional.getPosicion().getY()) ){
					unaCasilla.asimilarDisparo();
					break;
				}
			}
			
		}
		
	}


	public void recibirAtaque(MinaSubmarinaPorContacto unaMinaSubmarinaPorContacto) {
		//no hace nada
		
	}


	public void recibirAtaque(MinaSubmarinaPuntualConRetardo unaMinaSubmarinaPuntualConRetardo) {
		//no hace nada
		
	}


	
	public void recibirAtaque(AlcanceDeMinaSubmarina alcanceDeMinaSubmarina) {
		//no hace nada
		
	}


	public void recibirAtaque(
			MinaSubmarinaDobleConRetardo unaMinaSubmarinaDobleConRetardo) {
		//no hace nada
		
	}

}
