package navalgo.modelo;

public abstract class Disparo {
	
	/*representa el costo de utilizar un disparo*/
	protected int costo;
	
	/*represeta la posicion en el tablero en el cual se efectua
	 * el disparo
	 */
	protected Punto posicion;
	
	/*
	 * constructor
	 */
	public Disparo(Punto unaPosicion){
		
		this.posicion = unaPosicion;
	}
	
	/*
	 * accessors
	 */
	
	public int getCosto(){
		
		return this.costo;
	}
	
	public Punto getPosicion(){
		
		return this.posicion;
	}
	


	
}
