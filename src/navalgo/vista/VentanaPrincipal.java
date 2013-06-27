package navalgo.vista;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import navalgo.controlador.*;
import navalgo.controlador.ControladorDeMouse;
import navalgo.controlador.ControladorDeTablero;
import navalgo.controlador.EscuchaDisparoConvencional;
import navalgo.controlador.EscuchaMinaSubmarinaDobleConRetardo;
import navalgo.controlador.EscuchaMinaSubmarinaPorContacto;
import navalgo.controlador.EscuchaMinaSubmarinaPuntualConRetardo;
import navalgo.controlador.EscuchaMinaSubmarinaTripleConRetardo;
import navalgo.dibujables.MiImagen;
import navalgo.modelo.Barco;
import navalgo.modelo.Buque;
import navalgo.modelo.Destructor;
import navalgo.modelo.Direccion;
import navalgo.modelo.EstrategiaDireccionRandom;
import navalgo.modelo.EstrategiaOrientacionRandom;
import navalgo.modelo.EstrategiaPuntoRandom;
import navalgo.modelo.GeneradorRandomDireccion;
import navalgo.modelo.GeneradorRandomOrientacion;
import navalgo.modelo.GeneradorRandomPunto;
import navalgo.modelo.Lancha;
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
	private JLabel	Puntaje;
	private JLabel 	Estado;
	private Tablero tablero;
	private ControladorDeTablero controlDeTablero; //Lo hice nada mas para borrar los disparos
	private int TamanioDeCasillaX;
	private int TamanioDeCasillaY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		VentanaPrincipal window = new VentanaPrincipal();
		window.gameLoop.iniciarEjecucion();
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
	
	public GameLoop obtenerGameLoop(){
		return this.gameLoop;
	}
	
	public Tablero obtenerTablero(){
		return this.tablero;
	}

	public void habilitarTodos()
	{
		btnDispConvencional.setEnabled(true);
		btnMinaSubXContacto.setEnabled(true);
		btnMinaSubConRetAlc.setEnabled(true);
		btnMinaSubConRetAlcDoble.setEnabled(true);
		btnMinaSubConRetAlcTriple.setEnabled(true);
	}
	
	public void cambiarTipoDeDisparo(int tipoDeDisparo)
	{
		this.tipoDeDisparo = tipoDeDisparo;
	}
	
	
	public void deshabilitarbotonDispConvencional()
	{
		this.deshabilitar(this.btnDispConvencional);
	}
	
	public void deshabilitarbotonMinaSubXContacto()
	{
		this.deshabilitar(this.btnMinaSubXContacto);
	}
	
	public void deshabilitarbotonMinaSubConRetAlc()
	{
		this.deshabilitar(this.btnMinaSubConRetAlc);
	}
	
	public void deshabilitarbotonMinaSubConRetAlcDoble()
	{
		this.deshabilitar(this.btnMinaSubConRetAlcDoble);
	}
	
	public void deshabilitarbotonMinaSubConRetAlcTriple()
	{
		this.deshabilitar(this.btnMinaSubConRetAlcTriple);
	}
	
	public void deshabilitar(JButton unBoton)
	{
		unBoton.setEnabled(false);
	}
	
	//Crea Todos los Botones y lo ubica en el Tablero
	private void generarBotones()
	{
		btnDispConvencional = new JButton("Disparo Convencional");
		btnMinaSubXContacto = new JButton("MinaSub. Por Contacto");
		btnMinaSubConRetAlc = new JButton("MinaSub. con Retardo");
		btnMinaSubConRetAlcDoble = new JButton("Mina con Ret. y Alc. 2");
		btnMinaSubConRetAlcTriple = new JButton("Mina con Ret. y Alc. 3");
		Puntaje = new JLabel("Puntaje: 10000");
		Estado = new JLabel("Estado: Jugandose");
		btnDispConvencional.setBounds(100, 565, 170, 25);
		btnMinaSubXContacto.setBounds(300, 565, 170, 25);
		btnMinaSubConRetAlc.setBounds(40, 610, 170, 25);
		btnMinaSubConRetAlcDoble.setBounds(215, 610, 170, 25);
		btnMinaSubConRetAlcTriple.setBounds(390, 610, 170, 25);
		Puntaje.setBounds(40, 650, 170, 25);
		Estado.setBounds(250, 650, 170, 25);
		
		btnDispConvencional.addActionListener(
				new EscuchaDisparoConvencional(this));
		
		btnMinaSubXContacto.addActionListener(
				new EscuchaMinaSubmarinaPorContacto(this));
		
		btnMinaSubConRetAlc.addActionListener(
				new EscuchaMinaSubmarinaPuntualConRetardo(this));
		
		btnMinaSubConRetAlcDoble.addActionListener(
				new EscuchaMinaSubmarinaDobleConRetardo(this));
		
		btnMinaSubConRetAlcTriple.addActionListener(
				new EscuchaMinaSubmarinaTripleConRetardo(this));
		
		frame.getContentPane().add(btnDispConvencional);
		frame.getContentPane().add(btnMinaSubXContacto);
		frame.getContentPane().add(btnMinaSubConRetAlc);
		frame.getContentPane().add(btnMinaSubConRetAlcDoble);
		frame.getContentPane().add(btnMinaSubConRetAlcTriple);
		frame.getContentPane().add(Puntaje);
		frame.getContentPane().add(Estado);
		
		btnDispConvencional.setFocusable(true);
		btnMinaSubXContacto.setFocusable(true);
		btnMinaSubConRetAlc.setFocusable(true);
		btnMinaSubConRetAlcDoble.setFocusable(true);
		btnMinaSubConRetAlcTriple.setFocusable(true);
		Puntaje.setFocusable(false);
		Estado.setFocusable(false);
		btnDispConvencional.setVisible(true);
		btnMinaSubXContacto.setVisible(true);
		btnMinaSubConRetAlc.setVisible(true);
		btnMinaSubConRetAlcDoble.setVisible(true);
		btnMinaSubConRetAlcTriple.setVisible(true);
		Puntaje.setVisible(true);
		Estado.setVisible(true);
	}
	
	public void generadorDeBarcos() throws IOException{
		GeneradorRandomOrientacion randomOrientacion = new GeneradorRandomOrientacion(new EstrategiaOrientacionRandom());
		GeneradorRandomDireccion DerAbajo = new GeneradorRandomDireccion(new EstrategiaDireccionRandom());
		GeneradorRandomPunto randomPunto = new GeneradorRandomPunto(new EstrategiaPuntoRandom());
		
		Direccion direccion = DerAbajo.getValue();
		Lancha unalancha = new Lancha(randomPunto.getValue(),randomOrientacion.getValue(),direccion.getX(),direccion.getY());
		
		direccion = DerAbajo.getValue();
		Buque unbuque = new Buque(randomPunto.getValue(),randomOrientacion.getValue(),direccion.getX(),direccion.getY());
		
		direccion = DerAbajo.getValue();
		Destructor undestructor = new Destructor(randomPunto.getValue(),randomOrientacion.getValue(),direccion.getX(),direccion.getY());
		
		direccion = DerAbajo.getValue();
		Rompehielos unrompehielo = new Rompehielos(randomPunto.getValue(),randomOrientacion.getValue(),direccion.getX(),direccion.getY());
		
		direccion = DerAbajo.getValue();
		Portaavion portaavion = new Portaavion(randomPunto.getValue(),randomOrientacion.getValue(),direccion.getX(),direccion.getY());
		
		this.tablero.agregarBarco(unalancha);
		this.tablero.agregarBarco(unbuque);
		this.tablero.agregarBarco(undestructor);
		this.tablero.agregarBarco(unrompehielo);
		this.tablero.agregarBarco(portaavion);

		this.controlDeTablero = new ControladorDeTablero(this.tablero, this.gameLoop);
		 
		for (Barco barco : tablero.getBarcos()){
			for (Parte parte : barco.getCuerpo()){
				MiImagen vParteDeBarco = new VistaParteDeBarco(parte);
				this.gameLoop.agregar(vParteDeBarco);
				this.controlDeTablero.agregarMapaDeVistasDePartes(parte, vParteDeBarco);	
			}
		}
		this.gameLoop.agregarObservador(this.controlDeTablero);
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
		//Creo Superficie de Dibujo
		final JPanel panel = new SuperficiePanel();
		
		//FONDO DE LA SUPERFICIE DE DIBUJO
		panel.setBackground(Color.BLUE);
		
		//ubicacion y tamanio de la superficie de dibujo
		panel.setBounds(50, 50, 500, 500);
		frame.getContentPane().add(panel);
		
		this.gameLoop = new GameLoop(200,(SuperficieDeDibujo) panel);
			
		dibujoCuadrantesEnTablero(panel);
		
		panel.addMouseListener(new ControladorDeMouse(this));
		
		generadorDeBarcos();
		
	}
	
	public void dibujoCuadrantesEnTablero(JPanel panel){
		
		this.tablero = new Tablero(1,10,1,10);
		this.tablero.ligarAVentanaPrincipal(this);
		this.gameLoop.agregar(tablero);
		//Dibujo lineas del Tablero en X
		this.TamanioDeCasillaX = panel.getHeight()/this.tablero.obtenerMaximaDeColumnas();
		Punto.setTamanioDePosicionX(this.TamanioDeCasillaX);
		for (int tx = 1; tx < 10; tx++) {
			Posicion posicion = new Posicion(tx*this.TamanioDeCasillaX, 1);
			Figura linea = new Cuadrado(3, panel.getHeight(), posicion);
			this.gameLoop.agregar(linea);
		}
		
		//Dibujo lineas del Tablero en Y
		this.TamanioDeCasillaY = panel.getWidth()/this.tablero.obtenerMaximaDeFilas();
		Punto.setTamanioDePosicionY(this.TamanioDeCasillaY);
		for (int ty = 1; ty < 10; ty++) {
			Posicion posicion = new Posicion(1, ty*this.TamanioDeCasillaY);
			Figura linea = new Cuadrado(panel.getWidth(), 3, posicion);
			this.gameLoop.agregar(linea);
		}
	}

	public int obtenerTipoDeDisparo() {
		return this.tipoDeDisparo;
	}
	public int obtenerTamanioDeCasillaX() {
		return this.TamanioDeCasillaX;
	}

	public int obtenerTamanioDeCasillaY() {
		return this.TamanioDeCasillaY;
	}
	
	public ControladorDeTablero obtenerControlDeTablero() {
		return this.controlDeTablero;
	}
	
	public JLabel obtenerEtiquetaPuntaje()
	{
		return Puntaje;
	}
	
	public JLabel obtenerEtiquetaEstado()
	{
		return Estado;
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

