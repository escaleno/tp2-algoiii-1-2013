package navalgo.modelo;

public class EstrategiaDireccionIzquierda implements EstrategiaDireccion {

	@Override
	public Direccion execute() {
		return Direccion.IZQUIERDA;
	}

}
