package navalgo.modelo;

import java.io.IOException;

public class Parte extends MiImagen {
	
	/*representa la cantidad de disparos que soporta, cuando
	 * vale cero representa que fue totalmente destruida
	 */
	private int resistencia;
	
	private String nombre;
	/*
	 * representa su posicion (x,y) en el tablero
	 */
	private Punto posicion;
	
	
	/*constructor */
	public Parte(int resistencia, Punto posicion) throws IOException{
		super(Parte.class.getResource("/res/Nada.png"),posicion);
		//super(50,50, posicion);
		this.nombre = "Nada.png";
		this.resistencia = resistencia;
		this.posicion = posicion;
	}
	
	public Parte(int resistencia,Punto posicion, String nombre) throws IOException{
		super(Parte.class.getResource("/res/"+nombre), posicion);
		//super(50,50, posicion);
		this.nombre = nombre;
		this.resistencia = resistencia;
		this.posicion = posicion;
	}
	
	public int getResistencia(){
		
		return this.resistencia;
	}
	
	public void setResistencia(int nivelDeResistencia){
		
		this.resistencia = nivelDeResistencia;
		
	}
	
	public Punto getPosicion(){
		
		return this.posicion;
	}
	
	/*
	 * retorna true si la parte tiene resistencia cero
	 */
	public boolean estaDestruida() {
		return (this.resistencia == 0);
	}
	
	/*establece el danio realizado por el disparo*/
	public void asimilarDisparo(){
		if(this.resistencia > 0) {
			this.resistencia--;
		}
		//Valido Estado
		if (this.resistencia > 0)
		{
			try {
				this.setImagen(Parte.class.getResource("/res/Daniado/"+this.nombre));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				this.setImagen(Parte.class.getResource("/res/Hundido/"+this.nombre));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getX(){
		return posicion.obtenerX()*10;
	}
	
	public int getY(){
		return posicion.obtenerY()*10;
	}

}
	
