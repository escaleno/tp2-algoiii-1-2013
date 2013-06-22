package navalgo.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import navalgo.controlador.*;
import navalgo.modelo.Tablero;
import fiuba.algo3.titiritero.modelo.*;
import fiuba.algo3.titiritero.dibujables.*;


public class VentanaPrincipal {

	private JFrame frame;
	private GameLoop gameLoop;

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
		
		final JPanel panel = new SuperficiePanel();
		
//		panel.setBackground(new Color(0, 0, 0));
		//FONDO DE LA SUPERFICIE DE DIBUJO
		panel.setBackground(Color.BLUE);
		
		//ubicacion y tamanio de la superficie de dibujo
		panel.setBounds(50, 50, 500, 500);
		frame.getContentPane().add(panel);
		int y = panel.getHeight()/10;
		int x = panel.getWidth()/10;
		

		
		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
		final Tablero modelo = new Tablero(10,10,1,1);
		this.gameLoop.agregar(modelo); 
		
		for (int tx = 1; tx < 10; tx++) {
			Posicion posicion = new Posicion(tx*x, 1);
			Figura linea = new Cuadrado(3, panel.getHeight(), posicion);
			this.gameLoop.agregar(linea);
		}
		
		for (int ty = 1; ty < 10; ty++) {
			Posicion posicion = new Posicion(1, ty*y);
			Figura linea = new Cuadrado(panel.getWidth(), 3, posicion);
			this.gameLoop.agregar(linea);
		}
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
			}
		});
		
		btnMinaSubXContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDispConvencional.setEnabled(true);
				btnMinaSubXContacto.setEnabled(false);
				btnMinaSubConRetAlc.setEnabled(true);
				btnMinaSubConRetAlcDoble.setEnabled(true);
				btnMinaSubConRetAlcTriple.setEnabled(true);
			}
		});
		
		btnMinaSubConRetAlc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDispConvencional.setEnabled(true);
				btnMinaSubXContacto.setEnabled(true);
				btnMinaSubConRetAlc.setEnabled(false);
				btnMinaSubConRetAlcDoble.setEnabled(true);
				btnMinaSubConRetAlcTriple.setEnabled(true);
			}
		});
		
		btnMinaSubConRetAlcDoble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDispConvencional.setEnabled(true);
				btnMinaSubXContacto.setEnabled(true);
				btnMinaSubConRetAlc.setEnabled(true);
				btnMinaSubConRetAlcDoble.setEnabled(false);
				btnMinaSubConRetAlcTriple.setEnabled(true);
			}
		});
		
		btnMinaSubConRetAlcTriple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDispConvencional.setEnabled(true);
				btnMinaSubXContacto.setEnabled(true);
				btnMinaSubConRetAlc.setEnabled(true);
				btnMinaSubConRetAlcDoble.setEnabled(true);
				btnMinaSubConRetAlcTriple.setEnabled(false);
			}
		});
				
		panel.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent event) {
				btnMinaSubXContacto.setEnabled(true);
				btnDispConvencional.setEnabled(true);
				btnMinaSubConRetAlc.setEnabled(true);
				btnMinaSubConRetAlcDoble.setEnabled(true);
				btnMinaSubConRetAlcTriple.setEnabled(true);
				System.out.println("Click mouse");
				System.out.println("X" + ((event.getX()/(panel.getWidth()/10)) +1) );
				System.out.println("Y" + ((event.getY()/(panel.getHeight()/10))+1) );
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
		
		frame.getContentPane().add(btnDispConvencional);
		frame.getContentPane().add(btnMinaSubXContacto);
		frame.getContentPane().add(btnMinaSubConRetAlc);
		frame.getContentPane().add(btnMinaSubConRetAlcDoble);
		frame.getContentPane().add(btnMinaSubConRetAlcTriple);
		
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

