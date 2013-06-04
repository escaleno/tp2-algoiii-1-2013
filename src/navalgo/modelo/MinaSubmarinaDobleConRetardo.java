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
	}

}
