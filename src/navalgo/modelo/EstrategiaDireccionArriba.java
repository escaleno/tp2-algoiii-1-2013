package navalgo.modelo;

public class EstrategiaDireccionArriba implements EstrategiaDireccion {

	@Override
	public Direccion execute() {
		return Direccion.ARRIBA;
	}

}
