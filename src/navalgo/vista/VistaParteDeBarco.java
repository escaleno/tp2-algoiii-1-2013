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
	
	public Parte getParteDeBarco(){
		return this.parteDeBarco;
	}
//Sobre Escribi los metodos Para poder borrar los objetos Dibujables del Framwork
	public boolean equals( Object vParteDeBarco ){
		return (vParteDeBarco instanceof VistaParteDeBarco &&
		 this.parteDeBarco.equals(((VistaParteDeBarco)vParteDeBarco).getParteDeBarco()));
	}
	
	public int hashCode(){
		return this.parteDeBarco.hashCode();
	}

}
