package navalgo.modelo;

public class EstrategiaDireccionIzqAbajo implements EstrategiaDireccion {

	@Override
	public Direccion execute() {
		return Direccion.IZQABAJO;
	}

}
