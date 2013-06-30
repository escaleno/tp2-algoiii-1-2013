package navalgo.modelo;

public class GeneradorPunto {
	private EstrategiaPunto estrategia;
	
	public GeneradorPunto(EstrategiaPunto estrategia) {
		this.estrategia = estrategia;
	}
	
	public Punto getValue(){
		return this.estrategia.execute();
	}
}
