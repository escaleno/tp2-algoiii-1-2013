package navalgo.modelo;

public enum Direccion {
	IZQARRIBA(-1,-1),ARRIBA( 0,-1),DERARRIBA( 1,-1),
	IZQUIERDA(-1, 0),              DERECHA( 1, 0),
	IZQABAJO(-1, 1) , ABAJO( 0, 1),DERABAJO( 1, 1);
	
	private int x;
	private int y;
	
	private Direccion(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Direccion nuevaDireccionX(int x ){
		Direccion nuevaDireccion = null;
		for (Direccion dir : Direccion.values()) {
			if (this.y == dir.getY() && x == dir.getX()){
				nuevaDireccion = dir;
				break;
			}
		}
		if (nuevaDireccion!=null) {
			return nuevaDireccion;
		} else {
			return this;
		}
	}
	
	public Direccion nuevaDireccionY(int y ){
		Direccion nuevaDireccion = null;
		for (Direccion dir : Direccion.values()) {
			if ((y == dir.getY())&&(this.x == dir.getX())){
				nuevaDireccion = dir;
				break;
			}
		}
		if (nuevaDireccion!=null) {
			return nuevaDireccion;
		} else {
			return this;
		}
	}
	
	public Direccion nuevaDireccion(int x, int y ){
		Direccion nuevaDireccion = null;
		for (Direccion dir : Direccion.values()) {
			if ((y == dir.getY())&&( x == dir.getX())){
				nuevaDireccion = dir;
				break;
			}
		}
		if (nuevaDireccion!=null) {
			return nuevaDireccion;
		} else {
			return this;
		}
	}
}
