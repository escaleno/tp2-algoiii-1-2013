package navalgo.modelo;

public class GeneradorRandomDireccion {
	EstrategiaDireccion estrategia;
	
	public GeneradorRandomDireccion(EstrategiaDireccion estrategia){
		this.estrategia = estrategia;
	}
	
	public Direccion getValue(){
		return estrategia.execute();
	}
	
}
