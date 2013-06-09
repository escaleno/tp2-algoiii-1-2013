package navalgo.modelo;

import java.util.ArrayList;

public abstract class MinaSubmarinaConAlcance extends Disparo {
	
	protected ArrayList<Punto> puntosDeAlcance;
	
	//Constructor
	public MinaSubmarinaConAlcance(Punto unaPosicion) {
		super(unaPosicion);
		puntosDeAlcance = new ArrayList<Punto>(); 
		
	}
	
	public ArrayList<Punto> getPuntosDeAlcance(){
		return this.puntosDeAlcance;
	}
	
	
	

}
