package navalgo.modelo;

public class MinaSubmarinaPuntualConRetardo extends Disparo {
	public static int COSTO = 50;
	public MinaSubmarinaPuntualConRetardo(Punto unaPosicion) {
		super(unaPosicion);
		this.costo = COSTO;
		this.costoInicial = COSTO;
		this.alcance = 0;
		this.turnosRestantes = 3;
		this.detonado=false;
		this.cambioTurno=false;
	}

	
	public void atacar(Barco unBarco) 
	{
		unBarco.recibirAtaque(this);
	}

}
