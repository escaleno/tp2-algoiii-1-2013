package navalgo.modelo;

public class MinaDeAlcanceSubmarina extends Disparo {

	public MinaDeAlcanceSubmarina(Punto unaPosicion) {
		super(unaPosicion);
		this.costo = 0;
		this.alcance = 0;
		this.turnosRestantes = 0;
	}

	public void atacar(Barco unBarco) {
		unBarco.recibirAtaque(this);

	}

}
