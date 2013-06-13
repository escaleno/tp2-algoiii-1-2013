package navalgo.modelo;

public class OrientacionHorizontal implements Orientacion {

	@Override
	public int calcularFinDePosicionDelBarcoX(Punto puntoDeInicioBarco,
			int tamanio) {
		// TODO Auto-generated method stub
		return puntoDeInicioBarco.getX()+tamanio;
	}

	@Override
	public int calcularFinDePosicionDelBarcoY(Punto puntoDeInicioBarco,
			int tamanio) {
		// TODO Auto-generated method stub
		return puntoDeInicioBarco.getY();
	}

	@Override
	public void asimilarImpacto(Barco barco, Punto puntoDeDisparo) {
		// TODO Auto-generated method stub
		Punto posicionBarco = new Punto(barco.getPosicion().getX(), barco.getPosicion().getY());
		for (int i = 0; i < barco.getTamanio(); i++) {
			if (posicionBarco.equals(puntoDeDisparo)){
				barco.getCuerpo().get(i).asimilarDisparo();
			}
			posicionBarco.setX(posicionBarco.getX() + 1);
		}

	}

}
