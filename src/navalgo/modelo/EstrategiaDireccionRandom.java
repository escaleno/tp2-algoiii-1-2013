package navalgo.modelo;

import java.util.Random;

public class EstrategiaDireccionRandom implements EstrategiaDireccion {

	@Override
	public Direccion execute() {
		Direccion[] direcciones = Direccion.values();
		Random random = new Random();
		return direcciones[random.nextInt(direcciones.length)];
	}

}
