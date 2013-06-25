package navalgo.modelo;

public class EstrategiaDireccionDerecha implements EstrategiaDireccion {

	@Override
	public Direccion execute() {
		return Direccion.DERECHA;
	}

}
