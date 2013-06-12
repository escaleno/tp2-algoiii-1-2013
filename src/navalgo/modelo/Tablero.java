
package navalgo.modelo;
import java.util.ArrayList;
import java.util.Iterator;
import navalgo.modelo.Barco;
import navalgo.modelo.Disparo;

public class Tablero 
{
	private ArrayList<Barco> listaBarcos;
	private ArrayList<Disparo> disparosEfectuados;
	private ArrayList<Barco> barcosHundidos;
	
	public Tablero()
	{
		listaBarcos=new ArrayList<Barco>();
		disparosEfectuados=new ArrayList<Disparo>();
		barcosHundidos=new ArrayList<Barco>();
	}
	
	public void agregarBarco(Rompehielos b)
	{
		listaBarcos.add(b);
	}
	public void agregarBarco(Lancha b)
	{
		listaBarcos.add(b);
	}
	public void agregarBarco(Buque b)
	{
		listaBarcos.add(b);
	}
	
	public void agregarBarco(Destructor b)
	{
		listaBarcos.add(b);
	}

	public void agregarBarco(Portaavion b)
	{
		listaBarcos.add(b);
	}

	
	public void agregarDisparo(MinaSubmarinaPorContacto d)
	{
		disparosEfectuados.add(d);
	}
	
	public void agregarDisparo(DisparoConvencional d)
	{
		disparosEfectuados.add(d);
	}	
	
	public void agregarDisparo(MinaSubmarinaPuntualConRetardo d)
	{
		disparosEfectuados.add(d);
	}
	
	public void agregarDisparo(MinaSubmarinaDobleConRetardo d)
	{
		disparosEfectuados.add(d);
	}
	
	public void ejecutarTurno()
	{
		Iterator<Disparo> iteradorDisparos=disparosEfectuados.iterator();
		while (iteradorDisparos.hasNext())
		{	
			Disparo disparoactual=iteradorDisparos.next();
			Iterator<Barco> iteradorBarcos=listaBarcos.iterator();
			while(iteradorBarcos.hasNext())
			{	
				Barco unBarco=iteradorBarcos.next();
				disparoactual.atacar(unBarco);
			}
			
		}
		Iterator<Barco> iteradorBarcos=listaBarcos.iterator();
		while (iteradorBarcos.hasNext())
		{
			Barco unBarco=iteradorBarcos.next();
			if(unBarco.estaDestruido())
			{
				iteradorBarcos.remove();//remueve de la lista el elemento actual;
				barcosHundidos.add(unBarco);
			}
			else
			{
				unBarco.mover();
			}
		}
	}	
	
	public ArrayList<Barco> getBarcos()
	{
		return listaBarcos;
	}
	
	public ArrayList<Disparo> getDisparos()
	{
		return disparosEfectuados;
	}
	
	public ArrayList<Barco> getDestruidos()
	{
		return barcosHundidos;
	}
}
