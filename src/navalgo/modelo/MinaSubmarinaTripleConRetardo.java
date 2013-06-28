package navalgo.modelo;

public class MinaSubmarinaTripleConRetardo extends MinaSubmarinaConAlcance {
	
	public MinaSubmarinaTripleConRetardo(Punto posicion, Tablero tablero){
		super(posicion, 2, tablero);
		this.costo = 125;
		this.costoInicial = 125;
		this.turnosRestantes = 3;
		this.detonado=false;
		this.cambioTurno=false;
	}


	public void atacar(Barco unBarco) 
	{
		unBarco.recibirAtaque(this);

	}

}
