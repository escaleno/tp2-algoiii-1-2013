package navalgo.modelo;

public class Casilla {
	/*representa la cantidad de disparos que soporta, cuando
	 * vale cero representa que fue totalmente destruida
	 */
	private int resistencia;
	
	public Casilla(int cantDeResistencia){
		
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
	

	
	
	
	

}
