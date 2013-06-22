package navalgo.modelo;

public class OrientacionVertical extends Orientacion {

	public OrientacionVertical() {
		super("Vertical");
	}

	public int calcularFinDePosicionDelBarcoX(Punto puntoDeInicioBarco, 
			int tamanio) {
		// TODO Auto-generated method stub
		return puntoDeInicioBarco.obtenerX();
	}
	
	public int calcularFinDePosicionDelBarcoY(Punto puntoDeInicioBarco, 
			int tamanio){
		// TODO Auto-generated method stub
		return (puntoDeInicioBarco.obtenerY()+tamanio);
	}

//	@Override
//	public void asimilarImpacto(Barco barco, Punto puntoDeDisparo) {
//		// TODO Auto-generated method stub
//		Punto posicionBarco = new Punto(barco.getPosicion().getX(), barco.getPosicion().getY());
//		for (int i = 0; i < barco.getTamanio(); i++) {
//			if (posicionBarco.equals(puntoDeDisparo)){
//				barco.getCuerpo().get(i).asimilarDisparo();
//				}
//			posicionBarco.setY(posicionBarco.getY() + 1);
//		}
//	}

	public Punto getSiguientePosicion(Punto posicionDeReferencia) {
		Punto auxPosicion = new Punto(posicionDeReferencia.obtenerX(), posicionDeReferencia.obtenerY());
		auxPosicion.incrementarEnY();
		return auxPosicion;
		
	}

}
