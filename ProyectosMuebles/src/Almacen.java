/**
 * 
 */

/**
 * @author maalvarez
 *
 */
public class Almacen {
	private String nombre;
	private String direcion;
	
	
	/**
	 * @param nombre
	 * @param direcion
	 */
	public Almacen(String nombre, String direcion) {
		this.nombre = nombre;
		this.direcion = direcion;
	}



	public String muestraAlmacen() {
		return "Almacen : " + nombre + ", direcion=" + direcion ;
	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	
	

}
