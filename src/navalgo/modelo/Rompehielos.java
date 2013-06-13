package navalgo.modelo;

import java.util.ArrayList;

public class Rompehielos extends Barco {

	public Rompehielos(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		this.setTamanio(3);
		this.setResistencia(2);
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
	}
	
	public Rompehielos(Punto unaPosicion, Orientacion unaOrientacion, int direccionX,  int direccionY) {
		super(unaPosicion, unaOrientacion, direccionX, direccionY);
		this.setTamanio(3);
		this.setResistencia(2);
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
	}


}
