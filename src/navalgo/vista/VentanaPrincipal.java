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
//import titiritero.ejemplo5.modelo.ObjetoMultiforma;
import fiuba.algo3.titiritero.modelo.*;
import fiuba.algo3.titiritero.dibujables.*;


public class VentanaPrincipal {

	private JFrame frame;
	private GameLoop gameLoop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frame = new JFrame();
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		JButton btnIniciar = new JButton("Iniciar");
//
//		btnIniciar.addActionListener(new EscuchaIniciar(this));
//		btnIniciar.setBounds(42, 16, 77, 25);
//		frame.getContentPane().add(btnIniciar);
//		
//		JButton btnDetener = new JButton("Detener");
//		btnDetener.addActionListener(new EscuchaDetener(this));
//		btnDetener.setBounds(325, 16, 92, 25);
//		frame.getContentPane().add(btnDetener);
		
		JButton btnDisparoConvencional = new JButton("DisparoConvencional");
		btnDisparoConvencional.addActionListener(new EscuchaDisparoConvencional(this));
		btnDisparoConvencional.setBounds(25, 600, 250, 25);
		frame.getContentPane().add(btnDisparoConvencional);
		
		JButton btnMinaSubmarinaPuntualConRetardo = new JButton("MinaSubmarinaPuntualConRetardo");
		btnMinaSubmarinaPuntualConRetardo.addActionListener(new EscuchaMinaSubmarinaPuntualConRetardo(this));
		btnMinaSubmarinaPuntualConRetardo.setBounds(280, 600, 250, 25);
		frame.getContentPane().add(btnMinaSubmarinaPuntualConRetardo);
		
		JButton btnMinaSubmarinaDobleConRetardo = new JButton("MinaSubmarinaDobleConRetardo");
		btnMinaSubmarinaDobleConRetardo.addActionListener(new EscuchaMinaSubmarinaDobleConRetardo(this));
		btnMinaSubmarinaDobleConRetardo.setBounds(535, 600, 250, 25);
		frame.getContentPane().add(btnMinaSubmarinaDobleConRetardo);
		
		JButton btnMinaSubmarinaTripleConRetardo = new JButton("MinaSubmarinaTripleConRetardo");
		btnMinaSubmarinaTripleConRetardo.addActionListener(new EscuchaMinaSubmarinaTripleConRetardo(this));
		btnMinaSubmarinaTripleConRetardo.setBounds(25, 630, 250, 25);
		frame.getContentPane().add(btnMinaSubmarinaTripleConRetardo);
		
		JButton btnMinaSubmarinaPorContacto = new JButton("MinaSubmarinaPorContacto");
		btnMinaSubmarinaPorContacto.addActionListener(new EscuchaMinaSubmarinaPorContacto(this));
		btnMinaSubmarinaPorContacto.setBounds(280, 630, 250, 25);
		frame.getContentPane().add(btnMinaSubmarinaPorContacto);
		
		JPanel panel = new SuperficiePanel();
		
		//panel.setBackground(new Color(0, 0, 0));
		panel.setBackground(Color.BLUE);
		//panel.setSize(1500,800);
		//panel.setBounds(42, 53, 375, 187);
		panel.setBounds(42, 53, 400, 400);
		//Imagen unaImagen = new Imagen(this.class.getResource("/imagenes/imagenFondo.jpg"));
		frame.getContentPane().add(panel);
		

		
//		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
//		final ObjetoMultiforma modelo = new ObjetoMultiforma();
//		this.gameLoop.agregar(modelo);
//		Circulo circulo = new VistaObjetoMultiforma(modelo);
//		this.gameLoop.agregar(circulo);
//		
//		ObjetoMultiforma modelo2 = new ObjetoMultiforma();
//		modelo2.mutar();
//		this.gameLoop.agregar(modelo2);
//		Figura cuadrado = new Vista2ObjetoMultiforma(modelo2);
//		this.gameLoop.agregar(cuadrado);
//
//		ObjetoMultiforma modelo3 = new ObjetoMultiforma();
//		modelo3.inmutar();
//		this.gameLoop.agregar(modelo3);
//		Imagen imagen = new Vista3ObjetoMultiforma(modelo3);
//		this.gameLoop.agregar(imagen);
		
		
		
//		panel.addMouseListener(new MouseAdapter() {
//					
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				modelo.moverA(arg0.getX(), arg0.getY());
//					
//			}});
//
//		frame.setFocusable(true);
//		btnDetener.setFocusable(false);
//		btnIniciar.setFocusable(false);
				
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
		
		
		
	}
	public GameLoop getGameLoop(){
		return this.gameLoop;
	}
}

