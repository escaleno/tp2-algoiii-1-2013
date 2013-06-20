package navalgo.modelo;

import java.util.ArrayList;

public abstract class MinaSubmarinaConAlcance extends Disparo {
	
	protected ArrayList<Punto> puntosDeAlcance;
	
	//Constructor	
	public MinaSubmarinaConAlcance(Punto unaPosicion, int alcance, Tablero tablero) {
		super(unaPosicion);
		this.detonado=false;
		this.alcance = alcance;
		puntosDeAlcance = new ArrayList<Punto>(); 
		this.construirPuntosDeAlcance(tablero);
	
}
	
	/*
	 * crea los puntos de alcance
	 */
	private void construirPuntosDeAlcance(Tablero tablero){
		for (int i = this.posicion.getX() - this.alcance; i <= this.posicion.getX() + this.alcance; i++) {
			for (int j = this.posicion.getY() - this.alcance; j <= this.posicion.getY() + this.alcance; j++) {
			  if( ( (i >= tablero.getCantidadMinimaDeFilas()) && (i <= tablero.getCantidadFilas()) ) && ( (j >= tablero.getCantidadMinimaDeColumnas()) && (j <= tablero.getCantidadColumnas()) ) && ( (i != this.posicion.getX() ) || ( j != this.posicion.getY() )) ){
					Punto unPunto = new Punto(i, j);
					puntosDeAlcance.add(unPunto);
				}
				
			}
		}
	}
	
	public ArrayList<Punto> getPuntosDeAlcance(){
		return this.puntosDeAlcance;
	}
	
	
	

}
