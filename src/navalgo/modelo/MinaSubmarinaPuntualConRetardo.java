package navalgo.modelo;

public class MinaSubmarinaPuntualConRetardo extends Disparo {

	public MinaSubmarinaPuntualConRetardo(Punto unaPosicion) {
		super(unaPosicion);
		this.costo = 50;
		this.costoInicial = 50;
		this.alcance = 0;
		this.turnosRestantes = 3;
		this.detonado=false;
	}

	
	public void atacar(Barco unBarco) 
	{
		unBarco.recibirAtaque(this);
	}

}
