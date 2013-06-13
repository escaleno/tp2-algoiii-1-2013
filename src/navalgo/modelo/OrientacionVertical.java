package navalgo.modelo;

public class OrientacionVertical implements Orientacion {

	
	@Override
	public int calcularUltimaPosicionDelBarcoX(Punto puntoDeInicioBarco, 
			int tamanio) {
		// TODO Auto-generated method stub
		return puntoDeInicioBarco.getX();
	}
	
	@Override
	public int calcularUltimaPosicionDelBarcoY(Punto puntoDeInicioBarco, 
			int tamanio){
		// TODO Auto-generated method stub
		return (puntoDeInicioBarco.getY()+tamanio);
	}

	@Override
	public void asimilarImpacto(Barco barco, Punto puntoDeDisparo) {
		// TODO Auto-generated method stub
		Punto posicionBarco = new Punto(barco.getPosicion().getX(), barco.getPosicion().getY());
		for (int i = 0; i < barco.getTamanio(); i++) {
			if (posicionBarco.equals(puntoDeDisparo)){
				barco.getCuerpo().get(i).asimilarDisparo();
				}
			posicionBarco.setY(posicionBarco.getY() + 1);
		}
	}

}
