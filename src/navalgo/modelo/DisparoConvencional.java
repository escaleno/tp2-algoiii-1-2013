package navalgo.modelo;

public class DisparoConvencional extends Disparo {

	public DisparoConvencional(Punto unaPosicion){
		super (unaPosicion);
		this.costo = 200;
		this.turnosRestantes = 0;
		this.alcance = 0;
	}

}
