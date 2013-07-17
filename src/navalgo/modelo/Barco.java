
package navalgo.modelo;

import java.util.ArrayList;

public abstract class Barco {

	/*representa la ubicacion inicial (x,y) de la primera parte del barco*/
	private Punto posicion;
	
	private String nombre = "Nada";
	 	
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
	

	private int direccionX;
	private int direccionY;
	
	
	
	
	/*constructor*/
	public Barco(Punto posicion, Orientacion orientacion,int tamanio, int resistencia, int direccionX, int direccionY, String nombre) {
		
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
		this.nombre = nombre;
		this.construirCuerpo2();	
	}
		
	
	/*metodo del constructor para cargar el cuerpo del barco*/
	private void construirCuerpo2(){
		Punto posicionDeReferencia = new Punto(this.posicion.obtenerX(),this.posicion.obtenerY());
		this.cuerpo.addAll(this.orientacion.getPartes(this.tamanio, this.resistencia, this.nombre, posicionDeReferencia));
	}
	/*accesors*/
	public Punto getPosicion(){
		
		return this.posicion;
	}
	
	public void setPosicion(Punto unaPosicion){
		
		if((unaPosicion.obtenerX()<1)|(unaPosicion.obtenerY()<1)|(unaPosicion.obtenerX()>10)|(unaPosicion.obtenerX()>10)|(unaPosicion.obtenerY()>10)){
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
		
		int tamanio = this.cuerpo.size()-1;
		Punto posicionDeLaPrimeraParte = this.cuerpo.get(0).getPosicion();
		Punto posicionDeLaUltimaParte = this.cuerpo.get(tamanio).getPosicion();
		int inicioX= posicionDeLaPrimeraParte.obtenerX();
		int inicioY = posicionDeLaPrimeraParte.obtenerY();
		int finX = posicionDeLaUltimaParte.obtenerX();
		int finY = posicionDeLaUltimaParte.obtenerY();
		
		//Cambio de direccion si le Barco se encuentra en uno de los extrmos de X del Tablero
		if ((inicioX==1&&this.direccionX==-1) ||
			(finX==10 && this.direccionX==1)) {
			this.direccionX*=-1;
		}	
		//Cambio de direccion si le Barco se encuentra en uno de los extrmos de Y del Tablero
		if ((inicioY==1&&this.direccionY==-1) ||
		    (finY==10 && this.direccionY==1)) {
				this.direccionY*=-1;
		}
		
		//Muevo una posicion de X e Y
		for (Parte parte: this.cuerpo){
			Punto posicion = parte.getPosicion();
			posicion.ponerX(posicion.obtenerX()+this.direccionX);
			posicion.ponerY(posicion.obtenerY()+this.direccionY);
		}
		
		this.posicion = posicionDeLaPrimeraParte;
	}
	
	/*
	 * verifica el danio de un ataque de que no tiene alcance
	 */
	
	private void recibirAtaqueSinAlcance(Disparo disparo){
		int turnoRestante = disparo.getTurnosRestantes();
		if (turnoRestante == 0){
			for (Parte parte : this.getCuerpo()) {
				if (parte.getPosicion().equals(disparo.getPosicion())) {
					disparo.marcarComoDetonado();
					parte.asimilarDisparo();
					break;
				}
				
			}
		}
	}
	
	/*
	 * verifica el danio de un ataque que tiene alcance
	 */
	private void realizarAtaqueConAlcance(MinaSubmarinaConAlcance disparo){
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
			disparo.marcarComoDetonado();
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
