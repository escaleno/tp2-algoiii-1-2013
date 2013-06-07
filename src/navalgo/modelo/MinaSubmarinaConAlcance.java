package navalgo.modelo;

import java.util.ArrayList;

public abstract class MinaSubmarinaConAlcance extends Disparo {
	
	protected ArrayList<Punto> puntosDeAlcance;
	
	//Constructor
	public MinaSubmarinaConAlcance(Punto unaPosicion) {
		super(unaPosicion);
		puntosDeAlcance = new ArrayList<Punto>(); 
		
		for (int i = this.posicion.getX() -1; i < this.posicion.getX() +1; i++) {
			for (int j = this.posicion.getY() -1; j < this.posicion.getY() +1; j++) {
				
			}
		}
	}
	
	public ArrayList<Punto> getPuntosDeAlcance(){
		return this.puntosDeAlcance;
	}
	
	
	

}
