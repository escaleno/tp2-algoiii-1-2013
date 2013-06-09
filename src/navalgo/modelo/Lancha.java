package navalgo.modelo;

import java.util.ArrayList;

public class Lancha extends Barco {

	public Lancha(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		
		this.setTamanio(2);
		this.setResistencia(1);
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
		
	}


	
}

