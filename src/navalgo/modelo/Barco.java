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
	protected ArrayList<Casilla> cuerpo;
	
	/*indica la cantidad dano que requiere cada casilla para ser destruida*/
	protected int resistencia;
	
	/*constructor*/
	public Barco(Punto unaPosicion, Orientacion unaOrientacion) {
		
		this.posicion = unaPosicion;
		this.orientacion = unaOrientacion;
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
	
	public ArrayList<Casilla> getCuerpo(){
		
		return this.cuerpo;
	}
	
	public int getTamanio(){
		
		return this.tamanio;
	}
	
	/*retorna true si esta totalmente destruido*/
	public boolean estaDestruido(){
		int i = 0;
		boolean sale = false;
		while ( (i < this.cuerpo.size()) && (!sale)) {
			if (this.cuerpo.get(i).estaDestruida()) {
				i++;
			}else {
				sale = true;
			}
		}

		return !sale;
	}
	

}
