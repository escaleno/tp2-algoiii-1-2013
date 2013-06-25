package navalgo.modelo;

import java.io.IOException;

public class Parte {
	
	/*representa la cantidad de disparos que soporta, cuando
	 * vale cero representa que fue totalmente destruida
	 */
	private int resistencia;
	private int estado = 0;
	
	private String nombre;
	/*
	 * representa su posicion (x,y) en el tablero
	 */
	private Punto posicion;
	
	
	/*constructor */
	public Parte(int resistencia, Punto posicion) {
		this.nombre = "Nada";
		this.resistencia = resistencia;
		this.posicion = posicion;
	}
	
	public Parte(int resistencia,Punto posicion, String nombre) {
		this.nombre = nombre;
		this.resistencia = resistencia;
		this.posicion = posicion;
	}
	
	public int getResistencia(){
		
		return this.resistencia;
	}
	
	public void setResistencia(int nivelDeResistencia){
		
		this.resistencia = nivelDeResistencia;
		
	}
	
	public Punto getPosicion(){
		
		return this.posicion;
	}
	
	/*
	 * retorna true si la parte tiene resistencia cero
	 */
	public boolean estaDestruida() {
		return (this.resistencia == 0);
	}
	
	/*establece el danio realizado por el disparo*/
	public void asimilarDisparo(){
		if(this.resistencia > 0) {
			this.resistencia--;
		}
		//Valido Estado
		if (this.resistencia > 0)
		{
			estado = 1;
		} else {
			estado = 2;
		}
	}

	public int getEstado() {
		return this.estado;
	}
	
	public String getNomber() {
		System.out.println(this.nombre);
		return this.nombre;
	}

}
	
