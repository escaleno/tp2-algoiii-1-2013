package navalgo.modelo;

public class Punto 
{
	/*coordenadas en (x,y)*/
	private int x;
	private int y;
	
	public int getX() 
	{
		return this.x;
	}
	
	public void setX(int unx)
	{
		this.x = unx;
	}
	
	public void setY(int uny)
	{
		this.y= uny;
	}

	public int getY() 
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
		return ( (this.x == otroPunto.getX()) && (this.y == otroPunto.getY()) );
	}

};
