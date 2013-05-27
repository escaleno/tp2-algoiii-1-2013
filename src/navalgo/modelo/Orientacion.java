package navalgo.modelo;

public class Orientacion {
	
	/*indica si es de tipo Horizontal o tipo Vertical*/
	String tipo;
	
	public Orientacion(String tipoDeOrientacion){
		this.tipo = tipoDeOrientacion;
	}
	
	public String getOrientacion(){
		return this.tipo;
	}
	
	

}
