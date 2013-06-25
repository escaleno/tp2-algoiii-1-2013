package navalgo.modelo;

public class GeneradorRandomPunto {
	private EstrategiaPunto estrategia;
	
	public GeneradorRandomPunto(EstrategiaPunto estrategia) {
		this.estrategia = estrategia;
	}
	
	public Punto getValue(){
		return this.estrategia.execute();
	}
}
