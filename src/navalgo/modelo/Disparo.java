package navalgo.modelo;

public abstract class Disparo {
	
	/*representa el costo de utilizar un disparo*/
	protected int costo;
	
	/*represeta la posicion en el tablero en el cual se efectua
	 * el disparo
	 */
	protected Punto posicion;
	
	/*indica cuantos turnos faltan para que actue, en el momento que vale cero debe actuar*/
	protected int turnosRestantes;

	/*representa la cantidad de casillas adyacentes con son afectadas, si no afecta ninguna
	 * adyacente vale 0*/
	protected int alcance;
	
	
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
	
	public int getTurnosRestantes(){
		
		return this.turnosRestantes;
	}
	
	public int getAlcance(){
		
		return this.alcance;
	}
	

	public abstract void atacar(Barco unBarco);
	
}
