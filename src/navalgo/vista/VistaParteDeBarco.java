package navalgo.vista;

import java.io.IOException;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import navalgo.dibujables.ImagensParteBarcos;
import navalgo.modelo.Parte;

public class VistaParteDeBarco extends ImagensParteBarcos{
	Parte parteDeBarco;
	public VistaParteDeBarco(Parte parteDeBarco) throws IOException {
		super(parteDeBarco.getNomber(), parteDeBarco.getPosicion());
		this.parteDeBarco = parteDeBarco;
	}
	
	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		this.setEstado(parteDeBarco.getEstado());
		super.dibujar(superficieDeDibujo);
	}
}
