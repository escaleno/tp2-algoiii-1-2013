
package navalgo.modelo;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Iterator;

import javax.swing.JPanel;

import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import navalgo.modelo.Barco;
import navalgo.modelo.Disparo;
import navalgo.vista.VistaParteDeBarco;

@SuppressWarnings("unused")
public class Tablero implements ObjetoVivo
{
	private ArrayList<Barco> listaBarcos;
	private ArrayList<Disparo> disparosEfectuados;
	ArrayList<Disparo> disparosRemover = new ArrayList<Disparo>();
	private ArrayList<Barco> barcosHundidos;
	private int cantidadFilas;
	private int cantidadColumnas;
	private int cantidadMinimaDeFilas;
	private int cantidadMinimaDeColumnas;
	private int contparaRealizarTurnos = 0;
	private int puntos;
	private boolean perdido;
	private boolean ganado;
	private GameLoop game;
	
	public Tablero(int nf, int nc, int minimoFilas, int minimoColumnas)
	{
		if ((nf>0)&&(nc>0) && (minimoFilas > 0) && (minimoColumnas > 0))
		{	
			listaBarcos=new ArrayList<Barco>();
			disparosEfectuados=new ArrayList<Disparo>();
			barcosHundidos=new ArrayList<Barco>();
			cantidadFilas=nf;
			cantidadColumnas=nc;
			this.cantidadMinimaDeFilas = minimoFilas;
			this.cantidadMinimaDeColumnas = minimoColumnas;
			puntos=10000;
			perdido=false;
			ganado=false;
		}
	}
	
	public Tablero(int nf, int nc, int minimoFilas, int minimoColumnas , GameLoop game)
	{
		this(nf,nc,minimoFilas,minimoColumnas);
		this.game = game;
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
					barcosHundidos.add(barcodestruido);					
				}			
			}
			this.descontarPuntosPorDisparo(disparoactual);
			if (disparoactual.detonado())
			{
				disparosRemover.add(disparoactual);
			}
		}
		
		for(Barco unBarco:listaBarcos)
		{
			unBarco.mover();
		}
		if (game != null) {
			for (Disparo disp : disparosRemover){
				game.remover(disp);
			}
		
			for (Barco barco : barcosHundidos) {
				for (Parte parte : barco.getCuerpo()) {
					VistaParteDeBarco vPdB;
					try {
						vPdB = new VistaParteDeBarco(parte);
						game.remover(vPdB);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}
		listaBarcos.removeAll(barcosHundidos);
		disparosEfectuados.removeAll(disparosRemover);
		disparosRemover.clear();	
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
	
	public int getCantidadFilas()
	{
		return cantidadFilas;
	}

	public int getCantidadColumnas()
	{
		return cantidadColumnas;
	}
	
	public int getCantidadMinimaDeFilas(){
		
		return this.cantidadMinimaDeFilas;
	}
	
	public int getCantidadMinimaDeColumnas(){
		
		return this.cantidadMinimaDeColumnas;
	}
	

	public void vivir(){
		if(contparaRealizarTurnos == 4){
			this.ejecutarTurno();
			this.contparaRealizarTurnos = 0;
		} else {
			this.contparaRealizarTurnos++;
		}
	}
	
	public void descontarPuntosPorDisparo(Disparo disparoEjecutado)
	{
		if(puntos-disparoEjecutado.getCosto()>=0)
		{
			puntos-=disparoEjecutado.getCosto();
			if ((puntos>0)&&(this.getBarcos().size()==0))
			{
				this.CambiarAGanado();
			}
		}
		else
		{
			if (this.listaBarcos.size()>0)
			{
				CambiarAPerdido();
			}
		}
	}
	
	public int getPuntos()
	{
		return puntos;
	}

	public boolean estaPerdido() {
		return perdido;
	}

	public void CambiarAPerdido() {
		this.perdido = true;
	}
	
	public boolean estaGanado()
	{
		return ganado; 
	}
	
	public void CambiarAGanado()
	{
		ganado=true;
	}
	
	//lo uso para setear la condicion de ganado
	public void moverBarcosAListadoDeHundidos()
	{
		listaBarcos.removeAll(listaBarcos);
		this.CambiarAGanado();
	}
}
