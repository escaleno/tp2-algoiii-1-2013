package navalgo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import navalgo.vista.VentanaPrincipal;
import fiuba.algo3.titiritero.modelo.GameLoop;

public class EscuchaMinaSubmarinaDobleConRetardo implements ActionListener {

	private GameLoop gameLoop;
	private VentanaPrincipal vp;
	
	public EscuchaMinaSubmarinaDobleConRetardo(VentanaPrincipal vpInicial){
		
		this.vp=vpInicial;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
//		gameLoop = vp.getGameLoop();
//		gameLoop.detenerEjecucion();
		System.out.println("MinaSubmarinaDobleConRetardo...");
		
	}

}