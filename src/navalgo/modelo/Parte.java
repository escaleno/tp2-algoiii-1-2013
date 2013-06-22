package navalgo.modelo;

import java.awt.Color;
import fiuba.algo3.titiritero.dibujables.Cuadrado;

public class Parte extends Cuadrado {
	
	/*representa la cantidad de disparos que soporta, cuando
	 * vale cero representa que fue totalmente destruida
	 */
	private int resistencia;
	
	/*
	 * representa su posicion (x,y) en el tablero
	 */
	private Punto posicion;
	
	
	/*constructor */
	public Parte(int resistencia, Punto posicion){
		super(50,50,posicion);
		this.setColor(Color.GREEN);
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
			this.setColor(Color.YELLOW);
		} else {
			this.setColor(Color.RED);
		}
	}
	
	public int getX(){
		return posicion.obtenerX()*10;
	}
	
	public int getY(){
		return posicion.obtenerY()*10;
	}

}
	
