package navalgo.modelo;

public class Casilla {
	/*representa la cantidad de disparos que soporta, cuando
	 * vale cero representa que fue totalmente destruida
	 */
	private int resistencia;
	
	/*representa la posicion de una casilla en el tabler*/
	private Punto posicion;
	
	public Casilla(int cantDeResistencia,Punto unaPosicion){
		
		this.resistencia = cantDeResistencia;
		this.posicion = unaPosicion;
	}
	
	public int getResistencia(){
		
		return this.resistencia;
	}
	
	public Punto getPosicion(){
		return this.posicion;
	}
	
	public void setResistencia(int nivelDeResistencia){
		
		this.resistencia = nivelDeResistencia;
		
	}
	public boolean estaDestruida() {
		return (this.resistencia == 0);
	}
	
	/*establece el daño realizado por el disparo*/
	public void asimilarDisparo(Disparo unDisparo){
		if(this.resistencia > 0) {
			resistencia--;
		}
	}
	

	
	
	
	

}
