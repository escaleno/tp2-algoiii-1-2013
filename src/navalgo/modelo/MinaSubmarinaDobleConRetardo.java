package navalgo.modelo;

public class MinaSubmarinaDobleConRetardo extends MinaSubmarinaConAlcance {

	public MinaSubmarinaDobleConRetardo(Punto unaPosicion) {
		super(unaPosicion);
		this.costo = 100;
		this.alcance = 1;
		this.turnosRestantes = 3;
		for (int i = this.posicion.getX() -1; i <= this.posicion.getX() +1; i++) {
			for (int j = this.posicion.getY() -1; j <= this.posicion.getY() +1; j++) {
				//if( ( (i >= 1) || (i <= 10) ) && ( (j >=1) || (j <= 10) )){
				if( ( (i >= 1) || (i <= 10) ) && ( (j >=1) || (j <= 10) ) && ( (i != this.posicion.getX() ) && ( j != this.posicion.getY() )) ){
					System.out.println(i);
					System.out.println(j);
					Punto unPunto = new Punto(i, j);
					puntosDeAlcance.add(unPunto);
				}
				
			}
		}
	}

	
	public void atacar(Barco unBarco) {
		//unBarco.recibirAtaque(this);
	}

}
