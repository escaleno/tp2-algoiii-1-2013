package navalgo.modelo;

public class EstrategiaDireccionAbajo implements EstrategiaDireccion {

	@Override
	public Direccion execute() {
		return Direccion.ABAJO;
	}

}
