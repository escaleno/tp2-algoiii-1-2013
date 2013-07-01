package navalgo.modelo;

public class MinaSubmarinaDobleConRetardo extends MinaSubmarinaConAlcance {
	public static int COSTO = 100;
	public MinaSubmarinaDobleConRetardo(Punto unaPosicion, Tablero tablero) {
		super(unaPosicion, 1, tablero);
		this.costo = COSTO;
		this.costoInicial = COSTO;
		this.turnosRestantes = 3;
		this.detonado=false;
		this.cambioTurno=false;
	}

	public void atacar(Barco unBarco) 
	{
		unBarco.recibirAtaque(this);
	}

}
