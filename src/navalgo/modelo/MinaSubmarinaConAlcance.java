package navalgo.modelo;

import java.util.ArrayList;

public abstract class MinaSubmarinaConAlcance extends Disparo {
	
	protected ArrayList<MinaDeAlcanceSubmarina> minasDeAlcance;
	
	//Constructor
	public MinaSubmarinaConAlcance(Punto unaPosicion) {
		super(unaPosicion);
		minasDeAlcance = new ArrayList<MinaDeAlcanceSubmarina>(); 
		
		//esta en el borde del tablero
		if( (this.posicion.getX() == 1) || (this.posicion.getY() == 1) || (this.posicion.getX() == 10) || (this.posicion.getY() == 10) ){
			
			//esta en (1,1)
			if( (this.posicion.getX() == 1) && (this.posicion.getY() == 1) ){
				this.agregarMinaAlcanceSubmarinaPos6();
				this.agregarMinaAlcanceSubmarinaPos7();
				this.agregarMinaAlcanceSubmarinaPos8();
			}
			
			//esta en (10,1)
			if( (this.posicion.getX() == 10) && (this.posicion.getY() == 1) ){
				this.agregarMinaAlcanceSubmarinaPos8();
				this.agregarMinaAlcanceSubmarinaPos1();
				this.agregarMinaAlcanceSubmarinaPos2();
			}
			
			//esta en (1,10)
			if( (this.posicion.getX() == 1) && (this.posicion.getY() == 10) ){
				this.agregarMinaAlcanceSubmarinaPos4();
				this.agregarMinaAlcanceSubmarinaPos5();
				this.agregarMinaAlcanceSubmarinaPos6();
			}
			
			//esta en (10,10)
			if( (this.posicion.getX() == 10) && (this.posicion.getY() == 10) ){
				this.agregarMinaAlcanceSubmarinaPos2();
				this.agregarMinaAlcanceSubmarinaPos3();
				this.agregarMinaAlcanceSubmarinaPos4();
			}

			//esta en el borde superior pero no en las esquinas
			if( (this.posicion.getX() == 1) && (this.posicion.getY() > 1) && (this.posicion.getY() < 10) ){
				this.agregarMinaAlcanceSubmarinaPos4();
				this.agregarMinaAlcanceSubmarinaPos5();
				this.agregarMinaAlcanceSubmarinaPos6();
				this.agregarMinaAlcanceSubmarinaPos7();
				this.agregarMinaAlcanceSubmarinaPos8();
			}
			
			//esta en el borde inferior pero no en las esquinas
			if ( (this.posicion.getX() == 10) && (this.posicion.getY() > 1) && (this.posicion.getY() < 10) ){
				this.agregarMinaAlcanceSubmarinaPos8();
				this.agregarMinaAlcanceSubmarinaPos1();
				this.agregarMinaAlcanceSubmarinaPos2();
				this.agregarMinaAlcanceSubmarinaPos3();
				this.agregarMinaAlcanceSubmarinaPos4();
			}
			
			//esta en el borde izquierdo pero no en las esquinas
			if ( (this.posicion.getY() == 1) && (this.posicion.getX() > 1) && (this.posicion.getX() < 10) ){
				this.agregarMinaAlcanceSubmarinaPos1();
				this.agregarMinaAlcanceSubmarinaPos2();
				this.agregarMinaAlcanceSubmarinaPos6();
				this.agregarMinaAlcanceSubmarinaPos7();
				this.agregarMinaAlcanceSubmarinaPos8();
			}
			
			//esta en el borde derecho pero no en las esquinas
			if ( (this.posicion.getY() == 10) && (this.posicion.getX() > 1) && (this.posicion.getX() < 10)){
				this.agregarMinaAlcanceSubmarinaPos2();
				this.agregarMinaAlcanceSubmarinaPos3();
				this.agregarMinaAlcanceSubmarinaPos4();
				this.agregarMinaAlcanceSubmarinaPos5();
				this.agregarMinaAlcanceSubmarinaPos6();
			}
		}else { // esta en el medio
			this.agregarMinaAlcanceSubmarinaPos1();
			this.agregarMinaAlcanceSubmarinaPos2();
			this.agregarMinaAlcanceSubmarinaPos3();
			this.agregarMinaAlcanceSubmarinaPos4();
			this.agregarMinaAlcanceSubmarinaPos5();
			this.agregarMinaAlcanceSubmarinaPos6();
			this.agregarMinaAlcanceSubmarinaPos7();
			this.agregarMinaAlcanceSubmarinaPos8();
		}
		
	}
	
	public ArrayList<MinaDeAlcanceSubmarina> getMinasDeAlcance(){
		return this.minasDeAlcance;
	}
	
//	protected void agregarMinaDeAlcanceSubmarina(Punto posicion) {
//		MinaDeAlcanceSubmarina unaMinaDeAlcance;
//		unaMinaDeAlcance = new MinaDeAlcanceSubmarina(posicion);
//		this.minasDeAlcance.add(unaMinaDeAlcance);
//		
//	}
	
	
	/*   
	 * 		3      2     1	
	 * 		4	CENTRO   8
	 * 		5	   6	 7	
	 * 
	 */
	
	public void agregarMinaAlcanceSubmarinaPos1(){
		Punto posicion = new Punto((this.posicion.getX()) -1,(this.posicion.getY()) +1);
		MinaDeAlcanceSubmarina unaMinaDeAlcance = new MinaDeAlcanceSubmarina(posicion);
		this.minasDeAlcance.add(unaMinaDeAlcance);
	}
	
	public void agregarMinaAlcanceSubmarinaPos2(){
		Punto posicion = new Punto(this.posicion.getX() -1 , this.posicion.getY());
		MinaDeAlcanceSubmarina unaAlcanceSubmarina = new MinaDeAlcanceSubmarina(posicion);
		this.minasDeAlcance.add(unaAlcanceSubmarina);
	}
	
	public void agregarMinaAlcanceSubmarinaPos3(){
		Punto posicion = new Punto(this.posicion.getX() -1 , this.posicion.getY() -1);
		MinaDeAlcanceSubmarina unaAlcanceSubmarina = new MinaDeAlcanceSubmarina(posicion);
		this.minasDeAlcance.add(unaAlcanceSubmarina);
	}
	
	public void agregarMinaAlcanceSubmarinaPos4(){
		Punto posicion = new Punto(this.posicion.getX(), this.posicion.getY() -1);
		MinaDeAlcanceSubmarina unaAlcanceSubmarina = new MinaDeAlcanceSubmarina(posicion);
		this.minasDeAlcance.add(unaAlcanceSubmarina);
	}

	
	public void agregarMinaAlcanceSubmarinaPos5(){
		Punto posicion = new Punto(this.posicion.getX() +1, this.posicion.getY() -1);
		MinaDeAlcanceSubmarina unaAlcanceSubmarina = new MinaDeAlcanceSubmarina(posicion);
		this.minasDeAlcance.add(unaAlcanceSubmarina);
	}
	
	public void agregarMinaAlcanceSubmarinaPos6(){
		Punto posicion = new Punto(this.posicion.getX() +1, this.posicion.getY());
		MinaDeAlcanceSubmarina unaAlcanceSubmarina = new MinaDeAlcanceSubmarina(posicion);
		this.minasDeAlcance.add(unaAlcanceSubmarina);
	}
	
	public void agregarMinaAlcanceSubmarinaPos7(){
		Punto posicion = new Punto(this.posicion.getX() +1, this.posicion.getY() +1);
		MinaDeAlcanceSubmarina unaAlcanceSubmarina = new MinaDeAlcanceSubmarina(posicion);
		this.minasDeAlcance.add(unaAlcanceSubmarina);
	}
	
	public void agregarMinaAlcanceSubmarinaPos8(){
		Punto posicion = new Punto(this.posicion.getX(), this.posicion.getY() +1);
		MinaDeAlcanceSubmarina unaAlcanceSubmarina = new MinaDeAlcanceSubmarina(posicion);
		this.minasDeAlcance.add(unaAlcanceSubmarina);
	}
	
	
}
