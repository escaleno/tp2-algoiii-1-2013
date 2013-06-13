package navalgo.modelo;

import java.util.ArrayList;

public class Portaavion extends Barco {

	public Portaavion(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		this.setTamanio(5);
		this.setResistencia(1);
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
	}
	
	public Portaavion(Punto unaPosicion, Orientacion unaOrientacion, int direccionX,  int direccionY) {
		super(unaPosicion, unaOrientacion, direccionX, direccionY);
		this.setTamanio(5);
		this.setResistencia(1);
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
	}

	


}
