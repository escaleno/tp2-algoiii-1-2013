package navalgo.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fiuba.algo3.titiritero.modelo.GameLoop;

import navalgo.modelo.Disparo;
import navalgo.modelo.DisparoConvencional;
import navalgo.modelo.MinaSubmarinaDobleConRetardo;
import navalgo.modelo.MinaSubmarinaPorContacto;
import navalgo.modelo.MinaSubmarinaPuntualConRetardo;
import navalgo.modelo.MinaSubmarinaTripleConRetardo;
import navalgo.modelo.Punto;
import navalgo.modelo.Tablero;
import navalgo.vista.VentanaPrincipal;

public class ControladorDeMouse extends MouseAdapter {
	VentanaPrincipal vp;
	public ControladorDeMouse(VentanaPrincipal vp){
		this.vp = vp;
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		this.vp.habilitarTodos();
		Disparo disparo = null;
		GameLoop game = this.vp.obtenerGameLoop();
		Tablero tablero = this.vp.obtenerTablero();
		int x = ((event.getX()/this.vp.obtenerTamanioDeCasillaX()) +1);
		int y = ((event.getY()/this.vp.obtenerTamanioDeCasillaY()) +1);
		switch (this.vp.obtenerTipoDeDisparo()) {
		case 1:
			if (tablero.getPuntos()>=DisparoConvencional.COSTO)
				disparo = new DisparoConvencional(new Punto(x, y));
			break;
		case 2:
			if (tablero.getPuntos()>=MinaSubmarinaPorContacto.COSTO)
				disparo = new MinaSubmarinaPorContacto(new Punto(x, y));
			break;
		case 3:
			if (tablero.getPuntos()>=MinaSubmarinaPuntualConRetardo.COSTO)
				disparo = new MinaSubmarinaPuntualConRetardo(new Punto(x, y));
			break;
		case 4:
			if (tablero.getPuntos()>=MinaSubmarinaDobleConRetardo.COSTO)
				disparo = new MinaSubmarinaDobleConRetardo(new Punto(x, y),tablero);
			break;
		case 5:
			if (tablero.getPuntos()>=MinaSubmarinaTripleConRetardo.COSTO)
				disparo = new MinaSubmarinaTripleConRetardo(new Punto(x, y),tablero);
			break;
		default:
			break;
		}
		this.vp.cambiarTipoDeDisparo(0);
		if (disparo != null){
				tablero.agregarDisparo(disparo);
				game.agregar(disparo);
				//Cambiar despues por Vista de Disparos
				this.vp.obtenerControlDeTablero().agregarMapaDeVistasDeDisparos(disparo, disparo); 
		}
	}
}
