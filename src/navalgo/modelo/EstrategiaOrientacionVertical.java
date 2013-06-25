package navalgo.modelo;

public class EstrategiaOrientacionVertical implements EstrategiaOrientacion {

	@Override
	public Orientacion execute() {
		return new OrientacionVertical();
	}

}
