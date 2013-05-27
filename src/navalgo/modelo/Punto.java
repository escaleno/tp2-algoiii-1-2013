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
	
	/*public double distancia (Punto otro)
	{
		double d=0;
		double t1=0;
		double t2=0;
		double t3=0;
		t1=Math.pow((otro.x) - (this.x),2);
		t2=Math.pow((otro.y) - (this.y),2);
		t3=t1+t2;
		d=Math.sqrt(t3);
		return d;
	}
	
	public boolean EsIgual(Punto otro)
	{
		boolean resultado=false;
		resultado=((this.getX()==otro.getX())&&(this.getY()==otro.getY()));
		return resultado;
	}
	
	public Punto Sumar(int dx,int dy)
	{
		Punto resultado=null;
		resultado=new Punto(this.getX()+ dx, this.getY()+ dy);
		return resultado;
	}
		
	public void Sumar(Punto otro)
	{
		this.setX(this.getX() + otro.getX());
		this.setY(this.getY() + otro.getY());
	};
	
	public void resetearX()
	{
		this.setX(1);
	}
	
	public void resetearY()
	{
		this.setY(1);
	}
	
	public void incrementarX()
	{
		this.Sumar(1,0);
	}
	
	public void IncrementarY()
	{
		this.Sumar(0, 1);
	}*/
};
