package navalgo.modelo;

import java.util.ArrayList;

public class Buque extends Barco {

	public Buque(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		this.setTamanio(4);
		this.setResistencia(1);
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
	}
	
	public Buque() {
		super();
		this.setTamanio(4);
		this.setResistencia(1);
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
	}
	
	public Buque(Punto unaPosicion, Orientacion unaOrientacion, int direccionX,  int direccionY) {
		super(unaPosicion, unaOrientacion, direccionX, direccionY);
		this.setTamanio(4);
		this.setResistencia(1);
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
	}
	

	public boolean estaDestruido(){
		for(Parte unaCasilla : cuerpo){
			if(unaCasilla.estaDestruida()){
				return true;
			}
		}
		return false;
	}
	
}
