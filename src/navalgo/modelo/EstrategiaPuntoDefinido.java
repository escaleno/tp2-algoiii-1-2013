package navalgo.modelo;

public class EstrategiaPuntoDefinido implements EstrategiaPunto {
	private Punto punto;
	
	public EstrategiaPuntoDefinido(int x, int y) {
		this.punto = new Punto(x, y);
	}
	
	@Override
	public Punto execute() {
		return punto;
	}

}
