package navalgo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import navalgo.vista.VentanaPrincipal;

public class EscuchaMinaSubmarinaTripleConRetardo implements ActionListener {

	private VentanaPrincipal vp;
	
	public EscuchaMinaSubmarinaTripleConRetardo(VentanaPrincipal vpInicial){
		
		this.vp=vpInicial;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.vp.habilitarTodos();
		this.vp.cambiarTipoDeDisparo(5);
		this.vp.deshabilitarbotonMinaSubConRetAlcTriple();
	}

}