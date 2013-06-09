package navalgo.modelo;

import java.util.ArrayList;

public class Destructor extends Barco {

	public Destructor(Punto unaPosicion, Orientacion unaOrientacion) {
		super(unaPosicion, unaOrientacion);
		this.setTamanio(3);
		this.setResistencia(1);
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();

	}
	
	public Destructor(){
		super();
		this.setTamanio(3);
		this.setResistencia(1);
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
	}
	
	public Destructor(Punto unaPosicion, Orientacion unaOrientacion, int direccionX,  int direccionY) {
		super(unaPosicion, unaOrientacion, direccionX, direccionY);
		this.setTamanio(3);
		this.setResistencia(1);
		this.cuerpo = new ArrayList<Parte>();
		this.construirCuerpo();
	}


	public void recibirAtaque(MinaSubmarinaPorContacto unaMinaSubmarinaPorContacto) {
		//no hace nada
		
	}


	public void recibirAtaque(MinaSubmarinaPuntualConRetardo unaMinaSubmarinaPuntualConRetardo) {
		//no hace nada
		
	}



	public void recibirAtaque(MinaSubmarinaDobleConRetardo unaMinaSubmarinaDobleConRetardo) {
		//no hace nada
		
	}
	
	public void recibirAtaque(MinaSubmarinaTripleConRetardo unaMinaSubmarinaTripleConRetardo){
		//no hace nada
	}

}
