package navalgo.modelo;

public class GeneradorOrientacion {
	private EstrategiaOrientacion estrategia;
	public GeneradorOrientacion(EstrategiaOrientacion estrategia ){
		this.estrategia = estrategia;
	}
	
	public Orientacion getValue() {
		return this.estrategia.execute();
	}

}
