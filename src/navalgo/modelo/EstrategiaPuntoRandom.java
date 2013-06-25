package navalgo.modelo;

import java.util.Random;

public class EstrategiaPuntoRandom implements EstrategiaPunto {

	@Override
	public Punto execute() {
		Random random = new Random();
		int x = random.nextInt(5)+1;
		int y = random.nextInt(5)+1;
		return new Punto(x, y);
	}

}
