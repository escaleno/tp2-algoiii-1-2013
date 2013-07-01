package navalgo.modelo;

public class DisparoConvencional extends Disparo {
	public static int COSTO = 200;
	public DisparoConvencional(Punto unaPosicion){
		super (unaPosicion);
		this.costo = COSTO;
		this.costoInicial = COSTO;
		this.turnosRestantes = 0;
		this.alcance = 0;
		this.detonado=false;
		this.cambioTurno=true;//lo seteo asi para no alterar el funcionamiento, ya que funciona bien y se descuenta 1 sola vez
	}

	
	public void atacar(Barco unBarco) 
	{
		unBarco.recibirAtaque(this);
		this.marcarComoDetonado();
		
	}

}
