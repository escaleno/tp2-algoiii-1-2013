package navalgo.modelo;

import java.util.Random;

public enum Orientacion {
	HORIZONTAL, VERTICAL;
	
	public static Orientacion getRandom(){
		Orientacion o[] = Orientacion.values();
		Random random = new Random();
		return o[random.nextInt(o.length-1)];
	}
}
