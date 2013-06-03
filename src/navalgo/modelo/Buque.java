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
		if(unaMinaSubmarinaPorContacto.getTurnosRestantes() == 0){
			for(Parte unaCasilla : cuerpo){
				if( (unaCasilla.getPosicion().getX() == unaMinaSubmarinaPorContacto.getPosicion().getX()) && (unaCasilla.getPosicion().getY() == unaMinaSubmarinaPorContacto.getPosicion().getY()) ){
					unaCasilla.asimilarDisparo();
					break;
				}
			}
		
	}
		
		
}


	
	public void recibirAtaque(MinaSubmarinaPuntualConRetardo unaMinaSubmarinaPuntualConRetardo) {
		if(unaMinaSubmarinaPuntualConRetardo.getTurnosRestantes() == 0){
			for(Parte unaCasilla : cuerpo){
				if( (unaCasilla.getPosicion().getX() == unaMinaSubmarinaPuntualConRetardo.getPosicion().getX()) && (unaCasilla.getPosicion().getY() == unaMinaSubmarinaPuntualConRetardo.getPosicion().getY()) ){
					unaCasilla.asimilarDisparo();
					break;
				}
			}
		
	}
		
	}


	
	public void recibirAtaque(AlcanceDeMinaSubmarina alcanceDeMinaSubmarina) {
		if(alcanceDeMinaSubmarina.getTurnosRestantes() == 0){
			for(Parte unaCasilla : cuerpo){
				if( (unaCasilla.getPosicion().getX() == alcanceDeMinaSubmarina.getPosicion().getX()) && (unaCasilla.getPosicion().getY() == alcanceDeMinaSubmarina.getPosicion().getY()) ){
					unaCasilla.asimilarDisparo();
					break;
				}
			}
		
		}
		
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
