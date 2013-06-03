package navalgo.modelo;

public class MinaSubmarinaPorContacto extends Disparo {

	public MinaSubmarinaPorContacto(Punto unaPosicion) {
		super(unaPosicion);
		this.costo = 150;
		this.alcance = 0;
		this.turnosRestantes = 0;
	}

	
	public void atacar(Barco unBarco) {
		unBarco.recibirAtaque(this);
		
	}

}
