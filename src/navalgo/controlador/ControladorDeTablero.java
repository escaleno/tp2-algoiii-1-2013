package navalgo.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import navalgo.modelo.Barco;
import navalgo.modelo.Disparo;
import navalgo.modelo.Tablero;
import navalgo.modelo.Parte;
import navalgo.vista.VentanaPrincipal;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObservadorDeGameLoop;

public class ControladorDeTablero implements ObservadorDeGameLoop {
	private Map<Parte,ObjetoDibujable> MapaDeVistasDePartes = new HashMap<Parte, ObjetoDibujable>();
	private Map<Disparo,ObjetoDibujable> MapaDeVistasDeDisparos = new HashMap<Disparo,ObjetoDibujable>();
	VentanaPrincipal vp;
	public ControladorDeTablero( VentanaPrincipal vp){
		this.vp = vp;
	}
	
	public void agregarMapaDeVistasDePartes(Parte parte, ObjetoDibujable vista){
		this.MapaDeVistasDePartes.put(parte, vista);
	}
	
	public void agregarMapaDeVistasDeDisparos(Disparo disparo, ObjetoDibujable vista){
		this.MapaDeVistasDeDisparos.put(disparo, vista);
	}
	
	@Override
	public void notificarCicloFinalizado() {
		Tablero tablero = this.vp.obtenerTablero();
		GameLoop gameLoop = this.vp.obtenerGameLoop();
		ArrayList<Barco> listaBarco = tablero.getDestruidos();
		for(Barco barco : listaBarco){
			for(Parte parte: barco.getCuerpo()){
				ObjetoDibujable vista = MapaDeVistasDePartes.get(parte);
				if(vista!=null){
					gameLoop.remover(vista);
					MapaDeVistasDePartes.remove(parte);
				}
			}
		}
		
		ArrayList<Disparo> listaDisparo = tablero.getDisparosDetonados();
		for(Disparo disparo : listaDisparo){
			ObjetoDibujable vista = MapaDeVistasDeDisparos.get(disparo);
			if(vista!=null){
				gameLoop.remover(vista);
				MapaDeVistasDePartes.remove(disparo);
			}
		}
		listaDisparo.clear();
		
		this.vp.obtenerEtiquetaPuntaje().setText("Puntaje: "+ tablero.getPuntos());
		
		if (tablero.estaPerdido()) {
			JOptionPane.showMessageDialog(null, "Lamentablemente Usted Perdio");
			this.reiniciarTablero();
		} else if (tablero.estaGanado()) {
			JOptionPane.showMessageDialog(null, "Gano!!!!");
			this.reiniciarTablero();
		}
	}
	
	public void reiniciarTablero() {
		Tablero tablero = this.vp.obtenerTablero();
		GameLoop gameLoop = this.vp.obtenerGameLoop();
		tablero.reiniciarPuntos();
		for (ObjetoDibujable vista : MapaDeVistasDePartes.values()){
			gameLoop.remover(vista);
		}
		tablero.getBarcos().clear();
		tablero.getDestruidos().clear();
		
		for (ObjetoDibujable vista : MapaDeVistasDeDisparos.values()){
			gameLoop.remover(vista);
		}
		tablero.getDisparos().clear();
		tablero.getDisparosDetonados().clear();
		try {
			this.vp.generadorDeBarcos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
