
package navalgo.modelo;

import java.util.ArrayList;

public abstract class Barco {

	/*representa la ubicacion (x,y) de la primer casilla del barco*/
	protected Punto posicion;
	 	
	/*Indica su orientacion, puede ser horizontal o vertical*/
	protected Orientacion orientacion;
	
	/*indica cuantas casillas conforman el barco*/
	protected int tamanio;
	
	/*representa el cuerpo del barco que esta compuesto por casillas
	 * 
	 */
	protected ArrayList<Parte> cuerpo;
	
	/*indica la cantidad dano que requiere cada casilla para ser destruida*/
	protected int resistencia;
	
	
	
	/*constructor*/
	public Barco(Punto unaPosicion, Orientacion unaOrientacion) {
		
		this.posicion = unaPosicion;
		this.orientacion = unaOrientacion;
		
	}
	
	/*metodo del constructor para cargar el cuerpo del barco*/
	protected void construirCuerpo(){
		Parte casillaAux = null;
		Punto posicionAux = null;
		for (int i = 0; i < this.tamanio; i++) {
			if(this.orientacion == Orientacion.HORIZONTAL){
				posicionAux = new Punto(this.posicion.getX(),this.posicion.getY() + i);
			}else if(this.orientacion == Orientacion.VERTICAL){
				posicionAux = new Punto(this.posicion.getX() + i,this.posicion.getY());
			}
			casillaAux = new Parte(this.resistencia,posicionAux);
			this.cuerpo.add(casillaAux);
			}
	}
	
	/*accesors*/
	public Punto getPosicion(){
		
		return this.posicion;
	}
	
	public void setPosicion(Punto unaPosicion){
		
		this.posicion = unaPosicion;
	}
	

	public Orientacion getOrientacion(){
		
		return this.orientacion;
	}
	
	public ArrayList<Parte> getCuerpo(){
		
		return this.cuerpo;
	}
	
	public int getTamanio(){
		
		return this.tamanio;
	}
	
	
	/*retorna true si esta totalmente destruido*/
	public boolean estaDestruido(){
		for (Parte pos : cuerpo )
		{
			if (!pos.estaDestruida())
				return false;
		}
		return true;
	}
	
	
	/*
	 * verifica el daño causado por un DisparoConvencional
	 */

	public void recibirAtaque(DisparoConvencional unDisparoConvencional){
		if(unDisparoConvencional.getTurnosRestantes() == 0){
			for(Parte unaCasilla : cuerpo){
				if( (unaCasilla.getPosicion().getX() == unDisparoConvencional.getPosicion().getX()) && (unaCasilla.getPosicion().getY() == unDisparoConvencional.getPosicion().getY()) ){
					unaCasilla.asimilarDisparo();
					break;
				}
			}
			
		}
	}
	
	/*
	 * verifica el daño causado por una MinaSubmarinaPorContacto
	 */
	public void recibirAtaque(MinaSubmarinaPorContacto unaMinaSubmarinaPorContacto){
		if(unaMinaSubmarinaPorContacto.getTurnosRestantes() == 0){
			for(Parte unaCasilla : cuerpo){
				if( (unaCasilla.getPosicion().getX() == unaMinaSubmarinaPorContacto.getPosicion().getX()) && (unaCasilla.getPosicion().getY() == unaMinaSubmarinaPorContacto.getPosicion().getY()) ){
					unaCasilla.asimilarDisparo();
					break;
				}
			}
			
		}
	}
	
	/*
	 * verifica el daño causado por una MinaSubmarinaPuntualConRetardo
	 */
	public void recibirAtaque(MinaSubmarinaPuntualConRetardo unaMinaSubmarinaPuntualConRetardo){
		if(unaMinaSubmarinaPuntualConRetardo.getTurnosRestantes() == 0){
			for(Parte unaCasilla : cuerpo){
				if( (unaCasilla.getPosicion().getX() == unaMinaSubmarinaPuntualConRetardo.getPosicion().getX()) && (unaCasilla.getPosicion().getY() == unaMinaSubmarinaPuntualConRetardo.getPosicion().getY()) ){
					unaCasilla.asimilarDisparo();
					break;
				}
			}
			
		}
		
	}
	
	
	public abstract void recibirAtaque(MinaSubmarinaDobleConRetardo unaMinaSubmarinaDobleConRetardo);
	

}
