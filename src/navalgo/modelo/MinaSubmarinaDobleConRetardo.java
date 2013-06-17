package navalgo.modelo;

public class MinaSubmarinaDobleConRetardo extends MinaSubmarinaConAlcance {

	public MinaSubmarinaDobleConRetardo(Punto unaPosicion) {
		super(unaPosicion);
		this.costo = 100;
		this.alcance = 1;
		this.turnosRestantes = 3;
		this.detonado=false;
		for (int i = this.posicion.getX() - this.alcance; i <= this.posicion.getX() + this.alcance; i++) {
			for (int j = this.posicion.getY() - this.alcance; j <= this.posicion.getY() + this.alcance; j++) {
			  if( ( (i >= 1) && (i <= 10) ) && ( (j >=1) && (j <= 10) ) && ( (i != this.posicion.getX() ) || ( j != this.posicion.getY() )) ){
					Punto unPunto = new Punto(i, j);
					puntosDeAlcance.add(unPunto);
				}
				
			}
		}
	}
	

	
	public void atacar(Barco unBarco) 
	{
		this.chequearDetonacion();
		unBarco.recibirAtaque(this);
	}

}
