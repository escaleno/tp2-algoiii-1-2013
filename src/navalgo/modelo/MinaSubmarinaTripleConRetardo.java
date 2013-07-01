package navalgo.modelo;

public class MinaSubmarinaTripleConRetardo extends MinaSubmarinaConAlcance {
	public static int COSTO = 125;
	public MinaSubmarinaTripleConRetardo(Punto posicion, Tablero tablero){
		super(posicion, 2, tablero);
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
