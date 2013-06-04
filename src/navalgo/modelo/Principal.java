package navalgo.modelo;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinaSubmarinaDobleConRetardo unaMinaDobleConRetardoEnX10Y1;
		Punto posicionX10Y1;
		posicionX10Y1 = new Punto(10, 1);
		unaMinaDobleConRetardoEnX10Y1 = new MinaSubmarinaDobleConRetardo(posicionX10Y1);
		for (MinaDeAlcanceSubmarina unaMina : unaMinaDobleConRetardoEnX10Y1.getMinasDeAlcance()) {
			System.out.println(unaMina.getPosicion().getX());
			System.out.println(unaMina.getPosicion().getY());
					
		}
		

	}

}
