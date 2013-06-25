package navalgo.modelo;

public class EstrategiaDireccionDerArriba implements EstrategiaDireccion {

	@Override
	public Direccion execute() {
		return Direccion.DERARRIBA;
	}

}
