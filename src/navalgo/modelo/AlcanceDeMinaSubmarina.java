package navalgo.modelo;

public class AlcanceDeMinaSubmarina extends Disparo {

	public AlcanceDeMinaSubmarina(Punto unaPosicion) {
		super(unaPosicion);
		this.costo = 0;
		this.alcance = 0;
		this.turnosRestantes = 0;
	}

	public void atacar(Barco unBarco) {
		unBarco.recibirAtaque(this);

	}

}
