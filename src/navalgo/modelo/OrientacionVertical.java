package navalgo.modelo;

public class OrientacionVertical implements Orientacion {

	
	@Override
	public int calcularFinDePosicionDelBarcoX(Punto puntoDeInicioBarco, 
			int tamanio) {
		// TODO Auto-generated method stub
		return puntoDeInicioBarco.getX();
	}
	
	@Override
	public int calcularFinDePosicionDelBarcoY(Punto puntoDeInicioBarco, 
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

	@Override
	public Punto getSiguientePosicion(Punto posicionDeReferencia) {
		Punto auxPosicion = new Punto(posicionDeReferencia.getX(), posicionDeReferencia.getY());
		auxPosicion.incrementarEnX();
		return auxPosicion;
		
	}

}
