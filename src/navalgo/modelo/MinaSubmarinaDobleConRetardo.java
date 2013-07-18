package navalgo.modelo;

public class MinaSubmarinaDobleConRetardo extends MinaSubmarinaConAlcance {
	public static int COSTO = 100;
	public MinaSubmarinaDobleConRetardo(Punto unaPosicion, Tablero tablero) {
		super(unaPosicion, 1, tablero);
		this.inicializarCosto(COSTO);
		this.turnosRestantes = 3;

	}

	public void atacar(Barco unBarco) 
	{
		unBarco.recibirAtaque(this);
	}

}
