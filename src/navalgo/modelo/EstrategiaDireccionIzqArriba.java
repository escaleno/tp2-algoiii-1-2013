package navalgo.modelo;

public class EstrategiaDireccionIzqArriba implements EstrategiaDireccion {

	@Override
	public Direccion execute() {
		return Direccion.IZQARRIBA;
	}

}
