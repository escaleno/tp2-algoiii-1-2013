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
import navalgo.dibujables.MiImagen;
import navalgo.modelo.Barco;
import navalgo.modelo.Buque;
import navalgo.modelo.Destructor;
import navalgo.modelo.Direccion;
import navalgo.modelo.Disparo;
import navalgo.modelo.DisparoConvencional;
import navalgo.modelo.EstrategiaDireccionDerAbajo;
import navalgo.modelo.EstrategiaDireccionRandom;
import navalgo.modelo.EstrategiaOrientacionRandom;
import navalgo.modelo.EstrategiaPuntoRandom;
import navalgo.modelo.GeneradorRandomDireccion;
import navalgo.modelo.GeneradorRandomOrientacion;
import navalgo.modelo.GeneradorRandomPunto;
import navalgo.modelo.Lancha;
import navalgo.modelo.MinaSubmarinaDobleConRetardo;
import navalgo.modelo.MinaSubmarinaPorContacto;
import navalgo.modelo.MinaSubmarinaPuntualConRetardo;
import navalgo.modelo.MinaSubmarinaTripleConRetardo;
import navalgo.modelo.OrientacionHorizontal;
import navalgo.modelo.OrientacionVertical;
import navalgo.modelo.Parte;
import navalgo.modelo.Portaavion;
import navalgo.modelo.Punto;
import navalgo.modelo.Rompehielos;
import navalgo.modelo.Tablero;
import fiuba.algo3.titiritero.modelo.*;
import fiuba.algo3.titiritero.dibujables.*;


public class VentanaPrincipal {

	private JFrame frame;
	private GameLoop gameLoop;
	private int tipoDeDisparo = 0;
	private JButton btnDispConvencional;
	private JButton btnMinaSubXContacto;
	private JButton btnMinaSubConRetAlc;
	private JButton btnMinaSubConRetAlcDoble;
	private JButton btnMinaSubConRetAlcTriple;

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

	public void habilitarTodos()
	{
		btnDispConvencional.setEnabled(true);
		btnMinaSubXContacto.setEnabled(true);
		btnMinaSubConRetAlc.setEnabled(true);
		btnMinaSubConRetAlcDoble.setEnabled(true);
		btnMinaSubConRetAlcTriple.setEnabled(true);
	}
	
	public void deshabilitar(JButton unBoton)
	{
		unBoton.setEnabled(false);
	}
	
	private void generarBotones()
	{
		btnDispConvencional = new JButton("Disparo Convencional");
		btnMinaSubXContacto = new JButton("MinaSub. Por Contacto");
		btnMinaSubConRetAlc = new JButton("MinaSub. con Retardo");
		btnMinaSubConRetAlcDoble = new JButton("Mina con Ret. y Alc. 2");
		btnMinaSubConRetAlcTriple = new JButton("Mina con Ret. y Alc. 3");
		btnDispConvencional.setBounds(100, 565, 170, 25);
		btnMinaSubXContacto.setBounds(300, 565, 170, 25);
		btnMinaSubConRetAlc.setBounds(40, 610, 170, 25);
		btnMinaSubConRetAlcDoble.setBounds(215, 610, 170, 25);
		btnMinaSubConRetAlcTriple.setBounds(390, 610, 170, 25);

	}
	
	public void mostrar()
	{
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
	}
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame("Navalgo");
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.setForeground(Color.blue);
		frame.setBounds(1,1, 620, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		generarBotones();
		
		btnDispConvencional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				habilitarTodos();
				deshabilitar(btnDispConvencional);
				tipoDeDisparo = 1;
			}
		});
		
		btnMinaSubXContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarTodos();
				deshabilitar(btnMinaSubXContacto);
				tipoDeDisparo = 2;
			}
		});
		
		btnMinaSubConRetAlc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarTodos();
				deshabilitar(btnMinaSubConRetAlc);
				tipoDeDisparo = 3;
			}
		});
		
		btnMinaSubConRetAlcDoble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarTodos();
				deshabilitar(btnMinaSubConRetAlcDoble);
				tipoDeDisparo = 4;
			}
		});
		
		btnMinaSubConRetAlcTriple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarTodos();
				deshabilitar(btnMinaSubConRetAlcTriple);
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
		
		Punto.setTamanioDePosicionX(x);
		Punto.setTamanioDePosicionY(y);
		
		this.gameLoop = new GameLoop(250,(SuperficieDeDibujo) panel);
		frame.getContentPane().add(btnDispConvencional);
		frame.getContentPane().add(btnMinaSubXContacto);
		frame.getContentPane().add(btnMinaSubConRetAlc);
		frame.getContentPane().add(btnMinaSubConRetAlcDoble);
		frame.getContentPane().add(btnMinaSubConRetAlcTriple);
		mostrar();
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
		
		GeneradorRandomDireccion DerAbajo = new GeneradorRandomDireccion(new EstrategiaDireccionRandom());
		Direccion direccion = DerAbajo.getValue();
		GeneradorRandomOrientacion randomOrientacion = new GeneradorRandomOrientacion(new EstrategiaOrientacionRandom());
		GeneradorRandomPunto randomPunto = new GeneradorRandomPunto(new EstrategiaPuntoRandom());
		Lancha unalancha = new Lancha(randomPunto.getValue(),randomOrientacion.getValue(),direccion.getX(),direccion.getY());
		direccion = DerAbajo.getValue();
		Buque unbuque = new Buque(randomPunto.getValue(),randomOrientacion.getValue(),direccion.getX(),direccion.getY());
		direccion = DerAbajo.getValue();
		Destructor undestructor = new Destructor(randomPunto.getValue(),randomOrientacion.getValue(),direccion.getX(),direccion.getY());
		direccion = DerAbajo.getValue();
		//Falta Agregar las imagenes de los romehielos Verticales
		Rompehielos unrompehielo = new Rompehielos(randomPunto.getValue(),new OrientacionHorizontal(),direccion.getX(),direccion.getY());
		direccion = DerAbajo.getValue();
		//Falta Agregar las imagenes de los romehielos Verticales
		Portaavion portaavion = new Portaavion(randomPunto.getValue(),randomOrientacion.getValue(),direccion.getX(),direccion.getY());
		tablero.agregarBarco(unalancha);
		tablero.agregarBarco(unbuque);
		tablero.agregarBarco(undestructor);
		tablero.agregarBarco(unrompehielo);
		tablero.agregarBarco(portaavion);
		
//		Lancha lanchaV = new Lancha(new Punto(1, 1), new OrientacionVertical(), 0, 1);
//		Lancha lanchaH = new Lancha(new Punto(7, 1), new OrientacionHorizontal(), 1, 0);
//		
//		Buque buqueV = new Buque(new Punto(1, 1), new OrientacionVertical(), 0, 1);
//		Buque buqueH = new Buque(new Punto(7, 1), new OrientacionHorizontal(), 1, 0);
		
		
//		tablero.agregarBarco(lanchaV);
//		tablero.agregarBarco(lanchaH);
//		
//		tablero.agregarBarco(buqueV);
//		tablero.agregarBarco(buqueH);
//		
//		Destructor destructorV = new Destructor(new Punto(1, 1), new OrientacionVertical(), 0, 1);
//		Destructor destructorH = new Destructor(new Punto(7, 1), new OrientacionHorizontal(), 1, 0);
		
//		tablero.agregarBarco(destructorH);
//		tablero.agregarBarco(destructorV);

//		Rompehielos rompehielosV = new Rompehielos(new Punto(1, 1), new OrientacionVertical(), 0, 1);
//		Rompehielos rompehielosH = new Rompehielos(new Punto(7, 1), new OrientacionHorizontal(), 1, 0);
		
//		tablero.agregarBarco(rompehielosH);
//		tablero.agregarBarco(rompehielosV);
		
//		Portaavion portaavionV = new Portaavion(new Punto(1, 1), new OrientacionVertical(), 0, 1);
//		Portaavion portaavionH = new Portaavion(new Punto(4, 1), new OrientacionHorizontal(), 1, 0);
//		
//		tablero.agregarBarco(portaavionH);
//		tablero.agregarBarco(portaavionV);
				
		panel.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent event) {
				habilitarTodos();
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
				MiImagen vParteDeBarco = new VistaParteDeBarco(parte);
				this.gameLoop.agregar(vParteDeBarco);
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

