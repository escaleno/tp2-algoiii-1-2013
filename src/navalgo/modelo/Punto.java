package navalgo.modelo;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class Punto implements ObjetoPosicionable
{
	/*coordenadas en (x,y)*/
	private int x;
	private int y;
	
	public int obtenerX() 
	{
		return this.x;
	}
	
	public void ponerX(int unx)
	{
		this.x = unx;
	}
	
	public void ponerY(int uny)
	{
		this.y= uny;
	}

	public int obtenerY() 
	{
		return this.y;
	}
	
	public void incrementarEnX(){
		this.x++;
	}
	
	public void incrementarEnY(){
		this.y++;
	}
	
	public void decrementarEnX(){
		this.x--;
	}
	
	public void decrementarEnY(){
		this.y--;
	}
	
	
	/*Constructor*/
	public Punto(int cx, int cy)
	{
		this.x=cx;
		this.y=cy;
	}
	
	public boolean equals(Object obj){
		Punto otroPunto = (Punto) obj;
		return ( (this.x == otroPunto.obtenerX()) && (this.y == otroPunto.obtenerY()) );
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 50*(this.x-1);
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 50*(this.y-1);
	}

};
