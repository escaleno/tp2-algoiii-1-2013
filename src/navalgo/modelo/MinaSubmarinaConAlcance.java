package navalgo.modelo;

import java.util.ArrayList;

public abstract class MinaSubmarinaConAlcance extends Disparo {
	
	protected ArrayList<MinaDeAlcanceSubmarina> minasDeAlcance;
	public MinaSubmarinaConAlcance(Punto unaPosicion) {
		super(unaPosicion);
		minasDeAlcance = new ArrayList<MinaDeAlcanceSubmarina>(); 
		
	}
	
	protected void agregarMinaDeAlcanceSubmarina(Punto posicion) {
		MinaDeAlcanceSubmarina unaMinaDeAlcance;
		unaMinaDeAlcance = new MinaDeAlcanceSubmarina(posicion);
		this.minasDeAlcance.add(unaMinaDeAlcance);
		
	}
	
	
	
	
}
