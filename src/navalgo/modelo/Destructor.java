package navalgo.modelo;

import java.util.ArrayList;

public class Destructor extends Barco {

	public Destructor(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		this.tamanio = 3;
		this.resistencia = 1;
		this.cuerpo = new ArrayList<Casilla>();
		this.construirCuerpo();

	}

	@Override
	public void asimilarDisparo(Disparo unDisparo) {
		// TODO Auto-generated method stub
		
	}

}
