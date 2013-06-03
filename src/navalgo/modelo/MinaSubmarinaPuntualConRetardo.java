package navalgo.modelo;

public class MinaSubmarinaPuntualConRetardo extends Disparo {

	public MinaSubmarinaPuntualConRetardo(Punto unaPosicion) {
		super(unaPosicion);
		this.costo = 50;
		this.alcance = 0;
		this.turnosRestantes = 3;
	}

	
	public void atacar(Barco unBarco) {
		unBarco.recibirAtaque(this);
		

	}

}
