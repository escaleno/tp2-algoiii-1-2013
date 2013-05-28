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
	
	/*Constructor*/
	public Punto(int cx, int cy)
	{
		this.x=cx;
		this.y=cy;
	}

};
