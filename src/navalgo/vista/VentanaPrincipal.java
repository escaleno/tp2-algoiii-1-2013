package navalgo.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import navalgo.controlador.*;
import navalgo.modelo.Barco;
import navalgo.modelo.Buque;
import navalgo.modelo.Destructor;
import navalgo.modelo.Disparo;
import navalgo.modelo.DisparoConvencional;
import navalgo.modelo.Lancha;
import navalgo.modelo.MinaSubmarinaDobleConRetardo;
import navalgo.modelo.MinaSubmarinaPorContacto;
import navalgo.modelo.MinaSubmarinaPuntualConRetardo;
import navalgo.modelo.MinaSubmarinaTripleConRetardo;
import navalgo.modelo.OrientacionHorizontal;
import navalgo.modelo.OrientacionVertical;
import navalgo.modelo.Parte;
import navalgo.modelo.Punto;
import navalgo.modelo.Rompehielos;
import navalgo.modelo.Tablero;
import fiuba.algo3.titiritero.modelo.*;
import fiuba.algo3.titiritero.dibujables.*;


public class VentanaPrincipal {

	private JFrame frame;
	private GameLoop gameLoop;
	private int tipoDeDisparo = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		VentanaPrincipal window = new VentanaPrincipal();
		window.gameLoop.iniciarEjecucion();
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaPrincipal window = new VentanaPrincipal();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame("Nabalgo");
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.setForeground(Color.blue);
		frame.setBounds(1,1, 620, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JButton btnDispConvencional = new JButton("Disparo Conviecional");
		final JButton btnMinaSubXContacto = new JButton("MinaSub. Por Contacto");
		final JButton btnMinaSubConRetAlc = new JButton("MinaSub. con Retardo");
		final JButton btnMinaSubConRetAlcDoble = new JButton("Mina con Ret. y Alc. 2");
		final JButton btnMinaSubConRetAlcTriple = new JButton("Mina con Ret. y Alc. 3");
		
		btnDispConvencional.setBounds(100, 565, 170, 25);
		btnMinaSubXContacto.setBounds(300, 565, 170, 25);
		btnMinaSubConRetAlc.setBounds(40, 610, 170, 25);
		btnMinaSubConRetAlcDoble.setBounds(215, 610, 170, 25);
		btnMinaSubConRetAlcTriple.setBounds(390, 610, 170, 25);
		
		btnDispConvencional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnDispConvencional.setEnabled(false);
				btnMinaSubXContacto.setEnabled(true);
				btnMinaSubConRetAlc.setEnabled(true);
				btnMinaSubConRetAlcDoble.setEnabled(true);
				btnMinaSubConRetAlcTriple.setEnabled(true);
				tipoDeDisparo = 1;
			}
		});
		
		btnMinaSubXContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDispConvencional.setEnabled(true);
				btnMinaSubXContacto.setEnabled(false);
				btnMinaSubConRetAlc.setEnabled(true);
				btnMinaSubConRetAlcDoble.setEnabled(true);
				btnMinaSubConRetAlcTriple.setEnabled(true);
				tipoDeDisparo = 2;
			}
		});
		
		btnMinaSubConRetAlc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDispConvencional.setEnabled(true);
				btnMinaSubXContacto.setEnabled(true);
				btnMinaSubConRetAlc.setEnabled(false);
				btnMinaSubConRetAlcDoble.setEnabled(true);
				btnMinaSubConRetAlcTriple.setEnabled(true);
				tipoDeDisparo = 3;
			}
		});
		
		btnMinaSubConRetAlcDoble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDispConvencional.setEnabled(true);
				btnMinaSubXContacto.setEnabled(true);
				btnMinaSubConRetAlc.setEnabled(true);
				btnMinaSubConRetAlcDoble.setEnabled(false);
				btnMinaSubConRetAlcTriple.setEnabled(true);
				tipoDeDisparo = 4;
			}
		});
		
		btnMinaSubConRetAlcTriple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDispConvencional.setEnabled(true);
				btnMinaSubXContacto.setEnabled(true);
				btnMinaSubConRetAlc.setEnabled(true);
				btnMinaSubConRetAlcDoble.setEnabled(true);
				btnMinaSubConRetAlcTriple.setEnabled(false);
				tipoDeDisparo = 5;
			}
		});
		final JPanel panel = new SuperficiePanel();
		
//		panel.setBackground(new Color(0, 0, 0));
		//FONDO DE LA SUPERFICIE DE DIBUJO
		panel.setBackground(Color.BLUE);
		
		//ubicacion y tamanio de la superficie de dibujo
		panel.setBounds(50, 50, 500, 500);
		frame.getContentPane().add(panel);
		int y = panel.getHeight()/10;
		int x = panel.getWidth()/10;
		this.gameLoop = new GameLoop(250,(SuperficieDeDibujo) panel);
		frame.getContentPane().add(btnDispConvencional);
		frame.getContentPane().add(btnMinaSubXContacto);
		frame.getContentPane().add(btnMinaSubConRetAlc);
		frame.getContentPane().add(btnMinaSubConRetAlcDoble);
		frame.getContentPane().add(btnMinaSubConRetAlcTriple);
		btnDispConvencional.setFocusable(true);
		btnMinaSubXContacto.setFocusable(true);
		btnMinaSubConRetAlc.setFocusable(true);
		btnMinaSubConRetAlcDoble.setFocusable(true);
		btnMinaSubConRetAlcTriple.setFocusable(true);
		btnDispConvencional.setVisible(true);
		btnMinaSubXContacto.setVisible(true);
		btnMinaSubConRetAlc.setVisible(true);
		btnMinaSubConRetAlcDoble.setVisible(true);
		btnMinaSubConRetAlcTriple.setVisible(true);
		//Hago lineas de X para diferenciar el tablero
		for (int tx = 1; tx < 10; tx++) {
			Posicion posicion = new Posicion(tx*x, 1);
			Figura linea = new Cuadrado(3, panel.getHeight(), posicion);
			this.gameLoop.agregar(linea);
		}
		//Hago lineas de Y para diferenciar el tablero
		for (int ty = 1; ty < 10; ty++) {
			Posicion posicion = new Posicion(1, ty*y);
			Figura linea = new Cuadrado(panel.getWidth(), 3, posicion);
			this.gameLoop.agregar(linea);
		}
		
		final Tablero tablero = new Tablero(10,10,1,1,this.gameLoop);
		this.gameLoop.agregar(tablero);
		Lancha unalancha = new Lancha(new Punto(1,1),new OrientacionHorizontal(),1,0);
		Buque unbuque = new Buque(new Punto(1,3),new OrientacionVertical(),0,1);;
		Destructor undestructor = new Destructor(new Punto(1,5),new OrientacionHorizontal(),1,1);
		Rompehielos unrompehielo = new Rompehielos(new Punto(2,1),new OrientacionVertical(),0,1);
		
		tablero.agregarBarco(unalancha);
		tablero.agregarBarco(unbuque);
		tablero.agregarBarco(undestructor);
		tablero.agregarBarco(unrompehielo);
		
				
		panel.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent event) {
				btnMinaSubXContacto.setEnabled(true);
				btnDispConvencional.setEnabled(true);
				btnMinaSubConRetAlc.setEnabled(true);
				btnMinaSubConRetAlcDoble.setEnabled(true);
				btnMinaSubConRetAlcTriple.setEnabled(true);
				Disparo disparo = null;
				int x = ((event.getX()/(panel.getWidth()/10)) +1);
				int y = ((event.getY()/(panel.getHeight()/10)) +1);
				switch (tipoDeDisparo) {
				case 1:
					disparo = new DisparoConvencional(new Punto(x, y));
					break;
				case 2:
					disparo = new MinaSubmarinaPorContacto(new Punto(x, y));
					break;
				case 3:
					disparo = new MinaSubmarinaPuntualConRetardo(new Punto(x, y));
					break;
				case 4:
					disparo = new MinaSubmarinaDobleConRetardo(new Punto(x, y),tablero);
					break;
				case 5:
					disparo = new MinaSubmarinaTripleConRetardo(new Punto(x, y),tablero);
					break;
				default:
					break;
				}
				tipoDeDisparo = 0;
				if (disparo != null){
					tablero.agregarDisparo(disparo);
					gameLoop.agregar(disparo);
				}
				System.out.println("Click mouse");
				System.out.println("X" + x );
				System.out.println("Y" + y );
				//modelo.moverA(arg0.getX(), arg0.getY());	
			}});
				
		frame.addKeyListener(new KeyListener(
				) {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				System.out.println("Key pressed");
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
			
				System.out.println("Ping");
				
			}  
			 	
		});
		
		
		for (Barco barco : tablero.getBarcos()){
			for (Parte parte : barco.getCuerpo()){
				this.gameLoop.agregar(parte);
			}
		}
		
		//panel.setVisible(false);
	}
	
	class Posicion implements ObjetoPosicionable {
		int x;
		int y;
		
		public Posicion(int x,int y){
			this.x = x;
			this.y = y;
		}
		
		public int getX(){
			return this.x;
		}
		
		public int getY(){
			return this.y;
			
		}
		
	}
}

