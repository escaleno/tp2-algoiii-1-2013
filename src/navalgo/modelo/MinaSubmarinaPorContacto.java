package navalgo.modelo;

public class MinaSubmarinaPorContacto extends MinaSubmarina {

	public MinaSubmarinaPorContacto(Punto unaPosicion) {
		super(unaPosicion);
		this.costo = 150;
		this.alcance = 0;
		this.turnosRestantes = 0;
	}

}
