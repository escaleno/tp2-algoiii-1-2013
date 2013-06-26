package navalgo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import navalgo.vista.VentanaPrincipal;
import fiuba.algo3.titiritero.modelo.GameLoop;

public class EscuchaMinaSubmarinaPorContacto implements ActionListener {

	private VentanaPrincipal vp;
	
	public EscuchaMinaSubmarinaPorContacto(VentanaPrincipal vpInicial){
		
		this.vp=vpInicial;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.vp.habilitarTodos();
		this.vp.cambiarTipoDeDisparo(2);
		this.vp.deshabilitarbotonMinaSubXContacto();
	}

}