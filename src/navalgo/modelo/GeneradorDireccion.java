package navalgo.modelo;

public class GeneradorDireccion {
	private EstrategiaDireccion estrategia;
	
	public GeneradorDireccion(EstrategiaDireccion estrategia){
		this.estrategia = estrategia;
	}
	
	public Direccion getValue(){
		return estrategia.execute();
	}
	
}
