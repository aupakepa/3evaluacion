/**
 * 
 */

/**
 * @author maalvarez
 *
 */
public class Mueble {
	private Integer codigo;
	private String descripcion;
	private Integer ancho;
	private Integer alto;
	private Integer fondo;
	private Boolean asignado;
	private static Integer sig=100;

	
	public Mueble(String descripcion, Integer ancho, Integer alto, Integer fondo) {
		codigo=sig;
		this.descripcion = descripcion;
		this.ancho = ancho;
		this.alto = alto;
		this.fondo = fondo;
		asignado= false;
		sig++;
	}


	/**
	 * @return the asignado
	 */
	public Boolean getAsignado() {
		return asignado;
	}


	/**
	 * @param asignado the asignado to set
	 */
	public void setAsignado(Boolean asignado) {
		this.asignado = asignado;
	}


	public String muestraMueble() {
		return "Mueble " + codigo + ", descripcion=" + descripcion + ", ancho=" + ancho + ", alto=" + alto
				+ ", fondo=" + fondo;
	}

}
