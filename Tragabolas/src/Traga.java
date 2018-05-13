/**
 * 
 */

/**
 * @author yo
 *
 */
public class Traga {
	private String color;
	private Integer bolasTragadas;
	private Integer bolasMaximas;
	
	
	/**
	 * @param color
	 * @param bolasMaximas
	 */
	public Traga(String color, Integer bolasMaximas) {
		if(validaColor(color)){
			this.color = color;
		}
		if(validaBolasmax(bolasMaximas)){
			this.bolasMaximas = bolasMaximas;	
		}
		bolasTragadas=0;
	}


	/**
	 * @return correcto 
	 * verdadero si es uno de los colores posibles 
	 * o falso si no es uno de los colores correctos
	 */
	private Boolean validaColor(String color) {
		Boolean correcto=false;
		if(color.equals("rojo")||color.equals("verde")||color.equals("amarillo")||color.equals("azul")){
			correcto=true;
		}
		return correcto;
	}
	/**
	 * @return correcto 
	 * verdadero si el número de bolas máximo es positivo 
	 * o falso si no es mayor que cero
	 */
	private Boolean validaBolasmax(Integer bolasMaximas) {
		Boolean correcto=false;
		if(bolasMaximas>0){
			correcto=true;
		}
		return correcto;
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
		if(validaColor(color)){
			this.color = color;
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
		if(validaBolasmax(bolasMaximas)){
			this.bolasMaximas = bolasMaximas;	
		}
	}

	/**
	 * @return en texto el contenido del objeto
	 */
	public String cadena() {
		return "Traga [color=" + color + ", bolasTragadas=" + bolasTragadas + ", bolasMaximas=" + bolasMaximas + "]";
	}

	/**
	 * @return lo realizado
	 */
	public String trota() {
		String texto;
		if(this.bolasTragadas==0){
			texto="No hay bolas";
		} else{
			this.bolasTragadas--;
			texto="Una bola menos";
		}
		return texto;
	}
	/**
	 * @return lo realizado
	 */
	public String duerme() {
		String texto;
		if(this.bolasTragadas==this.bolasMaximas){
			this.bolasTragadas=this.bolasTragadas/2;
			texto="Durmiendo ZzZzZzZ";
		} else{
			texto="No puedo dormir";
		}
		return texto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	
	@Override
	public String toString() {
		return "Traga [color=" + color + ", bolasTragadas=" + bolasTragadas + ", bolasMaximas=" + bolasMaximas + "]";
	}
	*/
}
