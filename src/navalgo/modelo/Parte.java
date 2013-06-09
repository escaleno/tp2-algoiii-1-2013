package navalgo.modelo;

public class Parte {
	/*representa la cantidad de disparos que soporta, cuando
	 * vale cero representa que fue totalmente destruida
	 */
	private int resistencia;
		
	/*constructor */
	public Parte(int cantDeResistencia){
		
		this.resistencia = cantDeResistencia;
	}
	
	public int getResistencia(){
		
		return this.resistencia;
	}
	
	public void setResistencia(int nivelDeResistencia){
		
		this.resistencia = nivelDeResistencia;
		
	}
	public boolean estaDestruida() {
		return (this.resistencia == 0);
	}
	
	/*establece el daño realizado por el disparo*/
	public void asimilarDisparo(){
		if(this.resistencia > 0) {
			resistencia--;
		}
	}
	

	
	
	
	

}
