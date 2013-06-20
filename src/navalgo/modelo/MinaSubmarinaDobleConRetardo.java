package navalgo.modelo;

public class MinaSubmarinaDobleConRetardo extends MinaSubmarinaConAlcance {
	
	public MinaSubmarinaDobleConRetardo(Punto unaPosicion, Tablero tablero) {
		super(unaPosicion, 1, tablero);
		this.costo = 100;
		this.turnosRestantes = 3;
		this.detonado=false;
	}

	public void atacar(Barco unBarco) 
	{
		this.chequearDetonacion();
		unBarco.recibirAtaque(this);
	}

}
