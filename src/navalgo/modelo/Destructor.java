package navalgo.modelo;

public class Destructor extends Barco {

	/*
	 * constructor
	 */
	public Destructor(Punto posicion, Orientacion orientacion, int direccionX,  int direccionY) {
		super(posicion, orientacion, 3, 1, direccionX, direccionY);

	}



	public void recibirAtaque(MinaSubmarinaPorContacto unaMinaSubmarinaPorContacto) {
		for (Parte parte : this.getCuerpo()) {
			if (parte.getPosicion().equals(unaMinaSubmarinaPorContacto.getPosicion())){
				unaMinaSubmarinaPorContacto.marcarComoDetonado();
			}
		}
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
