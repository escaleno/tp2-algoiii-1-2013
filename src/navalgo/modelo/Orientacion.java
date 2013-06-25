package navalgo.modelo;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Orientacion {

	private String nombre ="";
	
	public Orientacion(String nombre) {
		this.nombre = nombre;
	}
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
	
	
	/*
	 * retorna la siguiente posicion respecto de posicionDeReferencia
	 */
	public abstract Punto getSiguientePosicion(Punto posicionDeReferencia);
	
	public ArrayList<Parte> getPartes(int tamanio, int resistencia, String nombre, Punto posicionDeReferencia) {
		
		Parte parteAux = null;
		ArrayList<Parte> partes = new ArrayList<Parte>();
		//la primera parte es la posicionInicial del barco
		parteAux = new Parte(resistencia, posicionDeReferencia, (nombre + this.nombre + 1 ));
		partes.add(parteAux);
		
		for (int i = 1; i < tamanio; i++) {
			
			parteAux = new Parte(resistencia,
					this.getSiguientePosicion(posicionDeReferencia),
					(nombre + this.nombre + (i+1)));
			partes.add(parteAux);
			posicionDeReferencia = parteAux.getPosicion();
		}
		return partes;
	}
}
