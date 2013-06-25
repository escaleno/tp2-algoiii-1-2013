package navalgo.modelo;

public class GeneradorRandomOrientacion {
	EstrategiaOrientacion estrategia;
	public GeneradorRandomOrientacion(EstrategiaOrientacion estrategia ){
		this.estrategia = estrategia;
	}
	
	public Orientacion getValue() {
		return this.estrategia.execute();
	}

}
