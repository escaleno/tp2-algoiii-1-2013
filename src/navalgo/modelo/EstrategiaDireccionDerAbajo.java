package navalgo.modelo;

public class EstrategiaDireccionDerAbajo implements EstrategiaDireccion { 

	@Override
	public Direccion execute() {
		return Direccion.DERABAJO;
	}

}
