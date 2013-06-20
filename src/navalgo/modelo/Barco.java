
package navalgo.modelo;

import java.util.ArrayList;

public abstract class Barco {

	/*representa la ubicacion inicial (x,y) de la primera parte del barco*/
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
	

	protected int direccionX;
	protected int direccionY;
	
	
	/*constructor*/
	public Barco(Punto posicion, Orientacion orientacion,int tamanio, int resistencia, int direccionX, int direccionY) {
		
		this.direccionX = direccionX;
		this.direccionY = direccionY;
		if(this.direccionX==0 && this.direccionY==0)
		{
			this.direccionX = 1;
			this.direccionY =-1;
		}
		this.posicion = posicion;
		this.orientacion = orientacion;
		this.tamanio = tamanio;
		this.resistencia = resistencia;
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
		
	}
	
	
	/*metodo del constructor para cargar el cuerpo del barco*/
	private void construirCuerpo(){
		Parte parteAux = null;
		Punto posicionDeReferencia = new Punto(this.posicion.getX(),this.posicion.getY());
		parteAux = new Parte(this.resistencia, this.posicion); //la primera parte es la posicionInicial del barco
		this.cuerpo.add(parteAux);
		
		for (int i = 1; i < this.tamanio; i++) {
			parteAux = new Parte(this.resistencia,this.orientacion.getSiguientePosicion(posicionDeReferencia));
			this.cuerpo.add(parteAux);
			posicionDeReferencia = parteAux.getPosicion();
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
	 * Muevo el Barco una Posicion del Tablero
	 */
	public void mover(){
		
		Punto posicionDeLaPrimeraParte = this.posicion;
		int x= posicionDeLaPrimeraParte.getX();
		int y = posicionDeLaPrimeraParte.getY();
		int validarX = this.orientacion.calcularFinDePosicionDelBarcoX(posicionDeLaPrimeraParte, this.tamanio);
		int validarY = this.orientacion.calcularFinDePosicionDelBarcoX(posicionDeLaPrimeraParte, this.tamanio);		
		//Cambio de direccion si le Barco se encuentra en uno de los extrmos de X del Tablero
		if ((x==1&&this.direccionX==-1) ||
			(validarX==10 && this.direccionX==-1)) {
			this.direccionX*=-1;
		}	
		//Cambio de direccion si le Barco se encuentra en uno de los extrmos de Y del Tablero
		if ((y==1&&this.direccionY==-1) ||
		    (validarY==10 && this.direccionY==-1)) {
				this.direccionY*=-1;
		}
		
		//Muevo una posicion de X e Y
		posicionDeLaPrimeraParte.setX((x+this.direccionX));
		posicionDeLaPrimeraParte.setY((y+this.direccionY));
		
	}
	
	/*
	 * verifica el danio de un ataque de que no tiene alcance
	 */
	
	public void recibirAtaqueSinAlcance(Disparo disparo){
		int turnoRestante = disparo.getTurnosRestantes();
		if (turnoRestante == 0){
			for (Parte parte : this.getCuerpo()) {
				if (parte.getPosicion().equals(disparo.getPosicion())) {
					parte.asimilarDisparo();
					break;
				}
				
			}
		} else {
			disparo.setTurnosRestantes(turnoRestante-1);
		}
	}
	
	/*
	 * verifica el danio de un ataque que tiene alcance
	 */
	public void realizarAtaqueConAlcance(MinaSubmarinaConAlcance disparo){
		int turnoRestante = disparo.getTurnosRestantes();
		if (turnoRestante == 0){
			for (Parte parte : this.getCuerpo()) {
				if (parte.getPosicion().equals(disparo.getPosicion())){
					parte.asimilarDisparo();
				}
			}
			
			//ahora verifico si los punto de alcance matchean con el barco
			for (Punto puntoDeAlcance : disparo.getPuntosDeAlcance()) {
				for (Parte parte : this.getCuerpo()) {
					if (puntoDeAlcance.equals(parte.getPosicion())) {
						parte.asimilarDisparo();
						break;
					}
				}
			}
		} else {
			disparo.setTurnosRestantes(turnoRestante-1);
		}
	}
	
	/*
	 * verifica el danio causado por un diparo convencional
	 */
	
	public void recibirAtaque(DisparoConvencional unDisparoConvencional){
		this.recibirAtaqueSinAlcance(unDisparoConvencional);
	}
	
	/*
	 * verifica el danio causado por una MinaSubmarinaPorContacto
	 */
	public void recibirAtaque(MinaSubmarinaPorContacto unaMinaSubmarinaPorContacto){
		this.recibirAtaqueSinAlcance(unaMinaSubmarinaPorContacto);
	}
	
	/*
	 * verifica el danio causado por una MinaSubmarinaPuntualConRetardo
	 */
	
	public void recibirAtaque(MinaSubmarinaPuntualConRetardo unaMinaSubmarinaPuntualConRetardo){
		this.recibirAtaqueSinAlcance(unaMinaSubmarinaPuntualConRetardo);
	}
	
	/*
	 * verifica el danio causado por una MinaSubmarinaDobleConRetardo
	 */


	public void recibirAtaque(MinaSubmarinaDobleConRetardo unaMinaSubmarinaDobleConRetardo){
		this.realizarAtaqueConAlcance(unaMinaSubmarinaDobleConRetardo);
	}
	
	
	/*
	 * verifica el dano causado por una MinaSubmarinaTripleConRetardo
	 */

	
	public void recibirAtaque(MinaSubmarinaTripleConRetardo unaMinaSubmarinaTripleConRetardo){
		this.realizarAtaqueConAlcance(unaMinaSubmarinaTripleConRetardo);
	}

}
