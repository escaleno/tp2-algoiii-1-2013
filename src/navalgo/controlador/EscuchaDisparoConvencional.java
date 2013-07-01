package navalgo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import navalgo.vista.VentanaPrincipal;

public class EscuchaDisparoConvencional implements ActionListener {

	private VentanaPrincipal vp;
	
	public EscuchaDisparoConvencional(VentanaPrincipal vpInicial){
		
		this.vp=vpInicial;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.vp.habilitarTodos();
		this.vp.cambiarTipoDeDisparo(1);
		this.vp.deshabilitarbotonDispConvencional();
	}

}