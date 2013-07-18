package navalgo.modelo;

public class MinaSubmarinaPorContacto extends Disparo {
	public static int COSTO = 150;
	public MinaSubmarinaPorContacto(Punto unaPosicion) {
		super(unaPosicion);
		this.inicializarCosto(COSTO);
		this.alcance = 0;
		this.turnosRestantes = 0;
	}

	
	public void atacar(Barco unBarco) 
	{
		unBarco.recibirAtaque(this);
		
	}

}
