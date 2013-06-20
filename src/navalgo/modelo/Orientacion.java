package navalgo.modelo;

public interface Orientacion {

	/**
	 * @param puntoDeInicioBarco es el punto de inicio del Barco
	 * @param tamanio es el tamanio de casillas que tiene el Barco
	 * @return El fin de la Posicion de Y del Barco
	 */
	public abstract int calcularFinDePosicionDelBarcoX(Punto puntoDeInicioBarco, int tamanio);
	
	/**
	 * @param puntoDeInicioBarco es el punto de inicio del Barco
	 * @param tamanio es el tamanio de casillas que tiene el Barco
	 * @return El fin de la Posicion de Y del Barco
	 */
	public abstract int calcularFinDePosicionDelBarcoY(Punto puntoDeInicioBarco, int tamanio);
	
	/**
	 * Asimila el Impacto en el Barco
	 * 
	 * @param Barco
	 * @param posicionDelDisparo
	 */
	public abstract void asimilarImpacto(Barco barco, Punto puntoDeDisparo);
	
	/*
	 * retorna la siguiente posicion respecto de posicionDeReferencia
	 */
	public abstract Punto getSiguientePosicion(Punto posicionDeReferencia);
	
}
