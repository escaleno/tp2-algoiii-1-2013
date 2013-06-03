package navalgo.modelo;

public class MinaSubmarinaDobleConRetardo extends MinaSubmarinaConAlcance {

	public MinaSubmarinaDobleConRetardo(Punto unaPosicion) {
		super(unaPosicion);
		this.costo = 100;
		this.alcance = 1;
		this.turnosRestantes = 3;
	}

	
	public void atacar(Barco unBarco) {
		unBarco.recibirAtaque(this);
		Punto posicion;
		if( (this.posicion.getX() == 1) || (this.posicion.getY() == 1) || (this.posicion.getX() == 10) || (this.posicion.getY() == 10) ){
			if( (this.posicion.getX() == 1) && (this.posicion.getY() == 1) ){
				posicion = new Punto(2, 1);
				this.agregarMinaDeAlcanceSubmarina(posicion);
				posicion = new Punto(2, 2);
				this.agregarMinaDeAlcanceSubmarina(posicion);
				posicion = new Punto(1, 2);
				this.agregarMinaDeAlcanceSubmarina(posicion);
			}
			if( (this.posicion.getX() == 10) && (this.posicion.getY() == 1) ){
				posicion = new Punto(9, 1);
				this.agregarMinaDeAlcanceSubmarina(posicion);
				posicion = new Punto(9, 2);
				this.agregarMinaDeAlcanceSubmarina(posicion);
				posicion = new Punto(10, 2);
				this.agregarMinaDeAlcanceSubmarina(posicion);
			}
			if( (this.posicion.getX() == 1) && (this.posicion.getY() == 10) ){
				posicion = new Punto(1, 9);
				this.agregarMinaDeAlcanceSubmarina(posicion);
				posicion = new Punto(2, 9);
				this.agregarMinaDeAlcanceSubmarina(posicion);
				posicion = new Punto(2, 10);
				this.agregarMinaDeAlcanceSubmarina(posicion);
			}
			if( (this.posicion.getX() == 10) && (this.posicion.getY() == 10) ){
				posicion = new Punto(10, 9);
				this.agregarMinaDeAlcanceSubmarina(posicion);
				posicion = new Punto(9, 9);
				this.agregarMinaDeAlcanceSubmarina(posicion);
				posicion = new Punto(9, 10);
				this.agregarMinaDeAlcanceSubmarina(posicion);
			}

			if( (this.posicion.getY() == 1) && (this.posicion.getX() > 1) && (this.posicion.getX() < 10) ){
				posicion = new Punto(this.posicion.getX() +1, this.posicion.getY());
				posicion = new Punto(this.posicion.getX() +1, this.posicion.getY() +1);
				posicion = new Punto(this.posicion.getX(),this.posicion.getY()+1);
				posicion = new Punto(this.posicion.getX() -1, this.posicion.getY() +1);
				posicion = new Punto(this.posicion.getX() -1, this.posicion.getY());
				this.agregarMinaDeAlcanceSubmarina(posicion);
			}
		}
		

	}

}
