package navalgo.modelo;

public class EstrategiaOrientacionHorizontal implements EstrategiaOrientacion {

	@Override
	public Orientacion execute() {
		return new OrientacionHorizontal();
	}

}
