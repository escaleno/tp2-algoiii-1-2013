package navalgo.modelo;

public class Buque extends Barco {
	
	public Buque(Punto unaPosicion, Orientacion unaOrientacion, int direccionX,  int direccionY) {
		super(unaPosicion, unaOrientacion, 4, 1, direccionX, direccionY);
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
