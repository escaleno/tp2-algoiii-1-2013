package navalgo.modelo;

import java.util.ArrayList;

public abstract class Orientacion {

	private String nombre ="";
	
	public Orientacion(String nombre) {
		this.nombre = nombre;
	}
	/*
	 * retorna la siguiente posicion respecto de posicionDeReferencia
	 */
	protected abstract Punto getSiguientePosicion(Punto posicionDeReferencia);
	
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
