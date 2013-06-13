package navalgo.modelo;

public interface Orientacion {

	/**
	 * @param Punto es el punto de inicio del Barco
	 * @param tamanio es el tamanio de casillas que tiene el Barco
	 * @return Ultima Posicion de X del Barco
	 */
	public abstract int calcularUltimaPosicionDelBarcoX(Punto puntoDeInicioBarco, int tamanio);
	
	/**
	 * @param Punto es el punto de inicio del Barco
	 * @param tamanio es el tamanio de casillas que tiene el Barco
	 * @return Ultima Posicion de Y del Barco
	 */
	public abstract int calcularUltimaPosicionDelBarcoY(Punto puntoDeInicioBarco, int tamanio);
	
	/**
	 * Asimila el Impacto en el Barco
	 * 
	 * @param Barco
	 * @param posicionDelDisparo
	 */
	public abstract void asimilarImpacto(Barco barco, Punto puntoDeDisparo);
	
}
