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
	private Almacen almacen;
	private static Integer sig=100;

	
	public Mueble(String descripcion, Integer ancho, Integer alto, Integer fondo) {
		codigo=sig;
		this.descripcion = descripcion;
		this.ancho = ancho;
		this.alto = alto;
		this.fondo = fondo;
		almacen=null;
		sig++;
		
		
	}


	/* (non-Javadoc)
	 *
	 */

	public String muestraMueble() {
		return "Mueble " + codigo + ", descripcion=" + descripcion + ", ancho=" + ancho + ", alto=" + alto
				+ ", fondo=" + fondo + ", almacen=" + almacen.getNombre();
	}


	/**
	 * @return the almacen
	 */
	public Almacen getAlmacen() {
		return almacen;
	}


	/**
	 * @param almacen the almacen to set
	 */
	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}
	
	
	

}
