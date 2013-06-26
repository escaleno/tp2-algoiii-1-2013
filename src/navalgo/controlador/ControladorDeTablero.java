package navalgo.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import navalgo.modelo.Barco;
import navalgo.modelo.Disparo;
import navalgo.modelo.Tablero;
import navalgo.modelo.Parte;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObservadorDeGameLoop;

public class ControladorDeTablero implements ObservadorDeGameLoop {
	private Map<Parte,ObjetoDibujable> MapaDeVistasDePartes = new HashMap<Parte, ObjetoDibujable>();
	private Map<Disparo,ObjetoDibujable> MapaDeVistasDeDisparos = new HashMap<Disparo,ObjetoDibujable>();
	Tablero tablero;
	GameLoop game;
	
	public ControladorDeTablero( Tablero tablero, GameLoop game){
		this.tablero = tablero;
		this.game = game;
	}
	
	public void agregarMapaDeVistasDePartes(Parte parte, ObjetoDibujable vista){
		this.MapaDeVistasDePartes.put(parte, vista);
	}
	
	public void agregarMapaDeVistasDeDisparos(Disparo disparo, ObjetoDibujable vista){
		this.MapaDeVistasDeDisparos.put(disparo, vista);
	}
	
	@Override
	public void notificarCicloFinalizado() {
		ArrayList<Barco> listaBarco = this.tablero.getDestruidos();
		for(Barco barco : listaBarco){
			for(Parte parte: barco.getCuerpo()){
				ObjetoDibujable vista = MapaDeVistasDePartes.get(parte);
				if(vista!=null){
					this.game.remover(vista);
					MapaDeVistasDePartes.remove(parte);
				}
			}
		}
		
		ArrayList<Disparo> listaDisparo = this.tablero.getDisparosDetonados();
		for(Disparo disparo : listaDisparo){
			ObjetoDibujable vista = MapaDeVistasDeDisparos.get(disparo);
			if(vista!=null){
				this.game.remover(vista);
				MapaDeVistasDePartes.remove(disparo);
			}
		}
		listaDisparo.clear();
	}

}
