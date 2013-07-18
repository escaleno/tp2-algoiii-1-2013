package navalgo.modelo;

public class MinaSubmarinaPuntualConRetardo extends Disparo {
	public static int COSTO = 50;
	public MinaSubmarinaPuntualConRetardo(Punto unaPosicion) {
		super(unaPosicion);
		this.inicializarCosto(COSTO);
		this.alcance = 0;
		this.turnosRestantes = 3;
	}

	
	public void atacar(Barco unBarco) 
	{
		unBarco.recibirAtaque(this);
	}

}
