
package navalgo.modelo;

import java.util.ArrayList;

public abstract class Barco {

	/*representa la ubicacion (x,y) de la primer casilla del barco*/
	private Punto posicion;
	 	
	/*Indica su orientacion, puede ser horizontal o vertical*/
	private Orientacion orientacion;
	
	/*indica cuantas casillas conforman el barco*/
	private int tamanio;
	
	/*indica la cantidad dano que requiere cada casilla para ser destruida*/
	private int resistencia;
	
	/*representa el cuerpo del barco que esta compuesto por casillas
	 * 
	 */
	protected ArrayList<Parte> cuerpo;
	

	
	/*constructor*/
	public Barco(Punto unaPosicion, Orientacion unaOrientacion) {
		
		this.posicion = unaPosicion;
		this.orientacion = unaOrientacion;
		
	}
	
	/*metodo del constructor para cargar el cuerpo del barco*/
	protected void construirCuerpo(){
		Parte parteAux = null;
		for (int i = 0; i < this.tamanio; i++) {
			parteAux = new Parte(this.resistencia);
			this.cuerpo.add(parteAux);
		}
	}
	
	/*accesors*/
	public Punto getPosicion(){
		
		return this.posicion;
	}
	
	public void setPosicion(Punto unaPosicion){
		
		if((unaPosicion.getX()<1)|(unaPosicion.getY()<1)|(unaPosicion.getX()>10)|(unaPosicion.getX()>10)|(unaPosicion.getY()>10)){
			throw new PosicionInvalidaException();
		}
		
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
	
	public void setTamanio(int unTamanio){
		if((unTamanio<2)|(unTamanio>5)){
			throw new TamanioDeLaNaveInvalidaException();
		}
		
		this.tamanio = unTamanio;
		
	}
	
	
	public int getResistencia(){
		
		return this.resistencia;
	}
	
	public void setResistencia(int unaResistencia){
		
		this.resistencia = unaResistencia;
		
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
		Punto posicionBarco = new Punto(this.posicion.getX(), this.posicion.getY());
		if (this.orientacion == Orientacion.VERTICAL){
			for (int i = 0; i < this.tamanio; i++) {
				if (posicionBarco.equals(unDisparoConvencional.getPosicion())){
					this.getCuerpo().get(i).asimilarDisparo();
					}
				posicionBarco.setX(posicionBarco.getX() + 1);
			}
		}else{
			for (int i = 0; i < this.tamanio; i++) {
				if (posicionBarco.equals(unDisparoConvencional.getPosicion())){			
					this.getCuerpo().get(i).asimilarDisparo();
				}
				posicionBarco.setY(posicionBarco.getY()+1);
			}
		}
	}
	
	
	/*
	 * verifica el daño causado por una MinaSubmarinaPorContacto
	 */
	public void recibirAtaque(MinaSubmarinaPorContacto unaMinaSubmarinaPorContacto){
		Punto posicionBarco = new Punto(this.posicion.getX(), this.posicion.getY());
		if (this.orientacion == Orientacion.VERTICAL){
			for (int i = 0; i < this.tamanio; i++) {
				if (posicionBarco.equals(unaMinaSubmarinaPorContacto.getPosicion())){
					this.getCuerpo().get(i).asimilarDisparo();
					}
				posicionBarco.setX(posicionBarco.getX() +1);
			}
		}else{
			for (int i = 0; i < this.tamanio; i++) {
				if (posicionBarco.equals(unaMinaSubmarinaPorContacto.getPosicion())){			
					this.getCuerpo().get(i).asimilarDisparo();
				}
				posicionBarco.setY(posicionBarco.getY()+1);
			}
		}
	}
	
	/*
	 * verifica el daño causado por una MinaSubmarinaPuntualConRetardo
	 */
	public void recibirAtaque(MinaSubmarinaPuntualConRetardo unaMinaSubmarinaPuntualConRetardo){
		if (unaMinaSubmarinaPuntualConRetardo.getTurnosRestantes() == 0){
			Punto posicionBarco = new Punto(this.posicion.getX(), this.posicion.getY());
			if (this.orientacion == Orientacion.VERTICAL){
				for (int i = 0; i < this.tamanio; i++) {
					if (posicionBarco.equals(unaMinaSubmarinaPuntualConRetardo.getPosicion())){
						this.getCuerpo().get(i).asimilarDisparo();
						}
					posicionBarco.setX(posicionBarco.getX()+1);
				}
			}else{
				for (int i = 0; i < this.tamanio; i++) {
					if (posicionBarco.equals(unaMinaSubmarinaPuntualConRetardo.getPosicion())){			
						this.getCuerpo().get(i).asimilarDisparo();
					}
					posicionBarco.setY(posicionBarco.getY()+1);
				}
			}
		}
	}	
	
	/*
	 * verifica el dano causado por una MinaSubmarinaDobleConRetardo
	 */

	
	public void recibirAtaque(MinaSubmarinaDobleConRetardo unaMinaSubmarinaDobleConRetardo){
		if (unaMinaSubmarinaDobleConRetardo.getTurnosRestantes() == 0){
		Punto posicionBarco = new Punto(this.posicion.getX(), this.posicion.getY());
		if (this.orientacion == Orientacion.VERTICAL){
			for (int i = 0; i < this.tamanio; i++) {
				if (posicionBarco.equals(unaMinaSubmarinaDobleConRetardo.getPosicion())){
					this.getCuerpo().get(i).asimilarDisparo();
					}
				posicionBarco.setX(posicionBarco.getX() + 1);
			}
			
			//ahora verifico si los punto de alcance matchean con el barco
			
			for (Punto puntoDeAlcance : unaMinaSubmarinaDobleConRetardo.getPuntosDeAlcance()) {
				posicionBarco = new Punto(this.posicion.getX(), this.posicion.getY());
				for (int i = 0; i < this.tamanio; i++) {
					if (posicionBarco.equals(puntoDeAlcance)){
						this.getCuerpo().get(i).asimilarDisparo();
					}
				posicionBarco.setX(posicionBarco.getX() +1);	
				}
			}
			
		}else{
			for (int i = 0; i < this.tamanio; i++) {
				if (posicionBarco.equals(unaMinaSubmarinaDobleConRetardo.getPosicion())){			
					this.getCuerpo().get(i).asimilarDisparo();
				}
				posicionBarco.setY(posicionBarco.getY()+1);
			}
			
			//ahora verifico si los punto de alcance matchean con el barco
			
			for (Punto puntoDeAlcance : unaMinaSubmarinaDobleConRetardo.getPuntosDeAlcance()) {
				posicionBarco = new Punto(this.posicion.getX(), this.posicion.getY());
				for (int i = 0; i < this.tamanio; i++) {
					if (posicionBarco.equals(puntoDeAlcance)){
						this.getCuerpo().get(i).asimilarDisparo();
					}
				posicionBarco.setY(posicionBarco.getY() +1);	
				}
			}
			
		}
	}
}
	
	
	/*
	 * verifica el dano causado por una MinaSubmarinaTripleConRetardo
	 */
	public void recibirAtaque(MinaSubmarinaTripleConRetardo unaMinaSubmarinaTripleConRetardo){
		if (unaMinaSubmarinaTripleConRetardo.getTurnosRestantes() == 0){
		Punto posicionBarco = new Punto(this.posicion.getX(), this.posicion.getY());
		if (this.orientacion == Orientacion.VERTICAL){
			for (int i = 0; i < this.tamanio; i++) {
				if (posicionBarco.equals(unaMinaSubmarinaTripleConRetardo.getPosicion())){
					this.getCuerpo().get(i).asimilarDisparo();
					}
				posicionBarco.setX(posicionBarco.getX() + 1);
			}
			
			//ahora verifico si los punto de alcance matchean con el barco
			
			for (Punto puntoDeAlcance : unaMinaSubmarinaTripleConRetardo.getPuntosDeAlcance()) {
				posicionBarco = new Punto(this.posicion.getX(), this.posicion.getY());
				for (int i = 0; i < this.tamanio; i++) {
					if (posicionBarco.equals(puntoDeAlcance)){
						this.getCuerpo().get(i).asimilarDisparo();
					}
				posicionBarco.setX(posicionBarco.getX() +1);	
				}
			}
			
		}else{
			for (int i = 0; i < this.tamanio; i++) {
				if (posicionBarco.equals(unaMinaSubmarinaTripleConRetardo.getPosicion())){			
					this.getCuerpo().get(i).asimilarDisparo();
				}
				posicionBarco.setY(posicionBarco.getY()+1);
			}
			
			//ahora verifico si los punto de alcance matchean con el barco
			
			for (Punto puntoDeAlcance : unaMinaSubmarinaTripleConRetardo.getPuntosDeAlcance()) {
				posicionBarco = new Punto(this.posicion.getX(), this.posicion.getY());
				for (int i = 0; i < this.tamanio; i++) {
					if (posicionBarco.equals(puntoDeAlcance)){
						this.getCuerpo().get(i).asimilarDisparo();
					}
				posicionBarco.setY(posicionBarco.getY() +1);	
				}
			}
			
		}		
	}
	
}
}
