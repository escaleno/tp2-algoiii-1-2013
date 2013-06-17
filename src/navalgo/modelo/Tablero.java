
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
	private int cantidadFilas;
	private int cantidadColumnas;
	
	public Tablero(int nf, int nc)
	{
		if ((nf>0)&&(nc>0))
		{	
			listaBarcos=new ArrayList<Barco>();
			disparosEfectuados=new ArrayList<Disparo>();
			barcosHundidos=new ArrayList<Barco>();
			cantidadFilas=nf;
			cantidadColumnas=nc;
		}
	}
	
	public void agregarBarco(Barco b)
	{
		listaBarcos.add(b);
	}
	
	public void agregarDisparo(Disparo d)
	{
		disparosEfectuados.add(d);
	}
	
	public void ejecutarTurno()
	{
		for(Disparo disparoactual:disparosEfectuados)
		{	
			for(Barco unBarco:listaBarcos)
			{	
				disparoactual.atacar(unBarco);
				if(unBarco.estaDestruido())
				{
					Barco barcodestruido=unBarco;
					this.getBarcos().remove(unBarco);
					barcosHundidos.add(barcodestruido);					
				}
				else
				{
					unBarco.mover();
				}			
			}
		}
		//this.borrarDisparosExplotados();		
	}

/*		for(Barco barco:listaBarcos)
		{	
			if(barco.estaDestruido())
			{
				this.getBarcos().remove(barco);
				barcosHundidos.add(barco);
			}
			else
			{
				barco.mover();
			}
		}*/
	
	
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
	
	public int getCantidadFilas()
	{
		return cantidadFilas;
	}

	public int getCantidadColumnas()
	{
		return cantidadColumnas;
	}
	
	private void borrarDisparosExplotados()
	{
		if (disparosEfectuados.size()>0)
		{	
			ArrayList<Disparo> listadisparos=this.getDisparos();
			Iterator<Disparo> iteradorDisparos=listadisparos.iterator();
			/*for(Disparo disparoactual:listadisparos)
			{*/
			while (iteradorDisparos.hasNext())
			{	
				Disparo disparoactual=iteradorDisparos.next();
				if (disparoactual.detonado())
				{
					disparosEfectuados.remove(disparoactual);
				}
			}
			//}
		}
	}
}
