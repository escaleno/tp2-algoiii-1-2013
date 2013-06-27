package navalgo.modelo;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Circulo;

public abstract class Disparo extends Circulo
{
	//lo utilizo en el tablero, lo logico seria sacar del tablero los disparos detonados
	protected boolean detonado;
	
	/*representa el costo de utilizar un disparo*/
	protected int costo;
	
	/*represeta la posicion en el tablero en el cual se efectua
	 * el disparo
	 */
	protected Punto posicion;
	
	/*indica cuantos turnos faltan para que actue, en el momento que vale cero debe actuar*/
	protected int turnosRestantes;

	/*representa la cantidad de casillas adyacentes con son afectadas, si no afecta ninguna
	 * adyacente vale 0*/
	protected int alcance;
	
	
	/*
	 * constructor
	 */
	public Disparo(Punto unaPosicion){
		super(50, unaPosicion);
		setColor(Color.CYAN);
		this.posicion = unaPosicion;
	}
	
	/*
	 * accessors
	 */
	
	public int getCosto(){
		
		return this.costo;
	}
	
	public Punto getPosicion(){
		
		return this.posicion;
	}
	
	public int getTurnosRestantes(){
		
		return this.turnosRestantes;
	}
	
	public void setTurnosRestantes(int cantTurnos){
		this.turnosRestantes = cantTurnos;
	}
	
	public int getAlcance(){
		
		return this.alcance;
	}
	

	public abstract void atacar(Barco unBarco);
	
	public boolean detonado()
	{
		return detonado;
	}
	
	public void marcarComoDetonado()
	{
		detonado=true;
	}
	
	public void restarUnTurno(){
		this.turnosRestantes--;
	}
	
}
