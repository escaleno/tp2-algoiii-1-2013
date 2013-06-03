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


	@Override
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

}
