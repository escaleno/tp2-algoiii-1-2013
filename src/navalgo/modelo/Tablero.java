
package navalgo.modelo;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import navalgo.modelo.Barco;
import navalgo.modelo.Disparo;
import navalgo.vista.VentanaPrincipal;
import navalgo.vista.VistaParteDeBarco;

@SuppressWarnings("unused")
public class Tablero implements ObjetoVivo
{
	private ArrayList<Barco> listaBarcos;
	private ArrayList<Disparo> disparosEfectuados;
	ArrayList<Disparo> disparosRemover = new ArrayList<Disparo>();
	private ArrayList<Barco> barcosHundidos;
	private int filaFin;
	private int columnaFin;
	private int filaInicio;
	private int columnaInicio;
	private int contparaRealizarTurnos = 0;
	private VentanaPrincipal ventanaactual;
	private int puntos;
	private boolean perdido;
	private boolean ganado;
	
	public Tablero(int filaInicio, int filaFin,int columnaInicio, int columnaFin)
	{
		if ((filaFin>0)&&(columnaFin>0) && (filaInicio > 0) && (columnaInicio > 0))
		{	
			this.listaBarcos=new ArrayList<Barco>();
			this.disparosEfectuados=new ArrayList<Disparo>();
			this.barcosHundidos=new ArrayList<Barco>();
			this.disparosRemover=new ArrayList<Disparo>();
			this.filaFin=filaFin;
			this.columnaFin=columnaFin;
			this.filaInicio = filaInicio;
			this.columnaInicio = columnaInicio;
			this.puntos=10000;
			this.perdido=false;
			this.ganado=false;
		}
	}
	
	public int obtenerMaximaDeFilas(){
		return (this.filaFin-this.filaInicio+1);
	}
	
	public int obtenerMaximaDeColumnas(){
		return (this.columnaFin-this.columnaInicio+1);
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
		
		for(Barco unBarco:listaBarcos)
		{
			unBarco.mover();
		}
		
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
			
			disparoactual.restarUnTurno();
			this.descontarPuntosPorDisparoParaTest(disparoactual);
			if (disparoactual.detonado())
			{
				disparosRemover.add(disparoactual);
			}
		}
		
		
		listaBarcos.removeAll(barcosHundidos);
		disparosEfectuados.removeAll(disparosRemover);	
	}
	
	public void ejecutarTurnoParaTest()
	{
		
		for(Barco unBarco:listaBarcos)
		{
			unBarco.mover();
		}
		
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
			
			disparoactual.restarUnTurno();
			this.descontarPuntosPorDisparoParaTest(disparoactual);
			if (disparoactual.detonado())
			{
				disparosRemover.add(disparoactual);
			}
		}
		
		
		listaBarcos.removeAll(barcosHundidos);
		disparosEfectuados.removeAll(disparosRemover);	
	}
	
	
	public ArrayList<Barco> getBarcos()
	{
		return listaBarcos;
	}
	
	public ArrayList<Disparo> getDisparos()
	{
		return disparosEfectuados;
	}
	
	public ArrayList<Disparo> getDisparosDetonados(){
		return disparosRemover;
	}
	
	public ArrayList<Barco> getDestruidos()
	{
		return barcosHundidos;
	}
	
	public int getFinDeFilas()
	{
		return filaFin;
	}

	public int getFinDeColumnas()
	{
		return columnaFin;
	}
	
	public int getInicioDeFilas(){
		
		return this.filaInicio;
	}
	
	public int getInicioDeColumnas(){
		
		return this.columnaInicio;
	}
	

	public void vivir(){
		if(contparaRealizarTurnos == 4){
			this.ejecutarTurno();
			this.contparaRealizarTurnos = 0;
		} else {
			this.contparaRealizarTurnos++;
		}
	}
	
	public void descontarPuntosPorDisparoParaTest(Disparo disparoEjecutado) 
	{
		if((puntos-disparoEjecutado.getCosto())>=0)
		{
			if (disparoEjecutado.getCosto()==disparoEjecutado.getCostoInicial())
			{	
				puntos-=disparoEjecutado.getCosto();
				ventanaactual.obtenerEtiquetaPuntaje().setText("Puntaje: "+ this.getPuntos());
			}         
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
		
	public void ligarAVentanaPrincipal(VentanaPrincipal ventana)
	{
		this.ventanaactual=ventana;
	}

	public void descontarPuntosPorDisparoParaTest(DisparoConvencional disparo) 
	{
		if(puntos-disparo.getCosto()>=0)
		{
			if (disparo.getCosto()==disparo.getCostoInicial())
			{	
				puntos-=disparo.getCosto();
			}
			
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
}
