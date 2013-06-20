package navalgo.modelo;

public class Parte {
	
	/*representa la cantidad de disparos que soporta, cuando
	 * vale cero representa que fue totalmente destruida
	 */
	private int resistencia;
	
	/*
	 * representa su posicion (x,y) en el tablero
	 */
	private Punto posicion;
	
	
	/*constructor */
	public Parte(int resistencia, Punto posicion){
		
		this.resistencia = resistencia;
		this.posicion = posicion;
	}
	
	public int getResistencia(){
		
		return this.resistencia;
	}
	
	public void setResistencia(int nivelDeResistencia){
		
		this.resistencia = nivelDeResistencia;
		
	}
	
	public Punto getPosicion(){
		
		return this.posicion;
	}
	
	/*
	 * retorna true si la parte tiene resistencia cero
	 */
	public boolean estaDestruida() {
		return (this.resistencia == 0);
	}
	
	/*establece el danio realizado por el disparo*/
	public void asimilarDisparo(){
		if(this.resistencia > 0) {
			resistencia--;
		}
	}
	

	
	
	
	

}
