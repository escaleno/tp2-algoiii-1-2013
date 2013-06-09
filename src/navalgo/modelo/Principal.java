package navalgo.modelo;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Punto posX3Y2 = new Punto(3, 2);
		Punto posX3Y3 =new Punto(3, 3);
		Punto posX4Y2 = new Punto(4, 2);
		Orientacion orientacionHorizontal = Orientacion.HORIZONTAL;
		Orientacion orientacionVertical = Orientacion.VERTICAL;
		MinaSubmarinaDobleConRetardo unaMinaEnX4Y2 = new MinaSubmarinaDobleConRetardo(posX4Y2);
		Buque unBuqueENX3Y2 = new Buque(posX3Y2, orientacionVertical);
		unaMinaEnX4Y2.atacar(unBuqueENX3Y2);
}
	
}


