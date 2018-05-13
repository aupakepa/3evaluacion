/**
 * 
 */

/**
 * @author usuario
 *
 */
public class Traga2 {
	private String color;
	private Integer bolasMaximas;
	private Integer bolasTragadas;

	
	/**
	 * @param color
	 * @param bolasMaximas
	 */
	public Traga2(String color, Integer bolasMaximas) {
		if(validarColor(color)){
			this.color = color;
		}
		if(validarBolaM(bolasMaximas)){
			this.bolasMaximas = bolasMaximas;			
		}
		bolasTragadas=0;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	private Boolean validarColor(String color){
		Boolean correcto=false;
		if(color.equals("rojo")||color.equals("amarillo")||color.equals("azul")||color.equals("verde")){
			correcto=true;
		}
		return correcto;
	}
	
	private Boolean validarBolaM(Integer bolas){
		Boolean correcto=false;
		if(bolas>0){
			correcto=true;
		}
		return correcto;
	}
	public String cadena() {
		return "Traga2 [color=" + color + ", bolasMaximas=" + bolasMaximas + ", bolasTragadas=" + bolasTragadas + "]";
	}

	public String comer(){
		String mensaje;
		if(bolasTragadas==this.bolasMaximas){
			mensaje="Ya no puedo comer más";
		} else{
			bolasTragadas++;
			mensaje="He comido una bola";
		}
		return mensaje;
	}
	public String trotar(){
		String mensaje;
		if(bolasTragadas==0){
			mensaje="No puedo perder bolas";
		} else{
			bolasTragadas--;
			mensaje="He perdido una bola";
		}
		return mensaje;
	}
	public String dormir(){
		String mensaje;
		if(bolasTragadas==bolasMaximas){
			mensaje="Me voy a dormir ZzZzZz";
			bolasTragadas=bolasTragadas/2;
		} else{
			mensaje="No me puedo ir a dormir";
		}
		return mensaje;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		if(validarColor(color)){
			this.color = color;
		}
	}


	/**
	 * @return the bolasMaximas
	 */
	public Integer getBolasMaximas() {
		return bolasMaximas;
	}


	/**
	 * @param bolasMaximas the bolasMaximas to set
	 */
	public void setBolasMaximas(Integer bolasMaximas) {
		if(validarBolaM(bolasMaximas)){
			this.bolasMaximas = bolasMaximas;			
		}
	}


	/**
	 * @return the bolasTragadas
	 */
	public Integer getBolasTragadas() {
		return bolasTragadas;
	}


	/**
	 * @param bolasTragadas the bolasTragadas to set
	 */
	public void setBolasTragadas(Integer bolasTragadas) {
		this.bolasTragadas = bolasTragadas;
	}
	
	
}
