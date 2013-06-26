package navalgo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import navalgo.vista.VentanaPrincipal;
import fiuba.algo3.titiritero.modelo.GameLoop;

public class EscuchaMinaSubmarinaPuntualConRetardo implements ActionListener {

	private VentanaPrincipal vp;
	
	public EscuchaMinaSubmarinaPuntualConRetardo(VentanaPrincipal vpInicial){
		
		this.vp=vpInicial;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.vp.habilitarTodos();
		this.vp.cambiarTipoDeDisparo(3);
		this.vp.deshabilitarbotonMinaSubConRetAlc();
	}

}