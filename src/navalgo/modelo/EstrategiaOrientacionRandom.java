package navalgo.modelo;

import java.util.Random;

public class EstrategiaOrientacionRandom implements EstrategiaOrientacion {

	@Override
	public Orientacion execute() {
		Orientacion orientacion = null;
		Random rand = new Random();
		int random = rand.nextInt(2);
		switch (random) {
		case 0:
			orientacion = new OrientacionVertical();
			break;
		case 1:
			orientacion = new OrientacionHorizontal();
			break;
		default:
			orientacion = new OrientacionHorizontal();
			break;
		}
		return orientacion;
	}

}
