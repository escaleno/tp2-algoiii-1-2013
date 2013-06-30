package navalgo.modelo;

public class GeneradorOrientacion {
	EstrategiaOrientacion estrategia;
	public GeneradorOrientacion(EstrategiaOrientacion estrategia ){
		this.estrategia = estrategia;
	}
	
	public Orientacion getValue() {
		return this.estrategia.execute();
	}

}
